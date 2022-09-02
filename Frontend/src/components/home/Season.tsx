import React from "react";
import Standing from "./Standing";
import Races from "./Races";
import Select from "./Select";

const Season: React.FC = () => {
    return (<div className={"h-full place-content-center"}>
        <div className={"flex place-content-center"}>
            <Select />
            <Select />
        </div>
        <div className={"flex place-content-center"}>
            <Standing />
            <Standing />
            <Races />
        </div>
    </div>)
}

export default Season;
