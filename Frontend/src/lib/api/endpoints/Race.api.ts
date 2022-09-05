import ApiEndpoint from "./Api.endpoint";

export default class RaceEndpoint extends ApiEndpoint {
    async fetchGrid(season: string | undefined, round: string | undefined) {
        return await fetch(`${this.baseUrl}/races/${season}/${round}/grid`, {
            headers: {
                "Content-Type": "application/json",
                "x-api-key": this.apiKey
            },
        })
            .then((response) => response.json())
    }

    async fetchRaceResult(season: string | undefined, round: string | undefined) {
        return await fetch(`${this.baseUrl}/races/${season}/${round}/result`, {
            headers: {
                "Content-Type": "application/json",
                "x-api-key": this.apiKey
            },
        })
            .then((response) => response.json())
    }
}
