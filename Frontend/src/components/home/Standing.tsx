import React from "react";
import Competitor from "../../lib/models/Competitor.model";
import Standing from "../../lib/models/season-detail/Standing.model";
import {plainToInstance} from "class-transformer";


export interface IStanding {
    standingName: string,
    standing: Standing[],
}

const StandingComponent: React.FC<IStanding> = ({ standingName,standing }) => {
    return (
        <div className="relative h-full mx-5">
            <div className="h-full overflow-y-auto shadow-md rounded bg-white bg-opacity-90">
                <table className="table-auto w-full">
                    <thead className="border-b border-gray-400">
                    <tr className="border-b border-gray-400">
                        <th scope="col" className="py-3 px-6 text-2xl font-black font-bold">
                            {standingName}
                        </th>
                    </tr>
                    <tr className="text-xs text-gray-700 uppercase bg-gray-50 bg-opacity-90">
                        <th scope="col" className="py-3 px-6">
                            Position
                        </th>
                        <th scope="col" className="py-3 px-6">
                            Name
                        </th>
                        <th scope="col" className="py-3 px-6">
                            Score
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    {standing.map((standing, index) => {
                        return (
                            <tr key={index} className="border-b">
                                <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap text-center">
                                    {standing.position}
                                </td>
                                <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap text-center">
                                    {standing.competitor.name}
                                </td>
                                <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap text-center">
                                    {standing.score}
                                </td>
                            </tr>)
                    })}
                    </tbody>
                </table>
            </div>
        </div>)
}

export default StandingComponent;
//table-auto w-full text-sm text-left text-gray-500 overflow-auto
