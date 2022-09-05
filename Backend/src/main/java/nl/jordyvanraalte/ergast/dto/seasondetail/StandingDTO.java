package nl.jordyvanraalte.ergast.dto.seasondetail;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import nl.jordyvanraalte.ergast.dto.CompetitorDTO;
import nl.jordyvanraalte.ergast.entities.Constructor;
import nl.jordyvanraalte.ergast.entities.Driver;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "position",
        "constructor",
        "points",
        "wins",
})
public class StandingDTO {
    private String position;
    private CompetitorDTO competitor;
    //double due to possibility of comma values (Belgium Grand prix 2021)
    private double score;

    public StandingDTO(String position, CompetitorDTO competitor, double score) {
        this.position = position;
        this.competitor = competitor;
        this.score = score;
    }

    public String getPosition() {
        return position;
    }

    public CompetitorDTO getCompetitor() {
        return competitor;
    }

    public double getScore() {
        return score;
    }
}





