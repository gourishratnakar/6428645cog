import React from 'react';
import { Link } from 'react-router-dom';

function Navbar() {
  return (
    <nav style={{ padding: '10px', background: '#f2f2f2' }}>
      <Link to="/" style={{ marginRight: '15px' }}>Home</Link>
      <Link to="/cohortdetails">Cohort Details</Link>
    </nav>
  );
}

export default Navbar;
