import React, { useState } from 'react';
import ListofPlayers from './ListofPlayers';
import IndianPlayers from './IndianPlayers';
import './App.css';

function App() {
  const [flag, setFlag] = useState(true);

  let content;
  if (flag) {
    content = <ListofPlayers />;
  } else {
    content = <IndianPlayers />;
  }

  return (
    <div className="App">
      <header className="App-header">
        <h1>Cricket App - ES6 Features Demo</h1>
        <button className="toggle-btn" onClick={() => setFlag(!flag)}>
          Toggle View (Current Flag = {String(flag)})
        </button>
      </header>
      <main className="App-main">
        {content}
      </main>
    </div>
  );
}

export default App;
