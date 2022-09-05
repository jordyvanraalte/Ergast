## Ergast Backend

This project was created with Springboot
## Getting started

### Installation
If not installed, install Maven on [Maven](https://maven.apache.org/install.html)

After installing Maven, add the missing dependencies to the project through the following command in the project directory where the POM.xml is located:

## `mvn dependency:resolve`

## Running the application

In the project directory, you can run to start the development server on localhost:8080 through the following command

## `mvn spring-boot:run`

The server is procected by the API key which is available in the application.properties. WARNING, change this API key if you want to run this project in production.

## Endpoints
Different Endpoints are available:

/seasons to fetch all the available seasons
/seasons/{season}/constructors to fetch the constructor standings of the season
/seasons/{season}/drivers to fetch the driver standings of the season
/seasons/{season}/constructors?scoring={scoring} to fetch the constructor standings of the season with a different score system
/seasons/{season}/drivers?scoring={scoring} to fetch the driver standings of the season with a different score system
/seasons/{season}/races to fetch the races of the season

/races/{season}/{round}/grid to fetch the starting grid of the race
/races/{season}/{round}/result to fetch the race result

/scores to fetch all possible score systems.
