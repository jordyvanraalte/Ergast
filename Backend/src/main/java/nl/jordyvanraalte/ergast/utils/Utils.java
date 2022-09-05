package nl.jordyvanraalte.ergast.utils;

import nl.jordyvanraalte.ergast.dto.CompetitorDTO;
import nl.jordyvanraalte.ergast.entities.Constructor;
import nl.jordyvanraalte.ergast.entities.Driver;

public class Utils {

    public static CompetitorDTO createDriverDTO(Driver driver)
    {
        return new CompetitorDTO(driver.getDriverId(), driver.getGivenName() + " " + driver.getFamilyName());
    }

    public static CompetitorDTO createConstructorDTO(Constructor constructor)
    {
        return new CompetitorDTO(constructor.getConstructorId(), constructor.getName());
    }
}
