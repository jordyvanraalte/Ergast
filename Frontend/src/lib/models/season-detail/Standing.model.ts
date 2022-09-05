import Competitor from "../Competitor.model";

export default class Standing {
    public competitor: Competitor;
    public position: string
    public score: number
    public wins: number

    constructor(position: string, score: number, wins: number, competitor: Competitor) {
        this.position = position;
        this.score = score;
        this.wins = wins;
        this.competitor = competitor;
    }
}
