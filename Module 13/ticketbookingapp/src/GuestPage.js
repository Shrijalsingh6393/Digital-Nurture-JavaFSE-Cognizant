import React from 'react';

const GuestPage = () => {
  const flights = [
    { id: 'AI-101', airline: 'Air India', from: 'Delhi', to: 'Mumbai', time: '10:00 AM', price: 'Rs. 4500' },
    { id: '6E-204', airline: 'IndiGo', from: 'Bengaluru', to: 'Chennai', time: '02:30 PM', price: 'Rs. 3200' },
    { id: 'UK-812', airline: 'Vistara', from: 'Hyderabad', to: 'Kolkata', time: '06:15 PM', price: 'Rs. 5100' }
  ];

  return (
    <div className="page-container guest-page">
      <h2>Guest View - Flight Schedule Directory</h2>
      <p className="info-msg">Please log in to book flight tickets.</p>
      <div className="flights-grid">
        {flights.map((f) => (
          <div key={f.id} className="flight-card">
            <h3>{f.airline} ({f.id})</h3>
            <p><strong>Route:</strong> {f.from} ➔ {f.to}</p>
            <p><strong>Departure:</strong> {f.time}</p>
            <p><strong>Fare:</strong> {f.price}</p>
            <span className="badge guest-badge">Browsing Mode Only</span>
          </div>
        ))}
      </div>
    </div>
  );
};

export default GuestPage;
