package nl.jordyvanraalte.ergast.services.impl;

import nl.jordyvanraalte.ergast.entities.Response;
import nl.jordyvanraalte.ergast.entities.race.RaceTable;
import nl.jordyvanraalte.ergast.entities.season.Season;
import nl.jordyvanraalte.ergast.entities.season.SeasonTable;
import nl.jordyvanraalte.ergast.services.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SeasonServiceImpl implements SeasonService {

    @Value( "${ergast.url}" )
    private String ergastUrl;

    @Autowired
    RestTemplate restTemplate;

    public SeasonServiceImpl()
    {

    }

    @Override
    public List<Season> fetchAll() {
        //TODO GET ALL SEASON INSTEAD OF FIRST 30
        ResponseEntity<Response<SeasonTable>> response = restTemplate.exchange(ergastUrl + "/seasons.json", HttpMethod.GET, null, new ParameterizedTypeReference<Response<SeasonTable>>(){});
        return response.getBody().getMRData().getTable().getSeasons();
    }

    @Override
    public RaceTable fetch(String year) {
        ResponseEntity<Response<RaceTable>> response = restTemplate.exchange(String.format("%s/%s/results.json", ergastUrl, year), HttpMethod.GET, null, new ParameterizedTypeReference<Response<RaceTable>>(){});
        return response.getBody().getMRData().getTable();
    }
}

