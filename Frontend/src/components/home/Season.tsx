import React, {useEffect, useState} from "react";
import Standing from "./Standing";
import Races from "./Races";
import Select, {OnSelect} from "./Select";
import api from "../../lib/api";
import Season from "../../lib/models/season.model";

const SeasonComponent: React.FC = () => {
    const [seasonOptions, setSeasonOptions] = useState<string[]>([]);

    useEffect(() => {
        const fetchSeasons = async () => {
            const seasons = await api.seasons.fetch();
            setSeasonOptions(seasons.map(season => {
                return season.season
            }))
        };
        fetchSeasons().catch(error => console.log(error));
    }, []);

    return (<div className={"h-full place-content-center"}>
        <div className={"flex place-content-center"}>
            <Select title={"Choose a season"} options={seasonOptions}/>
            <Select title={"Choose a point system"} options={["test", "test"]} />
        </div>
        <div className={"flex place-content-center"}>
            <Standing />
            <Standing />
            <Races />
        </div>
    </div>)
}

export default SeasonComponent;
