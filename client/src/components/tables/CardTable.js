import React from 'react';

import DinamicTable from './DinamicTable';
export default class CardTable extends React.Component{

    render() {
        return (
            
            <div className="card-table">
                <label className="form-label mt-4" htmlFor={this.props.htmlFor}>{this.props.label}</label>
                <button className='' >{this.props.action}</button>
                <DinamicTable collection={this.props.collection} remove={this.props.remove(item.name)}></DinamicTable>
            </div>
        );
    }

}