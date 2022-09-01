package nl.jordyvanraalte.ergast.entities.standings;

import com.fasterxml.jackson.annotation.JsonProperty;
import nl.jordyvanraalte.ergast.entities.Constructor;
import nl.jordyvanraalte.ergast.entities.Driver;

public class ConstructorStanding extends CompetitorStanding {
    @JsonProperty("position")
    private String position;
    @JsonProperty("positionText")
    private String positionText;
    @JsonProperty("points")
    private String points;
    @JsonProperty("wins")
    private String wins;
    @JsonProperty("Constructor")
    private Constructor constructor;

    public String getPosition() {
        return position;
    }

    public String getPositionText() {
        return positionText;
    }

    public String getPoints() {
        return points;
    }

    public String getWins() {
        return wins;
    }

    public Constructor getConstructor() {
        return constructor;
    }
}
