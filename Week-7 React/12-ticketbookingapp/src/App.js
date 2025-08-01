import React, { useState } from 'react';
import './App.css';
import Login from './components/Login';
import Logout from './components/Logout';
import GuestPage from './components/GuestPage';
import UserPage from './components/UserPage';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLogin = () => {
    setIsLoggedIn(true);
  };

  const handleLogout = () => {
    setIsLoggedIn(false);
  };

  return (
    <div className="App">
      <h1>Ticket Booking App</h1>
      {isLoggedIn ? (
        <>
          <Logout onLogout={handleLogout} />
          <UserPage />
        </>
      ) : (
        <>
          <Login onLogin={handleLogin} />
          <GuestPage />
        </>
      )}
    </div>
  );
}

export default App;