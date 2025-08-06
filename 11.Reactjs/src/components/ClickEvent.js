// src/components/ClickEvent.js
import React, { useState } from 'react';

function ClickEvent() {
    const [message, setMessage] = useState('');

    const handleClick = () => {
        setMessage('I was clicked');
    }

    return (
        <div>
            <button onClick={handleClick}>Click on me</button>
            <p>{message}</p>
        </div>
    );
}

export default ClickEvent;
