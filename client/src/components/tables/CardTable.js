import React from 'react';

import DinamicTable from './DinamicTable';

import '../tables/tables.css'
export default class CardTable extends React.Component {

    render() {
        return (

            <div className="card-table">
                <div className="half-head">
                    <label className="form-label mt-4" htmlFor={this.props.htmlFor}>{this.props.label}</label>
                    <button  onClick={this.props.find} type="button" className="btn btn-primary">{this.props.action}</button>
                </div>

                <div className="card border-primary mb-3" >
                    <div className="card-body">
                        <DinamicTable collection={this.props.collection} remove={this.props.remove}></DinamicTable>
                    </div>
                </div>

            </div>
        );
    }

}