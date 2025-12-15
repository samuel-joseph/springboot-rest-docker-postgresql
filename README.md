# Spring Boot + PostgreSQL Dockerized Application

## Overview
This is a sample Spring Boot application demonstrating a **RESTful API** for managing `SoftwareEngineer` entities, integrated with **PostgreSQL** as the database and **Docker** for containerization.  

The project uses:
- **Spring Boot** for building the REST API
- **Spring Data JPA** for database operations
- **PostgreSQL** for relational data storage
- **Docker & Docker Compose** for containerized development and deployment

---

## Features
- CRUD operations for `SoftwareEngineer` entities
- PostgreSQL database integration
- Dockerized Spring Boot app and PostgreSQL service
- Hibernate auto schema generation (`ddl-auto: update`)
- SQL logging for debugging (`spring.jpa.show-sql: true`)

---

## Project Structure

springboot-docker-postgresql/
├── src/main/java/com/springboot_docker_postgresql/demo/
│ ├── DemoApplication.java # Main Spring Boot application
│ ├── SoftwareEngineer.java # JPA entity
│ └── SoftwareEngineerRepo.java # JPA repository interface
├── Dockerfile # Build instructions for Spring Boot container
├── docker-compose.yml # Local orchestration for app + PostgreSQL
└── application.yml # Spring Boot configuration


---

## Docker Setup

### 1. Build and run with Docker Compose
```bash
docker compose up --build -d

    app runs the Spring Boot application

    db runs the PostgreSQL database

2. Stop containers

docker compose down

3. Reset database (remove volumes)

docker compose down -v
docker compose up -d

4. Access PostgreSQL inside container

docker exec -it postgres_db psql -U demo_user -d demo_db

Spring Boot Configuration (application.yml)

spring:
  application:
    name: demo

  datasource:
    url: jdbc:postgresql://localhost:5332/demo_db
    username: demo_user
    password: demo_pass
    driver-class-name: org.postgresql.Driver

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

    ddl-auto: update automatically creates tables for JPA entities

    show-sql: true logs executed SQL statements to console

Example API Endpoints
Method	Endpoint	Description
POST	/software-engineers	Add new engineer
GET	/software-engineers	List all engineers
GET	/software-engineers/{id}	Get engineer by ID
PUT	/software-engineers/{id}	Update engineer
DELETE	/software-engineers/{id}	Delete engineer

Example POST request body:

{
  "name": "Sam",
  "techStack": "Java"
}

JPA Repository Explanation

SoftwareEngineerRepo extends JpaRepository<SoftwareEngineer, Integer>:

    Provides built-in CRUD operations

    No implementation required — Spring Data JPA generates it at runtime

    Custom queries can be added easily, e.g., findByTechStack(String techStack)

How Docker and Application Work Together

    docker-compose.yml orchestrates two services:

        app → Spring Boot application container

        db → PostgreSQL database container

    Environment variables in compose ensure Spring Boot connects to the database

    Local development mirrors production setup in a repeatable containerized environment

Requirements

    Java 17+

    Maven

    Docker & Docker Compose

Running Locally Without Docker (Optional)

    Start PostgreSQL on your host machine

    Configure application.yml with your host database connection

    Run the Spring Boot app:

mvn spring-boot:run

Notes

    Port 8080 must be free locally

    To view database tables:

\dt

    To query data:

select * from software_engineer;
