package nl.jordyvanraalte.ergast.dto;

public class CompetitorDTO {
    private String competitorId;
    private String name;

    public CompetitorDTO(String competitorId, String name) {
        this.competitorId = competitorId;
        this.name = name;
    }

    public String getCompetitorId() {
        return competitorId;
    }

    public String getName() {
        return name;
    }
}
