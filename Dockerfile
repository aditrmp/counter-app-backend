FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
COPY target/counterapp-1.0.jar counterapp-1.0.jar
ENTRYPOINT ["java","-jar","/counterapp-1.0.jar"]