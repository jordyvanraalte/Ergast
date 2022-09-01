package nl.jordyvanraalte.ergast.services;

import nl.jordyvanraalte.ergast.dto.SeasonsDTO;
import nl.jordyvanraalte.ergast.dto.seasondetail.SeasonDTO;
import nl.jordyvanraalte.ergast.entities.race.RaceTable;
import nl.jordyvanraalte.ergast.entities.season.Season;

import java.util.List;

public interface SeasonService {
    List<SeasonsDTO> getAll();
    SeasonDTO getSeason(String year);
}
