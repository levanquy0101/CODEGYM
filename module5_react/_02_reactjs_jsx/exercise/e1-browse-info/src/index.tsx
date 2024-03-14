import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
    <div>
        <h4>Browser's details: {navigator.userAgent}</h4>
    </div>
);

