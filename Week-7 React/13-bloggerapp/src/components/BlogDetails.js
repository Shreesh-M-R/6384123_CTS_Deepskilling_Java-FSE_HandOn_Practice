import React from 'react';

const BlogDetails = ({ items }) => {
  return (
    <div>
      <h3 className="section-title">Blogs List</h3>
      {items.length > 0 ? (
        items.map(blog => (
          <div 
            key={blog.id} 
            className="item-card"
          >
            <h4 className="item-title">{blog.title}</h4>
            <p className="item-text">{blog.content}</p>
          </div>
        ))
      ) : (
        <p className="empty-state">No blogs available.</p>
      )}
    </div>
  );
};

export default BlogDetails;