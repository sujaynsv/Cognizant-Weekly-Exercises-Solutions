// src/Post.js
import React from 'react';

const Post = ({ title, body }) => {
  return (
    <div>
      <h3>{title}</h3>
      <p>{body}</p>
    </div>
  );
};

export default Post;