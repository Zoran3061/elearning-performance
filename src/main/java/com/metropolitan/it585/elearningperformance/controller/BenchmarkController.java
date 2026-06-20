package com.metropolitan.it585.elearningperformance.controller;

import com.metropolitan.it585.elearningperformance.service.BenchmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/benchmark")
@RequiredArgsConstructor
public class BenchmarkController {

    private final BenchmarkService benchmarkService;

    @GetMapping
    public Map<String, Object> runBenchmark() {
        return benchmarkService.runBenchmark();
    }

    @GetMapping("/cache")
    public Map<String, Object> runCacheBenchmark() {
        return benchmarkService.runCacheBenchmark();
    }
}