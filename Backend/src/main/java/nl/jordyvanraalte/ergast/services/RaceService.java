package nl.jordyvanraalte.ergast.services;

import nl.jordyvanraalte.ergast.dto.racedetail.GridDTO;
import nl.jordyvanraalte.ergast.dto.racedetail.RaceResultDTO;
import nl.jordyvanraalte.ergast.entities.race.RaceResult;

import java.util.List;

public interface RaceService {
    public List<RaceResultDTO> getRaceResults(String year, String round) throws Exception;
    public List<GridDTO> getQualifyingResults(String year, String round) throws Exception;
    public List<RaceResult> getRaceResultsForScoring(String year, String round) throws Exception;
}
