package com.gradebook.model;

import java.time.LocalDateTime;

public class StudentAssessmentScore {
	
	private String courseId;
    private String userId;
    private String assessmentId;
    private LocalDateTime dateSubmitted;
    private int pointsEarned;

    public StudentAssessmentScore(String courseId, String userId, String assessmentId, LocalDateTime dateSubmitted, int pointsEarned) {
        this.courseId = courseId;
        this.userId = userId;
        this.assessmentId = assessmentId;
        this.dateSubmitted = dateSubmitted;
        this.pointsEarned = pointsEarned;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getUserId() {
        return userId;
    }

    public String getAssessmentId() {
        return assessmentId;
    }

    public LocalDateTime getDateSubmitted() {
        return dateSubmitted;
    }

    public int getPointsEarned() {
        return pointsEarned;
    }

}
