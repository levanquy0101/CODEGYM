import { Component } from 'react';

interface AddComponentProps {
    firstNumber: number,
    secondNumber: number,
}

class AddComponent extends Component<AddComponentProps> {
    render() {
        return <h1>Total: {this.props.firstNumber + this.props.secondNumber}</h1>
    }
}
export default AddComponent;
