import React, { useEffect, useState } from 'react';
import ReactDOM from 'react-dom/client';
import reportWebVitals from './reportWebVitals';

function useBooksMap() {
  const [bookIdToNameMap, setBookIdToNameMap] = useState({});

  useEffect(() => {
    // API call to fetch books
    fetch("./books/all")
      .then(response => response.json())
      .then(data => {
        // Create a map of bookId to bookName
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
  
  useEffect(() => {
    fetch("./books/all")
      .then(response => response.json())
      .then(data => setBooks(data))
      .catch(err => {
        console.error('Error fetching books:', err);
      });
  }, []);
  
  return (
    <>
      <table>
        <thead>
          <tr>
            <th>S.no</th>
            <th>Book Name</th>
            <th>Book Description</th>
            <th>Quantity</th>
          </tr>
        </thead>
        <tbody>
          {books.length > 0 ? (
            books.map((book) => (
              <tr key={book.bookId}>
                <td>{book.bookId}</td>
                <td>{book.bookName}</td>
                <td>{book.bookDesc}</td>
                <td>{book.quantity === 0 ? 'Out of Stock' : book.quantity}</td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="4">...Loading</td>
            </tr>
          )}
        </tbody>
      </table>
    </>
  );
}

const div3 = ReactDOM.createRoot(document.getElementById('divId3'));
div3.render(<AllBooks />);

reportWebVitals();
