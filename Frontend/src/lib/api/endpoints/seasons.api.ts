import {plainToClass, plainToInstance} from "class-transformer";
import Season from "../../models/season.model";
import ApiEndpoint from "./api.endpoint";

export default class SeasonsEndpoint extends ApiEndpoint {
    async fetch(): Promise<Season[]> {
        return await fetch(`${this.baseUrl}/seasons`, {
            headers: {
                "Content-Type": "application/json",
            },
        })
            .then((response) => response.json())
            .then((data) => plainToInstance(Season, data));
    }
}
