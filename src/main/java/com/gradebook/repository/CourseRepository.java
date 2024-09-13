package com.gradebook.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gradebook.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

