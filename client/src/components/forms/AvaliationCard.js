import React from 'react';

import FormGroupCheck from './FormGroupCheck'

export default class AvaliationCard extends React.Component {
    state = {
        note:0
    }

    render() {
        return (

            <div className={this.props.active==true? "card-avaliation active-card":"card-avaliation"}>

                <div class="card border-primary mb-3 card-avaliation-card">
                    <div class="card-header card-avaliation-header">Indique o quanto você gostou do aspecto: {this.props.aspect}</div>

                    <div class="card-body radio-options card-avaliation-body">
                        <FormGroupCheck htmlFor="0" label="0">
                            <input type="radio" value="0" name="avaliation" id='0' className='form-check-input' />
                        </FormGroupCheck>
                        <FormGroupCheck htmlFor="1" label="1">
                            <input type="radio" value="1" name="avaliation" id='1' className='form-check-input' />
                        </FormGroupCheck>
                        <FormGroupCheck htmlFor="2" label="2">
                            <input type="radio" value="2" name="avaliation" id='2' className='form-check-input' />
                        </FormGroupCheck>
                        <FormGroupCheck htmlFor="3" label="3">
                            <input type="radio" value="3" name="avaliation" id='3' className='form-check-input' />
                        </FormGroupCheck>
                        <FormGroupCheck htmlFor="4" label="4">
                            <input type="radio" value="4" name="avaliation" id='4' className='form-check-input' />
                        </FormGroupCheck>
                        <FormGroupCheck htmlFor="5" label="5">
                            <input type="radio" value="5" name="avaliation" id='5' className='form-check-input' />
                        </FormGroupCheck>
                        <FormGroupCheck htmlFor="6" label="6">
                            <input type="radio" value="6" name="avaliation" id='6' className='form-check-input' />
                        </FormGroupCheck>
                        <FormGroupCheck htmlFor="7" label="7">
                            <input type="radio" value="7" name="avaliation" id='7' className='form-check-input' />
                        </FormGroupCheck>
                        <FormGroupCheck htmlFor="8" label="8">
                            <input type="radio" value="8" name="avaliation" id='8' className='form-check-input' />
                        </FormGroupCheck>
                        <FormGroupCheck htmlFor="9" label="9">
                            <input type="radio" value="9" name="avaliation" id='9' className='form-check-input' />
                        </FormGroupCheck>
                        <FormGroupCheck htmlFor="10" label="10">
                            <input type="radio" value="10" name="avaliation" id='10' className='form-check-input' />
                        </FormGroupCheck>
                    </div>
                    


                </div>
            </div>
        );
    }

}