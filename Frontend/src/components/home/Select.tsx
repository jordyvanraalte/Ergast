import React from "react";
import api from "../../lib/api";
import {setConstructorStandings, setCurrentSeason, setDriverStandings, setRaces} from "../../store/SeasonSlice";
import {useAppDispatch} from "../../store/Hooks";

export type OnSelect = (value: string) => void;

export interface ISelect {
    title: string,
    options: string[];
    onSelect: OnSelect
}



const Select: React.FC<ISelect> = ({title, options, onSelect}) => {
    const dispatch = useAppDispatch()

    return (<div className={"m-5 shadow-md sm:rounded-lg"}>
        <select id="Seasons" onChange={(e) => onSelect(e.currentTarget.value)} className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 ">
            <option value={title}>{title}</option>
            {options.map((option, index) => {
                return (<option value={option} key={index}>{option}</option>)
            })}
        </select>
    </div>)
}

export default Select;
