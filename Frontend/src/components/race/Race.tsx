import React, {useEffect} from "react";
import Grid from "./Grid";
import Results from "./Result";
import BackButton from "./BackButton";
import api from "../../lib/api";
import {setConstructorStandings, setCurrentSeason, setDriverStandings, setRaces} from "../../store/SeasonSlice";
import {useParams} from "react-router";
import {useAppDispatch} from "../../store/Hooks";
import {selectRaceState, setGrid, setResults} from "../../store/RaceSlice";
import {useSelector} from "react-redux";


const Race: React.FC = () => {

    const { year, round } = useParams();

    const dispatch = useAppDispatch()

    const raceState = useSelector(selectRaceState)

    useEffect(() => {
        const fetchResult = async () => {
            const result = await api.races.fetchRaceResult(year, round);
            dispatch(setResults(result))
        };
        fetchResult().catch(error => console.log(error));

        const fetchGrid = async () => {
            const grid = await api.races.fetchGrid(year, round);
            dispatch(setGrid(grid))
        };
        fetchGrid().catch(error => console.log(error));

    }, []);

    return (<div className={"h-screen w-full"}>
        <BackButton />
        <div className={"flex place-content-center h-4/5"}>
            <Grid grid={raceState.grid} />
            <Results results={raceState.results} />
        </div>
    </div>)
}

export default Race;
