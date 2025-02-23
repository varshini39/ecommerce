# ecommerce

1. You can generate a Spring Boot project using Spring Initializr (https://start.spring.io/)
Project: Maven
Java: OpenJDK 21
Dependencies to Include:
Spring Web (for REST APIs)
Spring Boot JPA (Hibernate) (for database interactions)
PostgreSQL Driver (to connect with Postgres)
Spring Security (for authentication/authorization)
Lombok (to reduce boilerplate code)
Spring Boot DevTools (for hot reloads during development - doesn't need to restart the server)

2. Liquibase library is used to manage DDL operations

3. File structure:
controller/ -> REST Controllers
service/ -> Business Logic
repository/ -> JPA Repositories
model/ -> Entity Models
dto/ -> Data Transfer Objects (optional) - instead of returning actual entity model to the client, we can create DTOs,
to avoid
exposing any sensitive data
and return necessary data alone
config/ or util/ -> utility files
filter/ -> security filter
Workflow:
Frontend (React)  <--->  Controller  <--->  Service  <--->  Repository (JPA)  <--->  Database (PostgreSQL)





