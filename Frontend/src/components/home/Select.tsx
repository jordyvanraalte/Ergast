import React from "react";

export type OnSelect = (value: string) => void;

export interface ISelect {
    title: string,
    options: string[];
}



const Select: React.FC<ISelect> = ({title, options}) => {
    const click = (e: any) => {
        console.log(e.currentTarget.value)
    }

    return (<div className={"m-5 shadow-md sm:rounded-lg"}>
        <select id="Seasons" onChange={click} className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 ">
            <option value={title}>{title}</option>
            {options.map((option, index) => {
                return (<option value={option} key={index}>{option}</option>)
            })}
        </select>
    </div>)
}

export default Select;
