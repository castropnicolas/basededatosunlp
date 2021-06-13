FROM java:8
COPY /target/basededatosunlp-0.0.1-SNAPSHOT.jar basededatosunlp.jar
ENTRYPOINT ["java","-jar","basededatosunlp.jar"]
