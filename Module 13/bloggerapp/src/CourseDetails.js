import React from 'react';

const CourseDetails = () => {
  const courses = [
    { id: 301, name: 'Java Full Stack Engineering', duration: '12 Weeks', fee: 'Rs. 25000' },
    { id: 302, name: 'Frontend Web Development with React', duration: '8 Weeks', fee: 'Rs. 18000' },
    { id: 303, name: 'Cloud Native Microservices', duration: '10 Weeks', fee: 'Rs. 22000' }
  ];

  return (
    <div className="section-card course-card">
      <h2>Course Details</h2>
      <div className="card-list">
        {courses.map((course) => (
          <div key={course.id} className="item-card">
            <h3>{course.name}</h3>
            <p><strong>Duration:</strong> {course.duration}</p>
            <p><strong>Course Fee:</strong> {course.fee}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default CourseDetails;
