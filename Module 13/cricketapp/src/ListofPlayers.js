import React from 'react';

const ListofPlayers = () => {
  const players = [
    { name: 'Jack', score: 50 },
    { name: 'Michael', score: 70 },
    { name: 'John', score: 40 },
    { name: 'Ann', score: 61 },
    { name: 'Elisabeth', score: 61 },
    { name: 'Sachin', score: 95 },
    { name: 'Dhoni', score: 100 },
    { name: 'Virat', score: 85 },
    { name: 'Rohit', score: 65 },
    { name: 'Yuvraj', score: 45 },
    { name: 'Raina', score: 55 }
  ];

  // Using ES6 arrow function filter to get players with score < 70
  const filteredPlayers = players.filter((player) => player.score < 70);

  return (
    <div className="players-section">
      <h1>List of Players</h1>
      <ul className="players-list">
        {players.map((item, index) => (
          <li key={index}>
            Mr. {item.name} <span>{item.score}</span>
          </li>
        ))}
      </ul>

      <hr className="divider" />

      <h1>List of Players having score less than 70</h1>
      <ul className="players-list filtered">
        {filteredPlayers.map((item, index) => (
          <li key={index}>
            Mr. {item.name} <span>{item.score}</span>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
