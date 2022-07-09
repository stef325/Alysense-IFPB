import React from 'react';

import AvaliationCard from '../../components/forms/AvaliationCard'
import "./Avaliation.css"

export default class EventCreate extends React.Component {

    state = {
        product: {
            name: "aaa",
            amostra: 1
        },
        aspects: [],
        SOM: false,
        VISAO: false,
        PALADAR: false,
        TATO: false,
        TEXTURA: false

    }

    componentDidMount() {
        this.state.aspects.forEach(aspect => {
            if (aspect.value == "SOM") {
                this.setState({ SOM: true })
            }
            if (aspect.value == "VISAO") {
                this.setState({ VISAO: true })
            }
            if (aspect.value == "PALADAR") {
                this.setState({ PALADAR: true })
            }
            if (aspect.value == "TATO") {
                this.setState({ TATO: true })
            }
            if (aspect.value == "TEXTURA") {
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
                        <button type="button" class="btn btn-primary">Avaliar</button>
                    </div>


                </div>
            </div>
        )
    }
}