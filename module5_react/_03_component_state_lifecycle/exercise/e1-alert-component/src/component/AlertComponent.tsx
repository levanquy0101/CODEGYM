import React, {Component} from 'react';
import 'bootstrap/dist/css/bootstrap.css'

interface AlertComponentProps{
    text ?: string
}

class AlertComponent extends Component<AlertComponentProps> {
    render() {
        return (
            <div className="alert alert-success">
                {this.props.text}
            </div>
        );
    }
}

export default AlertComponent;
