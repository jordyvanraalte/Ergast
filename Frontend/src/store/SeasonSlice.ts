import { createSlice } from "@reduxjs/toolkit";
import {RootState, store} from "./Store";
import DriverStanding from "../lib/models/season-detail/DriverStanding.model";
import ConstructorStanding from "../lib/models/season-detail/ConstructorStanding.model";
import Race from "../lib/models/season-detail/Race.model";

// Type for our state
export interface SeasonState {
    currentSeason: string;
    driverStandings: DriverStanding[];
    constructorStandings: ConstructorStanding[];
    races: Race[];
    pointSystem: any
}

// Initial state
const initialState: SeasonState = {
    currentSeason: "2022",
    driverStandings: [],
    constructorStandings: [],
    races: [],
    pointSystem: {}
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
        setPointSystem(state, action) {
            state.pointSystem = action.payload
        }
    },
});

export const { setCurrentSeason, setDriverStandings, setConstructorStandings, setRaces, setPointSystem } = seasonSlice.actions;

export const selectSeasonState = (state: RootState) => state.season;


export default seasonSlice.reducer;
