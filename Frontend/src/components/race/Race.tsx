import React, {useEffect} from "react";
import Grid from "./Grid";
import Results from "./Result";
import BackButton from "./BackButton";
import api from "../../lib/api";
import {useParams} from "react-router";
import {useAppDispatch} from "../../store/Hooks";
import {selectRaceState, setGrid, setResults} from "../../store/RaceSlice";
import {useSelector} from "react-redux";


const Race: React.FC = () => {

    const { year, round } = useParams();

    const dispatch = useAppDispatch()

    const raceState = useSelector(selectRaceState)

    useEffect(() => {
        const fetchRace = async () => {
            const race = await api.races.fetch(year, round);
            dispatch(setGrid(race.grid))

            dispatch(setResults(race.results))
        };
        fetchRace().catch(error => console.log(error));
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
