import React, { useState } from 'react';

function EventExamples() {
  const [counter, setCounter] = useState(0);

  const incrementCounter = () => {
    setCounter(prev => prev + 1);
  };

  const handleIncrement = () => {
    incrementCounter();
  };

  const decrementCounter = () => {
    setCounter(prev => prev - 1);
  };

  const sayWelcome = (message) => {
    alert(message);
  };

  const handlePress = (e) => {
    console.log('Synthetic event:', e);
    alert('You clicked me 😘');
  };

  return (
    <div className="event-examples">
      <h2>Event Examples</h2>
      <div className="counter-section">
        <p>Counter: {counter}</p>
        <button onClick={handleIncrement} className="btn btn-primary">
          Increment
        </button>
        <button onClick={decrementCounter} className="btn btn-secondary">
          Decrement
        </button>
      </div>
      <div className="welcome-section">
        <button 
          onClick={() => sayWelcome('welcome ❤')} 
          className="btn btn-success"
        >
          Say Welcome
        </button>
      </div>
      <div className="press-section">
        <button onClick={handlePress} className="btn btn-info">
          OnPress
        </button>
      </div>
    </div>
  );
}

export default EventExamples;
