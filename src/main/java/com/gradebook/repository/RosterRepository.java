package com.gradebook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gradebook.entity.Roster;

public interface RosterRepository extends JpaRepository<Roster, Long> {
    List<Roster> findByCourseId(Long courseId);
}

