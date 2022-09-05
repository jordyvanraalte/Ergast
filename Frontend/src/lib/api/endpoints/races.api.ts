import ApiEndpoint from "./Api.endpoint";
import RaceDetail from "../../models/race-detail/RaceDetail.model";

export default class RaceEndpoint extends ApiEndpoint {
    async fetch(year: string | undefined, round: string | number | undefined): Promise<RaceDetail> {
        return await fetch(`${this.baseUrl}/races/${year}/${round}`, {
            headers: {
                "Content-Type": "application/json",
            },
        })
            .then((response) => response.json())
    }


}
