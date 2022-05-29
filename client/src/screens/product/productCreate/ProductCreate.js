import React from 'react';

import BigForm from '../../../components/forms/BigForm'
import FormGroup from '../../../components/forms/FormGroup'
import CardTable from '../../../components/tables/CardTable'

import "../../../styles/createForms.css"
export default class ProductCreate extends React.Component {

  state = {
    name: '',
    owner: '',
    date: '',
    charact: [],
    slices: []
  }

  submit = () => {
  }

  remove = () => {

  }

  render() {
    return (
      <div>
        <div className="main-container">
          <BigForm title="ADICIONAR NOVO PRODUTO" submit={this.submit} action="Adicionar">
            <div className="name">
              <FormGroup htmlFor="name" label="Nome" className="name">
                <input className='form-control' type="text" placeholder='Nome' id='name' onChange={(e) => { this.setState({ name: e.target.value }) }} />
              </FormGroup>
            </div>

            <div className="half-container">
              <div className="owner">
                <FormGroup htmlFor="owner" label="Fornecedor">
                  <input className='form-control' type="text" placeholder='Fornecedor' id='owner' onChange={(e) => { this.setState({ owner: e.target.value }) }} />
                </FormGroup>
              </div>

              <div className="expiration-date">
                <FormGroup htmlFor="date" label="Data de validade">
                  <input className='form-control' type="date" placeholder='Data' id='date' onChange={(e) => { this.setState({ date: e.target.value }) }} />
                </FormGroup>

              </div>
            </div>


            <FormGroup htmlFor="ingredients" label="Ingredientes">
              <textarea className="form-control txt-ingred" id="ingredients" rows="3"></textarea>
            </FormGroup>

            <div className="half-container">
              <div className='characterist'>
                <CardTable action="Adicionar" collection={this.state.charact} remove={this.remove} label="Características"></CardTable>
              </div>

              <div className="slices">
                <CardTable action="Adicionar" collection={this.state.slices} remove={this.remove} label="Amostras"></CardTable>

              </div>

            </div>

          </BigForm>
        </div>

      </div>
    )
  }
}
