import React, {useState} from 'react';

function Counter(props: any) {
    let [count, setCount] = useState(0);

    const handleClick = () => {
        setCount(++count);
    };

    return (
        <div>
            Value {count}
            <div>
                <button onClick={handleClick}>Increment</button>
            </div>
        </div>
    );
}

export default Counter;
