import { createSlice } from "@reduxjs/toolkit";
import {RootState, store} from "./Store";

// Type for our state
export interface RaceState {
    currentRace: string,
    grid: any,
    results: any,
}

// Initial state
const initialState: RaceState = {
    currentRace: "2022",
    grid: [],
    results: []
};

export const raceSlice = createSlice({
    name: "race",
    initialState,
    reducers: {
        // Action to set the authentication status
        setCurrentRace(state, action) {
            state.currentRace = action.payload
        },
        setGrid(state, action ) {
            state.grid = action.payload
        },
        setResults(state, action) {
            state.results = action.payload
        }
    },
});

export const { setCurrentRace, setGrid, setResults } = raceSlice.actions;

export const selectRaceState = (state: RootState) => state;

export default raceSlice.reducer;
