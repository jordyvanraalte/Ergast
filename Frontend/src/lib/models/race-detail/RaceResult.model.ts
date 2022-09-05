import Competitor from "../Competitor.model";

export default class RaceResult {
    constructor(public position: number, public competitor: Competitor, public score: number) {}
}
