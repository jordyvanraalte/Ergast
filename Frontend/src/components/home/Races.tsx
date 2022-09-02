import React from "react";


const Races: React.FC = () => {
    const onRaceClick = () => {

    }

    return (
        <div className="h-fit overflow-x-auto relative shadow-md sm:rounded-lg m-5">
            <table className="text-sm text-left text-gray-500">
                <thead className="text-xs text-gray-700 uppercase bg-gray-50">
                <tr>
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
                <tr className="bg-white border-b">
                    <th scope="row" className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                        1
                    </th>
                    <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                        Dutch Grand Prix
                    </td>
                    <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                        04-09-2022
                    </td>
                    <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                        15:00
                    </td>
                </tr>
                <tr className="bg-white border-b">
                    <th scope="row" className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                        1
                    </th>
                    <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                        Dutch Grand Prix
                    </td>
                    <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                        04-09-2022
                    </td>
                    <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                        15:00
                    </td>
                </tr>
                <tr className="bg-white border-b">
                    <th scope="row" className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                        1
                    </th>
                    <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                        Dutch Grand Prix
                    </td>
                    <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                        04-09-2022
                    </td>
                    <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                        15:00
                    </td>
                </tr>
                </tbody>
            </table>
        </div>)
}

export default Races;
