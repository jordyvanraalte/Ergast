package nl.jordyvanraalte.ergast.services.impl;

import nl.jordyvanraalte.ergast.dto.SeasonsDTO;
import nl.jordyvanraalte.ergast.dto.racedetail.GridDTO;
import nl.jordyvanraalte.ergast.dto.racedetail.RaceDetailDTO;
import nl.jordyvanraalte.ergast.dto.racedetail.RaceResultDTO;
import nl.jordyvanraalte.ergast.dto.seasondetail.ConstructorStandingDTO;
import nl.jordyvanraalte.ergast.dto.seasondetail.DriverStandingDTO;
import nl.jordyvanraalte.ergast.dto.seasondetail.RaceDTO;
import nl.jordyvanraalte.ergast.dto.seasondetail.SeasonDTO;
import nl.jordyvanraalte.ergast.entities.Response;
import nl.jordyvanraalte.ergast.entities.race.RaceResult;
import nl.jordyvanraalte.ergast.entities.race.RaceTable;
import nl.jordyvanraalte.ergast.entities.season.Season;
import nl.jordyvanraalte.ergast.entities.season.SeasonTable;
import nl.jordyvanraalte.ergast.entities.standings.ConstructorStanding;
import nl.jordyvanraalte.ergast.entities.standings.DriverStanding;
import nl.jordyvanraalte.ergast.entities.standings.StandingTable;
import nl.jordyvanraalte.ergast.services.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeasonServiceImpl implements SeasonService {

    @Value( "${ergast.url}" )
    private String ergastUrl;

    @Autowired
    RestTemplate restTemplate;

    public SeasonServiceImpl()
    {

    }

    public List<SeasonsDTO> getAll() {
        //TODO GET ALL SEASON INSTEAD OF FIRST 30

        ArrayList<Season> seasons = new ArrayList<>();
        ResponseEntity<Response<SeasonTable>> firstResponse = restTemplate.exchange(ergastUrl + "/seasons.json", HttpMethod.GET, null, new ParameterizedTypeReference<Response<SeasonTable>>(){});
        seasons.addAll(firstResponse.getBody().getMRData().getTable().getSeasons());

        int offset = Integer.parseInt(firstResponse.getBody().getMRData().getLimit());
        int total = Integer.parseInt(firstResponse.getBody().getMRData().getTotal());
        while(offset < total) {
            ResponseEntity<Response<SeasonTable>> response = restTemplate.exchange(ergastUrl + "/seasons.json?offset=" + offset, HttpMethod.GET, null, new ParameterizedTypeReference<Response<SeasonTable>>(){});
            seasons.addAll(response.getBody().getMRData().getTable().getSeasons());
            offset += Integer.parseInt(response.getBody().getMRData().getLimit());
        }

        return seasons.stream().map(season -> {
            return new SeasonsDTO(season.getSeason());
        }).collect(Collectors.toList());
    }



    @Override
    public SeasonDTO getSeason(String year) {
        ResponseEntity<Response<RaceTable>> response = restTemplate.exchange(String.format("%s/%s/results.json", ergastUrl, year), HttpMethod.GET, null, new ParameterizedTypeReference<Response<RaceTable>>(){});
        List<RaceDTO> races = response.getBody().getMRData().getTable().getRaces().stream().map(race -> {
           return new RaceDTO(race.getRound(), race.getUrl(), race.getRaceName(), race.getDate(), race.getTime());
        }).collect(Collectors.toList());
        return new SeasonDTO(year, "Default", getDriverStandings(year), getConstructorStandings(year), races);
    }

    public RaceDetailDTO getRaceDetail(String year, String round)
    {
        ResponseEntity<Response<RaceTable>> response = restTemplate.exchange(String.format("%s/%s/%s/results.json", ergastUrl, year, round), HttpMethod.GET, null, new ParameterizedTypeReference<Response<RaceTable>>(){});
        List<RaceResultDTO> results = response.getBody().getMRData().getTable().getRaces().get(0).getResults().stream().map(result -> {
            return new RaceResultDTO(result.getPosition(), result.getDriver(), Double.parseDouble(result.getPoints()));
        }).collect(Collectors.toList());
        return new RaceDetailDTO(getQualifyingResults(year, round), results);
    }

    private List<GridDTO> getQualifyingResults(String year, String round)
    {
        ResponseEntity<Response<RaceTable>> response = restTemplate.exchange(String.format("%s/%s/%s/qualifying.json", ergastUrl, year, round), HttpMethod.GET, null, new ParameterizedTypeReference<Response<RaceTable>>(){});

        return response.getBody().getMRData().getTable().getRaces().get(0).getQualifyingResults().stream().map(qualifyingResult -> {
            return new GridDTO(qualifyingResult.getPosition(), qualifyingResult.getDriver(), qualifyingResult.getQ3());
        }).collect(Collectors.toList());
    }



    private List<DriverStandingDTO> getDriverStandings(String year)
    {
        ResponseEntity<Response<StandingTable<DriverStanding>>> response = restTemplate.exchange(String.format("%s/%s/driverStandings.json", ergastUrl, year), HttpMethod.GET, null, new ParameterizedTypeReference<Response<StandingTable<DriverStanding>>>(){});
        return response.getBody().getMRData().getTable().getStandings().get(0).getCompetitorStandings().stream().map(driverStanding -> {
            return new DriverStandingDTO(driverStanding.getPosition(), driverStanding.getDriver(), Double.parseDouble(driverStanding.getPoints()), Integer.parseInt(driverStanding.getWins()));
        }).collect(Collectors.toList());
    }

    private List<ConstructorStandingDTO> getConstructorStandings(String year)
    {
        ResponseEntity<Response<StandingTable<ConstructorStanding>>> response = restTemplate.exchange(String.format("%s/%s/constructorStandings.json", ergastUrl, year), HttpMethod.GET, null, new ParameterizedTypeReference<Response<StandingTable<ConstructorStanding>>>(){});
        return response.getBody().getMRData().getTable().getStandings().get(0).getCompetitorStandings().stream().map(constructorStanding -> {
            return new ConstructorStandingDTO(constructorStanding.getPosition(), constructorStanding.getConstructor(), Double.parseDouble(constructorStanding.getPoints()), Integer.parseInt(constructorStanding.getWins()));
        }).collect(Collectors.toList());
    }





}

