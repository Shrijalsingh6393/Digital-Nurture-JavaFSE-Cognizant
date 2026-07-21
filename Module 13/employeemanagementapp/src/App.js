import React, { useState } from 'react';
import ThemeContext from './ThemeContext';
import EmployeesList from './EmployeesList';
import './App.css';

function App() {
  const [theme, setTheme] = useState('light');

  const employees = [
    { id: 1, name: 'Alice Johnson', designation: 'Senior Software Engineer', department: 'Technology', email: 'alice@cognizant.com' },
    { id: 2, name: 'Bob Smith', designation: 'UI/UX Designer', department: 'Design', email: 'bob@cognizant.com' },
    { id: 3, name: 'Charlie Davis', designation: 'DevOps Engineer', department: 'Infrastructure', email: 'charlie@cognizant.com' }
  ];

  const toggleTheme = () => {
    setTheme((prevTheme) => (prevTheme === 'light' ? 'dark' : 'light'));
  };

  return (
    /* Define theme context provider wrapping entire JSX of App component */
    <ThemeContext.Provider value={theme}>
      <div className={`App ${theme}-theme-bg`}>
        <header className="App-header">
          <h1>Apps Centric Solutions - Employee Management</h1>
          <button className="btn theme-toggle-btn" onClick={toggleTheme}>
            Toggle Theme (Current: {theme.toUpperCase()})
          </button>
        </header>

        <main className="App-main">
          {/* Theme name is no longer passed as props to EmployeesList */}
          <EmployeesList employees={employees} />
        </main>
      </div>
    </ThemeContext.Provider>
  );
}

export default App;
