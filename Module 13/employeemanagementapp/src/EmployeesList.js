import React from 'react';
import EmployeeCard from './EmployeeCard';

const EmployeesList = ({ employees }) => {
  return (
    <div className="employees-list">
      <h2>Employee List</h2>
      <div className="card-grid">
        {employees && employees.map((emp) => (
          /* Theme name is no longer passed as props explicitly to child component */
          <EmployeeCard key={emp.id} employee={emp} />
        ))}
      </div>
    </div>
  );
};

export default EmployeesList;
