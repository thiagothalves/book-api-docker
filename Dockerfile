FROM openjdk:11
ADD target/book-api-docker.jar book-api-docker.jar
ENTRYPOINT ["java", "-jar","book-api-docker.jar"]
EXPOSE 8080