# Spring Boot with MySQL and Docker Compose

## STEPS FOR THIS SPRING BOOT APP
- Define dependencies in pom.xml.
- Create a Spring Boot Main @SpringBootApplication.
- Create components @Entity / @RestController / @Repository.
- Create application.properties.
- Build the application.
- Check app application.

## BUILD the application
mvn clean install

## BUILD AND UP Docker Compose
docker-compose up --build   
docker-compose down <- down docker compose

## Check app application
http://localhost:8080/user/all

### Example POST /user/save
curl -s -X POST \
http://localhost:8080/user/create \
-H 'Content-Type: application/json' \
-d '{"username":"quito"}'


### GET /user/{id}
curl -s -X GET \
http://localhost:8080/user/quito
