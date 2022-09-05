import React, {useEffect, useState} from "react";
import Standing from "./Standing";
import Races from "./Races";
import Select from "./Select";
import api from "../../lib/api";
import {useAppDispatch, useAppSelector} from "../../store/Hooks";
import {
    selectSeasonState,
    setConstructorStandings,
    setCurrentSeason,
    setDriverStandings,
    setRaces
} from "../../store/SeasonSlice";

const SeasonComponent: React.FC = () => {
    const [seasonOptions, setSeasonOptions] = useState<string[]>([]);

    const dispatch = useAppDispatch()

    const seasonState = useAppSelector(selectSeasonState)

    useEffect(() => {
        const fetchSeasons = async () => {
            const seasons = await api.seasons.fetch();
            setSeasonOptions(seasons.map(season => {
                return season.season
            }))
        };
        fetchSeasons().catch(error => console.log(error));

        const fetchSeason = async () => {
            const season = await api.seasons.fetchOne("2021");
            console.log(season)
            dispatch(setCurrentSeason("2021"))
            dispatch(setDriverStandings(season.driverStandings))
            dispatch(setConstructorStandings(season.constructorStandings))
            dispatch(setRaces(season.races))
        }

        fetchSeason().catch(error => console.log(error))
    }, []);



    return (<div className={"h-full"}>
        <div className={"flex place-content-center"}>
            <Select title={"Choose a season"} options={seasonOptions}/>
            <Select title={"Choose a point system"} options={["test", "test"]} />
        </div>
        <div className={"flex h-4/5 place-content-center"}>
            <Standing standingName={"Drivers"} standing={seasonState.driverStandings} />
            <Standing standingName={"Constructors"} standing={seasonState.constructorStandings}/>
            <Races races={seasonState.races} />
        </div>
    </div>)
}

export default SeasonComponent;
