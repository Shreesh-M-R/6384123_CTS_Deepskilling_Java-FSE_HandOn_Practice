import React, { useState } from 'react';
import './App.css'; // Assuming you have some styles in App.css
import BookDetails from './components/BookDetails';
import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';

const App = () => {
  const [view, setView] = useState('book');
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [items, setItems] = useState([
    { id: 1, type: 'book', title: 'React Mastery', author: 'John Doe' },
    { id: 2, type: 'blog', title: 'React Tips', content: 'Best practices for React' },
    { id: 3, type: 'course', title: 'React 101', duration: '4 weeks' },
    { id: 4, type: 'book', title: 'JavaScript Basics', author: 'Jane Smith' },
    { id: 5, type: 'blog', title: 'React Hooks', content: 'Guide to React Hooks' },
  ]);

  const handleToggleLogin = () => {
    setIsLoggedIn(!isLoggedIn);
  };

  return (
    <div className="app-container">
      <div className="content-wrapper">
        <h1 className="main-title">Blogger App</h1>
        
        {/* Navigation */}
        <div className="nav-container">
          <button 
            className={`nav-button ${view === 'book' ? 'nav-button-active' : ''}`}
            onClick={() => setView('book')}
          >
            Books
          </button>
          <button 
            className={`nav-button ${view === 'blog' ? 'nav-button-active' : ''}`}
            onClick={() => setView('blog')}
          >
            Blogs
          </button>
          <button 
            className={`nav-button ${view === 'course' ? 'nav-button-active' : ''}`}
            onClick={() => setView('course')}
          >
            Courses
          </button>
          <button 
            className="login-button"
            onClick={handleToggleLogin}
          >
            {isLoggedIn ? 'Logout' : 'Login'}
          </button>
        </div>

        {/* Main Content */}
        <div className="content-card">
          {/* If-else conditional rendering */}
          {isLoggedIn ? (
            <div className="status-card logged-in">
              <h2 className="status-title">Welcome, User!</h2>
              <p className="status-text">You have access to all premium content.</p>
            </div>
          ) : (
            <div className="status-card guest">
              <h2 className="status-title">Guest Mode</h2>
              <p className="status-text">Please login to access all content.</p>
            </div>
          )}

          {/* Ternary operator for view selection */}
          <div className="section-header">
            {view === 'book' ? (
              <h3 className="section-title">Book Section</h3>
            ) : view === 'blog' ? (
              <h3 className="section-title">Blog Section</h3>
            ) : (
              <h3 className="section-title">Course Section</h3>
            )}
          </div>

          {/* Logical && operator for premium content */}
          {isLoggedIn && (
            <div className="premium-card">
              <h3 className="premium-title">Premium Content</h3>
              <p className="premium-text">Exclusive content for logged-in users!</p>
            </div>
          )}

          {/* Switch case equivalent using object mapping */}
          {
            {
              book: <BookDetails items={items.filter(item => item.type === 'book')} />,
              blog: <BlogDetails items={items.filter(item => item.type === 'blog')} />,
              course: <CourseDetails items={items.filter(item => item.type === 'course')} />
            }[view]
          }

          {/* List rendering with map() and keys */}
          <div className="all-items-section">
            <h3 className="section-title">All Items</h3>
            <div className="items-grid">
              {items.map(item => (
                <div 
                  key={item.id} 
                  className="item-card"
                >
                  {item.type === 'book' && (
                    <div>
                      <h4 className="item-title">{item.title}</h4>
                      <p className="item-text">Author: {item.author}</p>
                    </div>
                  )}
                  {item.type === 'blog' && (
                    <div>
                      <h4 className="item-title">{item.title}</h4>
                      <p className="item-text">{item.content}</p>
                    </div>
                  )}
                  {item.type === 'course' && (
                    <div>
                      <h4 className="item-title">{item.title}</h4>
                      <p className="item-text">Duration: {item.duration}</p>
                    </div>
                  )}
                </div>
              ))}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default App;