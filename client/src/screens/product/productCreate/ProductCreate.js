import React from 'react';
import { showSucessMessage, showErrorMessage, showWarningMessage } from '../../../components/toastr/Toastr'
import ProductApiService from '../../../services/ProductApiService';
import BigForm from '../../../components/forms/BigForm'
import FormGroup from '../../../components/forms/FormGroup'
import CardCharact from '../../../components/tables/charact/CardCharact'
import CardSample from '../../../components/tables/samples/CardSample';
import Modal from 'react-modal';

import "./ProductCreateStyle.css"
export default class ProductCreate extends React.Component {

  state = {
    name: '',
    owner: '',
    date: '',
    ingredients: '',
    userId: '',
    charact: [],
    samples: [],
    isVisibleCharact: false,
    isVisibleSample: false,

    newCharact: {

    },
    newSample: {
    },
    showSamples: []
  }

  componentDidMount() {
    Modal.setAppElement('#root');
    this.setState({ isVisibleCharact: false })
    this.setState({ isVisibleSample: false })
  }

  constructor() {
    super();
    this.service = new ProductApiService();
  }

  validate = () => {
    const errors = [];

    if (!this.state.name) {
      errors.push('Campo Nome é obrigatório!')
    }
    if (!this.state.owner) {
      errors.push('informe o fornecedor!')
    }
    if (!this.state.date) {
      errors.push('Campo de validade obrigatório!')
    } else {
      let currentdate = new Date();
      let dia = currentdate.getDate().toString(),
        diaF = (dia.length == 1) ? '0' + dia : dia,
        mes = (currentdate.getMonth() + 1).toString(),
        mesF = (mes.length == 1) ? '0' + mes : mes,
        anoF = currentdate.getFullYear(),
        atual = anoF + "-" + mesF + "-" + diaF
      
      if (this.state.date < atual) {
        errors.push('Produto fora do prazo de validade!')
      }
    }


    return errors;
  };

  getLoggedUser = () => {
    var value = localStorage.getItem('loggedUser');
    var user = JSON.parse(value);
    return user;
  }

  eraseSample = (SampleName) => {

    this.setState({ showSamples: this.state.showSamples.filter((item) => item.id !== SampleName) })

  }
  eraseCharact = (Charactatribute) => {

    this.setState({ charact: this.state.charact.filter((item) => item.atribute !== Charactatribute) })

  }

  submit = async () => {
    this.state.userId = this.getLoggedUser().id
    const errors = this.validate();
    if (errors.length > 0) {
      errors.forEach((message, index) => {
        showErrorMessage(message)
      });
      return false;
    }
    this.state.showSamples.forEach(sample => {
      this.state.samples.push({ detailsSample: sample.detailsSample })
    })


    console.log(this.state.samples)
    console.log(this.state.userId)
    await this.service.create({
      name: this.state.name,
      expirationDate: this.state.date,
      owner: this.state.owner,
      ingredients: this.state.ingredients,
      characteristics: this.state.charact,
      samples: this.state.samples,
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

  removeCharact = () => {

  }
  removeSample = () => {

  }

  openModalCharact = () => {
    document.body.style.overflowY = "hidden";
    //this.find();
    this.setState({ isVisibleCharact: true })

  }
  closeModalCharact = () => {
    document.body.style.overflowY = "scroll";
    this.setState({ isVisibleCharact: false })

  }

  addCharact = () => {
    this.state.charact.push({ atribute: this.state.newCharact });
    console.log(this.state.charact)
    this.closeModalCharact();
  }


  openModalSample = () => {
    document.body.style.overflowY = "hidden";
    //this.find();
    this.setState({ isVisibleSample: true })

  }
  closeModalSample = () => {
    document.body.style.overflowY = "scroll";
    this.setState({ isVisibleSample: false })

  }

  addSample = () => {
    this.state.showSamples.push({
      id: (this.state.showSamples.length == 0 ? 1 : this.state.showSamples[this.state.showSamples.length - 1].id + 1),
      detailsSample: this.state.newSample
    });
    console.log(this.state.showSamples)
    this.closeModalSample();
  }

  render() {
    return (
      <div>
        <div className="main-container">
          <Modal
            isOpen={this.state.isVisibleCharact}
            onRequestClose={this.closeModalCharact}
            style={{
              overlay: {
                position: 'fixed',
                zIndex: 1020,
                top: 0,
                left: 0,
                width: '100vw',
                height: '100vh',
                background: 'rgba(235,104,100, 0.75)',
                display: 'flex',
                alignItems: 'center',
                justifyContent: 'center',
              },
              content: {
                background: 'white',
                width: '70vw',
                height: '40vh',
                maxWidth: 'calc(100vw - 2rem)',
                maxHeight: 'calc(100vh - 2rem)',
                overflowY: 'hidden',
                position: 'relative',
                border: '1px solid #ccc',
                borderRadius: '0.3rem',
              }
            }}
          >
            <div className="modalContent" id="modalContent">
              <div className="close-button">
                <button onClick={this.closeModalCharact} className="btn btn-primary">x</button>
              </div>

              <FormGroup htmlFor="charact" label="Característica">
                <input className='form-control' type="text" placeholder='Característica' id='charact' onChange={(e) => { this.setState({ newCharact: e.target.value }) }} />
              </FormGroup>
              <button type="button" className="btn btn-primary" onClick={this.addCharact}>Adicionar</button>
            </div>


          </Modal>

          <Modal
            isOpen={this.state.isVisibleSample}
            onRequestClose={this.closeModalSample}
            style={{
              overlay: {
                position: 'fixed',
                zIndex: 1020,
                top: 0,
                left: 0,
                width: '100vw',
                height: '100vh',
                background: 'rgba(235,104,100, 0.75)',
                display: 'flex',
                alignItems: 'center',
                justifyContent: 'center',
              },
              content: {
                background: 'white',
                width: '70vw',
                height: '40vh',
                maxWidth: 'calc(100vw - 2rem)',
                maxHeight: 'calc(100vh - 2rem)',
                overflowY: 'hidden',
                position: 'relative',
                border: '1px solid #ccc',
                borderRadius: '0.3rem',
              }
            }}
          >
            <div className="modalContent" id="modalContent">
              <div className="close-button">
                <button onClick={this.closeModalSample} className="btn btn-primary">x</button>
              </div>
              <h3>Amostra</h3>
              <FormGroup htmlFor="obs" label="Observação">
                <input className='form-control' type="text" placeholder='Observação' id='obs' onChange={(e) => { this.setState({ newSample: e.target.value }) }} />
              </FormGroup>
              <button type="button" className="btn btn-primary" onClick={this.addSample}>Adicionar</button>
            </div>


          </Modal>

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
              <textarea className="form-control txt-ingred" id="ingredients" rows="3" onChange={(e) => { this.setState({ ingredients: e.target.value }) }}></textarea>
            </FormGroup>

            <div className="half-container">
              <div className='characterist'>
                <CardCharact action="Adicionar" collection={this.state.charact} remove={this.eraseCharact} find={this.openModalCharact} label="Características"></CardCharact>
              </div>

              <div className="slices">
                <CardSample action="Adicionar" collection={this.state.showSamples} remove={this.eraseSample} find={this.openModalSample} label="Amostras"></CardSample>

              </div>

            </div>

          </BigForm>
        </div>

      </div>
    )
  }
}
