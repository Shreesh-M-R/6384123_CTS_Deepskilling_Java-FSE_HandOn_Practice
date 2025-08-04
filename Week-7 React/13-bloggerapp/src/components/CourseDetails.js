import React from 'react';

const CourseDetails = ({ items }) => {
  return (
    <div>
      <h3 className="section-title">Courses List</h3>
      {items.length > 0 ? (
        items.map(course => (
          <div 
            key={course.id} 
            className="item-card"
          >
            <h4 className="item-title">{course.title}</h4>
            <p className="item-text">Duration: {course.duration}</p>
          </div>
        ))
      ) : (
        <p className="empty-state">No courses available.</p>
      )}
    </div>
  );
};

export default CourseDetails;