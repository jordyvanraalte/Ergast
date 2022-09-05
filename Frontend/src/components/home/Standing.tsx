import React from "react";
import Standing from "../../lib/models/season-detail/Standing.model";


export interface IStanding {
    standingName: string,
    standing: Standing[],
}

const StandingComponent: React.FC<IStanding> = ({ standingName,standing }) => {
    return (
        <div className="relative h-full mx-5">
            <div className="shadow-md rounded bg-white bg-opacity-90 my-5 text-center">
                <span className="px-5 my-5 text-3xl">{standingName}</span>
            </div>
            <div className="h-full overflow-y-auto shadow-md rounded bg-white bg-opacity-90">
                <table className="table-auto w-full">
                    <thead className="text-xs text-gray-700 uppercase">
                    <tr>
                        <th scope="col" className="py-3 px-4">
                            Position
                        </th>
                        <th scope="col" className="py-3 px-6">
                            Name
                        </th>
                        <th scope="col" className="py-3 px-6">
                            Points
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    {standing.map((standing, index) => {
                        return (
                            <tr key={index} className="border-b">
                                <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                                    {standing.position}
                                </td>
                                <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                                    {standing.competitor.name}
                                </td>
                                <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                                    {standing.points}
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
