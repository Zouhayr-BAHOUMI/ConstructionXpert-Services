FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
COPY target/discovery-0.0.1-SNAPSHOT.jar discovery.jar
ENTRYPOINT ["java","-jar","/discovery.jar"]
