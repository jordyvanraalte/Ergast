import React from "react";
import Race from "../../lib/models/season-detail/Race.model";
import {useNavigate} from "react-router-dom";
import {useSelector} from "react-redux";
import {selectSeasonState} from "../../store/SeasonSlice";



export interface IRaces  {
    races: Race[]
}

const RacesComponent: React.FC<IRaces> = ({ races}) => {
    const navigate = useNavigate();
    const year = useSelector(selectSeasonState).currentSeason

    const onRaceClick = (race: Race): any => {
        navigate(`/race/${year}/${race.round}`, { replace: true })
    }

    return (
        <div className="relative h-full mx-5">
            <div className="w-full h-full overflow-y-auto overflow-x-auto overflow-hidden shadow-md rounded bg-white bg-opacity-90">
                <table className="table-auto w-full opacity-75">
                    <thead className="border-b border-gray-400">
                    <tr className="border-b border-gray-400">
                        <th scope="col" className="py-3 px-6 text-2xl font-black font-bold">
                            Races
                        </th>
                    </tr>
                    <tr className="text-xs text-gray-700 uppercase bg-gray-50 bg-opacity-90">
                        <th scope="col" className="py-3 px-6">
                            Round
                        </th>
                        <th scope="col" className="py-3 px-6">
                            Name
                        </th>
                        <th scope="col" className="py-3 px-6">
                            Date
                        </th>
                        <th scope="col" className="py-3 px-6">
                            Time
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    {races.map((race, index) => {
                        return (<tr onClick={() => onRaceClick(race)} key={index} className="border-b cursor-pointer">
                            <th scope="row" className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                                {race.round}
                            </th>
                            <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                                {race.raceName}
                            </td>
                            <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                                {race.date}
                            </td>
                            <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                                {race.time}
                            </td>
                        </tr>)
                    })}
                    </tbody>
                </table>
            </div>
        </div>)
}

export default RacesComponent;
