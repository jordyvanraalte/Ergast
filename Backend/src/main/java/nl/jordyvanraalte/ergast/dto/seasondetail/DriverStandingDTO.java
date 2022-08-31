package nl.jordyvanraalte.ergast.dto.seasondetail;

import nl.jordyvanraalte.ergast.entities.Driver;

public class DriverStandingDTO {
    private String position;
    private Driver driver;
    //double due to possibility of comma values (Belgium Grand prix 2021)
    private double points;
}
