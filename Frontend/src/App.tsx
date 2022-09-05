import React from 'react';
import './App.css';
import { Routes, Route } from "react-router-dom";
import Home from "./views/Home";
import Race from "./views/Race";

//@ts-ignore
import Background from "./assets/background.jpg"


function App() {
  return (
      <div className="" style={{ backgroundImage: `url(${Background})` }}>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/race/:year/:round"
                 element={<Race />}
          />
        </Routes>
      </div>
  );
}

export default App;
