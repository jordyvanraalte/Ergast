import React from "react";


const Results: React.FC = () => {
    return (
        <div className="h-fit overflow-x-auto relative shadow-md sm:rounded-lg m-5 bg-white">
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
                <tr className="bg-white border-b">
                    <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                        Max Verstappen (Red Bull Racing)
                    </td>
                    <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                        1
                    </td>
                    <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                        25
                    </td>
                </tr>
                <tr className="bg-white border-b">
                    <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                        Lewis Hamilton (Mercedes)
                    </td>
                    <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                        2
                    </td>
                    <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                        18
                    </td>
                </tr>
                </tbody>
            </table>
        </div>)
}

export default Results;
