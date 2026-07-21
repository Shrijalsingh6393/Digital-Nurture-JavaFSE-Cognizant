import React from 'react';
import { Link } from 'react-router-dom';

const TrainersList = ({ trainers }) => {
  return (
    <div className="trainers-list-container">
      <h2>Trainers List</h2>
      <ul className="trainers-list">
        {trainers && trainers.map((trainer) => (
          <li key={trainer.TrainerId} className="trainer-item">
            <Link to={`/trainers/${trainer.TrainerId}`} className="trainer-link">
              {trainer.Name}
            </Link>
            <span className="trainer-tech"> — {trainer.Technology}</span>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default TrainersList;
