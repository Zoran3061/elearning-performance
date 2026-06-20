package com.metropolitan.it585.elearningperformance.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String contentUrl;

    private Integer durationMinutes;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}