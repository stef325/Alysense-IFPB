import React from 'react';
import BigForm from '../../../components/forms/BigForm';
import './EventCreate.css';
import FormGroup from '../../../components/forms/FormGroup';
import CardProduct from '../../../components/tables/Product/CardProduct';
import EventApiService from '../../../services/EventApiService';
import ProductEvent from '../../../components/tables/Product/ProductEvent';
import{showSucessMessage, showErrorMessage, showWarningMessage} from '../../../components/Toastr/Toastr'
import ProductApiService from '../../../services/ProductApiService';

export default class EventCreate extends React.Component{

    state={
        title:'',
        local:'',
        dateEvent:'',
        qtdParticipants:0,
        qtdSamples:0,
        products: [],
        admUser: 0,
        avaliators:[],


        id:'',
        name:''
    }

    constructor(){
        super();
        this.serviceEvent = new EventApiService();
        this.serviceProduct = new ProductApiService();
    }


    validate = () =>{
        const errors = [];
    
        if(!this.state.title){
            errors.push('Campo titulo é obrigatório!')
        }
        if(!this.state.local){
            errors.push('informe o local do evento!')
        }
        if(!this.state.dateEvent){
            errors.push('informe a data do evento!')
        }
        if(!this.state.qtdParticipants){
            errors.push('Campo da quantidade de participantes é obrigatório!')
        }
        if(!this.state.qtdSamples){
            errors.push('Campo quantidade de amostras é obrigatório!')
        }
        
        return errors;
    };

    getLoggedUser=()=>{
        var value = localStorage.getItem('loggedUser');
        var user = JSON.parse(value);
        return user;
    }

    submit = async() =>{
        
        this.state.admUser = this.getLoggedUser().id
        const errors = this.validate();
        if(errors.length>0){
            errors.forEach((message,index)=>{
                showErrorMessage(message)
            });
            return false;
        }

        await this.serviceEvent.create({
            title: this.state.title,
            date: this.state.dateEvent,
            local:this.state.local,
            peopleLimit: this.state.qtdParticipants,
            numberSample: this.state.qtdSamples,
            items: this.state.products,
            evaluators: this.state.avaliators,
            admUser: this.state.admUser
            
        
          }).then(response =>{
            console.log(response)
            showSucessMessage("Produto Criado!");
            this.props.history.push(`/EventFeed/`);
          }).catch(error =>{
            console.log(error.response)
          });
          console.log("request finished");
          
    }

    find = async () => {
       var params = '?';

        if(this.state.id != ''){
            if(params != '?'){
                params = `${params}&`;
            }
        params = `${params}id=${this.state.id}`;
        }

        if(this.state.name != ''){
            if(params != '?'){
                params = `${params}&`;
            }
        params = `${params}name=${this.state.name}`;
        }
        
        await this.serviceProduct.find(`/filter/${params}`)
        .then(response => {
            const products = response.data;
            this.setState({products})
            console.log(this.state.products)
        }).catch(error =>{
            console.log(error.response);
        })
        
    }

    remove = () =>{}

    render(){
        return (
            <div className="event-create">
                <header className="EventCreate-header">
                    <div className="main-container">
                        <BigForm title="CRIAR NOVO EVENTO" submit={this.submit} action="Adicionar">
                            <div className='titulo'>
                                <FormGroup label ="Titulo">
                                <input type='titulo' className='form-control' id='inputTitulo'
                                placeholder='titulo' value={this.state.title} onChange={(e) => this.setState({title: e.target.value})}></input>
                                </FormGroup>
                            </div>

                            <div className='half-container'>
                                <div className='local'>
                                    <FormGroup label ="Local">
                                    <input type='local' className='form-control' id='inputLocal'
                                    placeholder='local' value={this.state.local} onChange={(e) => this.setState({local: e.target.value})}></input>
                                    </FormGroup>
                                </div>
                                <div className='dateEvent'>
                                    <FormGroup label ="Data do evento">
                                    <input type='date' className='form-control' id='inputDate'
                                    placeholder='Data do evento' value={this.state.dateEvent} onChange={(e) => this.setState({dateEvent: e.target.value})}></input>
                                    </FormGroup>
                                </div>
                            </div>

                            <div className='half-container'>
                                <div className='participants'>
                                    <FormGroup label ="Qtd. de participantes">
                                    <input type='participants' className='form-control' id='inputParticipants'
                                    placeholder='Qtd. de participantes' value={this.state.qtdParticipants} onChange={(e) => this.setState({qtdParticipants: e.target.value})}></input>
                                    </FormGroup>
                                </div>
                                <div className='samples'>
                                    <FormGroup label ="Qtd. de amostras">
                                    <input type='samples' className='form-control' id='inputSamples'
                                    placeholder='Qtd. de amostras' value={this.state.qtdSamples} onChange={(e) => this.setState({qtdSamples: e.target.value})}></input>
                                    </FormGroup>
                                </div>
                            </div>
                            <div className='CardTable'>
                                <CardProduct  action='Adicionar' find={this.find} collection={this.state.products} remove={this.remove} 
                                label='Produtos' >
                                </CardProduct>
                            </div>
                        </BigForm>
                    </div>
                </header>
            </div>
        )
    }
}