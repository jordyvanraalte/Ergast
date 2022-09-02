import ApiEndpoint from "./api.endpoint";

export default class RaceEndpoint extends ApiEndpoint {
    async login(data: any) {
        return await fetch(`${this.baseUrl}/seasons`, {
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(data),
        })
            .then((response) => response.json())
            .then((data) => data);
    }

}
