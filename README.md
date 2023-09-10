# Flight Search App (Backend)

Backend app for a flight search application. 

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Project Structure](#project-structure)
- [API Endpoints](#api-endpoints)
- [Authentication](#authentication)
- [Search API](#seacrh-api)
- [Contact](#contact)

## Introduction

This project is a backend API developed for a flight search application. It allows users to search for flights based on various criteria, manage airports, and perform CRUD operations on flight data.

## Features

- CRUD operations for flights and airports.
- Search API for listing flights based on departure, arrival, departure date, and return date.
- Authentication system for user security & Role based endpoint coverage (ADMIN & USER).
- Scheduled background jobs for updating flight information from a third-party API (mocked in this case).

## Technologies Used

- Java 17
- Spring Boot
- MySQL (or your chosen relational database)
- Hibernate
- JWT Token Authentication
- Swagger UI (API documentation)
- Git (Version control)

## Getting Started

### Prerequisites

- Java 17 should be installed.
- MySQL or another relational database should be set up and configured.
- Git should be installed.

### Installation

1. **Clone this repository to your local machine:**

```bash
  git clone https://github.com/CankatCS/FlightSearchApp.git
```

2. **Database configuration:**
Create a MySQL database for the project.

Open the src/main/resources/application.properties file.

Modify the following properties to match your database configuration:
 ```bash
spring.datasource.url=jdbc:mysql://localhost:8080/your_database_name
spring.datasource.username=your_database_username
spring.datasource.password=your_database_password
```
3. Build and run the project:
```bash
cd flight-search-api
./mvnw spring-boot:run
```
### Project Structure

Here's an overview of the directory structure of this project:

- **`src/main/java`**: This directory contains the Java source code for application.
  - `com.amadeuscankatsezer.casestudy`: The main package for application.
    - `controller`: Contains API controllers.
    - `model`: Contains data models and entities.
    - `repository`: Contains database repository interfaces.
    - `service`: Contains business logic and services.
    - `dto`: Contains dto classes.
    - `filter`: Contains JWT authentication filter class.
    - `mapper`: Contains "toEntity" and "toDto" classes.
    - `mockapi`: Contains the classes that handle mock flight data generation.
    - `scheduler`: Contains scheduler & requesting to mock api to get flight data.
    - `security`: Contains security configurations.
- **`src/main/resources`**: Configuration files and resources.
  - `application.properties`: Configuration file for Spring Boot, including database settings.
- **`pom.xml`**: Maven project configuration file.

### API Endpoints
Here is all endpoints 

![swaggerUI_Controllers](https://github.com/CankatCS/RoleBasedAuth/assets/68610552/27aa0c49-a7f8-425f-83dc-7812c1cc7eef)

### Authentication

Authentication and security in this project are implemented using JSON Web Tokens (JWT) for user identity verification and access control. We use the `SignatureAlgorithm.HS256` algorithm to sign and verify JWT tokens. Below, we provide a detailed overview of how authentication and security are configured in this project.

In the Spring Security configuration (`SecurityFilterChain`), we have the following settings:

- CSRF protection is disabled (`csrf.disable()`) as this is a stateless REST API.
- Session management is set to `SessionCreationPolicy.STATELESS` to ensure no session management is performed.
- Certain endpoints such as sign-up and sign-in, as well as Swagger API documentation, are configured to be accessible without authentication using `.permitAll()`.
- All other requests require authentication.
- An authentication provider and a JWT authentication filter are configured.

Here is the relevant code snippet:

```java
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable())
        .sessionManagement(session -> session
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        )
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers(HttpMethod.POST, "/api/v1/signup", "/api/v1/signin").permitAll()
            .requestMatchers(
                "/swagger-ui/**",
                "/v2/api-docs",
                "/v3/api-docs",
                "/v3/api-docs/**",
                "/swagger-resources",
                "/swagger-resources/**",
                "/configuration/ui",
                "/configuration/security",
                "/swagger-ui/**",
                "/webjars/**",
                "/swagger-ui.html"
            ).permitAll()
            .anyRequest().authenticated()
        )
        .authenticationProvider(authenticationProvider())
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    return http.build();
}
```

### Search API

Here is the format that you can use to make requests to search API & some example output

1.One way flight request;

![oneWayOutput](https://github.com/CankatCS/RoleBasedAuth/assets/68610552/517945a7-65bc-4ae6-a7e5-119f98965c81)

2. Round up trip flight request;

![twoWayOutput](https://github.com/CankatCS/RoleBasedAuth/assets/68610552/ac71e195-6466-4c3d-8891-f2c12848a742)

### Contact

- Cankat Sezer
- Tel: [+90 506 933 26 77](tel:+905069332677)
- E-posta: [cankatsezer55@gmail.com](mailto:cankatsezer55@gmail.com)
- Linkedin: [www.linkedin.com/in/cankatsezer](https://www.linkedin.com/in/cankatsezer/)
