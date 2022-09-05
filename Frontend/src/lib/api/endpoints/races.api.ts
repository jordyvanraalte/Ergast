import ApiEndpoint from "./api.endpoint";
import Season from "../../models/Season.model";
import Race from "../../models/season-detail/Race.model";
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
