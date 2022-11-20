import React from 'react';

import ProductApiService from '../../../services/ProductApiService';
import BigForm from '../../../components/forms/BigForm'
import FormGroup from '../../../components/forms/FormGroup'
import CardCharact from '../../../components/tables/charact/CardCharact'
import CardSample from '../../../components/tables/samples/CardSample'
import{showSucessMessage, showErrorMessage, showWarningMessage} from '../../../components/Toastr/Toastr'
import "../productCreate/ProductCreateStyle.css"
import "./ProductUpdadeStyle.css"
import Modal from 'react-modal';
export default class ProductUpdate extends React.Component {

  state = {
    id: 0,
    name: '',
    owner: '',
    expirationDate: '',
    ingredients: '',
    userId:0,
    characteristics: [],
    samples: [],
    isVisibleCharact: false,
    isVisibleSample: false,
    showSamples:[]
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
    if(!this.state.expirationDate){
        errors.push('Campo de validade obrigatório!')
    }
    
    return errors;
};

getLoggedUser=()=>{
  var value = localStorage.getItem('loggedUser');
  var user = value[6]+value[7];
  return user;
}

  componentDidMount() {
    const params = this.props.match.params;
    const id = params.id;
    this.findById(id);
    
    Modal.setAppElement('#root');
    this.setState({ isVisibleCharact: false })
    this.setState({ isVisibleSample: false })

  }
  eraseSample = (SampleName) => {

    this.setState({ showSamples: this.state.showSamples.filter((item) => item.name !== SampleName) })
    
  }
  eraseCharact = (Charactatribute) => {

    this.setState({ characteristics: this.state.characteristics.filter((item) => item.atribute !== Charactatribute) })
    
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
    this.state.characteristics.push({ atribute: this.state.newCharact });
    console.log(this.state.characteristics)
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
      name: (this.state.showSamples.length == 0 ? 1 : this.state.showSamples[this.state.showSamples.length - 1].name + 1),
      detailsSample: this.state.newSample
    });
    console.log(this.state.showSamples)
    this.closeModalSample();
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
    await this.service.findById(productID)
      .then(response => {
        const product = response.data;
        const id = product.id;
        const name = product.name;
        const owner = product.owner;
        const expirationDate = this.convertFromStringToDate(product.expirationDate);
        const ingredients = product.ingredients;
        const userId = product.userId;
        const characteristics = product.characteristics;
        const samples = product.samples;
        for (let index = 1; index < this.state.samples.length+1; index++) {
          this.state.showSamples.push({
            name: index,
            detailsSample:this.state.samples[index-1].detailsSample
          })
          
        }
        
        this.setState({ id, name, owner, expirationDate, ingredients,userId,characteristics,samples});
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
    await this.service.update(this.state.id, {
      name: this.state.name,
      expirationDate: this.state.expirationDate,
      owner: this.state.owner,
      ingredients: this.state.ingredients,
      userId: this.state.userId,
      characteristics: this.state.characteristics,
      samples: this.state.samples

    }).then(response => {
      console.log(response)
      showSucessMessage("Produto editado!");
    }).catch(error => {
      console.log(error.response)
    });

    console.log("request finished");
    this.props.history.push(`/ProductView/`);

  }


  render() {
    return (
      <div className='product-update'>
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
                  <input className='form-control' type="text" placeholder='Característica' id='charact' onChange={(e) => {this.setState({ newCharact: e.target.value })}} />
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
                  <input className='form-control' type="text" placeholder='Observação' id='obs' onChange={(e) => {this.setState({ newSample: e.target.value })}} />
                </FormGroup>
                <button type="button" className="btn btn-primary" onClick={this.addSample}>Adicionar</button>
            </div>


          </Modal>
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
                <CardCharact action="Adicionar" find={this.openModalCharact} collection={this.state.characteristics} remove={this.eraseCharact} label="Características"></CardCharact>
              </div>

              <div className="slices">
                <CardSample action="Adicionar" find={this.openModalSample} collection={this.state.samples} remove={this.eraseSample} label="Amostras"></CardSample>

              </div>

            </div>

          </BigForm>
        </div>

      </div>
    )
  }
}
