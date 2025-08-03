import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import CohortDetails from './pages/CohortDetails';
import Navbar from './components/Navbar';

function App() {
  return (
    <>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/cohortdetails" element={<CohortDetails />} />
      </Routes>
    </>
  );
}

export default App;
