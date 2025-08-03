import React from 'react';
import styles from '../css/CohortDetails.module.css';

function CohortDetails() {
  const cohorts = [
    {
      name: 'Sample Cohort 1',
      startDate: '01/01/2025',
      endDate: '30/06/2025',
    },
    {
      name: 'Sample Cohort 2',
      startDate: '01/07/2025',
      endDate: '31/12/2025',
    },
    {
      name: 'Sample Cohort 3',
      startDate: '01/01/2026',
      endDate: '30/06/2026',
    },
  ];

  return (
    <div className={styles.container}>
      <h2>Cohort Details Page</h2>
      <div className={styles.cardContainer}>
        {cohorts.map((cohort, index) => (
          <div key={index} className={styles.card}>
            <h3>{cohort.name}</h3>
            <p><strong>Start Date:</strong> {cohort.startDate}</p>
            <p><strong>End Date:</strong> {cohort.endDate}</p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default CohortDetails;
