import { configureStore, ThunkAction, Action } from "@reduxjs/toolkit";
import { seasonSlice} from "./SeasonSlice";

export const store = configureStore({
        reducer: {
            [seasonSlice.name]: seasonSlice.reducer,
        },
        devTools: true,
    });

// Infer the `RootState` and `AppDispatch` types from the store itself
export type RootState = ReturnType<typeof store.getState>
// Inferred type: {posts: PostsState, comments: CommentsState, users: UsersState}
export type AppDispatch = typeof store.dispatch

