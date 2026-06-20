package com.metropolitan.it585.elearningperformance.service;

import com.metropolitan.it585.elearningperformance.repository.ActivityLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BenchmarkService {

    private final ActivityLogRepository activityLogRepository;
    private final CourseService courseService;

    public Map<String, Object> runBenchmark() {
        Map<String, Object> results = new LinkedHashMap<>();

        int iterations = 100;

        long studentTime = measure(() -> activityLogRepository.findByStudentId(500L), iterations);
        long courseTime = measure(() -> activityLogRepository.findByCourseId(5L), iterations);
        long dateTime = measure(() -> activityLogRepository.findByCreatedAtAfter(LocalDateTime.of(2026, 6, 15, 0, 0)), iterations);
        long studentCourseTime = measure(() -> activityLogRepository.findByStudentIdAndCourseId(500L, 6L), iterations);

        results.put("iterations", iterations);
        results.put("studentQueryAverageMs", studentTime / 1_000_000.0);
        results.put("courseQueryAverageMs", courseTime / 1_000_000.0);
        results.put("dateQueryAverageMs", dateTime / 1_000_000.0);
        results.put("studentCourseQueryAverageMs", studentCourseTime / 1_000_000.0);

        return results;
    }

    private long measure(Runnable runnable, int iterations) {
        long totalTime = 0;

        for (int i = 0; i < iterations; i++) {
            long start = System.nanoTime();
            runnable.run();
            long end = System.nanoTime();

            totalTime += (end - start);
        }

        return totalTime / iterations;
    }

    public Map<String, Object> runCacheBenchmark() {
        Map<String, Object> results = new LinkedHashMap<>();

        long firstStart = System.nanoTime();
        courseService.getAllCourses();
        long firstEnd = System.nanoTime();

        long secondStart = System.nanoTime();
        courseService.getAllCourses();
        long secondEnd = System.nanoTime();

        results.put("firstCallMs", (firstEnd - firstStart) / 1_000_000.0);
        results.put("secondCallCachedMs", (secondEnd - secondStart) / 1_000_000.0);

        return results;
    }
}