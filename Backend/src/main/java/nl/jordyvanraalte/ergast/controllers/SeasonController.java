package nl.jordyvanraalte.ergast.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/seasons")
public class SeasonController {

    @RequestMapping(value="", method = RequestMethod.GET)
    public List fetchSeasons(){
        return new ArrayList();
    }

    @RequestMapping(value="/{seasonId}", method = RequestMethod.GET)
    public Object fetchSeason(@PathVariable("seasonId")long id){
        return new Object();
    }

    @RequestMapping(value="/{seasonId}/drivers", method = RequestMethod.GET)
    public Object fetchSeasonDrivers(@PathVariable("seasonId")long id){
        return new Object();
    }

    @RequestMapping(value="/{seasonId}/constructors/score-systems", method = RequestMethod.GET)
    public Object fetchConstructorsScoreSystems(@PathVariable("seasonId")long id, @RequestParam String system){
        return new Object();
    }

    @RequestMapping(value="/{seasonId}/drivers/score-systems", method = RequestMethod.GET)
    public Object fetchDriversScoreSystems(@PathVariable("seasonId")long id, @RequestParam String system){
        return new Object();
    }

    @RequestMapping(value="/{seasonId}/drivers/results", method = RequestMethod.GET)
    public Object fetchSeasonDriverResults(@PathVariable("seasonId")long id, @RequestParam String system){
        return new Object();
    }

    @RequestMapping(value="/{seasonId}/constructors/results", method = RequestMethod.GET)
    public Object fetchSeasonConstructorsResults(@PathVariable("seasonId")long id, @RequestParam String system){
        return new Object();
    }

    @RequestMapping(value="/{seasonId}/races", method = RequestMethod.GET)
    public Object fetchSeasonRaces(@PathVariable("seasonId")long id){
        return new Object();
    }

    @RequestMapping(value="/{seasonId}/races/{raceId}/results", method = RequestMethod.GET)
    public Object fetchSeasonRaceResult(@PathVariable("seasonId")long id, @PathVariable("raceId") long raceId){
        return new Object();
    }

    @RequestMapping(value="/{seasonId}/qualifying/{raceId}/results", method = RequestMethod.GET)
    public Object fetchSeasonQualificationResult(@PathVariable("seasonId")long id, @PathVariable("raceId") long raceId){
        return new Object();
    }







}
