package com.gradebook.api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gradebook.entity.Score;
import com.gradebook.service.GradebookService;

@RestController
@RequestMapping("/api")
public class GradebookController {
    private GradebookService gradebookService;
    
    public GradebookController(GradebookService gradebookService) {
		this.gradebookService = gradebookService;
	}

	@PostMapping("/assessments/submit")
    public ResponseEntity<?> submitAssessmentScore(@RequestBody Score score) {
        gradebookService.submitScore(score);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/students/{studentId}/scores")
    public ResponseEntity<?> getStudentScores(@PathVariable Long studentId, @RequestParam Long courseId) {
        double studentScore = gradebookService.calculateStudentOverallScore(courseId, studentId);
        return ResponseEntity.ok(studentScore);
    }

    @GetMapping("/courses/{courseId}/scores")
    public ResponseEntity<?> getCourseScores(@PathVariable Long courseId) {
        double classScore = gradebookService.calculateClassOverallScore(courseId);
        return ResponseEntity.ok(classScore);
    }
}
