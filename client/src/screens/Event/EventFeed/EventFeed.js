import React from 'react';
import BigForm from '../../../components/forms/BigForm';
import FormGroup from '../../../components/forms/FormGroup';
import axios from 'axios'
import './EventFeed.css'

export default class EventFeed extends React.Component{

    state={
        idEvent: 0,
        title:'',
        local:'',
        dateEvent:'',
        qtdParticipants:0,
        qtdSamples:0,
        products: [],
        admUser: null,
        avaliators:[],


        id:'',
        name:''
    }

    submit =()=>{

    };

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
                    </div>
                </header>
            </div>
        )
    }
}