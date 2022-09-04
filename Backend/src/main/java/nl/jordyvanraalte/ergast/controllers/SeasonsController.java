package nl.jordyvanraalte.ergast.controllers;

import nl.jordyvanraalte.ergast.dto.SeasonsDTO;
import nl.jordyvanraalte.ergast.dto.seasondetail.SeasonDTO;
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
    public List<SeasonsDTO> fetchSeasons(){
        return seasonService.getAll();
    }

    @RequestMapping(value="/{year}", method = RequestMethod.GET)
    public SeasonDTO fetchSeason(@PathVariable("year") String year, @RequestParam(required = false, defaultValue = "", value="scoring") String scoring){
        return seasonService.getSeason(year, scoring);
    }

}
