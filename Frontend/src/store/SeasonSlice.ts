import { createSlice } from "@reduxjs/toolkit";
import {RootState, store} from "./Store";
import Race from "../lib/models/season-detail/Race.model";
import Standing from "../lib/models/season-detail/Standing.model";

// Type for our state
export interface SeasonState {
    currentSeason: string;
    driverStandings: Standing[];
    constructorStandings: Standing[];
    races: Race[];
    seasons: string[]
    scoreSystems: string[]
    scoreSystem: string
}

// Initial state
const initialState: SeasonState = {
    currentSeason: "2022",
    driverStandings: [],
    constructorStandings: [],
    races: [],
    seasons: [],
    scoreSystem: "",
    scoreSystems: []
};

export const seasonSlice = createSlice({
    name: "season",
    initialState,
    reducers: {
        // Action to set the authentication status
        setCurrentSeason(state, action) {
            state.currentSeason = action.payload;
        },
        setDriverStandings(state, action) {
            state.driverStandings = action.payload;
        },
        setConstructorStandings(state, action) {
            state.constructorStandings = action.payload;
        },
        setRaces(state, action) {
            state.races = action.payload;
        },
        setSeasons(state, action) {
            state.seasons = action.payload
        },
        setScoreSystem(state, action) {
            state.scoreSystem = action.payload
        },
        setScoresSystems(state, action) {
            state.scoreSystems = action.payload
        }
    },
});

export const { setCurrentSeason, setDriverStandings, setConstructorStandings, setRaces, setScoreSystem, setSeasons, setScoresSystems } = seasonSlice.actions;

export const selectSeasonState = (state: RootState) => state.season;

export default seasonSlice.reducer;
