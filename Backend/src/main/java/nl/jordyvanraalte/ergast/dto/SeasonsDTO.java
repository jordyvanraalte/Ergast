package nl.jordyvanraalte.ergast.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "season",
})
public class SeasonsDTO {
    private String season;

    public SeasonsDTO(String season) {
        this.season = season;
    }

    public String getSeason() {
        return season;
    }
}
