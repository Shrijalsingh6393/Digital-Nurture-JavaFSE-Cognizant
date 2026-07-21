import React from 'react';

const BookDetails = () => {
  const books = [
    { id: 101, title: 'Mastering React 18', author: 'Dan Abramov', price: 'Rs. 799' },
    { id: 102, title: 'Learning JavaScript ES6', author: 'Kyle Simpson', price: 'Rs. 599' },
    { id: 103, title: 'Clean Code in Java', author: 'Robert C. Martin', price: 'Rs. 899' }
  ];

  return (
    <div className="section-card book-card">
      <h2>Book Details</h2>
      <div className="card-list">
        {books.map((book) => (
          <div key={book.id} className="item-card">
            <h3>{book.title}</h3>
            <p><strong>Author:</strong> {book.author}</p>
            <p><strong>Price:</strong> {book.price}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default BookDetails;
