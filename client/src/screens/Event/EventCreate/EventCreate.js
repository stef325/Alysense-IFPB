import React from 'react';
import BigForm from '../../../components/forms/BigForm';
import './EventCreate.css';
import FormGroup from '../../../components/forms/FormGroup';
import CardTable from '../../../components/tables/CardTable';

export default class EventCreate extends React.Component{

    state={
        title:'',
        local:'',
        dateEvent:'aaaa-mm-dd',
        qtdParticipants:0,
        qtdSamples:0,
        products: []
    }

    submit = () =>{

    }

    remove = () =>{

    }

    render(){
        return (
            <div>
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
                                <CardTable action='Adicionar' collection={this.state.products} remove={this.remove} 
                                label='Produtos'>
                                </CardTable>
                            </div>
                        </BigForm>
                    </div>
                </header>
            </div>
        )
    }
}