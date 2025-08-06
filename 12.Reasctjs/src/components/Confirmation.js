import React from 'react';

function Confirmation({ userName, movie }) {
  return (
    <div>
      <h2>Booking Confirmed!</h2>
      <p>
        Thank you, <strong>{userName}</strong>. You have successfully booked a ticket for:
      </p>
      <p>
        <strong>{movie.title}</strong> at {movie.time}
      </p>
    </div>
  );
}

export default Confirmation;
