import React from 'react';

function FlightList({ canBook }) {
  const flights = [
    { id: 1, from: 'Madurai', to: 'Chennai', price: 5000 },
    { id: 2, from: 'Chennai', to: 'Tokyo', price: 80000 },
    { id: 3, from: 'Tokyo', to: 'Chennai', price: 65000 },
    { id: 4, from: 'New York', to: 'Chennai', price: 90000 },
    { id: 5, from: 'Paris', to: 'New York', price: 80000 },
    { id: 6, from: 'Sydney', to: 'Dubai', price: 65000 },
    
  ];

  const handleBook = (flight) => {
    alert(`Booking flight from ${flight.from} to ${flight.to} for ₹${flight.price}`);
  };

  return (
    <div className="flight-list">
      <h3>Available Flights</h3>
      {flights.map((flight) => (
        <div key={flight.id} className="flight-item">
          <p>
            {flight.from} to {flight.to} - ₹{flight.price}
          </p>
          {canBook && (
            <button className="book-button" onClick={() => handleBook(flight)}>
              Book Now
            </button>
          )}
        </div>
      ))}
    </div>
  );
}

export default FlightList;