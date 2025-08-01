import React from 'react';
import FlightList from './FlightList';

function UserPage() {
  return (
    <div>
      <h2>Welcome User</h2>
      <p>Browse and book your flights below.</p>
      <FlightList canBook={true} />
    </div>
  );
}

export default UserPage;