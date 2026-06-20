package com.metropolitan.it585.elearningperformance.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer maxScore;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}