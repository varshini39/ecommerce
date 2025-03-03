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

2. Liquibase library is used to manage DDL operations.<br>
Added liquibase.properties file for debugging purpose - to get change logs

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

4. For locations, we use postgis and hibernate-spatial. For 'Point' variable (referring the latitude,longitude), we 
   use org.locationtech.jts. Install postgis in your postgres setup

5. Added DB connection pool related properties<br>
spring.jpa.show-sql=true -> Logs SQL queries	false<br>
spring.jpa.properties.hibernate.format_sql=true -> Formats SQL output<br>
spring.datasource.hikari.maximum-pool-size=10 -> Limits max DB connections<br>
spring.datasource.hikari.minimum-idle=2 -> Ensures at least 2 idle connections<br>
spring.datasource.hikari.idle-timeout=30000 -> Closes idle connections after 30 sec<br>
spring.datasource.hikari.connection-timeout=20000 -> Max wait time for a connection<br>
spring.datasource.hikari.max-lifetime=1800000 -> Max connection lifetime

6. Added "querydsl" library for fetching data from DB without writing queries. Mainly used for complicated joins and 
   criteria. It generates Q-Classes for each entity and we would use it to fetch the data.







