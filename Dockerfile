FROM openjdk:17-alpine
COPY build/libs/planilla-0.0.1-SNAPSHOT.jar planilla-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/planilla-0.0.1-SNAPSHOT.jar"]