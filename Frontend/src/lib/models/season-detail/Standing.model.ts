import Competitor from "../Competitor.model";
import {Type} from "class-transformer";
import Driver from "../Driver.model";
import Constructor from "../Constructor.model";
import 'reflect-metadata'


const TypeOptions = {
    discriminator: {
        property: 'type',
        subTypes: [
            { value: Driver, name: 'Driver' },
            { value: Constructor, name: 'Constructor' },
        ]
    },
};

export default class Standing<T extends Competitor> {
    public position: string
    public points: number
    public wins: number

    @Type(() => Competitor, TypeOptions)
    public competitor: Competitor

    constructor(position: string, points: number, wins: number, competitor: T) {
        this.position = position;
        this.points = points;
        this.wins = wins;
        this.competitor = competitor;
    }
}
