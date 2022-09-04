package nl.jordyvanraalte.ergast.controllers;

import nl.jordyvanraalte.ergast.dto.SeasonsDTO;
import nl.jordyvanraalte.ergast.dto.seasondetail.RaceDTO;
import nl.jordyvanraalte.ergast.dto.seasondetail.StandingDTO;
import nl.jordyvanraalte.ergast.services.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/seasons")
public class SeasonsController {
    @Autowired
    private SeasonService seasonService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<SeasonsDTO> fetchSeasons() throws Exception {
        return seasonService.getAll();
    }

    @RequestMapping(value="/{year}/constructors", method = RequestMethod.GET)
    public List<StandingDTO> fetchSeasonConstructors(@PathVariable("year") String year, @RequestParam(required = false, defaultValue = "", value="scoring") String scoring) throws Exception {
        if(scoring.equals("")){
            return seasonService.getSeasonConstructors(year);
        } else {
            return seasonService.getSeasonConstructorsWithDifferentScoring(year, scoring);
        }
    }

    @RequestMapping(value="/{year}/drivers", method = RequestMethod.GET)
    public List<StandingDTO> fetchSeasonDrivers(@PathVariable("year") String year, @RequestParam(required = false, defaultValue = "", value="scoring") String scoring) throws Exception {
        //if scoring is empty, return the default scoring
        if(scoring.equals("")){
            return seasonService.getSeasonDrivers(year);
        } else {
            return seasonService.getSeasonDriversWithDifferentScoring(year, scoring);
        }
    }

    @RequestMapping(value="/{year}/races", method = RequestMethod.GET)
    public List<RaceDTO> fetchSeasonRaces(@PathVariable("year") String year) throws Exception {
        return seasonService.getSeasonRaces(year);
    }


}
