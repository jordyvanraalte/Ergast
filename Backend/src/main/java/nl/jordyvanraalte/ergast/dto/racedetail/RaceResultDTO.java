package nl.jordyvanraalte.ergast.dto.racedetail;

import nl.jordyvanraalte.ergast.dto.CompetitorDTO;
import nl.jordyvanraalte.ergast.entities.Driver;

public class RaceResultDTO {
    private String position;
    private CompetitorDTO competitor;
    private double score;

    public RaceResultDTO(String position, CompetitorDTO competitor, double score) {
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

    public void setScore(double score) {
        this.score = score;
    }

    public String getCompetitorName(){
        return competitor.getName();
    }
}
