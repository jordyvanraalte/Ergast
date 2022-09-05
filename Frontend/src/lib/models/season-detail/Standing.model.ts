import Competitor from "../Competitor.model";
import {Type} from "class-transformer";

export default class Standing {
    public competitor: Competitor;
    public position: string
    public points: number
    public wins: number

    constructor(position: string, points: number, wins: number, competitor: Competitor) {
        this.position = position;
        this.points = points;
        this.wins = wins;
        this.competitor = competitor;
    }
}
