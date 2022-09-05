package nl.jordyvanraalte.ergast.services.impl.ergast;

import nl.jordyvanraalte.ergast.entities.standings.CompetitorStanding;
import nl.jordyvanraalte.ergast.entities.standings.StandingTable;
import nl.jordyvanraalte.ergast.services.ergast.StandingTableService;
import org.springframework.stereotype.Service;

public class StandingTableServiceImpl<T extends CompetitorStanding> extends ErgastServiceImpl<StandingTable<T>> implements StandingTableService<T> {

}
