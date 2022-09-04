package nl.jordyvanraalte.ergast.services.impl;

import nl.jordyvanraalte.ergast.dto.CompetitorDTO;
import nl.jordyvanraalte.ergast.dto.SeasonsDTO;
import nl.jordyvanraalte.ergast.dto.racedetail.RaceResultDTO;
import nl.jordyvanraalte.ergast.dto.seasondetail.RaceDTO;
import nl.jordyvanraalte.ergast.dto.seasondetail.StandingDTO;
import nl.jordyvanraalte.ergast.entities.Response;
import nl.jordyvanraalte.ergast.entities.race.RaceTable;
import nl.jordyvanraalte.ergast.entities.season.SeasonTable;
import nl.jordyvanraalte.ergast.entities.standings.ConstructorStanding;
import nl.jordyvanraalte.ergast.entities.standings.DriverStanding;
import nl.jordyvanraalte.ergast.entities.standings.StandingTable;
import nl.jordyvanraalte.ergast.services.RaceService;
import nl.jordyvanraalte.ergast.services.ScoringService;
import nl.jordyvanraalte.ergast.services.SeasonService;
import nl.jordyvanraalte.ergast.services.ergast.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import static nl.jordyvanraalte.ergast.utils.Utils.createConstructorDTO;
import static nl.jordyvanraalte.ergast.utils.Utils.createDriverDTO;

import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SeasonServiceImpl implements SeasonService {

    @Value( "${ergast.url}" )
    private String ergastUrl;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    SeasonTableService seasonTableService;

    @Autowired
    DriverStandingTableService driverStandingTableService;

    @Autowired
    RaceTableService raceTableService;

    @Autowired
    RaceService raceService;

    @Autowired
    ConstructorStandingTableService constructorStandingTableService;

    @Autowired
    ScoringService scoringService;

    public SeasonServiceImpl()
    {

    }

    @Cacheable("seasons")
    public List<SeasonsDTO> getAll() throws Exception {
        var seasonTables = seasonTableService.FetchALL("seasons.json", new ParameterizedTypeReference<Response<SeasonTable>>() {});
        var seasons = new ArrayList<SeasonsDTO>();
        seasonTables.forEach(seasonTable -> {
            var resultSeasons = seasonTable.getSeasons().stream().map(season -> new SeasonsDTO(season.getSeason())).collect(Collectors.toList());
            seasons.addAll(resultSeasons);
        });
        return seasons;
    }

    @Cacheable("seasonConstructors")
    public List<StandingDTO> getSeasonConstructors(String season) throws Exception {
        var standingsTables = constructorStandingTableService.FetchALL(season + "/constructorStandings.json", new ParameterizedTypeReference<Response<StandingTable<ConstructorStanding>>>() {});
        var standings = new ArrayList<StandingDTO>();
        standingsTables.forEach(standing -> {
            standing.getStandings().get(0).getCompetitorStandings().forEach(constructorStanding -> {
                var constructor = constructorStanding.getConstructor();
                var standingDTO = new StandingDTO(constructorStanding.getPosition(), createConstructorDTO(constructor), Double.parseDouble(constructorStanding.getPoints()));
                standings.add(standingDTO);
            });
        });
        return standings;
    }

    @Cacheable("seasonDrivers")
    public List<StandingDTO> getSeasonDrivers(String season) throws Exception {
        var standingsTables = driverStandingTableService.FetchALL(season + "/driverStandings.json", new ParameterizedTypeReference<Response<StandingTable<DriverStanding>>>() {});
        var standings = new ArrayList<StandingDTO>();
        standingsTables.forEach(standing -> {
            standing.getStandings().get(0).getCompetitorStandings().forEach(driverStanding -> {
                var driver = driverStanding.getDriver();
                var standingDTO = new StandingDTO(driverStanding.getPosition(), createDriverDTO(driver), Double.parseDouble(driverStanding.getPoints()));
                standings.add(standingDTO);
            });
        });
        return standings;
    }

    @Cacheable("SeasonDriversWithScores")
    public List<StandingDTO> getSeasonDriversWithDifferentScoring(String season, String scoring) throws Exception {
        if(!scoringService.doesScoringExist(scoring))
            throw new Exception("Scoring does not exist");

        var races = getSeasonRaces(season);
        var newRaceResults = new ArrayList<RaceResultDTO>();
        //first get all the current race result of the season
        races.forEach(race -> {
            try {
                var raceResult = raceService.getRaceResultsForScoring(season, race.getRound());
                raceResult.forEach(result -> {
                    //change each score to new scoring system
                    var score = scoringService.getPoints(scoring, result.getPosition());
                    newRaceResults.add(new RaceResultDTO(result.getPosition(), createDriverDTO(result.getDriver()), score));
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        var groupedResults = newRaceResults.stream().collect(Collectors.groupingBy(RaceResultDTO::getCompetitor));

        HashMap<CompetitorDTO, Double> driverScores = new HashMap<>();
        groupedResults.forEach((driver, results) -> {
            var totalScore = results.stream().mapToDouble(RaceResultDTO::getPoints).sum();
            driverScores.put(driver, totalScore);
        });
        //then sort the map based on score
        var sortedDriverScores = driverScores.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
        //then create the standings
        var standings = new ArrayList<StandingDTO>();
        for(int i = 0; i < sortedDriverScores.size(); i++){
            var driver = sortedDriverScores.get(i).getKey();
            var score = sortedDriverScores.get(i).getValue();
            var standing = new StandingDTO(Integer.toString(i + 1), driver, score);
            standings.add(standing);
        }
        return standings;
    }

    @Cacheable("SeasonConstructorsWithScores")
    public List<StandingDTO> getSeasonConstructorsWithDifferentScoring(String season, String scoring) throws Exception {
        //normally we would create multiple methods to handle duplicate code however, due to time constraints we will not do this.
        if(!scoringService.doesScoringExist(scoring))
            throw new Exception("Scoring does not exist");

        var races = getSeasonRaces(season);
        var newRaceResults = new ArrayList<RaceResultDTO>();
        //first get all the current race result of the season
        races.forEach(race -> {
            try {
                var raceResult = raceService.getRaceResultsForScoring(season, race.getRound());
                raceResult.forEach(result -> {
                    //change each score to new scoring system
                    var score = scoringService.getPoints(scoring, result.getPosition());
                    newRaceResults.add(new RaceResultDTO(result.getPosition(), createConstructorDTO(result.getConstructor()), score));
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        var groupedResults = newRaceResults.stream().collect(Collectors.groupingBy(RaceResultDTO::getCompetitor));

        HashMap<CompetitorDTO, Double> constructorScores = new HashMap<>();
        groupedResults.forEach((constructor, results) -> {
            var totalScore = results.stream().mapToDouble(RaceResultDTO::getPoints).sum();
            constructorScores.put(constructor, totalScore);
        });
        //then sort the map based on score
        var sortedConstructors = constructorScores.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
        //then create the standings
        var standings = new ArrayList<StandingDTO>();
        for(int i = 0; i < sortedConstructors.size(); i++){
            var driver = sortedConstructors.get(i).getKey();
            var score = sortedConstructors.get(i).getValue();
            var standing = new StandingDTO(Integer.toString(i + 1), driver, score);
            standings.add(standing);
        }
        return standings;
    }

    @Cacheable("seasonRaces")
    public List<RaceDTO> getSeasonRaces(String season) throws Exception {
        var raceTables = raceTableService.FetchALL(season + ".json", new ParameterizedTypeReference<Response<RaceTable>>() {});
        var races = new ArrayList<RaceDTO>();
        raceTables.forEach(raceTable -> {
            var raceTableRaces =  raceTable.getRaces().stream().map(race -> {
                return new RaceDTO(race.getRound(), race.getUrl(), race.getRaceName(), race.getDate(), race.getTime());
            }).collect(Collectors.toList());
            races.addAll(raceTableRaces);
        });
        return races;
    }
}

