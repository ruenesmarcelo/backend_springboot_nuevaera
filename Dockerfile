# ------------------------------------------------------
# 1) Build stage
# Construye el JAR usando Maven
# ------------------------------------------------------
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
# Copiamos pom.xml y descargamos dependencias primero (para cache)
COPY pom.xml .
RUN mvn dependency:go-offline
# Copiamos el código
COPY src ./src
# Construimos el jar
RUN mvn clean package -DskipTests
# ------------------------------------------------------
# 2) Run stage
# Corre el JAR con Java
# ------------------------------------------------------
FROM eclipse-temurin:21-jre
WORKDIR /app
# Copiamos el jar construido
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]