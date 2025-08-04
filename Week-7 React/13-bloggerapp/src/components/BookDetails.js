import React from 'react';

const BookDetails = ({ items }) => {
  return (
    <div>
      <h3 className="section-title">Books List</h3>
      {items.length > 0 ? (
        items.map(book => (
          <div 
            key={book.id} 
            className="item-card"
          >
            <h4 className="item-title">{book.title}</h4>
            <p className="item-text">Author: {book.author}</p>
          </div>
        ))
      ) : (
        <p className="empty-state">No books available.</p>
      )}
    </div>
  );
};

export default BookDetails;