import React, { Component } from 'react';
import Hello from "./component/Hello";

class App extends Component {
  constructor(props: any) {
    super(props);
    this.state = {
      display: true
    };
  }

  delete = () => {
    this.setState({ display: false });
  };

  render() {
    let comp;
    // @ts-ignore
    if (this.state.display) {
      comp = <Hello />
    }
    return (
        <div style={{ textAlign: 'center' }}>
          {comp}
          <button onClick={this.delete}>
            Delete the component
          </button>
        </div>
    );
  }
}

export default App;
