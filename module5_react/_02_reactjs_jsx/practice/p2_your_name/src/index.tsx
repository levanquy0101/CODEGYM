import React from "react";
import ReactDOM from "react-dom/client";

const name = "Quoc Gunner";

const root = ReactDOM.createRoot(
    document.getElementById('root') as HTMLElement
);

root.render(
    React.createElement("h1", { style: { textAlign: "center" } }, name)
);

