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
public class Driver {
    @JsonProperty("driverId")
    private String driverId;
    @JsonProperty("permanentNumber")
    private String permanentNumber;
    @JsonProperty("code")
    private String code;
    @JsonProperty("url")
    private String url;
    @JsonProperty("givenName")
    private String givenName;
    @JsonProperty("familyName")
    private String familyName;
    @JsonProperty("dateOfBirth")
    private String dateOfBirth;
    @JsonProperty("nationality")
    private String nationality;
}
