# Spring Boot with MySQL and Docker Compose

## STEPS FOR THIS SPRING BOOT APP
- Build the application.
- Build and Up Docker Compose.
- Check app application.

## BUILD the application
mvn clean install

## BUILD AND UP Docker Compose
docker-compose up --build
docker-compose down <- down docker compose

## Run company script
docker exec -it docker-mysql mysql -uroot -p
INSERT INTO companies(id) VALUES ('a4295f86-6cd0-4f48-acda-080005f3a558');

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
