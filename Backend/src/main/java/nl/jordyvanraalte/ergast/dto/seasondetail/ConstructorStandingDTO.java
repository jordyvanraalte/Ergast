package nl.jordyvanraalte.ergast.dto.seasondetail;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import nl.jordyvanraalte.ergast.entities.Constructor;
import nl.jordyvanraalte.ergast.entities.Driver;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "position",
        "constructor",
        "points",
        "wins",
})
public class ConstructorStandingDTO {
    private String position;
    private Constructor constructor;
    //double due to possibility of comma values (Belgium Grand prix 2021)
    private double points;
    private int wins;

    public ConstructorStandingDTO(String position, Constructor constructor, double points, int wins) {
        this.position = position;
        this.constructor = constructor;
        this.points = points;
        this.wins = wins;
    }

    public String getPosition() {
        return position;
    }

    public Constructor getConstructor() {
        return constructor;
    }

    public double getPoints() {
        return points;
    }

    public int getWins() {
        return wins;
    }
}
