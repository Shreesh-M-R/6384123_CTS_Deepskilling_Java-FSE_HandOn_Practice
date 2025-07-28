// src/App.js
import React from "react";
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import Home from "./Home";
import TrainerList from "./TrainerList";
import TrainerDetails from "./TrainerDetails";
import trainers from "./TrainersMock";

function App() {
  return (
    
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/trainers" element={<TrainerList trainers={trainers} />} />
        <Route path="/trainer/:id" element={<TrainerDetails />} />
      </Routes>
       <nav>
        <Link to="/">Home</Link> | <Link to="/trainers">Show Trainers</Link>
      </nav>
    </BrowserRouter>
  );
}

export default App;
