package nl.jordyvanraalte.ergast.services;

import java.util.List;

public interface ScoringService {
    public List<String> getScoringSystems();
    public double getPoints(String scoringSystem, String position);
    public boolean doesScoringExist(String scoringSystem);
}
