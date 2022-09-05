import Race from "./Race.model";
import {Type} from "class-transformer";
import Standing from "./Standing.model";

export default class SeasonDetail {
    public season: string
    public pointSystem: string

    public driverStandings: Standing[]

    public constructorStandings: Standing[]

    @Type(() => Race)
    public races: Race[]


    constructor(season: string, pointSystem: string, driverStandings: Standing[], constructorStandings: Standing[], races: Race[]) {
        this.season = season;
        this.pointSystem = pointSystem;
        this.driverStandings = driverStandings;
        this.constructorStandings = constructorStandings;
        this.races = races;
    }
}
