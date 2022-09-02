import React from "react";


const Grid: React.FC = () => {
    return (
        <div className="h-fit overflow-x-auto relative shadow-md sm:rounded-lg m-5 bg-white">
            <table className="text-sm text-left">
                <thead className="border-b border-gray-400">
                    <tr className="border-b border-gray-400">
                        <th scope="col" className="py-3 px-6 text-2xl font-black font-bold">
                            Starting grid
                        </th>
                    </tr>
                    <tr className="text-xs text-gray-700 uppercase bg-gray-50">
                        <th scope="col" colSpan={2} className="py-3 px-6">
                            Position
                        </th>
                        <th scope="col" className="py-3 px-6">
                            Qualifying time
                        </th>
                    </tr>
                </thead>
                <tbody>
                <tr className="bg-white border-b">
                    <td scope="row" className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                        Max Verstappen (Red Bull Racing)
                    </td>
                    <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                    </td>
                    <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap border-l border-gray-400">
                        Qualifiying time
                    </td>
                </tr>
                <tr className="bg-white border-b">
                    <th scope="row" className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                    </th>
                    <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                        Charles Leclerc (Ferrari)
                    </td>
                    <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap border-l border-gray-400">
                        Qualifiying time
                    </td>
                </tr>
                </tbody>
            </table>
        </div>)
}

export default Grid;
