import React from 'react';

import axios from 'axios'
import BigForm from '../../../components/forms/BigForm'
import FormGroup from '../../../components/forms/FormGroup'
import ProductViewTable from '../../../components/tables/Product/ProductViewTable'

import "../../../styles/createForms.css"
import "./ProductView.css"
export default class ProductView extends React.Component {

    state = {
        name: '',
        owner: '',
        date: '',
        products: []
    }


    submit = async () => {
        await axios.post('http://localhost:8080/api/product', {
            name: this.state.name,
            expirationDate: this.state.date,
            owner: this.state.owner,
            ingredients: this.state.ingredients,
            characteristics: this.state.charact,
            samples: this.state.slices

        }).then(response => {
            console.log(response)
            alert("Produto adicionado!")
        }).catch(error => {
            console.log(error.response)
            alert("Erro!")
        });

        console.log("request finished");


    }

    remove = () => {

    }
    edit = () => {

    }

    render() {
        return (
            <div className='product-view'>
                <div className="main-container">
                    <BigForm action="Buscar">
                        <div className="form-line">
                            <div className="name">
                                <FormGroup htmlFor="name" label="Nome" className="name">
                                    <input className='form-control' type="text" placeholder='Nome' id='name' onChange={(e) => { this.setState({ name: e.target.value }) }} />
                                </FormGroup>
                            </div>
                            <div className="owner">
                                <FormGroup htmlFor="owner" label="Fornecedor">
                                    <input className='form-control' type="text" placeholder='Fornecedor' id='owner' onChange={(e) => { this.setState({ owner: e.target.value }) }} />
                                </FormGroup>
                            </div>

                            <div className="expiration-date">
                                <FormGroup htmlFor="date" label="Data de validade">
                                    <input className='form-control' type="date" placeholder='Data' id='date' onChange={(e) => { this.setState({ date: e.target.value }) }} />
                                </FormGroup>
                            </div>

                        </div>

                    </BigForm>

                    <ProductViewTable collection={this.state.products} edit={this.edit} remove={this.remove}></ProductViewTable>

                </div>

            </div>
        )
    }
}
