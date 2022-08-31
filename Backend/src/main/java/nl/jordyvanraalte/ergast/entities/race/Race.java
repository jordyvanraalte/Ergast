package nl.jordyvanraalte.ergast.entities.race;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Race {
    @JsonProperty("season")
    private String season;
    @JsonProperty("round")
    private String round;
    @JsonProperty("url")
    private String url;
    @JsonProperty("raceName")
    private String raceName;
    @JsonProperty("date")
    private String date;
    @JsonProperty("time")
    private String time;
    @JsonProperty("Results")
    private List<RaceResult> results = null;
}
