package nl.jordyvanraalte.ergast.entities.standings;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import nl.jordyvanraalte.ergast.entities.Constructor;
import nl.jordyvanraalte.ergast.entities.Driver;

import java.util.List;

public class Standing<T extends CompetitorStanding> {
    @JsonProperty("season")
    private String season;
    @JsonProperty("round")
    private String round;
    @JsonAlias({"DriverStandings", "ConstructorStandings"})
    private List<T> competitorStandings = null;

    public String getSeason() {
        return season;
    }

    public String getRound() {
        return round;
    }

    public List<T> getCompetitorStandings() {
        return competitorStandings;
    }
}
