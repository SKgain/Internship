# Bank API

A simple banking system built with **Spring Boot**, featuring **JWT authentication**, account management, and transaction tracking.

## Features

### Authentication
- User registration and login
- Password encryption using BCrypt
- JWT-based authentication and authorization

### Account Management
- Initialize account balance
- Deposit money
- Transfer money between accounts
- View transaction history

### Validation & Exception Handling
- Input validation using `jakarta.validation`
- Custom exceptions:
  - `ResourceNotFoundException`
  - `InsufficientBalanceException`
  - `DuplicateResourceException`
- Planned: Global exception handling using `@ControllerAdvice`

### Database & Utilities
- **ORM:** Spring Data JPA repositories
- **Entities:** `User`, `Account`, `Transaction`
- **Relationships:** 
  - `User ↔ Account (OneToOne)`
  - `User ↔ Transaction (OneToMany)`
- **Utilities:** ModelMapper for DTO mapping, Lombok for boilerplate reduction, Slf4j for logging

## Technologies Used
- Java 17+
- Spring Boot 3
- Spring Security with JWT
- Spring Data JPA
- postgreSQL database
- ModelMapper
- Lombok
- Maven

## Prerequisites
Before you begin, ensure you have the following installed:
- Java Development Kit (JDK) 17 or later
- Apache Maven
- A running instance of postgreSQL

## Getting Started
Follow these steps to get a local copy of the project up and running.

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/bank-api.git
cd bank-api
```
### 2. Configure Application Properties

#### Open the src/main/resources/application.properties file and update the datasource properties to match your local database setup.

MySQL Database Configuration
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/bank
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Build the Project

Use Maven to compile the project and download all necessary dependencies.
```bash
mvn clean install
```
### 4. Run the Application

Run the Spring Boot application:
```bash
mvn spring-boot:run
```

The API will be running on http://localhost:8080.

API Endpoints

To use the secured endpoints, first register and sign in to get a JWT. Include this token in the Authorization header as a Bearer token.

| Endpoint                  | Method | Description                        | Secured |
|---------------------------|--------|------------------------------------|---------|
| /api/auth/sign-up         | POST   | Register a new user                | No      |
| /api/auth/sign-in         | POST   | Login and receive a JWT token      | No      |
| /api/accounts/init        | POST   | Initialize account balance         | Yes     |
| /api/accounts/deposit     | POST   | Deposit money into an account      | Yes     |
| /api/accounts/transfer    | POST   | Transfer money between accounts    | Yes     |
| /api/transactions         | GET    | List all transactions for a user   | Yes     |

## Project Structure
```
src/main/java/com/example/bank/
├── config/       # Security & App configuration
├── controller/   # REST controllers
├── DTO/          # Request and Response DTOs
├── entity/       # JPA entities
├── exception/    # Custom exceptions
├── filter/       # JWT filter
├── repository/   # Spring Data JPA repositories
├── service/      # Business logic
└── BankApplication.java
```
