FROM openjdk:8-jdk

LABEL maintainer "michael.zender@bsi-software.com"

ENV TASKS_VERSION=0.1.0-SNAPSHOT

COPY target/standalone-$TASKS_VERSION.jar /opt/tasks/tasks-standalone.jar

EXPOSE 8080

CMD ["java", "-jar", "/opt/tasks/tasks-standalone.jar"]

