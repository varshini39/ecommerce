# ecommerce

1. Generate a Spring Boot project using Spring Initializer (https://start.spring.io/)<br>
Project: Maven<br>
Java: OpenJDK 21<br>
Dependencies to Include:<br>
Spring Web (for REST APIs)<br>
Spring Boot JPA (Hibernate) (for database interactions)<br>
PostgreSQL Driver (to connect with Postgres)<br>
Spring Security (for authentication/authorization)<br>
Lombok (to reduce boilerplate code)<br>
Spring Boot DevTools (for hot reloads during development - doesn't need to restart the server)<br>

2. Liquibase library is used to manage DDL operations

3. File structure:<br>
controller/ -> REST Controllers<br>
service/ -> Business Logic<br>
repository/ -> JPA Repositories<br>
model/ -> Entity Models<br>
dto/ -> Data Transfer Objects (optional) - instead of returning actual entity model to the client, we can create DTOs, to avoid exposing any sensitive data and return necessary data alone<br>
config/ or util/ -> utility files<br>
filter/ -> security filter<br>
Workflow:<br>
Frontend (React)  <--->  Controller  <--->  Service  <--->  Repository (JPA)  <--->  Database (PostgreSQL)<br>





