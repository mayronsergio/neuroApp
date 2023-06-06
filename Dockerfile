# Base image com JDK 17 e Maven
FROM maven:3.8-openjdk-17-slim as build
WORKDIR /src
COPY pom.xml .

# Baixa as dependências do Maven
RUN mvn dependency:go-offline
COPY . /src
# Compila o aplicativo
RUN mvn clean package -DskipTests

# Imagem de produção que contém apenas o JAR compilado e o Java Runtime Environment
FROM openjdk:20-slim
WORKDIR /app
COPY --from=build /src/target/neuroApp.jar /app/neuroApp.jar

CMD echo "America/Fortaleza" > /etc/timezone && dpkg-reconfigure -f noninteractive tzdata

ENV TZ America/Fortaleza

EXPOSE 8080
CMD ["java", "-jar", "neuroApp.jar"]