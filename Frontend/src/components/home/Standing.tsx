import React from "react";

const Standing: React.FC = () => {
    return (
        <div className="h-fit overflow-x-auto relative shadow-md sm:rounded-lg m-5">
            <table className="text-sm text-left text-gray-500">
            <thead className="text-xs text-gray-700 uppercase bg-gray-50">
            <tr>
                <th scope="col" className="py-3 px-6">
                    Position
                </th>
                <th scope="col" className="py-3 px-6">
                    Competitor
                </th>
                <th scope="col" className="py-3 px-6">
                    Points
                </th>
            </tr>
            </thead>
            <tbody>
            <tr className="bg-white border-b">
                <th scope="row" className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                    1
                </th>
                <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                    Red Bull Racing
                </td>
                <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                    300
                </td>
            </tr>
            <tr className="bg-white border-b">
                <th scope="row" className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                    1
                </th>
                <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                    Red Bull Racing
                </td>
                <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                    300
                </td>
            </tr>
            <tr className="bg-white border-b">
                <th scope="row" className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                    1
                </th>
                <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                    Red Bull Racing
                </td>
                <td className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap">
                    300
                </td>
            </tr>
            </tbody>
        </table>
    </div>)
}

export default Standing;
