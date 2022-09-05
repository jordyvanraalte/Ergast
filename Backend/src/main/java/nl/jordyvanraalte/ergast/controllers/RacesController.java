package nl.jordyvanraalte.ergast.controllers;

import nl.jordyvanraalte.ergast.dto.racedetail.GridDTO;
import nl.jordyvanraalte.ergast.dto.racedetail.RaceResultDTO;
import nl.jordyvanraalte.ergast.services.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/races")
public class RacesController {
    @Autowired
    private RaceService raceService;

    @RequestMapping(value="/{year}/{round}/grid", method = RequestMethod.GET)
    public List<GridDTO> fetchGrid(@PathVariable("year") String year, @PathVariable("round") String round) throws Exception {
        return raceService.getQualifyingResults(year, round);
    }

    @RequestMapping(value="/{year}/{round}/result", method = RequestMethod.GET)
    public List<RaceResultDTO> fetchRaceResult(@PathVariable("year") String year, @PathVariable("round") String round) throws Exception {
        return raceService.getRaceResults(year, round);
    }
}
