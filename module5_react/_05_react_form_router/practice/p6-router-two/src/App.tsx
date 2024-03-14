import React from 'react';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Category from "./component/Category";
import Product from "./component/Product";

function App() {
  return (
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Category />} />
          <Route path="/product/:categoryId" element={<Product />} />
        </Routes>
      </BrowserRouter>
  );
}

export default App;
