package com.metropolitan.it585.elearningperformance.service;

import com.metropolitan.it585.elearningperformance.entity.Course;
import com.metropolitan.it585.elearningperformance.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    @Cacheable("courses")
    public List<Course> getAllCourses() {
        System.out.println("Fetching courses from database...");
        return courseRepository.findAll();
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }
}