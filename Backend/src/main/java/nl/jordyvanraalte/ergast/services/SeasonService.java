package nl.jordyvanraalte.ergast.services;

import nl.jordyvanraalte.ergast.entities.race.RaceTable;
import nl.jordyvanraalte.ergast.entities.season.Season;

import java.util.List;

public interface SeasonService {
    List<Season> fetchAll();
    RaceTable fetch(String id);
}
