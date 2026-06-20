package com.metropolitan.it585.elearningperformance.repository;

import com.metropolitan.it585.elearningperformance.entity.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestResultRepository extends JpaRepository<TestResult, Long> {
}