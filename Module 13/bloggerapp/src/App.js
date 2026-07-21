import React, { useState } from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';
import './App.css';

function App() {
  const [selectedCategory, setSelectedCategory] = useState('all');

  // Conditional Rendering Method 1: Switch Statement with Element Variable
  let renderViewContent;
  switch (selectedCategory) {
    case 'books':
      renderViewContent = <BookDetails />;
      break;
    case 'blogs':
      renderViewContent = <BlogDetails />;
      break;
    case 'courses':
      renderViewContent = <CourseDetails />;
      break;
    case 'all':
    default:
      renderViewContent = (
        <div className="all-views">
          {/* Conditional Rendering Method 2: Logical && Operator */}
          {selectedCategory === 'all' && <BookDetails />}
          {selectedCategory === 'all' && <BlogDetails />}
          
          {/* Conditional Rendering Method 3: Ternary Operator */}
          {selectedCategory === 'all' ? <CourseDetails /> : null}
        </div>
      );
      break;
  }

  return (
    <div className="App">
      <header className="App-header">
        <h1>Blogger Application Portal</h1>
        <p className="subtitle">Demonstrating Multiple Conditional Rendering Methods & List Keys</p>
        <div className="tab-navigation">
          <button
            className={`tab-btn ${selectedCategory === 'all' ? 'active' : ''}`}
            onClick={() => setSelectedCategory('all')}
          >
            Show All
          </button>
          <button
            className={`tab-btn ${selectedCategory === 'books' ? 'active' : ''}`}
            onClick={() => setSelectedCategory('books')}
          >
            Books Only
          </button>
          <button
            className={`tab-btn ${selectedCategory === 'blogs' ? 'active' : ''}`}
            onClick={() => setSelectedCategory('blogs')}
          >
            Blogs Only
          </button>
          <button
            className={`tab-btn ${selectedCategory === 'courses' ? 'active' : ''}`}
            onClick={() => setSelectedCategory('courses')}
          >
            Courses Only
          </button>
        </div>
      </header>

      <main className="App-main">
        {renderViewContent}
      </main>
    </div>
  );
}

export default App;
