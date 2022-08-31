package nl.jordyvanraalte.ergast.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "constructorId",
        "url",
        "name",
        "nationality"
})
public class Constructor {
    @JsonProperty("constructorId")
    private String constructorId;
    @JsonProperty("url")
    private String url;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nationality")
    private String nationality;

    public String getConstructorId() {
        return constructorId;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }
}
