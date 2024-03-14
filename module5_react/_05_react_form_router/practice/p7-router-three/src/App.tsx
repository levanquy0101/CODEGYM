import React from 'react';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Category from "./component/Category";
import Product from "./component/Product";

function App() {
  return (
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Category />} />
          <Route path="/product" element={<Product />} />
        </Routes>
      </BrowserRouter>
  );
}

export default App;
