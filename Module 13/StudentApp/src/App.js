import React from 'react';
import Home from './Components/Home';
import About from './Components/About';
import Contact from './Components/Contact';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>Student Management Portal</h1>
      </header>
      <main className="App-main">
        <Home />
        <About />
        <Contact />
      </main>
    </div>
  );
}

export default App;
