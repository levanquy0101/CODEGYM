import React, {useState} from 'react';

function App() {
    const [selectedCar, setSelectedCar] = useState({car: "Honda", color: "White"});

    const fncSelected = (e: any, t: number) => {
        t === 1 ?
            setSelectedCar({car: selectedCar.car, color: e.target.value})
            : setSelectedCar({car: e.target.value, color: selectedCar.color});
    }

    return (
        <div>
            <h1>Select your car</h1>
            <div>
                Select a car
                <select onChange={e => fncSelected(e, 0)}>
                    <option value="Honda">Honda</option>
                    <option value="Toyota">Toyota</option>
                    <option value="BMW">BMW</option>
                </select>
            </div>
            <div>
                Select a color
                <select onChange={e => fncSelected(e, 1)}>
                    <option value="White">White</option>
                    <option value="Black">Black</option>
                    <option value="Blue">Blue</option>
                </select>
            </div>
            <h2>Your selected: {selectedCar.car} and {selectedCar.color}</h2>
        </div>
    );
}

export default App;
