import React, { useEffect, useState } from 'react';
import ReactDOM from 'react-dom/client';
import reportWebVitals from './reportWebVitals';

function useBooksMap() {
  const [bookIdToNameMap, setBookIdToNameMap] = useState({});

  useEffect(() => {
    fetch("./books/all")
      .then(response => response.json())
      .then(data => {
        const idToNameMap = {};
        data.forEach(book => {
          idToNameMap[book.bookId] = book.bookName;
        });
        setBookIdToNameMap(idToNameMap);
      })
      .catch(err => {
        console.error('Error fetching books:', err);
      });
  }, []);

  return bookIdToNameMap;
}

export default useBooksMap;

function AllBooks() {
  const [books, setBooks] = useState([]);
  const [jsonMsg, setJsonMsg] = useState(null);
  const [lentBooks, setLentBooks] = useState(new Set()); // Track lent books
  const bookIdToNameMap = useBooksMap();

  useEffect(() => {
    fetch("./books/all")
      .then(response => response.json())
      .then(data => setBooks(data))
      .catch(err => console.error('Error fetching books:', err));
  }, []);

  const lendBook = async (bookId, userId, quantity, transType) => {
    try {
      const response = await fetch("./transactions", {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({ bookId, userId, quantity, transType })
      });

      if (!response.ok) {
        throw new Error('Network response was not ok');
      }

      // Update the local state
      const updatedBooks = books.map(book => {
        if (book.bookId === bookId) {
          return {
            ...book,
            quantity: book.quantity - 1 // Decrease quantity by 1
          };
        }
        return book;
      });

      setBooks(updatedBooks);

      // Mark this book as lent
      setLentBooks(prevLentBooks => new Set(prevLentBooks.add(bookId)));

      setJsonMsg(`Book lent successfully: ${bookIdToNameMap[bookId]}`);

    } catch (error) {
      console.error('Error lending book:', error);
      setJsonMsg({ error: error.message });
    }
  };

  return (
    <>
      <table>
        <thead>
          <tr>
            <th>S.no</th>
            <th>Book Name</th>
            <th>Book Description</th>
            <th>Quantity</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {books.length > 0 ? (
            books.map((book) => (
              <tr key={book.bookId}>
                <td>{book.bookId}</td>
                <td>{book.bookName}</td>
                <td>{book.bookDesc}</td>
                <td>
                  {book.quantity === 0 ? 'Out of Stock' : book.quantity}
                </td>
                <td>
                  {book.quantity > 0 && !lentBooks.has(book.bookId) ? (
                    <button onClick={() => lendBook(book.bookId, 1, 1, 'lend')}>
                      Lend
                    </button>
                  ) : lentBooks.has(book.bookId) ? (
                    <span>Book lent</span>
                  ) : null}
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="5">...Loading</td>
            </tr>
          )}
        </tbody>
      </table>
      {jsonMsg && <div>{jsonMsg}</div>}
    </>
  );
}

const div3 = ReactDOM.createRoot(document.getElementById('divId3'));
div3.render(<AllBooks />);

reportWebVitals();
