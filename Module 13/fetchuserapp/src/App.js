import React from 'react';
import Getuser from './Getuser';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>REST API User Fetch Application</h1>
      </header>
      <main className="App-main">
        <Getuser />
      </main>
    </div>
  );
}

export default App;
