FROM amazoncorretto:21-alpine-jdk

COPY target/client-0.0.1-SNAPSHOT.jar ortegaclient.jar

ENTRYPOINT ["java", "-jar", "/ortegaclient.jar"]