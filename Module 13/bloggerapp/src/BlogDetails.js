import React from 'react';

const BlogDetails = () => {
  const blogs = [
    { id: 201, title: 'React Server Components Explained', author: 'Sophie Alpert', date: '2026-02-15' },
    { id: 202, title: 'State Management with React Context', author: 'Kent C. Dodds', date: '2026-03-01' },
    { id: 203, title: 'Optimizing Virtual DOM Re-renders', author: 'Addy Osmani', date: '2026-03-10' }
  ];

  return (
    <div className="section-card blog-card">
      <h2>Blog Details</h2>
      <div className="card-list">
        {blogs.map((blog) => (
          <div key={blog.id} className="item-card">
            <h3>{blog.title}</h3>
            <p><strong>Author:</strong> {blog.author}</p>
            <p><strong>Published Date:</strong> {blog.date}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default BlogDetails;
