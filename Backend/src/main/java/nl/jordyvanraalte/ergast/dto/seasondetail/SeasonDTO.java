package nl.jordyvanraalte.ergast.dto.seasondetail;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "season",
        "pointSystem",
        "driverStandings",
        "constructorStandings",
        "races"
})
public class SeasonDTO {
    private String season;
    private String pointSystem;
    private List<DriverStandingDTO> driverStandings;
    private List<ConstructorStandingDTO> constructorStandings;
    private List<RaceDTO> races;

    public SeasonDTO(String season, String pointSystem, List<DriverStandingDTO> driverStandings, List<ConstructorStandingDTO> constructorStandings, List<RaceDTO> races) {
        this.season = season;
        this.pointSystem = pointSystem;
        this.driverStandings = driverStandings;
        this.constructorStandings = constructorStandings;
        this.races = races;
    }

    public String getSeason() {
        return season;
    }

    public String getPointSystem() {
        return pointSystem;
    }

    public List<DriverStandingDTO> getDriverStandings() {
        return driverStandings;
    }

    public List<ConstructorStandingDTO> getConstructorStandings() {
        return constructorStandings;
    }

    public List<RaceDTO> getRaces() {
        return races;
    }
}
