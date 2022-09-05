import Competitor from "../Competitor.model";

export default class Grid {
    constructor(public position: number, public competitor: Competitor, public qualifyTime: string) {}
}
