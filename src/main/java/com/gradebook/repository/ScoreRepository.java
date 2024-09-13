package com.gradebook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gradebook.entity.Score;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findByCourseIdAndUserId(Long courseId, Long userId);
    List<Score> findByCourseId(Long courseId);
}
