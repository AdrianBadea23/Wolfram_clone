FROM docker.io/library/maven:3.8.7-eclipse-temurin-17 AS builder

WORKDIR /usr/local/app
COPY . .

RUN mvn clean package

#FROM docker.io/library/eclipse-temurin:17-jdk
#
#WORKDIR /usr/local/app
#COPY --from=builder /usr/local/app/target/Wolfram_clone-0.0.1-SNAPSHOT.jar app.jar
#
#EXPOSE 8080
#
#CMD ["java", "-jar", "app.jar"]
