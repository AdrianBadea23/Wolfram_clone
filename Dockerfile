FROM docker.io/library/eclipse-temurin:17-jdk

WORKDIR /usr/local/app
COPY target/Wolfram_clone-0.0.1-SNAPSHOT.jar ./

EXPOSE 8080

CMD ["java", "-jar", "Wolfram_clone-0.0.1-SNAPSHOT.jar"]
