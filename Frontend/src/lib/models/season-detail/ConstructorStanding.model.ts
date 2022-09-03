import Constructor from "../Constructor.model";
import {Type} from "class-transformer";
import Standing from "./Standing.model";

export default class ConstructorStanding extends Standing<Constructor>{
    constructor(position: string, points: number, wins: number, constructor: Constructor) {
        super(position, points, wins, constructor);
    }
}
