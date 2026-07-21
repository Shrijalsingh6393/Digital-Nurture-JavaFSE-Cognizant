import React from 'react';
import CalculateScore from './Components/CalculateScore';
import './App.css';

function App() {
  return (
    <div className="App">
      <CalculateScore
        Name={"John Doe"}
        School={"D.A.V Public School"}
        Total={284}
        goal={300}
      />
    </div>
  );
}

export default App;
