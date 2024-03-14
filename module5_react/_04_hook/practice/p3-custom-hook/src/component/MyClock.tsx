import React from 'react';
import useClock from "../hooks/useClock";

function MyClock(props:any) {
    const [time, ampm] = useClock();
    return (
        <div id="Clock-style">
            {time}
            <span> {ampm}</span>
        </div>
    );
}

export default MyClock;
