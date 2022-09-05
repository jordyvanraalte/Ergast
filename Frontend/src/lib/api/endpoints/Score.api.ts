import ApiEndpoint from "./Api.endpoint";

export default class ScoreEndpoint extends ApiEndpoint {
    async fetchScores() {
        return await fetch(`${this.baseUrl}/scores`, {
            headers: {
                "Content-Type": "application/json",
                "x-api-key": this.apiKey
            },
        })
            .then((response) => response.json())
    }

}
