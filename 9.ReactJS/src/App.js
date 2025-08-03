import React from 'react';

function App() {
  const players = [
    { name: 'Mr. Jack', score: 50 },
    { name: 'Mr. Michael', score: 70 },
    { name: 'Mr. John', score: 40 },
    { name: 'Mr. Ann', score: 61 },
    { name: 'Mr. Elisabeth', score: 61 },
    { name: 'Mr. Sachin', score: 95 },
    { name: 'Mr. Dhoni', score: 100 },
    { name: 'Mr. Virat', score: 84 },
    { name: 'Mr. Jadeja', score: 64 },
    { name: 'Mr. Raina', score: 75 },
    { name: 'Mr. Rohit', score: 80 }
  ];

  const lessThan70 = players.filter(player => player.score < 70);

  // For second output (screenshot 2)
  const indianPlayers = ["Sachin", "Dhoni", "Virat", "Rohit", "Raina", "Yuvaraj"];
  const oddPlayers = indianPlayers.filter((_, i) => i % 2 === 0);
  const evenPlayers = indianPlayers.filter((_, i) => i % 2 === 1);

  return (
    <div>
      <h1>List of Players</h1>
      <ul>
        {players.map((p, index) => (
          <li key={index}>{p.name} {p.score}</li>
        ))}
      </ul>

      <hr />

      <h1>List of Players having Scores Less than 70</h1>
      <ul>
        {lessThan70.map((p, index) => (
          <li key={index}>{p.name} {p.score}</li>
        ))}
      </ul>

      <hr />

      <h2>Odd Players</h2>
      <ul>
        {oddPlayers.map((name, i) => (
          <li key={i}>
            {["First", "Third", "Fifth"][i]} : {name}{i * 2 + 1}
          </li>
        ))}
      </ul>

      <h2>Even Players</h2>
      <ul>
        {evenPlayers.map((name, i) => (
          <li key={i}>
            {["Second", "Fourth", "Sixth"][i]} : {name}{i * 2 + 2}
          </li>
        ))}
      </ul>

      <h2>List of Indian Players Merged:</h2>
      <ul>
        {indianPlayers.map((_, index) => (
          <li key={index}>Mr. {["First", "Second", "Third", "Fourth", "Fifth", "Sixth"][index]} Player</li>
        ))}
      </ul>
    </div>
  );
}

export default App;
