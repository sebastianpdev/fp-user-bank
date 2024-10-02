FROM gradle:8.10.2-jdk-lts-and-current-graal-jammy AS build

COPY . /app

WORKDIR /app

RUN gradle build --no-daemon

FROM openjdk:23-ea-17-jdk-bookworm

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

CMD java -jar app.jar