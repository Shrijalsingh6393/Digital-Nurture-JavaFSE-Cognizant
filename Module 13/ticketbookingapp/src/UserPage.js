import React, { useState } from 'react';

const UserPage = () => {
  const [bookingMsg, setBookingMsg] = useState('');

  const flights = [
    { id: 'AI-101', airline: 'Air India', from: 'Delhi', to: 'Mumbai', time: '10:00 AM', price: 'Rs. 4500' },
    { id: '6E-204', airline: 'IndiGo', from: 'Bengaluru', to: 'Chennai', time: '02:30 PM', price: 'Rs. 3200' },
    { id: 'UK-812', airline: 'Vistara', from: 'Hyderabad', to: 'Kolkata', time: '06:15 PM', price: 'Rs. 5100' }
  ];

  const handleBook = (flight) => {
    setBookingMsg(`Ticket successfully booked for ${flight.airline} (${flight.id}) from ${flight.from} to ${flight.to}!`);
  };

  return (
    <div className="page-container user-page">
      <h2>User Dashboard - Book Flight Tickets</h2>
      <p className="welcome-msg">Welcome back, Authenticated User!</p>
      {bookingMsg && <div className="alert success-alert">{bookingMsg}</div>}
      <div className="flights-grid">
        {flights.map((f) => (
          <div key={f.id} className="flight-card user-flight-card">
            <h3>{f.airline} ({f.id})</h3>
            <p><strong>Route:</strong> {f.from} ➔ {f.to}</p>
            <p><strong>Departure:</strong> {f.time}</p>
            <p><strong>Fare:</strong> {f.price}</p>
            <button className="btn book-btn" onClick={() => handleBook(f)}>
              Book Ticket
            </button>
          </div>
        ))}
      </div>
    </div>
  );
};

export default UserPage;
