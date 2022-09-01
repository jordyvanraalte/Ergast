package nl.jordyvanraalte.ergast.dto.seasondetail;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "round",
        "url",
        "raceName",
        "date",
        "time",
})
public class RaceDTO {
    private String round;
    private String url;
    private String raceName;
    private String date;
    private String time;

    public RaceDTO(String round, String url, String raceName, String date, String time) {
        this.round = round;
        this.url = url;
        this.raceName = raceName;
        this.date = date;
        this.time = time;
    }

    public String getRound() {
        return round;
    }

    public String getUrl() {
        return url;
    }

    public String getRaceName() {
        return raceName;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
