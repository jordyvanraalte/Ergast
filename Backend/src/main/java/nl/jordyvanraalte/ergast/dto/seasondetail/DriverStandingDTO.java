package nl.jordyvanraalte.ergast.dto.seasondetail;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import nl.jordyvanraalte.ergast.entities.Driver;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "position",
        "driver",
        "points",
        "wins",
})
public class DriverStandingDTO {
    private String position;
    private Driver driver;
    //double due to possibility of comma values (Belgium Grand prix 2021)
    private double points;
    private int wins;

    public DriverStandingDTO(String position, Driver driver, double points, int wins) {
        this.position = position;
        this.driver = driver;
        this.points = points;
        this.wins = wins;
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

    public int getWins() {
        return wins;
    }
}
