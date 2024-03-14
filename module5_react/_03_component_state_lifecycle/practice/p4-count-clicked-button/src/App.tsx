import {Component} from "react";

interface AppComponentProps {
    a?: string
}

interface AppComponentState {
    number: number
}

class App extends Component<AppComponentProps, AppComponentState> {
    constructor(props: AppComponentProps) {
        super(props);
        this.state = {
            number: 0
        };
    }

    increase = () => {
        this.setState({number: this.state.number + 1});
    };
    decrease = () => {
        this.setState({number: this.state.number - 1});
    };

    render() {
        return (
            <div style={{textAlign: "center", padding: 30}}>
                <button onClick={this.decrease}>Decrease</button>
                <span style={{padding: 10}}>{this.state.number}</span>
                <button onClick={this.increase}>Increase</button>
            </div>
        );
    }
}

export default App;
