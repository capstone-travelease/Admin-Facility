FROM openjdk:21

VOLUME /tmp

COPY target/*.jar Facility-Admin-0.0.1-SNAPSHOT.jar

EXPOSE 28645
ENTRYPOINT ["java","-jar","/Facility-Admin-0.0.1-SNAPSHOT.jar"]