import React from "react";
import Grid from "./Grid";
import Results from "./Result";
import BackButton from "./BackButton";


const Race: React.FC = () => {
    return (<div className={"h-screen w-full"}>
        <BackButton />
        <div className={"flex place-content-center"}>
            <Grid />
            <Results />
        </div>
    </div>)
}

export default Race;
