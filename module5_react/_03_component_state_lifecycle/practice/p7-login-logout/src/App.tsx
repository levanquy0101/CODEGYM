import React, {Component} from 'react';
import Home from "./component/Home";

class App extends Component {
    constructor(props: any) {
        super(props);
        this.state = {
            isLoggedIn: false
        };
    }

    handleLogIn = () => {
        this.setState({isLoggedIn: true})
    }

    handleLogOut = () => {
        this.setState({isLoggedIn: false})
    }

    render() {
        // @ts-ignore
        const {isLoggedIn} = this.state

        if (isLoggedIn) {
            return (<Home onLogOut={this.handleLogOut}/>)
        }

        return (
            <div style={{textAlign: 'center'}}>
                <div>
                    <h1>Please Log in</h1>
                    <button onClick={this.handleLogIn}>Log in</button>
                </div>
            </div>
        )
    }
}

export default App
