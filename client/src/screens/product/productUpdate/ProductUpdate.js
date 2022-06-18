import React from 'react';

import axios from 'axios'
import BigForm from '../../../components/forms/BigForm'
import FormGroup from '../../../components/forms/FormGroup'
import CardCharact from '../../../components/tables/charact/CardCharact'
import CardSample from '../../../components/tables/samples/CardSample'
import{showSucessMessage, showErrorMessage, showWarningMessage} from '../../../components/Toastr/Toastr'
import "../../../styles/createForms.css"
import "./ProductUpdade.css"
export default class ProductUpdate extends React.Component {

  state = {
    id: 0,
    name: '',
    owner: '',
    expirationDate: '',
    ingredients: '',
    characteristics: [],
    samples: []
  }

  validate = () =>{
    const errors = [];

    if(!this.state.name){
        errors.push('Campo Nome é obrigatório!')
    }
    if(!this.state.owner){
        errors.push('informe o fornecedor!')
    }
    if(!this.state.expirationDate){
        errors.push('Campo de validade obrigatório!')
    }
    
    return errors;
};

  componentDidMount() {
    const params = this.props.match.params;
    const id = params.id;
    this.findById(id);

  }
  convertFromStringToDate = (args) => {
    var veri = args[1]
    var veri2 = args[2]
    if (veri < 10) {
      veri = "-0" + args[1];
    }
    else {
      veri = "-" + args[1];
    }
    if (veri2 < 10) {
      veri2 = "-0" + args[2];
    }
    else {
      veri2 = "-" + args[2];
    }
    const result = args[0] + veri+ veri2;
    return result;
  };

  cancel = () => {
    this.props.history.push(`/ProductView/`);
    window.location.reload();
  }
  findById = async (productID) => {
    await axios.get(`http://localhost:8080/api/product/${productID}`)
      .then(response => {
        const product = response.data;
        const id = product.id;
        const name = product.name;
        const owner = product.owner;
        const expirationDate = this.convertFromStringToDate(product.expirationDate);
        const ingredients = product.ingredients;
        //const characteristics = product.characteristics;
        //const samples = product.samples;
        this.setState({ id, name, owner, expirationDate, ingredients});
        console.log(product);

      }).catch(error => {
        console.log(error.response)
      })
  }

  submit = async () => {
    const errors = this.validate();
    if(errors.length>0){
        errors.forEach((message,index)=>{
            showErrorMessage(message)
        });
        return false;
    }
    await axios.put(`http://localhost:8080/api/product/${this.state.id}`, {
      name: this.state.name,
      expirationDate: this.state.expirationDate,
      owner: this.state.owner,
      ingredients: this.state.ingredients,
      //characteristics: this.state.charact,
      //samples: this.state.samples

    }).then(response => {
      console.log(response)
      showSucessMessage("Produto editado!");
    }).catch(error => {
      console.log(error.response)
    });

    console.log("request finished");


  }

  remove = () => {

  }

  render() {
    return (
      <div className='product-update'>
        <div className="main-container">
          <div className='button-test'>
            <button type="button" class="btn btn-primary" onClick={this.cancel}>Voltar</button>
          </div>
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
