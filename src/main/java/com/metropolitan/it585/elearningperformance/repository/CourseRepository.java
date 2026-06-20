package com.metropolitan.it585.elearningperformance.repository;

import com.metropolitan.it585.elearningperformance.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}