// src/components/BlogDetails.js
import React from 'react';

const BlogDetails = ({ show }) => {
    // Method 2: short-circuit && rendering
    return (
        show && (
            <div>
                <h2>Blog Details</h2>
                <p><strong>Title:</strong> Mastering Conditional Rendering in React</p>
                <p><strong>Author:</strong> John Doe</p>
                <p><strong>Date:</strong> August 6, 2025</p>
            </div>
        )
    );
};

export default BlogDetails;
