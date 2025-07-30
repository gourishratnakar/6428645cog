// src/Post.js
import React from 'react';

export default function Post(props) {
  return (
    <div>
      <h3>{props.title}</h3>
      <p>{props.body}</p>
    </div>
  );
}
