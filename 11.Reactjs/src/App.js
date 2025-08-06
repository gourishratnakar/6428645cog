// src/App.js
import React from 'react';
import Counter from './components/Counter';
import Welcome from './components/Welcome';
import ClickEvent from './components/ClickEvent';
import CurrencyConvertor from './components/CurrencyConvertor';

function App() {
    return (
        <div className="App">
            <Counter />
            <Welcome />
            <ClickEvent />
            <CurrencyConvertor />
        </div>
    );
}

export default App;
