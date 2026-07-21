import React from 'react';
import { useParams, Link } from 'react-router-dom';

const TrainerDetails = ({ trainers }) => {
  const { id } = useParams();
  const trainer = trainers ? trainers.find((t) => String(t.TrainerId) === String(id)) : null;

  if (!trainer) {
    return (
      <div className="trainer-details-container">
        <h2>Trainer Details</h2>
        <p className="error-text">No trainer details found for ID: {id}</p>
        <Link to="/trainers" className="back-link">← Back to Trainers List</Link>
      </div>
    );
  }

  const skillsText = Array.isArray(trainer.Skills) ? trainer.Skills.join(', ') : trainer.Skills;

  return (
    <div className="trainer-details-container">
      <h2>Trainer Details</h2>
      <div className="details-card">
        <p><strong>Trainer ID:</strong> {trainer.TrainerId}</p>
        <p><strong>Name:</strong> {trainer.Name}</p>
        <p><strong>Email:</strong> {trainer.Email}</p>
        <p><strong>Phone:</strong> {trainer.Phone}</p>
        <p><strong>Technology:</strong> {trainer.Technology}</p>
        <p><strong>Skills:</strong> {skillsText}</p>
      </div>
      <Link to="/trainers" className="back-link">← Back to Trainers List</Link>
    </div>
  );
};

export default TrainerDetails;
