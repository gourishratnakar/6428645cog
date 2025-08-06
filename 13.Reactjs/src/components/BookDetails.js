// src/components/BookDetails.js
import React from 'react';

const BookDetails = ({ show }) => {
    if (!show) return null;   // Method 1: return null if not show

    return (
        <div>
            <h2>Book Details</h2>
            <p><strong>Title:</strong> React Explained</p>
            <p><strong>Author:</strong> Zac Gordon</p>
            <p><strong>Price:</strong> $29.99</p>
        </div>
    );
};

export default BookDetails;
