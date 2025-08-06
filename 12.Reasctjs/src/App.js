import React, { useState } from 'react';
import MovieList from './components/MovieList';
import BookingForm from './components/BookingForm';
import Confirmation from './components/Confirmation';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [selectedMovie, setSelectedMovie] = useState(null);
  const [userName, setUserName] = useState('');

  const handleLogin = () => {
    setIsLoggedIn(true);
    setSelectedMovie(null);
    setUserName('');
  };

  const handleLogout = () => {
    setIsLoggedIn(false);
    setSelectedMovie(null);
    setUserName('');
  };

  const handleBook = (movie) => {
    setSelectedMovie(movie);
  };

  const handleConfirm = (name) => {
    setUserName(name);
  };

  return (
    <div style={{ padding: '20px' }}>
      <h1>Flight Ticket Booking</h1>

      <div style={{ marginBottom: '20px' }}>
        {isLoggedIn ? (
          <button onClick={handleLogout}>Logout</button>
        ) : (
          <button onClick={handleLogin}>Login</button>
        )}
      </div>

      {isLoggedIn ? (
        <>
          {!selectedMovie && !userName && (
            <MovieList onBook={handleBook} />
          )}

          {selectedMovie && !userName && (
            <BookingForm selectedMovie={selectedMovie} onConfirm={handleConfirm} />
          )}

          {selectedMovie && userName && (
            <Confirmation userName={userName} movie={selectedMovie} />
          )}
        </>
      ) : (
        <p>Welcome Guest! Please log in to book a flight.</p>
      )}
    </div>
  );
}

export default App;
