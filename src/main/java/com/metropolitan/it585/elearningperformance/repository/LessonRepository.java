package com.metropolitan.it585.elearningperformance.repository;

import com.metropolitan.it585.elearningperformance.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}