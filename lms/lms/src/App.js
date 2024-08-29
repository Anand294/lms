import React, { useEffect, useState } from 'react';
import logo from './logo.svg';
import './App.css';


function App() {
	 const [transactions, setTransactions] = useState(null);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetch("/lms/transactions/all")
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json(); // The response is already JSON, so we parse it directly
      })
      .then(data => setTransactions(data)) // Set the transactions state with the JSON data
      .catch(error => setError(error)); // Handle any errors
  }, []);
  return (
    <div className="App">
      <header className="App-header">
         {error ? (
          <p>Error fetching transactions: {error.message}</p>
        ) : (
          <pre>{transactions ? JSON.stringify(transactions, null, 2) : 'Loading...'}</pre>
        )}
      </header>
    </div>
  );
}

export default App;
