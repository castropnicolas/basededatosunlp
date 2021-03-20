FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ADD target/basededatosunlp-0.0.1-SNAPSHOT.jar basededatosunlp.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/basededatosunlp.jar"]
