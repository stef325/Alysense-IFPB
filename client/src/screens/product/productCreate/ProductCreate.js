import React from 'react';
import{showSucessMessage, showErrorMessage, showWarningMessage} from '../../../components/Toastr/Toastr'
import ProductApiService from '../../../services/ProductApiService';
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
    userId:0,
    charact: [],
    slices: []
  }

  constructor(){
    super();
    this.service = new ProductApiService();
  }

  validate = () =>{
    const errors = [];

    if(!this.state.name){
        errors.push('Campo Nome é obrigatório!')
    }
    if(!this.state.owner){
        errors.push('informe o fornecedor!')
    }
    if(!this.state.date){
        errors.push('Campo de validade obrigatório!')
    }
    
    return errors;
};

getLoggedUser=()=>{
  var value = localStorage.getItem('loggedUser');
  var user = JSON.parse(value);
  return user;
}


  submit = async () => {
    this.state.userId = this.getLoggedUser().id
    const errors = this.validate();
    if(errors.length>0){
        errors.forEach((message,index)=>{
            showErrorMessage(message)
        });
        return false;
    }
    await this.service.create({
      name: this.state.name,
      expirationDate: this.state.date,
      owner: this.state.owner,
      ingredients: this.state.ingredients,
      characteristics: this.state.charact,
      samples: this.state.slices,
      userId: this.state.userId

    }).then(response => {
      console.log(response)
      showSucessMessage("Produto Criado!");
      this.props.history.push(`/ProductView/`);
    }).catch(error => {
      console.log(error.response)
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
