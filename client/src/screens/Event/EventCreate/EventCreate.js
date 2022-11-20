import React from 'react';
import BigForm from '../../../components/forms/BigForm';
import './EventCreateStyle.css';
import FormGroup from '../../../components/forms/FormGroup';
import CardProduct from '../../../components/tables/Product/CardProduct';
import EventApiService from '../../../services/EventApiService';
import ProductEvent from '../../../components/tables/Product/ProductEvent';
import { showSucessMessage, showErrorMessage } from '../../../components/Toastr/Toastr'
import Modal from 'react-modal';
import AvaliationApiService from '../../../services/AvaliationApiService';

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
        products: [],
        admUser: null,
        avaliators: [],
        minimunAge:0,


        id: '',
        name: '',
        isVisible: false,
        addedProducts: [],
        avaliation: [],
        toggleAvaliation:false

    }

    constructor() {
        super();
        this.serviceEvent = new EventApiService();
        this.serviceProduct = new ProductApiService();
        this.serviceAvaliation = new AvaliationApiService();
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

    getLoggedUser=()=>{
        var value = localStorage.getItem('loggedUser');
        var user = value[6]+value[7];
        return user;
      }

    submit = async () => {

        this.state.admUser = this.getLoggedUser()
        const errors = this.validate();
        if (errors.length > 0) {
            errors.forEach((message, index) => {
                showErrorMessage(message)
            });
            return false;
        }

        await this.serviceEvent.create({
            title: this.state.title,
            dateEvent: this.state.dateEvent,
            local: this.state.local,
            peopleLimit: this.state.qtdParticipants,
            numberSample: this.state.qtdSamples,
            items: this.state.products,
            evaluators: this.state.avaliators,
            admUser: this.state.admUser


        },this.state.avaliation.forEach(element=>{
            this.serviceAvaliation.create(element).then(response => {
            console.log(response)
            showSucessMessage("Produto Criado!");
        }).catch(error => {
            console.log(error.response)
        });
        })).then(response => {
            console.log(response)
            showSucessMessage("Evento Criado!");
            this.props.history.push(`/EventFeed`);
        }).catch(error => {
            console.log(error.response)
        });
        /*this.state.avaliation.forEach(element =>{
            console.log(element.value)
            this.serviceAvaliation.create({
                answer: element.value
            })
        })*/
        this.state.avaliation.forEach(element=>{
            console.log(element)
            this.serviceAvaliation.create(element).then(response => {
            console.log(response)
            showSucessMessage("Evento Criado!");
        }).catch(error => {
            console.log(error.response)
        });
        })
        console.log("request finished");



    }

    openModal = () => {
        document.body.style.overflowY = "hidden";
        this.find();
        this.setState({ isVisible: true })

    }
    closeModal = () => {
        document.body.style.overflowY = "scroll";
        this.setState({ isVisible: false })

    }
    remove = () => { }
    addAvaliation = () => {
        const elements = document.getElementsByClassName("checkAspect");

        for (let index = 0; index < elements.length; index++) {
            const element = elements[index];
            if (element.checked) {
                let notIn = true;
                for (let i = 0; i < this.state.avaliation.length; i++) {
                    if (this.state.avaliation[i].answer == element.value) {
                        notIn = false; 
                    }
                    
                }
                if (notIn == true) {
                   this.state.avaliation.push({ answer: element.value }) 
                }
                
            }

        }
        console.log(this.state.avaliation)

    }
    addon = (product) => {
        this.setState({toggleAvaliation: true})
        this.state.addedProducts.push(product)
    }

    render() {
        return (
            <div className="event-create">

                <Modal
                    isOpen={this.state.isVisible}
                    onRequestClose={this.closeModal}
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
                            <button onClick={this.closeModal} className="btn btn-primary">x</button>
                        </div>

                        <div className={this.state.toggleAvaliation === false? "modal-table-user-products active-tab-modal": "modal-table-user-products"}>
                            <ProductEvent collection={this.state.products} remove={this.addon}></ProductEvent>
                        </div>

                        <div className={this.state.toggleAvaliation === true? "modal-table-prod-avaliation active-tab-avaliadion": "modal-table-prod-avaliation"}>
                            <h2>Avaliações</h2>
                            <div>
                                <input className="checkAspect" type="checkbox" id="APARENCIA" name="APARENCIA" value="APARENCIA" />
                                <label htmlFor="APARENCIA">APARENCIA</label>
                            </div>
                            <div>
                                <input className="checkAspect" type="checkbox" id="ODOR" name="ODOR" value="ODOR" />
                                <label htmlFor="ODOR">ODOR</label>
                            </div>
                            <div>
                                <input className="checkAspect" type="checkbox" id="SABOR" name="SABOR" value="SABOR" />
                                <label htmlFor="SABOR">SABOR</label>
                            </div>
                            <div>
                                <input className="checkAspect" type="checkbox" id="SOM" name="SOM" value="SOM" />
                                <label htmlFor="SOM">SOM</label>
                            </div>
                            <div>
                                <input className="checkAspect" type="checkbox" id="TEXTURA" name="TEXTURA" value="TEXTURA" />
                                <label htmlFor="TEXTURA">TEXTURA</label>
                            </div>
                            <button className="btn btn-primary" onClick={this.addAvaliation}>Adicionar</button>
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

                            <div className='half-container conteiner-down'>
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
                                <div className='minimun-age'>
                                    <FormGroup label="Idade Mínima">
                                        <input type='minimun-age' className='form-control' id='minimunAge'
                                            placeholder='Idade Mínima' value={this.state.minimunAge} onChange={(e) => this.setState({ minimunAge: e.target.value })}></input>
                                    </FormGroup>
                                </div>
                            </div>
                            <div className='CardTable'>
                                <CardProduct action='Adicionar' find={this.openModal} collection={this.state.addedProducts} remove={this.remove}
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