import React from 'react';
import BigForm from '../../../components/forms/BigForm';
import FormGroup from '../../../components/forms/FormGroup';
import CardProduct from '../../../components/tables/Product/CardProduct';
import EventApiService from '../../../services/EventApiService';
import "./EventUpdateStyle.css";
import{showSucessMessage, showErrorMessage, showWarningMessage} from '../../../components/Toastr/Toastr'

export default class EventUpdate extends React.Component{

    state={
        idEvent: 0,
        title:'',
        dateEvent:'',
        local:'',
        qtdParticipants:0,
        qtdSamples:0,
        products: [],
        admUser: 0,
        avaliators:[],
    }

    constructor(){
        super();
        this.service = new EventApiService();
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
        var user = value[6]+value[7];
        return user;
      }


    submit = async() =>{
        const errors = this.validate();
        if(errors.length>0){
            errors.forEach((message,index)=>{
                showErrorMessage(message)
            });
            return false;
        }
        await this.service.update(this.state.idEvent,{
            title: this.state.title,
            dateEvent: this.state.dateEvent,
            local:this.state.local,
            peopleLimit: this.state.qtdParticipants,
            numberSample: this.state.qtdSamples,
            items: this.state.products,
            evaluators: this.state.avaliators,
            admUser: this.state.admUser
            
        
        }).then(response =>{
            console.log(response)
            showSucessMessage("Evento Atualizado!");
        }).catch(error =>{
            console.log(error.response)
        });
        console.log("request finished");
        this.props.history.push(`/EventFeed`);
    }

    componentDidMount(){
        const params = this.props.match.params;
        const idEvent = params.id;
        console.log(idEvent);
        this.findById(idEvent);

    }

    cancel =()=>{
        this.props.history.push(`/EventFeed`);
    }


    findById = async(eventId) =>{
        await this.service.find(`/filter?id=${eventId}`)
        .then(response=>{
            const event = response.data[0];
            console.log(response.data[0])
            const idEvent = event.id;
            const title = event.title;
            const dateEvent =  this.convertFromStringToDate(event.dateEvent);
            const local = event.local;
            const qtdParticipants= event.peopleLimit;
            const qtdSamples= event.numberSample;
            const admUser = event.admUser;
            this.setState({idEvent,title, dateEvent,local, qtdParticipants,qtdSamples,admUser});
        }).catch(error=>{
            console.log(error.response);
        })
    };

     convertFromStringToDate= (args) =>{
         var veri = args[1]
         if(veri<10){
             veri= "-0"+args[1];
         }
         else{
            veri= "-"+args[1];
         }
        const result = args[0]+veri+"-"+args[2];
       return result;
    };

    remove = () =>{}

    render(){
        return (
            <div className='EventUpdate'>
                <header className="EventUpdate-header">
                    <div className="main-container">
                            <div className='button-test'>
                                <button type="button" class="btn btn-primary" onClick={this.cancel}>Voltar</button>
                            </div>
                        <BigForm title="ATUALIZAR EVENTO" submit={this.submit} action="Alterar">
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