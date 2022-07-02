import React from 'react';
import BigForm from '../../../components/forms/BigForm';
import './EventCreate.css';
import FormGroup from '../../../components/forms/FormGroup';
import CardProduct from '../../../components/tables/Product/CardProduct';
import EventApiService from '../../../services/EventApiService';
import ProductEvent from '../../../components/tables/Product/ProductEvent';
import { showSucessMessage, showErrorMessage, showWarningMessage } from '../../../components/Toastr/Toastr'
import Modal from 'react-modal';
import { useState } from "react";

import ProductApiService from '../../../services/ProductApiService';

export default class EventCreate extends React.Component {




    componentDidMount() {
        Modal.setAppElement('#root');
        this.setState({ isVisible: false })
    }

    state = {
        title: '',
        local: '',
        dateEvent: '',
        qtdParticipants: 0,
        qtdSamples: 0,
        products: [
            {
                name:'aaa'
            },
            {
                name:'aaa'
            },
            {
                name:'aaa'
            },
            {
                name:'aaa'
            },
            {
                name:'aaa'
            },
            {
                name:'aaa'
            },
            {
                name:'aaa'
            },
            {
                name:'aaa'
            },
            {
                name:'aaa'
            },
            {
                name:'aaa'
            },
            {
                name:'aaa'
            },
            {
                name:'aaa'
            },
            {
                name:'aaa'
            },
            {
                name:'aaa'
            },
            {
                name:'aaa'
            }
            
        ],
        admUser: null,
        avaliators: [],


        id: '',
        name: '',
        isVisible: false,
        addedProducts: []

    }

    constructor() {
        super();
        this.serviceEvent = new EventApiService();
        this.serviceProduct = new ProductApiService();
    }


    find = async () => {
        var params = '?';

        if (this.state.id != '') {
            if (params != '?') {
                params = `${params}&`;
            }
            params = `${params}id=${this.state.id}`;
        }

        await this.serviceProduct.find(`/filter/${params}`)
            .then(response => {
                const products = response.data;
                this.setState({ products })
                console.log(this.state.products)
            }).catch(error => {
                console.log(error.response);
            })

    }

    validate = () => {
        const errors = [];

        if (!this.state.title) {
            errors.push('Campo titulo é obrigatório!')
        }
        if (!this.state.local) {
            errors.push('informe o local do evento!')
        }
        if (!this.state.dateEvent) {
            errors.push('informe a data do evento!')
        }
        if (!this.state.qtdParticipants) {
            errors.push('Campo da quantidade de participantes é obrigatório!')
        }
        if (!this.state.qtdSamples) {
            errors.push('Campo quantidade de amostras é obrigatório!')
        }

        return errors;
    };

    submit = async () => {

        const errors = this.validate();
        if (errors.length > 0) {
            errors.forEach((message, index) => {
                showErrorMessage(message)
            });
            return false;
        }

        await this.serviceEvent.create({
            title: this.state.title,
            date: this.state.dateEvent,
            local: this.state.local,
            peopleLimit: this.state.qtdParticipants,
            numberSample: this.state.qtdSamples,
            items: this.state.products,
            evaluators: this.state.avaliators,
            admUser: this.state.admUser


        }).then(response => {
            console.log(response)
            showSucessMessage("Produto Criado!");
        }).catch(error => {
            console.log(error.response)
        });
        console.log("request finished");

    }

    openProductModal = () => {
        document.body.style.overflowY = "hidden";
        this.find();
        this.setState({ isVisible: true })

    }
    closeProductModal = () => {
        document.body.style.overflowY = "scroll";
        this.setState({ isVisible: false })

    }


    remove = () => { }
    addon = () => {
        let htmlavaliation = `<div class="conteiner">
		<h2>Avaliações</h2>
		<div>
			<input type="checkbox" id="APARENCIA" name="APARENCIA" value="APARENCIA">
			<label for="APARENCIA">APARENCIA</label>
		</div>
		<div>
			<input type="checkbox" id="ODOR" name="ODOR" value="ODOR">
			<label for="ODOR">ODOR</label>
		</div>
		<div>
			<input type="checkbox" id="SABOR" name="SABOR" value="SABOR">
			<label for="SABOR">SABOR</label>
		</div>
		<div>
			<input type="checkbox" id="SOM" name="SOM" value="SOM">
			<label for="SOM">SOM</label>
		</div>
		<div>
			<input type="checkbox" id="TEXTURA" name="TEXTURA" value="TEXTURA">
			<label for="TEXTURA">TEXTURA</label>
		</div>

	</div>`
        document.getElementById('modalContent').innerHTML = `<div class="conteiner">
		<h2>Avaliações</h2>
		<div>
			<input type="checkbox" id="APARENCIA" name="APARENCIA" value="APARENCIA">
			<label for="APARENCIA">APARENCIA</label>
		</div>
		<div>
			<input type="checkbox" id="ODOR" name="ODOR" value="ODOR">
			<label for="ODOR">ODOR</label>
		</div>
		<div>
			<input type="checkbox" id="SABOR" name="SABOR" value="SABOR">
			<label for="SABOR">SABOR</label>
		</div>
		<div>
			<input type="checkbox" id="SOM" name="SOM" value="SOM">
			<label for="SOM">SOM</label>
		</div>
		<div>
			<input type="checkbox" id="TEXTURA" name="TEXTURA" value="TEXTURA">
			<label for="TEXTURA">TEXTURA</label>
		</div>
        <button>Adicionar</button>
	</div>`
    }

    render() {
        return (
            <div className="event-create">
                <Modal
                    isOpen={this.state.isVisible}
                    onRequestClose={this.closeProductModal}
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
                            height: '80vh',
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
                            <button onClick={this.closeProductModal }className="btn btn-primary">x</button>
                        </div>

                        <div className="modal-table-user-products">
                            <ProductEvent collection={this.state.products} remove={this.addon}></ProductEvent>
                        </div>
                    </div>


                </Modal>
                <header className="EventCreate-header">
                    <div className="main-container">
                        <BigForm title="CRIAR NOVO EVENTO" submit={this.submit} action="Adicionar">
                            <div className='titulo'>
                                <FormGroup label="Titulo">
                                    <input type='titulo' className='form-control' id='inputTitulo'
                                        placeholder='titulo' value={this.state.title} onChange={(e) => this.setState({ title: e.target.value })}></input>
                                </FormGroup>
                            </div>

                            <div className='half-container'>
                                <div className='local'>
                                    <FormGroup label="Local">
                                        <input type='local' className='form-control' id='inputLocal'
                                            placeholder='local' value={this.state.local} onChange={(e) => this.setState({ local: e.target.value })}></input>
                                    </FormGroup>
                                </div>
                                <div className='dateEvent'>
                                    <FormGroup label="Data do evento">
                                        <input type='date' className='form-control' id='inputDate'
                                            placeholder='Data do evento' value={this.state.dateEvent} onChange={(e) => this.setState({ dateEvent: e.target.value })}></input>
                                    </FormGroup>
                                </div>
                            </div>

                            <div className='half-container'>
                                <div className='participants'>
                                    <FormGroup label="Qtd. de participantes">
                                        <input type='participants' className='form-control' id='inputParticipants'
                                            placeholder='Qtd. de participantes' value={this.state.qtdParticipants} onChange={(e) => this.setState({ qtdParticipants: e.target.value })}></input>
                                    </FormGroup>
                                </div>
                                <div className='samples'>
                                    <FormGroup label="Qtd. de amostras">
                                        <input type='samples' className='form-control' id='inputSamples'
                                            placeholder='Qtd. de amostras' value={this.state.qtdSamples} onChange={(e) => this.setState({ qtdSamples: e.target.value })}></input>
                                    </FormGroup>
                                </div>
                            </div>
                            <div className='CardTable'>
                                <CardProduct action='Adicionar' find={this.openProductModal} collection={this.state.products} remove={this.remove}
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