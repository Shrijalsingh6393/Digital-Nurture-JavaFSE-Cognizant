import React from 'react';

const IndianPlayers = () => {
  const indianPlayersList = ['Sachin', 'Dhoni', 'Virat', 'Rohit', 'Yuvraj', 'Raina'];

  // ES6 Array Destructuring
  const [first, second, third, fourth, fifth, sixth] = indianPlayersList;

  const oddTeam = [first, third, fifth];
  const evenTeam = [second, fourth, sixth];

  // ES6 Array Merging using Spread Operator
  const T20players = ['First T20 Player', 'Second T20 Player', 'Third T20 Player'];
  const RanjiTrophyplayers = ['First Ranji Player', 'Second Ranji Player', 'Third Ranji Player'];
  const mergedPlayers = [...T20players, ...RanjiTrophyplayers];

  return (
    <div className="indian-players-section">
      <h1>Indian Players</h1>

      <h2>Odd Team Players (Destructuring):</h2>
      <ul className="players-list odd-team">
        {oddTeam.map((player, index) => (
          <li key={index}>Firstname : {player}</li>
        ))}
      </ul>

      <h2>Even Team Players (Destructuring):</h2>
      <ul className="players-list even-team">
        {evenTeam.map((player, index) => (
          <li key={index}>Firstname : {player}</li>
        ))}
      </ul>

      <hr className="divider" />

      <h2>Merged T20 & Ranji Trophy Players (Spread Operator):</h2>
      <ul className="players-list merged-team">
        {mergedPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>
    </div>
  );
};

export default IndianPlayers;
