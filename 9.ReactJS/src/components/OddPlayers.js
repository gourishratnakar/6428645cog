import React from 'react';

const OddPlayers = (props) => {
  const names = props.IndianTeam;
  return (
    <ul>
      {names.map((name, index) => {
        if ((index + 1) % 2 !== 0) {
          return <li key={index}>Position {index + 1}: {name}</li>;
        }
        return null;
      })}
    </ul>
  );
};

export default OddPlayers;
