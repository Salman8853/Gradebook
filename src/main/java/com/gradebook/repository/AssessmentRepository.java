package com.gradebook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gradebook.entity.Assessment;

public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
    List<Assessment> findByAssignmentId(Long assignmentId);
}

