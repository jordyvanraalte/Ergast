package nl.jordyvanraalte.ergast.services.impl;

import nl.jordyvanraalte.ergast.services.ScoringService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ScoringServiceImpl implements ScoringService {

    private HashMap<String, HashMap<String, Double>> scoringMap = new HashMap<>();

    public ScoringServiceImpl()
    {
        //default is current season
        HashMap<String, Double> scoring19912002 = new HashMap<>();
        scoring19912002.put("1", 10.0);
        scoring19912002.put("2", 6.0);
        scoring19912002.put("3", 4.0);
        scoring19912002.put("4", 3.0);
        scoring19912002.put("5", 2.0);
        scoring19912002.put("6", 1.0);
        scoring19912002.put("7", 0.0);
        scoring19912002.put("8", 0.0);
        scoring19912002.put("9", 0.0);
        scoring19912002.put("10", 0.0);

        HashMap<String, Double> scoring20032009 = new HashMap<>();
        scoring20032009.put("1", 10.0);
        scoring20032009.put("2", 8.0);
        scoring20032009.put("3", 6.0);
        scoring20032009.put("4", 5.0);
        scoring20032009.put("5", 4.0);
        scoring20032009.put("6", 3.0);
        scoring20032009.put("7", 2.0);
        scoring20032009.put("8", 1.0);
        scoring20032009.put("9", 0.0);
        scoring20032009.put("10", 0.0);

        scoringMap.put("1991-2002", scoring19912002);
        scoringMap.put("2003-2009", scoring20032009);
    }

    public boolean doesScoringExist(String scoringSystem)
    {
        return scoringMap.containsKey(scoringSystem);
    }

    public double getPoints(String scoringSystem, String position)
    {
        if(Integer.parseInt(position) > 10)
        {
            return 0;
        }

        System.out.println("Scoring system: " + scoringSystem);
        System.out.println("Position: " + position);
        return scoringMap.get(scoringSystem).get(position);
    }

}
