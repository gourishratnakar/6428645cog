// src/App.js
import React, { useState } from 'react';
import BookDetails from './components/BookDetails';
import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';
import './App.css';

function App() {
    const [showBook, setShowBook] = useState(true);
    const [showBlog, setShowBlog] = useState(true);
    const [showCourse, setShowCourse] = useState(true);

    return (
        <div className="App">
            <h1>Blogger App</h1>
            <div className="buttons">
                <button onClick={() => setShowBook(!showBook)}>Toggle Book Details</button>
                <button onClick={() => setShowBlog(!showBlog)}>Toggle Blog Details</button>
                <button onClick={() => setShowCourse(!showCourse)}>Toggle Course Details</button>
            </div>
            <div className="details">
                <BookDetails show={showBook} />
                <BlogDetails show={showBlog} />
                <CourseDetails show={showCourse} />
            </div>
        </div>
    );
}

export default App;
