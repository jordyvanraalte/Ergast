import Driver from "../Driver.model";
import {Type} from "class-transformer";
import Standing from "./Standing.model";
import Competitor from "../Competitor.model";


export default class DriverStanding extends Standing<Driver>
{
    constructor(position: string, points: number, wins: number, driver: Driver) {
        super(position, points, wins, driver);

    }
}
