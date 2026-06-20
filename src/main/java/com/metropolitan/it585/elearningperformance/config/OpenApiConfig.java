package com.metropolitan.it585.elearningperformance.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI elearningOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("E-learning Performance Optimization API")
                        .description("API za IT585 projekat: optimizacija performansi PostgreSQL baze, indeksi, benchmark i cache.")
                        .version("1.0"));
    }
}