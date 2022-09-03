import {plainToClass, plainToInstance} from "class-transformer";
import Season from "../../models/Season.model";
import ApiEndpoint from "./api.endpoint";
import SeasonDetail from "../../models/season-detail/SeasonDetail.model";

export default class SeasonsEndpoint extends ApiEndpoint {
    async fetch(): Promise<Season[]> {
        return await fetch(`${this.baseUrl}/seasons`, {
            headers: {
                "Content-Type": "application/json",
            },
        })
            .then((response) => response.json())
    }

    async fetchOne(season: string): Promise<SeasonDetail> {
        // @ts-ignore ignoring due to library issues with type casting
        return await fetch(`${this.baseUrl}/seasons/${season}`, {
            headers: {
                "Content-Type": "application/json",
            },
        })
            .then((response) => response.json())
    }
}
