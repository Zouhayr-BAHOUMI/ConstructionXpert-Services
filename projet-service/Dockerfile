FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
COPY target/projet-service-0.0.1-SNAPSHOT.jar projet.jar
ENTRYPOINT ["java","-jar","/projet.jar"]