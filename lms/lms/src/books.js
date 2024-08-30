import React, { useEffect, useState } from 'react';

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
