package com.metropolitan.it585.elearningperformance.repository;

import com.metropolitan.it585.elearningperformance.entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {

    List<ActivityLog> findByStudentId(Long studentId);

    List<ActivityLog> findByCourseId(Long courseId);

    List<ActivityLog> findByCreatedAtAfter(LocalDateTime date);

    List<ActivityLog> findByStudentIdAndCourseId(Long studentId, Long courseId);
}