FROM maven:3.8.4-openjdk-17

WORKDIR /app

COPY . /app

COPY pom.xml /app

RUN mvn clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/upload.download.files.system-1.0.0.jar"]
