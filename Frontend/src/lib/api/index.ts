import SeasonsEndpoint from "./endpoints/Season.api";
import RaceEndpoint from "./endpoints/Race.api";
import ScoreEndpoint from "./endpoints/Score.api";

const api = {
    seasons: new SeasonsEndpoint(),
    races: new RaceEndpoint(),
    scores: new ScoreEndpoint()
};

export default api;
