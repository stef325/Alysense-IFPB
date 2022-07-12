import React from 'react';

import AvaliationCard from '../../components/forms/AvaliationCard'
import "./Avaliation.css"
import AvaliateApiService from '../../services/AvaliateApiService'

export default class Avaliation extends React.Component {

    state = {
        product: {
            name: "aaa",
            amostra: 1
        },
        aspects: [
            { answer: "PALADAR" }
        ],
        SOM: false,
        VISAO: false,
        PALADAR: false,
        TATO: false,
        TEXTURA: false,
        SOMnote: 0,
        VISAOnote: 0,
        PALADARnote: 0,
        TATOnote: 0,
        TEXTURAnote: 0

    }
    constructor() {
        super();
        this.service = new AvaliateApiService();

    }
    getLoggedUser = () => {
        var value = localStorage.getItem('loggedUser');
        var user = JSON.parse(value);
        return user;
      }

    setnote=(note) =>{
        this.setState(note)
    }
    avaliate = async() => {
        
        this.state.aspects.forEach(async aspect=>{
            console.log(aspect.answer)
            await this.service.create([{
                question: aspect.answer,
                evaluator: this.getLoggedUser().id,
                note:{
                    scale: aspect.answer=="SOM"? this.state.SOMnote: (aspect.answer=="VISAO"?this.state.VISAOnote:(aspect.answer=="PALADAR"? this.state.PALADARnote: aspect.answer=="TATO"?this.state.TATOnote: aspect.answer=="TEXTURA"?this.state.TEXTURAnote:""))
                }
            }]).catch(error => {
                console.log(error.response)
            });
        })



    }

    componentDidMount() {

        this.state.aspects.forEach(aspect => {
            console.log(aspect.answer)
            if (aspect.answer == "SOM") {
                this.setState({ SOM: true })
            }
            if (aspect.answer == "VISAO") {
                this.setState({ VISAO: true })
            }
            if (aspect.answer == "PALADAR") {
                this.setState({ PALADAR: true })
            }
            if (aspect.answer == "TATO") {
                this.setState({ TATO: true })
            }
            if (aspect.answer == "TEXTURA") {
                this.setState({ TEXTURA: true })
            }
        });
    }


    render() {
        return (
            <div>
                <div className='avaliation-container'>

                    <div className="card border-secondary mb-3">
                        <div className="card-body card-header-body">
                            <h2>Produto: {this.state.product.name}</h2>
                            <h3>Amostra: {this.state.product.amostra}</h3>
                        </div>
                    </div>



                    <h4>Insira sua nota diante dos aspectos indicados com base na amostra consumida</h4>
                    <h5>Legenda: 0 = muito ruim, 10 = muito bom</h5>



                    <div className="avaliation-form">

                        <AvaliationCard active={this.state.SOM} aspect="SOM"></AvaliationCard>
                        <AvaliationCard active={this.state.VISAO} aspect="VISAO"></AvaliationCard>
                        <AvaliationCard active={this.state.PALADAR} aspect="PALADAR"></AvaliationCard>
                        <AvaliationCard active={this.state.TATO} aspect="TATO"></AvaliationCard>
                        <AvaliationCard active={this.state.TEXTURA} aspect="TEXTURA"></AvaliationCard>

                    </div>
                    <div className='avaliate-button'>
                        <button type="button" class="btn btn-primary" onClick={this.avaliate}>Avaliar</button>
                    </div>


                </div>
            </div>
        )
    }
}