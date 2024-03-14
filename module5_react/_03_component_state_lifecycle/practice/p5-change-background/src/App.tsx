import React, {Component} from 'react';

interface AppComponentProps {

}

interface AppComponentState {
    color: string
}

class App extends Component<AppComponentProps, AppComponentState> {
    constructor(props: AppComponentProps) {
        super(props);
        this.state = {
            color: 'black'
        };
    }

    componentDidMount() {
        setTimeout(() => {
            this.setState({color: 'pink'});
        }, 5000);
    }

    render() {
        return (
            <div
                style={{
                    backgroundColor: this.state.color,
                    height: '100vh'
                }}
            >
            </div>
        );
    }
}

export default App;
