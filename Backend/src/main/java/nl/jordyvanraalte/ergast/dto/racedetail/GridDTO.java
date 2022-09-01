package nl.jordyvanraalte.ergast.dto.racedetail;

import nl.jordyvanraalte.ergast.entities.Driver;

public class GridDTO {
    private String position;
    private Driver driver;
    private String qualifyTime;

    public GridDTO(String position, Driver driver, String qualifyTime) {
        this.position = position;
        this.driver = driver;
        this.qualifyTime = qualifyTime;
    }

    public String getPosition() {
        return position;
    }

    public Driver getDriver() {
        return driver;
    }

    public String getQualifyTime() {
        return qualifyTime;
    }
}
