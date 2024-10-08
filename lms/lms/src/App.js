import React, { useEffect, useState } from 'react';
import logo from './logo.svg';
import './App.css';
import useBooksMap from './books';

function App() {
  const [transactions, setTransactions] = useState([]);
  const [books, setBooks] = useState([]);
  const bookIdToNameMap = useBooksMap();
  const [error, setError] = useState(null); // Add error state

  useEffect(() => {
    // Fetch transactions
    fetch("./transactions/all")
      .then(response => response.json())
      .then(data => setTransactions(data))
      .catch(err => {
        console.error('Error fetching transactions:', err);
        setError(err); // Set error state
      });

    // Fetch books
   
  }, []);

  return (
    <div className="App">
      <header className="App-header">
        {error ? (
          <p>Error fetching data: {error.message}</p>
        ) : transactions.length > 0 ? (
          <table>
            <thead>
              <tr>
                <th>Transaction ID</th>
                <th>User ID</th>
                <th>Book Name</th>
                <th>Quantity</th>
                <th>Transaction Type</th>
                <th>Transaction Date</th>
                <th>Status</th>
              </tr>
            </thead>
            <tbody>
              {transactions.map((transaction, index) => (
                <tr key={index}>
                  <td>{transaction.transId}</td>
                  <td>{transaction.userId}</td>
                  <td>{bookIdToNameMap[transaction.bookId] || 'Unknown'}</td>
                  <td>{transaction.quantity}</td>
                  <td>{transaction.transType}</td>
                  <td>{new Date(transaction.transDate).toLocaleString()}</td>
                  <td>{transaction.status}</td>
                </tr>
              ))}
            </tbody>
          </table>
        ) : (
          <p>Loading...</p>
        )}
      </header>
    </div>
  );
}

export default App;
