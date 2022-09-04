package nl.jordyvanraalte.ergast.controllers;

import nl.jordyvanraalte.ergast.dto.SeasonsDTO;
import nl.jordyvanraalte.ergast.services.ScoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/scores")
public class ScoreController {
    @Autowired
    private ScoringService scoringService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<String> fetchScoringSystems(){
        return scoringService.getScoringSystems();
    }

}
