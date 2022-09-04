package nl.jordyvanraalte.ergast.services.ergast;

import nl.jordyvanraalte.ergast.entities.standings.CompetitorStanding;
import nl.jordyvanraalte.ergast.entities.standings.StandingTable;

public interface StandingTableService<T extends CompetitorStanding> extends ErgastService<StandingTable<T>> {

}
