import React, {useState} from 'react';

function CalculatorComponent(props: any) {
    const [numberOne, setNumberOne] = useState(0);
    const [numberTwo, setNumberTwo] = useState(0);
    const [result, setResult] = useState(0);

    return (
        <div className="calculator">
            <div>
                <input onChange={e => setNumberOne(+e.target.value)} placeholder="0"/>
            </div>
            <div>
                <input onChange={e => setNumberTwo(+e.target.value)} placeholder="0"/>
            </div>
            <div className="result">
                Result: {result.toFixed(2)}
            </div>
            <div>
                <button onClick={e => setResult(numberOne + numberTwo)}>+</button>
                <button onClick={e => setResult(numberOne - numberTwo)}>-</button>
                <button onClick={e => setResult(numberOne * numberTwo)}>x</button>
                <button onClick={e => setResult(numberOne / numberTwo)}>/</button>
            </div>
        </div>
    );
}

export default CalculatorComponent;
