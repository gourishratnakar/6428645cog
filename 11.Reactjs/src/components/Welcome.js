// src/components/Welcome.js
import React from 'react';

function Welcome() {
    const handleClick = () => {
        alert("Welcome to React JS!!!");
    }

    return (
        <div>
            <button onClick={handleClick}>Say welcome</button>
        </div>
    );
}

export default Welcome;
