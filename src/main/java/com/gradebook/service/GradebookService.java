package com.gradebook.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gradebook.entity.Roster;
import com.gradebook.entity.Score;
import com.gradebook.repository.CourseRepository;
import com.gradebook.repository.RosterRepository;
import com.gradebook.repository.ScoreRepository;

@Service
public class GradebookService {
	
	    private ScoreRepository scoreRepository;
	    private RosterRepository rosterRepository;
	   
	    public GradebookService(ScoreRepository scoreRepository, RosterRepository rosterRepository,
				CourseRepository courseRepository) {
			super();
			this.scoreRepository = scoreRepository;
			this.rosterRepository = rosterRepository;
			
		}

		public void submitScore(Score score) {
	        scoreRepository.save(score);
	        calculateStudentOverallScore(score.getCourse().getId(), score.getUser().getId());
	        calculateClassOverallScore(score.getCourse().getId());
	    }

	    public double calculateStudentOverallScore(Long courseId, Long userId) {
	        List<Score> scores = scoreRepository.findByCourseIdAndUserId(courseId, userId);
	        double totalPointsEarned = scores.stream().mapToDouble(Score::getPointsEarned).sum();
	        double totalPointsPossible = scores.stream().mapToDouble(score -> getPointsPossible(score.getAssessment().getId())).sum();
	        return totalPointsEarned / totalPointsPossible * 100;
	    }

	    public double calculateClassOverallScore(Long courseId) {
	        List<Roster> students = rosterRepository.findByCourseId(courseId).stream()
	                .filter(r -> r.getType() == Roster.UserType.STUDENT)
	                .collect(Collectors.toList());

	        double totalAverage = students.stream()
	                .mapToDouble(student -> calculateStudentOverallScore(courseId, student.getId()))
	                .average()
	                .orElse(0.0);

	        return totalAverage;
	    }

	    private double getPointsPossible(Long assessmentId) {
	        // Implement logic to retrieve points possible for an assessment
	        return 100; // Placeholder
	    }

}
