import React, { useState } from 'react';
import GuestPage from './GuestPage';
import UserPage from './UserPage';
import './App.css';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  // Element Variables for Conditional Rendering
  let pageContent;
  let authButton;

  if (isLoggedIn) {
    pageContent = <UserPage />;
    authButton = (
      <button className="btn auth-btn logout-btn" onClick={() => setIsLoggedIn(false)}>
        Logout
      </button>
    );
  } else {
    pageContent = <GuestPage />;
    authButton = (
      <button className="btn auth-btn login-btn" onClick={() => setIsLoggedIn(true)}>
        Login
      </button>
    );
  }

  return (
    <div className="App">
      <header className="navbar">
        <h1>Flight Ticket Booking Portal</h1>
        <div className="auth-controls">
          {authButton}
        </div>
      </header>

      <main className="main-content">
        {pageContent}
      </main>
    </div>
  );
}

export default App;
