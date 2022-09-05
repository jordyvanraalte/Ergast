package nl.jordyvanraalte.ergast.services.impl;

import nl.jordyvanraalte.ergast.dto.racedetail.GridDTO;
import nl.jordyvanraalte.ergast.dto.racedetail.RaceResultDTO;
import nl.jordyvanraalte.ergast.entities.Response;
import nl.jordyvanraalte.ergast.entities.race.QualifyingResult;
import nl.jordyvanraalte.ergast.entities.race.RaceResult;
import nl.jordyvanraalte.ergast.entities.race.RaceTable;
import nl.jordyvanraalte.ergast.services.RaceService;
import nl.jordyvanraalte.ergast.services.ergast.RaceTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static nl.jordyvanraalte.ergast.utils.Utils.createDriverDTO;

@Service
public class RaceServiceImpl implements RaceService {

    @Autowired
    private RaceTableService raceTableService;

    @Cacheable("qualifyingResult")
    public List<GridDTO> getQualifyingResults(String year, String round) throws Exception {
        var raceTables = raceTableService.FetchALL(String.format("%s/%s/qualifying.json", year, round), new ParameterizedTypeReference<Response<RaceTable>>() {});
        ArrayList<GridDTO> grid = new ArrayList<>();
        raceTables.forEach(raceTable -> {
            if(raceTable.getRaces().size() == 0){
                return;
            }

            raceTable.getRaces().get(0).getQualifyingResults().forEach(qualifyingResult -> {
                grid.add(new GridDTO(qualifyingResult.getPosition(), createDriverDTO(qualifyingResult.getDriver()), processQualifyingTime(qualifyingResult)));
            });
        });
        return grid;
    }

    @Cacheable("raceResult")
    public List<RaceResultDTO> getRaceResults(String year, String round) throws Exception {
        var raceTables = raceTableService.FetchALL(String.format("%s/%s/results.json", year, round), new ParameterizedTypeReference<Response<RaceTable>>() {});
        ArrayList<RaceResultDTO> raceResults = new ArrayList<>();
        raceTables.forEach(raceTable -> {
            //safety if for current season
            if(raceTable.getRaces().size() == 0)
                return;

            raceTable.getRaces().get(0).getResults().forEach(result -> {
                raceResults.add(new RaceResultDTO(result.getPosition(),createDriverDTO(result.getDriver()), Double.parseDouble(result.getPoints())));
            });
        });
        return raceResults;
    }

    @Cacheable("raceResultScoring")
    public List<RaceResult> getRaceResultsForScoring(String year, String round) throws Exception {
        var raceTables = raceTableService.FetchALL(String.format("%s/%s/results.json", year, round), new ParameterizedTypeReference<Response<RaceTable>>() {});
        ArrayList<RaceResult> raceResults = new ArrayList<>();
        raceTables.forEach(raceTable -> {
            //safety if for current season
            if(raceTable.getRaces().size() == 0)
                return;
            raceResults.addAll(raceTable.getRaces().get(0).getResults());
        });
        return raceResults;
    }


    private String processQualifyingTime(QualifyingResult qualifyingResult) {
        if(qualifyingResult.getQ3() == null)
        {
            if(qualifyingResult.getQ2() == null)
            {
                if(qualifyingResult.getQ1() == null)
                    return "Did not qualify";
                else
                    return qualifyingResult.getQ1();
            }
            else
                return qualifyingResult.getQ2();
        }
        else
            return qualifyingResult.getQ3();
    }
}
