FROM amazoncorretto:21
LABEL author=wagnerwd40
EXPOSE 8761
WORKDIR /app
COPY ./target/*.jar ./app.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker", "app.jar"]