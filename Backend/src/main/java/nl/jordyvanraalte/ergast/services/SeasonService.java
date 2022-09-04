package nl.jordyvanraalte.ergast.services;

import nl.jordyvanraalte.ergast.dto.SeasonsDTO;
import nl.jordyvanraalte.ergast.dto.seasondetail.RaceDTO;
import nl.jordyvanraalte.ergast.dto.seasondetail.StandingDTO;

import java.util.List;

public interface SeasonService {
    List<SeasonsDTO> getAll() throws Exception;
    List<StandingDTO> getSeasonConstructors(String season) throws Exception;
    List<StandingDTO> getSeasonDrivers(String season) throws Exception;
    List<StandingDTO> getSeasonDriversWithDifferentScoring(String season, String scoring) throws Exception;
    List<StandingDTO> getSeasonConstructorsWithDifferentScoring(String season, String scoring) throws Exception;
    List<RaceDTO> getSeasonRaces(String season) throws Exception;
}
