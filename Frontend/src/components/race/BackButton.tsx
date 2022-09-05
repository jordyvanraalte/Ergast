import React from "react";
import { useNavigate } from "react-router-dom";

const BackButton: React.FC = () => {
    const navigate = useNavigate();
    const onBackButtonClick = () => {
       navigate("/")
    }

    return (<div className="absolute m-5">
        <div className="flex space-x-2 justify-center">
            <div>
                <button type="button"
                        className="inline-block rounded-full bg-white text-black leading-normal uppercase shadow-md hover:bg-gray-200 hover:shadow-lg focus:outline-none focus:ring-0transition duration-150 ease-in-out w-16 h-16"
                    onClick={onBackButtonClick}
                >
                    <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" className="w-3 mx-auto w-8 h-8" role="img" viewBox="0 0 16 16">
                        <path fill-rule="evenodd"
                              d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8z"/>
                    </svg>
                </button>
            </div>
        </div>
    </div>)
}

export default BackButton;
