// src/components/CourseDetails.js
import React from 'react';

const CourseDetails = ({ show }) => {
    // Method 3: ternary operator rendering
    return show ? (
        <div>
            <h2>Course Details</h2>
            <p><strong>Course:</strong> Full Stack Web Development</p>
            <p><strong>Instructor:</strong> Jane Smith</p>
            <p><strong>Duration:</strong> 12 weeks</p>
        </div>
    ) : null;
};

export default CourseDetails;
