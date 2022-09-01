package nl.jordyvanraalte.ergast.entities.race;

import com.fasterxml.jackson.annotation.JsonProperty;
import nl.jordyvanraalte.ergast.entities.Table;

import java.util.List;

public class RaceTable extends Table {
    @JsonProperty("season")
    private String season;
    @JsonProperty("Races")
    private List<Race> races = null;

    public String getSeason() {
        return season;
    }

    public List<Race> getRaces() {
        return races;
    }

}
