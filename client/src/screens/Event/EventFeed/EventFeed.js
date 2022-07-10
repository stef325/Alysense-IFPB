import React from 'react';
import BigForm from '../../../components/forms/BigForm';
import FormGroup from '../../../components/forms/FormGroup';
import EventApiService from '../../../services/EventApiService';
import './EventFeed.css'
import EventTable from '../../../components/tables/event/EventView'
import{showSucessMessage, showErrorMessage, showWarningMessage} from '../../../components/Toastr/Toastr'
export default class EventFeed extends React.Component{

    state={
        idEvent: '',
        title:'',
        local:'',
        dateEvent:'',
        events:[],
        admUser:0
    }

    constructor(){
        super();
        this.service = new EventApiService();
    }

    remove =(idEvent)=>{
        this.service.delete(idEvent)
        .then(response =>{
            this.find();
            showSucessMessage("Evento excluido!")
        }).catch(error =>{
            console.log(error.response)
            showErrorMessage("Ocorreu algum erro ao excluir o evento!")
        });
        window.location.reload();
    };

    edit =(idEvent)=>{
        this.props.history.push(`/EventUpdate/${idEvent}`);
        window.location.reload();
    }

    componentDidMount(){
        this.state.admUser = this.getLoggedUser().id
        this.submit();
    }

    componentWillUnmount(){
        this.clear();
    }

    getLoggedUser=()=>{
        var value = localStorage.getItem('loggedUser');
        var user = JSON.parse(value);
        return user;
      }

    submit =async ()=>{
        var params = '?';

        if(this.state.admUser != ''){
            if(params != '?'){
                params = `${params}&`;
            }
        params = `${params}admUser=${this.state.admUser}`;
        }

        if(this.state.idEvent != ''){
            if(params != '?'){
                params = `${params}&`;
            }
        params = `${params}id=${this.state.idEvent}`;
        }

        if(this.state.title != ''){
            if(params != '?'){
                params = `${params}&`;
            }
        params = `${params}title=${this.state.title}`;
        }
        if(this.state.local != ''){
            if(params != '?'){
                params = `${params}&`;
            }
        params = `${params}local=${this.state.local}`;
        }
        if(this.state.dateEvent != ''){
            if(params != '?'){
                params = `${params}&`;
            }
        params = `${params}dateEvent=${this.state.dateEvent}`;
        }

        await this.service.find(`/filter${params}`)
        .then(response => {
            const events = response.data;
            this.setState({events})
            console.log(events)
        }).catch(error =>{
            console.log(error.response);
        })
    }
    


    render(){
        return (
            <div className='EventFeed'>
                <header className="EventFeed-header">
                    <div className="main-container">
                        <BigForm title="SEUS EVENTOS" submit={this.submit} action="Buscar">
                            <div className='half-container'>
                                    <div className='titulo'>
                                        <FormGroup label ="Titulo">
                                        <input type='titulo' className='form-control' id='inputTitulo'
                                        placeholder='titulo' value={this.state.title} onChange={(e) => this.setState({title: e.target.value})}></input>
                                        </FormGroup>
                                    </div>
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
                            </BigForm>
                            <div className='EventTable'>
                                <EventTable collection={this.state.events} remove={this.remove} edit={this.edit}>
                                </EventTable>
                            </div>
                    </div>
                </header>
            </div>
        )
    }
}