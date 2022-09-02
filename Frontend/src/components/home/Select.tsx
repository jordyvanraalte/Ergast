import React from "react";

const Select: React.FC = () => {
    return (<div className={"m-5 shadow-md sm:rounded-lg"}>
        <select id="Seasons"
                className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 ">
            <option selected>Choose a Season</option>
            <option value="US">United States</option>
            <option value="CA">Canada</option>
            <option value="FR">France</option>
            <option value="DE">Germany</option>
        </select>
    </div>)
}

export default Select;
