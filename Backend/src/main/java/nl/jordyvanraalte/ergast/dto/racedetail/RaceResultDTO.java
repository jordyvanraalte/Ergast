package nl.jordyvanraalte.ergast.dto.racedetail;

import nl.jordyvanraalte.ergast.entities.Driver;

public class RaceResultDTO {
    private String position;
    private Driver driver;
    private double points;

    public RaceResultDTO(String position, Driver driver, double points) {
        this.position = position;
        this.driver = driver;
        this.points = points;
    }

    public String getPosition() {
        return position;
    }

    public Driver getDriver() {
        return driver;
    }

    public double getPoints() {
        return points;
    }
}
