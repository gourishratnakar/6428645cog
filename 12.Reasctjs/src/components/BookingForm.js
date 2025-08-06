import React, { useState } from 'react';

function BookingForm({ selectedMovie, onConfirm }) {
  const [name, setName] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    onConfirm(name);
  };

  return (
    <div>
      <h2>Book Ticket for: {selectedMovie.title}</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="Enter Your Name"
          value={name}
          onChange={(e) => setName(e.target.value)}
          required
        />
        <button type="submit">Confirm Booking</button>
      </form>
    </div>
  );
}

export default BookingForm;
