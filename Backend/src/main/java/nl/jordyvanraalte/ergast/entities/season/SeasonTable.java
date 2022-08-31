package nl.jordyvanraalte.ergast.entities.season;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import nl.jordyvanraalte.ergast.entities.Table;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Seasons"
})
public class SeasonTable extends Table {

    @JsonProperty("Seasons")
    private List<Season> seasons = null;

    @JsonProperty("Seasons")
    public List<Season> getSeasons() {
        return seasons;
    }

    @JsonProperty("Seasons")
    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }
}