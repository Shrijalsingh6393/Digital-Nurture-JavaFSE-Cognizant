import React from 'react';
import CohortDetails from './CohortDetails';
import './App.css';

function App() {
  const cohorts = [
    {
      code: 'INTADM21D001',
      technology: 'Java Full Stack Engineering',
      status: 'ongoing',
      startDate: '2026-01-15',
      duration: '12 Weeks',
      count: 25
    },
    {
      code: 'INTADM21D002',
      technology: 'Python Data Science',
      status: 'completed',
      startDate: '2025-09-01',
      duration: '10 Weeks',
      count: 30
    },
    {
      code: 'INTADM21D003',
      technology: 'Cloud Native AWS',
      status: 'ongoing',
      startDate: '2026-02-01',
      duration: '8 Weeks',
      count: 20
    }
  ];

  return (
    <div className="App">
      <header className="App-header">
        <h1>Cognizant Academy - Cohort Details Dashboard</h1>
      </header>
      <main className="cohort-container">
        {cohorts.map((c) => (
          <CohortDetails key={c.code} cohort={c} />
        ))}
      </main>
    </div>
  );
}

export default App;
