import React, {Component, createRef, RefObject} from 'react';
import AlertComponent from './component/AlertComponent';

interface AppComponentProps {

}

interface AppComponentState {
    ms?: string
}

class App extends Component<AppComponentProps, AppComponentState> {
    inputRef: RefObject<HTMLInputElement> = createRef();


    constructor(props: AppComponentProps) {
        super(props);
        this.state = {
            ms: ''
        }
    }

    alertFcn = () => {
        const inputValue = this.inputRef.current?.value;
        this.setState(
            {
                ms: inputValue
            }
        );
    }

    render() {
        return (
            <div>
                <input type="text" ref={this.inputRef} />
                <button onClick={this.alertFcn}>Alert</button>
                {
                    this.state.ms ?  <AlertComponent text={this.state.ms}></AlertComponent>: null
                }
            </div>
        );
    }
}

export default App;


