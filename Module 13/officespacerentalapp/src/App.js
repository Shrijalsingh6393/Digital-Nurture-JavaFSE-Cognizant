import React from 'react';
import './App.css';

function App() {
  const officeHeading = "Office Space , at Affordable Range";
  const officeImage = "https://images.unsplash.com/photo-1497366216548-37526070297c?w=500&auto=format&fit=crop";

  // Single Office Object
  const singleOffice = {
    Name: 'DBS',
    Rent: 50000,
    Address: 'Chennai'
  };

  // List of Office Objects
  const officeList = [
    { Name: 'DBS Tech Park', Rent: 50000, Address: 'Chennai' },
    { Name: 'Cognizant Innovation Hub', Rent: 65000, Address: 'Bengaluru' },
    { Name: 'Smart Workspace Center', Rent: 55000, Address: 'Hyderabad' },
    { Name: 'Global Enterprise Office', Rent: 75000, Address: 'Pune' }
  ];

  return (
    <div className="App">
      <div className="rental-card">
        <h1 className="heading">{officeHeading}</h1>
        
        <div className="image-container">
          <img
            src={officeImage}
            alt="Office Space"
            width="320"
            height="200"
            className="office-img"
          />
        </div>

        <div className="single-office-section">
          <h2>Featured Office Space:</h2>
          <p><strong>Name:</strong> {singleOffice.Name}</p>
          <p>
            <strong>Rent: </strong>
            <span style={{ color: singleOffice.Rent > 60000 ? 'green' : 'red', fontWeight: 'bold' }}>
              Rs. {singleOffice.Rent}
            </span>
          </p>
          <p><strong>Address:</strong> {singleOffice.Address}</p>
        </div>

        <hr className="divider" />

        <div className="office-list-section">
          <h2>Available Office Spaces:</h2>
          <div className="office-grid">
            {officeList.map((office, index) => (
              <div key={index} className="office-item">
                <h3>{office.Name}</h3>
                <p>
                  <strong>Rent: </strong>
                  <span style={{ color: office.Rent > 60000 ? 'green' : 'red', fontWeight: 'bold' }}>
                    Rs. {office.Rent}
                  </span>
                </p>
                <p><strong>Address:</strong> {office.Address}</p>
              </div>
            ))}
          </div>
        </div>
      </div>
    </div>
  );
}

export default App;
