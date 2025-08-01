import React from 'react';
import EventExamples from './EventExamples';
import CurrencyConverter from './CurrencyConverter';
import './App.css';

function App() {
  return (
    <div className="app-container">
      <h1>React Event Handling Demo</h1>
      <EventExamples />
      <CurrencyConverter />
    </div>
  );
}

export default App;