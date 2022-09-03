import Race from "./Race.model";
import DriverStanding from "./DriverStanding.model";
import ConstructorStanding from "./ConstructorStanding.model";
import {Type} from "class-transformer";

export default class SeasonDetail {
    public season: string
    public pointSystem: string

    @Type(() => DriverStanding)
    public driverStandings: DriverStanding[]

    @Type(() => ConstructorStanding)
    public constructorStandings: ConstructorStanding[]

    @Type(() => Race)
    public races: Race[]


    constructor(season: string, pointSystem: string, driverStandings: DriverStanding[], constructorStandings: ConstructorStanding[], races: Race[]) {
        this.season = season;
        this.pointSystem = pointSystem;
        this.driverStandings = driverStandings;
        this.constructorStandings = constructorStandings;
        this.races = races;
    }
}
