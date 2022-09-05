import React from "react";
import RaceResult from "../../lib/models/race-detail/RaceResult.model";

export interface IResults {
    results: RaceResult[]
}

const Results: React.FC<IResults> = ({ results }) => {
    return (
        <div className="relative h-full mx-5">
        <div className="h-full overflow-x-auto relative shadow-md sm:rounded-lg m-5 bg-white">
            <table className="text-sm text-left">
                <thead className="border-b border-gray-400">
                <tr className="border-b border-gray-400">
                    <th scope="col" className="py-3 px-6 text-2xl font-black font-bold">
                        Race Results
                    </th>
                </tr>
                <tr className="text-xs text-gray-700 uppercase bg-gray-50">
                    <th scope="col" className="py-3 px-6">
                        Driver
                    </th>
                    <th scope="col" className="py-3 px-6">
                        Position
                    </th>
                    <th scope="col" className="py-3 px-6">
                        Points
                    </th>
                </tr>
                </thead>
                <tbody>
                {results.map((result, index) => {
                    return (                <tr className="bg-white border-b">
                        <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                            {result.competitor.name}
                        </td>
                        <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                            {result.position}
                        </td>
                        <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                            {result.points}
                        </td>
                    </tr>)
                })}
                </tbody>
            </table>
        </div>
        </div>)
}

export default Results;
