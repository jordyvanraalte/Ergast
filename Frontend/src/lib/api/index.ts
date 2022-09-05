import SeasonsEndpoint from "./endpoints/Seasons.api";
import RaceEndpoint from "./endpoints/Races.api";
import ScoreEndpoint from "./endpoints/Score.api";

const api = {
    seasons: new SeasonsEndpoint(),
    races: new RaceEndpoint(),
    scores: new ScoreEndpoint()
};

export default api;
