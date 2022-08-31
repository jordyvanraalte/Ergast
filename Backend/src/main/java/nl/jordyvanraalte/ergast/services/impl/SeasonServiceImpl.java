package nl.jordyvanraalte.ergast.services.impl;

import nl.jordyvanraalte.ergast.dto.SeasonsDTO;
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
    public RaceTable fetch(String year) {
        ResponseEntity<Response<RaceTable>> response = restTemplate.exchange(String.format("%s/%s/results.json", ergastUrl, year), HttpMethod.GET, null, new ParameterizedTypeReference<Response<RaceTable>>(){});
        return response.getBody().getMRData().getTable();
    }
}

