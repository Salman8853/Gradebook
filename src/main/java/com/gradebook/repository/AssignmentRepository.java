package com.gradebook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gradebook.entity.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findByCourseId(Long courseId);
}

