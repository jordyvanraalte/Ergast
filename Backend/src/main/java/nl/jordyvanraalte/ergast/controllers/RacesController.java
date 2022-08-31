package nl.jordyvanraalte.ergast.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/races")
public class RacesController {
    @RequestMapping(value="/{year}/{round}", method = RequestMethod.GET)
    public Object fetchRace(@PathVariable("year") String year, @PathVariable("round") String round)
    {
        return new Object();
    }
}
