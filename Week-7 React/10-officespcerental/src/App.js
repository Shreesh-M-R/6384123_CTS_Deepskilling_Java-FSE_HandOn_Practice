import React from 'react';
import './App.css';
import officeImage from './office.jpg';
function App() {
  // Object for office details
  const itemName = {
    Name: "DBS",
    Rent: 50000,
    Address: "Chennai"
  };

  // Array of office objects for looping
  const offices = [
    { Name: "DBS", Rent: 50000, Address: "Chennai" },
    { Name: "ABC Corp", Rent: 70000, Address: "Bangalore" }
  ];

  // Conditional inline CSS based on Rent
  const getRentStyle = (rent) => ({
    color: rent <= 60000 ? 'red' : 'green',
  });

  return (
    <div className="App">
      <h1>Office Space, at Affordable Range</h1>
      <img src={officeImage} width="25%" height="25%" alt="Office Space" style={{ display: 'block', margin: '0 auto' }} />
      <div className="office-container">
        <h1>{itemName.Name}, at Affordable Range</h1>
        <h3>Rent: Rs. {itemName.Rent}</h3>
        <h3 style={getRentStyle(itemName.Rent)}>Rent: Rs. {itemName.Rent}</h3>
        <h3>Address: {itemName.Address}</h3>
      </div>

      {/* Loop through offices */}
      {offices.map((office, index) => (
        <div key={index} className="office-container">
          <h1>{office.Name}, at Affordable Range</h1>
          <img src={officeImage} width="25%" height="25%" alt="Office Space" style={{ display: 'block', margin: '0 auto' }} />
          <h3>Rent: Rs. {office.Rent}</h3>
          <h3 style={getRentStyle(office.Rent)}>Rent: Rs. {office.Rent}</h3>
          <h3>Address: {office.Address}</h3>
        </div>
      ))}
    </div>
  );
}

export default App;