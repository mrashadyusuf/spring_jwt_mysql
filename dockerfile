FROM openjdk:21-rc

COPY target/spring-boot-security-jwt-0.0.1-SNAPSHOT.jar /app/spring-boot-security-jwt-0.0.1-SNAPSHOT.jar

CMD ["java","-jar","/app/spring-boot-security-jwt-0.0.1-SNAPSHOT.jar"]
