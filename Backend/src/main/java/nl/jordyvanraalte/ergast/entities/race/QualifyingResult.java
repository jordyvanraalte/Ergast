package nl.jordyvanraalte.ergast.entities.race;

import com.fasterxml.jackson.annotation.JsonProperty;
import nl.jordyvanraalte.ergast.entities.Constructor;
import nl.jordyvanraalte.ergast.entities.Driver;

public class QualifyingResult {
    @JsonProperty("number")
    private String number;
    @JsonProperty("position")
    private String position;
    @JsonProperty("Driver")
    private Driver driver;
    @JsonProperty("Constructor")
    private Constructor constructor;

    @JsonProperty("Q3")
    private String q3;

    @JsonProperty("Q2")
    private String q2;

    @JsonProperty("Q1")
    private String q1;

    public String getNumber() {
        return number;
    }

    public String getPosition() {
        return position;
    }

    public Driver getDriver() {
        return driver;
    }

    public Constructor getConstructor() {
        return constructor;
    }

    public String getQ3() {
        return q3;
    }

    public String getQ2() {
        return q2;
    }

    public String getQ1() {
        return q1;
    }
}
