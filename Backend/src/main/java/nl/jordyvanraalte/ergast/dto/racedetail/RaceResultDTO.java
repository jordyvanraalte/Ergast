package nl.jordyvanraalte.ergast.dto.racedetail;

import nl.jordyvanraalte.ergast.dto.CompetitorDTO;
import nl.jordyvanraalte.ergast.entities.Driver;

public class RaceResultDTO {
    private String position;
    private CompetitorDTO competitor;
    private double points;

    public RaceResultDTO(String position, CompetitorDTO competitor, double points) {
        this.position = position;
        this.competitor = competitor;
        this.points = points;
    }

    public String getPosition() {
        return position;
    }

    public CompetitorDTO getCompetitor() {
        return competitor;
    }

    public double getPoints() {
        return points;
    }
}
