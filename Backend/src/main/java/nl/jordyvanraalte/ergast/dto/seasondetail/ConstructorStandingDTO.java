package nl.jordyvanraalte.ergast.dto.seasondetail;

import nl.jordyvanraalte.ergast.entities.Constructor;
import nl.jordyvanraalte.ergast.entities.Driver;

public class ConstructorStandingDTO {
    private String position;
    private Constructor constructor;
    //double due to possibility of comma values (Belgium Grand prix 2021)
    private double points;
}
