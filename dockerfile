FROM openjdk:17

COPY target/spring-jwt.jar /app/spring-jwt.jar

CMD ["java","-jar","/app/spring-jwt.jar"]
