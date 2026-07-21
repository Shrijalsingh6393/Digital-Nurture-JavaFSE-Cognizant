import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Home from './Home';
import TrainersList from './TrainersList';
import TrainerDetails from './TrainerDetails';
import mockTrainers from './TrainersMock';
import './App.css';

function App() {
  return (
    <Router>
      <div className="App">
        <header className="navbar">
          <h1>Cognizant Academy - Trainers Portal</h1>
          <nav className="nav-links">
            <Link to="/" className="nav-item">Home</Link>
            <Link to="/trainers" className="nav-item">Trainers List</Link>
          </nav>
        </header>

        <main className="main-content">
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/trainers" element={<TrainersList trainers={mockTrainers} />} />
            <Route path="/trainers/:id" element={<TrainerDetails trainers={mockTrainers} />} />
          </Routes>
        </main>
      </div>
    </Router>
  );
}

export default App;
