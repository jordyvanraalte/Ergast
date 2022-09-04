package nl.jordyvanraalte.ergast.services;

public interface ScoringService {
    public double getPoints(String scoringSystem, String position);
    public boolean doesScoringExist(String scoringSystem);
}
