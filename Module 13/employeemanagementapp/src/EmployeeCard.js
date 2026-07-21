import React, { useContext } from 'react';
import ThemeContext from './ThemeContext';

const EmployeeCard = ({ employee }) => {
  // Retrieve theme context value via useContext hook
  const theme = useContext(ThemeContext);

  return (
    <div className={`employee-card ${theme}-card`}>
      <h3>{employee.name}</h3>
      <p><strong>Designation:</strong> {employee.designation}</p>
      <p><strong>Department:</strong> {employee.department}</p>
      <p><strong>Email:</strong> {employee.email}</p>
      {/* Use theme variable to pass the className for the button */}
      <button className={`btn ${theme}-btn`}>
        View Details ({theme.toUpperCase()} Theme)
      </button>
    </div>
  );
};

export default EmployeeCard;
