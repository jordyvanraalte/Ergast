package nl.jordyvanraalte.ergast.controllers;

import nl.jordyvanraalte.ergast.dto.racedetail.RaceDetailDTO;
import nl.jordyvanraalte.ergast.services.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/races")
public class RacesController {
    @Autowired
    private SeasonService seasonService;

    @RequestMapping(value="/{year}/{round}", method = RequestMethod.GET)
    public RaceDetailDTO fetchRace(@PathVariable("year") String year, @PathVariable("round") String round)
    {
        return seasonService.getRaceDetail(year, round);
    }
}
