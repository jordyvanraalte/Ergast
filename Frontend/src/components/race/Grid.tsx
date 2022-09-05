import React from "react";
import Grid from "../../lib/models/race-detail/Grid.model";

export interface IGrid {
    grid: Grid[]
}

const GridComponent: React.FC<IGrid> = ({ grid }) => {
    return (
        <div className="relative h-full mx-5">
        <div className="h-full overflow-x-auto relative shadow-md sm:rounded-lg m-5 bg-white bg-opacity-90">
            <table className="text-sm text-left">
                <thead className="border-b border-gray-400">
                    <tr className="border-b border-gray-400">
                        <th scope="col" className="py-3 px-6 text-2xl font-black font-bold">
                            Starting grid
                        </th>
                    </tr>
                    <tr className="text-xs text-gray-700 uppercase bg-opacity-90 bg-gray-50">
                        <th scope="col" colSpan={2} className="py-3 px-6">
                            Position
                        </th>
                        <th scope="col" className="py-3 px-6">
                            Qualifying time
                        </th>
                    </tr>
                </thead>
                <tbody>
                {grid.map((gridObject, index) => {
                    return(
                        index % 2 === 0 ? (
                            <tr key={gridObject.position} className="border-b">
                            <td scope="row" className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                                {gridObject.competitor.name}
                            </td>
                            <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                            </td>
                            <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap border-l border-gray-400">
                                {gridObject.qualifyTime}
                            </td>
                        </tr>) : <tr key={gridObject.position} className="border-b">
                            <td scope="row" className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                            </td>
                            <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                                {gridObject.competitor.name}
                            </td>
                            <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap border-l border-gray-400">
                                {gridObject.qualifyTime}
                            </td>
                        </tr>
                    )
                })}
                </tbody>
            </table>
        </div>
        </div>)
}

export default GridComponent;
