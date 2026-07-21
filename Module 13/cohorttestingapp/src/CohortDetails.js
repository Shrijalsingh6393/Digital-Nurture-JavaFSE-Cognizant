import React from 'react';

const CohortDetails = ({ cohort }) => {
  if (!cohort) return null;

  const { code, technology, status, startDate, duration, count } = cohort;
  const headingColor = status === 'ongoing' ? 'green' : 'blue';

  return (
    <div className="cohort-box">
      <h3 style={{ color: headingColor }}>{code}</h3>
      <dl>
        <dt>Technology:</dt>
        <dd>{technology}</dd>

        <dt>Status:</dt>
        <dd>{status}</dd>

        <dt>Start Date:</dt>
        <dd>{startDate}</dd>

        <dt>Duration:</dt>
        <dd>{duration}</dd>

        <dt>Participants Count:</dt>
        <dd>{count}</dd>
      </dl>
    </div>
  );
};

export default CohortDetails;
