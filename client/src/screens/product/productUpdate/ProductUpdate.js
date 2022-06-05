import React from 'react';

import axios from 'axios'
import BigForm from '../../../components/forms/BigForm'
import FormGroup from '../../../components/forms/FormGroup'
import CardCharact from '../../../components/tables/charact/CardCharact'
import CardSample from '../../../components/tables/samples/CardSample'

import "../../../styles/createForms.css"
export default class ProductCreate extends React.Component {

  state = {
    name: '',
    owner: '',
    date: '',
    ingredients: '',
    charact: [],
    slices: []
  }


  submit = async () => {
    await axios.post('http://localhost:8080/api/product', {
      name: this.state.name,
      expirationDate: this.state.date,
      owner: this.state.owner,
      ingredients: this.state.ingredients,
      characteristics: this.state.charact,
      samples: this.state.slices

    }).then(response => {
      console.log(response)
      alert("Produto adicionado!")
    }).catch(error => {
      console.log(error.response)
      alert("Erro!")
    });

    console.log("request finished");


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
                <CardCharact action="Adicionar" collection={this.state.charact} remove={this.remove} label="Características"></CardCharact>
              </div>

              <div className="slices">
                <CardSample action="Adicionar" collection={this.state.slices} remove={this.remove} label="Amostras"></CardSample>

              </div>

            </div>

          </BigForm>
        </div>

      </div>
    )
  }
}
