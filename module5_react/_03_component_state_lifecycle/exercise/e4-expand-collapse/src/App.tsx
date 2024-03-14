import React, {Component} from 'react';

interface AppComponentState {
    isExpand: boolean,
    buttonText: string
}

class App extends Component<any, AppComponentState> {

    constructor(props: any) {
        super(props);
        this.state = {
            isExpand: false,
            buttonText: "Expand Introduction"
        }
    }

    handle = () => {
        this.setState(
            {
                isExpand: !this.state.isExpand,
                buttonText: (this.state.isExpand ? "Expand" : "Collapse ") + "Introduction"
            }
        )
    }

    render() {
        return (
            <div>
                <div className="title"><h1>Conditional Rendering</h1></div>
                <button onClick={this.handle}>{this.state.buttonText}</button>
                <div style={{
                    "display": this.state.isExpand ? "block" : "none"
                }}>
                    <div className="intro">Introduction</div>
                    <div>
                        What does calling useState do? It declares a “state variable”. Our variable is called count but
                        we could call it anything else, like banana. This is a way to “preserve” some values between the
                        function calls — useState is a new way to use the exact same capabilities that this.state
                        provides in a class. Normally, variables “disappear” when the function exits but state variables
                        are preserved by React.

                        What do we pass to useState as an argument? The only argument to the useState() Hook is the
                        initial state. Unlike with classes, the state doesn’t have to be an object. We can keep a number
                        or a string if that’s all we need. In our example, we just want a number for how many times the
                        user clicked, so pass 0 as initial state for our variable. (If we wanted to store two different
                        values in state, we would call useState() twice.)
                    </div>
                </div>
            </div>
        );
    }
}

export default App;
