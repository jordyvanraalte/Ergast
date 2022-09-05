import { configureStore} from "@reduxjs/toolkit";
import { seasonSlice} from "./SeasonSlice";
import {raceSlice} from "./RaceSlice";

export const store = configureStore({
        reducer: {
            [seasonSlice.name]: seasonSlice.reducer,
            [raceSlice.name]: raceSlice.reducer
        },
        devTools: true,
    });

// Infer the `RootState` and `AppDispatch` types from the store itself
export type RootState = ReturnType<typeof store.getState>
// Inferred type: {posts: PostsState, comments: CommentsState, users: UsersState}
export type AppDispatch = typeof store.dispatch

