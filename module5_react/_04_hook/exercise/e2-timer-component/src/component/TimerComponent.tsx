import React, {useEffect, useState} from 'react';

function TimerComponent(props:any) {
    const [timer, setTimer] = useState(10)

    useEffect(() => {
        if(timer === 0){
            alert("time's up!")
            return
        }

        const t = setInterval(e=> setTimer(timer-1),1000)

        return () => clearInterval(t)
    }, [timer]);

    return (
        <div>Count down from {timer}</div>
    )
}

export default TimerComponent;
