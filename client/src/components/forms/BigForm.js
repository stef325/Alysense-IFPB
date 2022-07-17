import React from 'react';

import "../forms/FormsStyle.css"
export default class BigForm extends React.Component{

    render() {
        return (
            
            <div className="big-form">
                <h1 className="title">{this.props.title}</h1>
                <form>
                    {this.props.children}

                    <div className="action-button">
                        <button onClick={this.props.submit} type="button" className="btn btn-primary">{this.props.action}</button>
                    </div>
                    
                </form>
            </div>
        );
    }

}