package nl.jordyvanraalte.ergast.dto;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompetitorDTO that = (CompetitorDTO) o;
        return Objects.equals(competitorId, that.competitorId) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(competitorId, name);
    }
}
