package com.metropolitan.it585.elearningperformance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ElearningPerformanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElearningPerformanceApplication.class, args);
	}
}