import React, {useEffect, useState} from "react";
import Standing from "./Standing";
import Races from "./Races";
import Select, {OnSelect} from "./Select";
import api from "../../lib/api";
import {useAppDispatch, useAppSelector} from "../../store/Hooks";
import {
    selectSeasonState,
    setConstructorStandings,
    setCurrentSeason,
    setDriverStandings,
    setRaces, setScoresSystems, setScoreSystem, setSeasons
} from "../../store/SeasonSlice";

const SeasonComponent: React.FC = () => {

    const dispatch = useAppDispatch()

    const seasonState = useAppSelector(selectSeasonState)

    useEffect(() => {
        const fetchSeasons = async () => {
            const seasons = await api.seasons.fetch();
            const stringSeasons = seasons.map((season: any) => season.season)
            stringSeasons.push("Season")
            dispatch(setSeasons(stringSeasons))
        };
        fetchSeasons().catch(error => console.log(error));

        const fetchStandings = async () => {
            const driverStandings = await api.seasons.fetchDriverStandings(seasonState.currentSeason, seasonState.scoreSystem)
            dispatch(setDriverStandings(driverStandings))

            const constructorStandings = await api.seasons.fetchConstructorsStandings(seasonState.currentSeason, seasonState.scoreSystem)
            dispatch(setConstructorStandings(constructorStandings))
        }
        fetchStandings().catch(error => console.log(error))

        const fetchRaces = async () => {
            const races = await api.seasons.fetchRaces(seasonState.currentSeason)
            dispatch(setRaces(races))
        }
        fetchRaces().catch(error => console.log(error))

        const fetchPointSystems = async () => {
            const scoreSystem = await api.scores.fetchScores()
            scoreSystem.push("Season's scoring systems (Default)")
            dispatch(setScoresSystems(scoreSystem))
        }
        fetchPointSystems().catch(error => console.log(error))
    }, []);

    const selectedSeason = seasonState.currentSeason !== "" ? seasonState.currentSeason : "Current season"
    const selectedScoreSystem = seasonState.scoreSystem !== "" ? seasonState.scoreSystem : "Season's scoring systems (Default)"

    const selectSeason = async (season: string) => {
        if(season === "Current season") {
            season = "2022"
        }

        const races = await api.seasons.fetchRaces(season)
        const driverStandings = await api.seasons.fetchDriverStandings(season, seasonState.scoreSystem)
        const constructorsStandings = await api.seasons.fetchConstructorsStandings(season, seasonState.scoreSystem)

        dispatch(setCurrentSeason(season))
        dispatch(setRaces(races))
        dispatch(setDriverStandings(driverStandings))
        dispatch(setConstructorStandings(constructorsStandings))
    }

    const selectScoreSystem = async (system: string | null) => {
        if(system === "Season's scoring systems (Default)") {
            system = null
        }

        const driverStandings = await api.seasons.fetchDriverStandings(seasonState.currentSeason, system)
        const constructorsStandings = await api.seasons.fetchConstructorsStandings(seasonState.currentSeason, system)

        dispatch(setDriverStandings(driverStandings))
        dispatch(setConstructorStandings(constructorsStandings))
        dispatch(setScoreSystem(system))

    }

    return (<div className={"h-full"}>
        <div className={"flex place-content-center"}>
            <Select title={selectedSeason} options={seasonState.seasons} onSelect={selectSeason}/>
            <Select title={selectedScoreSystem} options={seasonState.scoreSystems} onSelect={selectScoreSystem} />
        </div>
        <div className={"flex h-4/5 place-content-center"}>
            <Standing standingName={"Drivers"} standing={seasonState.driverStandings} />
            <Standing standingName={"Constructors"} standing={seasonState.constructorStandings}/>
            <Races races={seasonState.races} />
        </div>
    </div>)
}

export default SeasonComponent;
