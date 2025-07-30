import React from 'react';

const ListofPlayers = () => {
  const players = [
    { name: 'Virat Kohli', score: 85 },
    { name: 'Rohit Sharma', score: 92 },
    { name: 'KL Rahul', score: 65 },
    { name: 'Shikhar Dhawan', score: 78 },
    { name: 'Rishabh Pant', score: 45 },
    { name: 'Hardik Pandya', score: 60 },
    { name: 'Ravindra Jadeja', score: 73 },
    { name: 'Jasprit Bumrah', score: 20 },
    { name: 'Mohammed Shami', score: 15 },
    { name: 'Yuzvendra Chahal', score: 30 },
    { name: 'Ishan Kishan', score: 88 },
  ];

  const lowScorePlayers = players.filter(player => player.score < 70);

  return (
    <div>
      <h2>All Players</h2>
      <ul>
        {players.map((player, index) => (
          <li key={index}>
            {player.name}: {player.score}
          </li>
        ))}
      </ul>
      <h2>Players with Scores Below 70</h2>
      <ul>
        {lowScorePlayers.map((player, index) => (
          <li key={index}>
            {player.name}: {player.score}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;