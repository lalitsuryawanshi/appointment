FROM openjdk:17-oracle

COPY target/appointment-0.0.1-SNAPSHOT.jar appointment.jar

ENTRYPOINT ["java","-jar","/appointment.jar"]