import React from 'react';
import CohortDetails from './CohortDetails';
import { CohortData } from './Cohort';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>Cognizant Academy - Cohort Unit Testing Dashboard</h1>
      </header>
      <main className="cohort-grid">
        {CohortData.map((cohort) => (
          <CohortDetails key={cohort.code} cohort={cohort} />
        ))}
      </main>
    </div>
  );
}

export default App;
