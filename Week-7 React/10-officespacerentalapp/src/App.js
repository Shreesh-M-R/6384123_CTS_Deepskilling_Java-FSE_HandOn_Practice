import React from 'react';
import './App.css';
import officeImage from './assests/office_space.jpg'; 

const OfficeSpaceRentalApp = () => {
  
  const office = {
    name: 'Prime Office',
    rent: 55000,
    address: '123 Business Street, City Center',
  };

  const officeList = [
    { id: 1, name: 'Downtown Hub', rent: 45000, address: '456 Main Ave, Downtown' },
    { id: 2, name: 'Skyline Plaza', rent: 75000, address: '789 Sky Road, Uptown' },
    { id: 3, name: 'Metro Office', rent: 62000, address: '101 Metro Lane, Suburb' },
  ];

  return (
    <div style={{ fontFamily: 'Arial, sans-serif', padding: '20px', maxWidth: '800px', margin: '0 auto' }}>
   
      <h1 style={{ textAlign: 'center', color: '#333' }}>Office Space Rental</h1>

      <img
        src={officeImage} 
        alt="Office Space"
        style={{ width: '100%', height: 'auto', borderRadius: '8px', marginBottom: '20px' }}
      />

      <div style={{ border: '1px solid #ddd', padding: '15px', borderRadius: '8px', marginBottom: '20px' }}>
        <h2>{office.name}</h2>
        <p style={{ color: office.rent < 60000 ? 'red' : 'green', fontWeight: 'bold' }}>
          Rent: ₹{office.rent}
        </p>
        <p>Address: {office.address}</p>
      </div>

     
      <h2 style={{ color: '#333' }}>Available Office Spaces</h2>
      <div style={{ display: 'flex', flexDirection: 'column', gap: '10px' }}>
        {officeList.map((office) => (
          <div
            key={office.id}
            style={{
              border: '1px solid #ddd',
              padding: '10px',
              borderRadius: '8px',
              backgroundColor: '#f9f9f9',
            }}
          >
            <h3>{office.name}</h3>
            <p style={{ color: office.rent < 60000 ? 'red' : 'green', fontWeight: 'bold' }}>
              Rent: ₹{office.rent}
            </p>
            <p>Address: {office.address}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default OfficeSpaceRentalApp;