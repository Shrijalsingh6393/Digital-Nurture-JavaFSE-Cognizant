import React from 'react';
import ComplaintRegister from './ComplaintRegister';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>Ticket Raising Portal</h1>
      </header>
      <main className="App-main">
        <ComplaintRegister />
      </main>
    </div>
  );
}

export default App;
