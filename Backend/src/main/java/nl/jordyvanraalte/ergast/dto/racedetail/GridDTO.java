package nl.jordyvanraalte.ergast.dto.racedetail;

import nl.jordyvanraalte.ergast.dto.CompetitorDTO;
import nl.jordyvanraalte.ergast.entities.Driver;

public class GridDTO {
    private String position;
    private CompetitorDTO competitor;
    private String qualifyTime;

    public GridDTO(String position, CompetitorDTO competitor, String qualifyTime) {
        this.position = position;
        this.competitor = competitor;
        this.qualifyTime = qualifyTime;
    }
}
