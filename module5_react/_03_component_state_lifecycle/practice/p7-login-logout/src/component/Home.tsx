import React, { Component } from 'react';

interface HomeComponentProps{
    onLogOut: any
}

class Home extends Component<HomeComponentProps>{
    render () {
        return (
            <div style={{textAlign: 'center'}}>
                <div>
                    <h1>Welcome</h1>
                    <button onClick={this.props.onLogOut}>Log out</button>
                </div>
            </div>
        )
    }
}

export default Home
