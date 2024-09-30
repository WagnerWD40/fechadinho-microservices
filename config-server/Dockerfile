FROM amazoncorretto:21
LABEL author=wagnerwd40
WORKDIR /app
COPY ./target/*.jar ./app.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker", "app.jar"]