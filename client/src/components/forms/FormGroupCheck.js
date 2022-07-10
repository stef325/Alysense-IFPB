import React from 'react';

export default class FormGroupCheck extends React.Component{

    render() {
        return (
            
            <div className="form-check">
                <label className="form-check-label mt-4" htmlFor={this.props.htmlFor}>{this.props.children}{this.props.label}</label>
                
            </div>
        );
    }

}