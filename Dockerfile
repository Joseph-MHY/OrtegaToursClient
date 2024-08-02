FROM amazoncorretto:21-alpine-jdk

ENV DATABASE_URL=jdbc:postgresql://dpg-cqir0luehbks73c1ss90-a.oregon-postgres.render.com:5432/ortegatours
ENV DATABASE_USERNAME=josephmhy
ENV DATABASE_PASSWORD=bewo1vBRDsZFz7SHgyFwuqNUDKjknXpO

COPY target/client-0.0.1-SNAPSHOT.jar ortegaclient.jar

ENTRYPOINT ["java", "-jar", "/ortegaclient.jar"]