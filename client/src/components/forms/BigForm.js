import React from 'react';

export default class BigForm extends React.Component{

    render() {
        return (
            
            <div className="big-form">
                <h1 className="title">{this.props.title}</h1>
                <form>
                    {this.props.children}
                    <button onClick={this.props.submit()}>{this.props.action}</button>
                </form>
            </div>
        );
    }

}