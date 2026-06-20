package com.metropolitan.it585.elearningperformance.config;

import com.metropolitan.it585.elearningperformance.entity.*;
import com.metropolitan.it585.elearningperformance.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final LessonRepository lessonRepository;
    private final TestRepository testRepository;
    private final TestResultRepository testResultRepository;
    private final ActivityLogRepository activityLogRepository;

    @Override
    public void run(String... args) {

        if (activityLogRepository.count() > 0) {
            return;
        }

        Random random = new Random();

        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<TestEntity> tests = new ArrayList<>();

        // Courses, lessons and tests
        if (courseRepository.count() <= 1) {
            for (int i = 1; i <= 10; i++) {
                Course course = courseRepository.save(Course.builder()
                        .title("Course " + i)
                        .description("Description for course " + i)
                        .category(i % 2 == 0 ? "Programming" : "Security")
                        .active(true)
                        .build());

                courses.add(course);

                for (int j = 1; j <= 10; j++) {
                    lessonRepository.save(Lesson.builder()
                            .title("Lesson " + j + " for Course " + i)
                            .contentUrl("https://example.com/course-" + i + "/lesson-" + j)
                            .durationMinutes(20 + random.nextInt(40))
                            .course(course)
                            .build());
                }

                TestEntity test = testRepository.save(TestEntity.builder()
                        .title("Test for Course " + i)
                        .maxScore(100)
                        .course(course)
                        .build());

                tests.add(test);
            }
        } else {
            courses = courseRepository.findAll();
            tests = testRepository.findAll();
        }

        // Students
        if (studentRepository.count() == 0) {
            for (int i = 1; i <= 1000; i++) {
                Student student = studentRepository.save(Student.builder()
                        .fullName("Student " + i)
                        .email("student" + i + "@example.com")
                        .city(i % 2 == 0 ? "Belgrade" : "Novi Sad")
                        .build());

                students.add(student);
            }
        } else {
            students = studentRepository.findAll();
        }

        // Test results
        if (testResultRepository.count() == 0) {
            for (int i = 1; i <= 5000; i++) {
                Student student = students.get(random.nextInt(students.size()));
                TestEntity test = tests.get(random.nextInt(tests.size()));

                testResultRepository.save(TestResult.builder()
                        .student(student)
                        .test(test)
                        .score(50 + random.nextInt(51))
                        .submittedAt(LocalDateTime.now().minusDays(random.nextInt(365)))
                        .build());
            }
        }

        // Activity logs
        String[] actions = {
                "LOGIN",
                "VIEW_COURSE",
                "VIEW_LESSON",
                "START_TEST",
                "SUBMIT_TEST",
                "DOWNLOAD_MATERIAL"
        };

        if (activityLogRepository.count() == 0) {
            for (int i = 1; i <= 100000; i++) {
                Student student = students.get(random.nextInt(students.size()));
                Course course = courses.get(random.nextInt(courses.size()));

                activityLogRepository.save(ActivityLog.builder()
                        .student(student)
                        .course(course)
                        .action(actions[random.nextInt(actions.length)])
                        .createdAt(LocalDateTime.now().minusDays(random.nextInt(365)))
                        .ipAddress("192.168.1." + random.nextInt(255))
                        .build());

                if (i % 10000 == 0) {
                    System.out.println("Inserted activity logs: " + i);
                }
            }
        }

        System.out.println("Data seeding completed successfully.");
    }
}