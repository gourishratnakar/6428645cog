
import React from 'react';

function MovieList({ onBook }) {
  const movies = [
    { id: 1, title: 'Chennai to Bangalore', time: '10:00 AM' },
    { id: 2, title: 'Delhi to Mumbai', time: '1:00 PM' },
    { id: 3, title: 'Kolkata to Hyderabad', time: '5:30 PM' },
  ];

  return (
    <div>
      <h2>Available Flights</h2>
      {movies.map((movie) => (
        <div key={movie.id} style={{ marginBottom: '10px' }}>
          <strong>{movie.title}</strong> - {movie.time}
          <button onClick={() => onBook(movie)} style={{ marginLeft: '10px' }}>
            Book Ticket
          </button>
        </div>
      ))}
    </div>
  );
}

export default MovieList;
