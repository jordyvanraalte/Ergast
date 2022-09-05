package nl.jordyvanraalte.ergast.entities.race;

import com.fasterxml.jackson.annotation.JsonProperty;
import nl.jordyvanraalte.ergast.entities.Constructor;
import nl.jordyvanraalte.ergast.entities.Driver;

public class RaceResult {
    private String number;
    @JsonProperty("position")
    private String position;
    @JsonProperty("positionText")
    private String positionText;
    @JsonProperty("points")
    private String points;
    @JsonProperty("Driver")
    private Driver driver;
    @JsonProperty("Constructor")
    private Constructor constructor;
    @JsonProperty("grid")
    private String grid;
    @JsonProperty("laps")
    private String laps;
    @JsonProperty("status")
    private String status;

    public String getNumber() {
        return number;
    }

    public String getPosition() {
        return position;
    }

    public String getPositionText() {
        return positionText;
    }

    public String getPoints() {
        return points;
    }

    public Driver getDriver() {
        return driver;
    }

    public Constructor getConstructor() {
        return constructor;
    }

    public String getGrid() {
        return grid;
    }

    public String getLaps() {
        return laps;
    }

    public String getStatus() {
        return status;
    }
}
