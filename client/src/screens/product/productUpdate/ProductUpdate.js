import React from 'react';

import axios from 'axios'
import BigForm from '../../../components/forms/BigForm'
import FormGroup from '../../../components/forms/FormGroup'
import CardCharact from '../../../components/tables/charact/CardCharact'
import CardSample from '../../../components/tables/samples/CardSample'

import "../../../styles/createForms.css"
import "./ProductUpdade.css"
export default class ProductUpdate extends React.Component {

  state = {
    id:0,
    name: '',
    owner: '',
    expirationDate: '',
    ingredients: '',
    characteristics: [],
    samples: []
  }

  componentDidMount(){
    const params = this.props.match.params;
    const id = params.id;
    this.findById(id);
}

  findById = async (productID) => {
    await axios.get(`http://localhost:8080/api/product/${productID}`)
    .then(response=>{
        const product = response.data;
        const id = product.id;
        const name = product.name;
        const owner = product.owner;
        const expirationDate = product.expirationDate;
        const ingredients = product.ingredients;
        const characteristics = product.characteristics;
        const samples = product.samples;
        this.setState({id , name,owner, expirationDate, ingredients,characteristics,samples});
        console.log(product);

    }).catch(error=>{
        console.log(error.response)
    })
  }

  submit = async () => {
    await axios.put(`http://localhost:8080/api/product/${this.state.id}`, {
      name: this.state.name,
      expirationDate: this.state.date,
      owner: this.state.owner,
      ingredients: this.state.ingredients,
      characteristics: this.state.charact,
      samples: this.state.samples

    }).then(response => {
      console.log(response)
      alert("Produto editado!")
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
      <div className='product-update'>
        <div className="main-container">
          <BigForm title="ATUALIZAR PRODUTO" submit={this.submit} action="Alterar">
            <div className="name">
              <FormGroup htmlFor="name" label="Nome" className="name">
                <input value={this.state.name} className='form-control' type="text" placeholder='Nome' id='name' onChange={(e) => { this.setState({ name: e.target.value }) }} />
              </FormGroup>
            </div>

            <div className="half-container">
              <div className="owner">
                <FormGroup htmlFor="owner" label="Fornecedor">
                  <input value={this.state.owner} className='form-control' type="text" placeholder='Fornecedor' id='owner' onChange={(e) => { this.setState({ owner: e.target.value }) }} />
                </FormGroup>
              </div>

              <div className="expiration-date">
                <FormGroup htmlFor="date" label="Data de validade">
                  <input value={this.state.expirationDate} className='form-control' type="date" placeholder='Data' id='date' onChange={(e) => { this.setState({ date: e.target.value }) }} />
                </FormGroup>

              </div>
            </div>


            <FormGroup htmlFor="ingredients" label="Ingredientes">
              <textarea value={this.state.ingredients} className="form-control txt-ingred" id="ingredients" rows="3"></textarea>
            </FormGroup>

            <div className="half-container">
              <div className='characterist'>
                <CardCharact action="Adicionar" collection={this.state.characteristics} remove={this.remove} label="Características"></CardCharact>
              </div>

              <div className="slices">
                <CardSample action="Adicionar" collection={this.state.samples} remove={this.remove} label="Amostras"></CardSample>

              </div>

            </div>

          </BigForm>
        </div>

      </div>
    )
  }
}
