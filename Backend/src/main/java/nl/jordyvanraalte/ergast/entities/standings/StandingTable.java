package nl.jordyvanraalte.ergast.entities.standings;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import nl.jordyvanraalte.ergast.entities.Table;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Seasons"
})
public class StandingTable<T extends CompetitorStanding> extends Table {
    private String season;
    private String round;

    @JsonProperty("StandingsLists")
    private List<Standing<T>> standings = null;

    public void setSeason(String season) {
        this.season = season;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getSeason() {
        return season;
    }

    public String getRound() {
        return round;
    }

    public List<Standing<T>> getStandings() {
        return standings;
    }

    public void setStandings(List<Standing<T>> standings) {
        this.standings = standings;
    }
}
