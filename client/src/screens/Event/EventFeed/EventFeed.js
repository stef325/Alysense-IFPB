import React from 'react';
import BigForm from '../../../components/forms/BigForm';
import FormGroup from '../../../components/forms/FormGroup';
import axios from 'axios'
import './EventFeed.css'
import EventTable from '../../../components/tables/event/EventView'
import {withRouter} from 'react-router-dom';

export default class EventFeed extends React.Component{

    state={
        idEvent: '',
        title:'',
        local:'',
        dateEvent:'',
        events:[]
    }

    remove =(idEvent)=>{
        axios.delete(`http://localhost:8080/api/event/${idEvent}`)
        .then(response =>{
            this.find();
        }).catch(error =>{
            console.log(error.response)
        });
    };

    edit =(idEvent)=>{
        this.props.history.push(`/EventUpdate/${idEvent}`)
    }

    componentDidMount(){
        this.submit();
    }

    submit =async ()=>{

        var params = '?';
        if(this.state.idEvent != ''){
            if(params != '?'){
                params = `${params}&`;
            }
        params = `${params}id=${this.state.idEvent}`;
        }

        var params = '?';
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
        params = `${params}date=${this.state.dateEvent}`;
        }
        
        await axios.get(`http://localhost:8080/api/event/filter${params}`)
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
                        <BigForm title="ATUALIZAR EVENTO" submit={this.submit} action="Buscar">
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
                                <EventTable  action='Adicionar' collection={this.state.events} remove={this.remove} edit={this.edit}
                                label='Produtos' >
                                </EventTable>
                            </div>
                    </div>
                </header>
            </div>
        )
    }
}