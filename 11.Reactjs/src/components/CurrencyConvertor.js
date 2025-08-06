// src/components/CurrencyConvertor.js
import React, { useState } from 'react';

function CurrencyConvertor() {
    const [amount, setAmount] = useState('');
    const [currency, setCurrency] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        let convertedAmount = 0;
        if (currency.toLowerCase() === 'euro') {
            convertedAmount = amount * 80;
        } else if (currency.toLowerCase() === 'dollar') {
            convertedAmount = amount * 70;
        } else {
            alert("Currency not supported");
            return;
        }
        alert(`Converting to ${currency} Amount is ${convertedAmount}`);
    }

    return (
        <div>
            <h2 style={{ color: 'green' }}>Currency Convertor!!!</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Amount: </label>
                    <input type="number" value={amount} onChange={(e) => setAmount(e.target.value)} required />
                </div>
                <div>
                    <label>Currency: </label>
                    <input type="text" value={currency} onChange={(e) => setCurrency(e.target.value)} required />
                </div>
                <button type="submit">Submit</button>
            </form>
        </div>
    );
}

export default CurrencyConvertor;
