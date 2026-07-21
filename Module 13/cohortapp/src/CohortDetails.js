import React from 'react';
import styles from './CohortDetails.module.css';

const CohortDetails = (props) => {
  const cohort = props.cohort || props;
  const status = cohort.status ? cohort.status.toLowerCase() : '';
  const headingColor = status === 'ongoing' ? 'green' : 'blue';

  return (
    <div className={styles.box}>
      <h3 style={{ color: headingColor }}>
        {cohort.code || 'Cohort Details'}
      </h3>
      <dl>
        <dt>Technology:</dt>
        <dd>{cohort.technology}</dd>

        <dt>Status:</dt>
        <dd style={{ color: headingColor, fontWeight: 'bold' }}>{cohort.status}</dd>

        <dt>Start Date:</dt>
        <dd>{cohort.startDate}</dd>

        <dt>Duration:</dt>
        <dd>{cohort.duration}</dd>

        <dt>Participants Count:</dt>
        <dd>{cohort.count}</dd>
      </dl>
    </div>
  );
};

export default CohortDetails;
