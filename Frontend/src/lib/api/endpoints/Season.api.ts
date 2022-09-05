import Season from "../../models/Season.model";
import ApiEndpoint from "./Api.endpoint";

export default class SeasonsEndpoint extends ApiEndpoint {
    async fetch(): Promise<Season[]> {
        return await fetch(`${this.baseUrl}/seasons`, {
            headers: {
                "Content-Type": "application/json",
                "x-api-key": this.apiKey
            },
        })
            .then((response) => response.json())
    }

    async fetchRaces(season: string): Promise<any> {
        return await fetch(`${this.baseUrl}/seasons/${season}/races`, {
            headers: {
                "Content-Type": "application/json",
                "x-api-key": this.apiKey
            },
        })
            .then((response) => response.json())
    }

    async fetchDriverStandings(season: string, scoring: string | null): Promise<any> {
        if(scoring === null)
            return await fetch(`${this.baseUrl}/seasons/${season}/drivers`, {
                headers: {
                    "Content-Type": "application/json",
                    "x-api-key": this.apiKey
                },
            })
                .then((response) => response.json())
        else {
            return await fetch(`${this.baseUrl}/seasons/${season}/drivers?scoring=${scoring}`, {
                headers: {
                    "Content-Type": "application/json",
                    "x-api-key": this.apiKey
                },
            })
                .then((response) => response.json())
        }
    }

    async fetchConstructorsStandings(season: string, scoring: string | null): Promise<any> {
        if(scoring === null)
            return await fetch(`${this.baseUrl}/seasons/${season}/constructors`, {
                headers: {
                    "Content-Type": "application/json",
                    "x-api-key": this.apiKey
                },
            })
                .then((response) => response.json())
        else {
            return await fetch(`${this.baseUrl}/seasons/${season}/constructors?scoring=${scoring}`, {
                headers: {
                    "Content-Type": "application/json",
                    "x-api-key": this.apiKey
                },
            })
                .then((response) => response.json())
        }
    }
}
