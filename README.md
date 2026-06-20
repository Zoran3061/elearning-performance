# 🚀 E-learning Performance Optimization

A Spring Boot application developed for the **IT585** course at Metropolitan University.

The project demonstrates **PostgreSQL database performance optimization** using indexing, SQL query analysis, benchmarking, and caching.

---

## 📌 Project Overview

The application simulates an e-learning platform and measures the performance of different database queries before and after optimization.

Main goals of the project:

- Optimize SQL queries using PostgreSQL indexes
- Compare execution time before and after optimization
- Benchmark different query types
- Demonstrate caching with Spring Cache
- Provide REST API documentation using Swagger

---

## 🛠 Technologies

- Java 17
- Spring Boot 3
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Swagger / OpenAPI
- Spring Cache

---

## 📂 Database Structure

The project contains the following entities:

- Students
- Courses
- Lessons
- Tests
- Test Results
- Activity Logs

More than **100,000 activity log records** are generated for performance testing.

---

## ⚡ Performance Experiments

The project includes multiple benchmark experiments:

### Query Optimization

- Search activity logs by Student ID
- Search activity logs by Course ID
- Search activity logs by Date
- Search activity logs by Student ID + Course ID

Each query is tested:

- Before indexing
- After indexing

using PostgreSQL `EXPLAIN ANALYZE`.

---

## 📈 Benchmark API

Benchmark endpoint:

```
GET /api/benchmark
```

Returns average execution times for:

- Student query
- Course query
- Date query
- Student + Course query

---

## ⚡ Cache Benchmark

Cache endpoint:

```
GET /api/benchmark/cache
```

Measures:

- First database call
- Cached call

and compares execution times.

---

## 📖 API Documentation

Swagger UI:

```
http://localhost:8080/swagger-ui/index.html
```
<img width="1916" height="969" alt="Screenshot 2026-06-20 164654" src="https://github.com/user-attachments/assets/eab9c32a-9f13-4b5f-9fb7-de1df3a20644" />

---

## ▶️ Running the Project

### Clone repository

```bash
git clone https://github.com/Zoran3061/elearning-performance.git
```

### Configure PostgreSQL

Create a PostgreSQL database and update:

```
application.properties
```

with your database credentials.

### Run

```bash
mvn spring-boot:run
```

---

## 📊 Features

✔ PostgreSQL integration

✔ Spring Boot REST API

✔ Hibernate ORM

✔ SQL optimization

✔ PostgreSQL indexing

✔ Benchmark testing

✔ Spring Cache

✔ Swagger/OpenAPI documentation

---

## 👨‍💻 Author

**Zoran Višić**

Faculty project for **IT585 – Database Performance Optimization**
