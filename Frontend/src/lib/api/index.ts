import SeasonsEndpoint from "./endpoints/seasons.api";
import RaceEndpoint from "./endpoints/races.api";

const api = {
    seasons: new SeasonsEndpoint(),
    races: new RaceEndpoint()
};

export default api;
