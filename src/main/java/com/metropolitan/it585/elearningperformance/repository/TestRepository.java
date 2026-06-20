package com.metropolitan.it585.elearningperformance.repository;

import com.metropolitan.it585.elearningperformance.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestEntity, Long> {
}