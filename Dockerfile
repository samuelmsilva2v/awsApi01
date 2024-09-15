# Etapa 1: Build da aplicação
FROM maven:3.8.7-eclipse-temurin-17 AS build
WORKDIR /app
# Copiar o arquivo pom.xml e resolver as dependências
COPY pom.xml .
RUN mvn dependency:go-offline -B
# Copiar o restante do código-fonte
COPY src ./src
# Compilar o projeto e gerar o arquivo JAR
RUN mvn clean package -DskipTests
# Etapa 2: Imagem final para rodar o Spring Boot
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
# Copiar o JAR gerado na fase anterior
COPY --from=build /app/target/AwsApi01-0.0.1-SNAPSHOT.jar app.jar
# Expor a porta onde o Spring Boot vai rodar
EXPOSE 8080
# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]