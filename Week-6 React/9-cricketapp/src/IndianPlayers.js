import React from 'react';

const IndianPlayers = () => {
  const teamPlayers = [
    'Virat Kohli',
    'Rohit Sharma',
    'KL Rahul',
    'Shikhar Dhawan',
    'Rishabh Pant',
    'Hardik Pandya',
  ];

  const [odd1, , odd2, , odd3] = teamPlayers; 
  const [, even1, , even2, , even3] = teamPlayers; 

  const T20players = ['Virat Kohli', 'Rohit Sharma', 'KL Rahul'];
  const RanjiTrophy = ['Cheteshwar Pujara', 'Ajinkya Rahane', 'Hanuma Vihari'];

  const allPlayers = [...T20players, ...RanjiTrophy];

  return (
    <div>
      <h2>Odd Team Players</h2>
      <ul>
        <li>{odd1}</li>
        <li>{odd2}</li>
        <li>{odd3}</li>
      </ul>
      <h2>Even Team Players</h2>
      <ul>
        <li>{even1}</li>
        <li>{even2}</li>
        <li>{even3}</li>
      </ul>
      <h2>Merged Players (T20 and Ranji Trophy)</h2>
      <ul>
        {allPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>
    </div>
  );
};

export default IndianPlayers;