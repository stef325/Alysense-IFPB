import React from 'react';

import axios from 'axios'
import BigForm from '../../../components/forms/BigForm'
import FormGroup from '../../../components/forms/FormGroup'
import ProductViewTable from '../../../components/tables/Product/ProductViewTable'

import "../../../styles/createForms.css"
import "./ProductView.css"
export default class ProductView extends React.Component {

    state = {
        id:0,
        name: '',
        owner: '',
        expirationDate: '',
        products: []
    }

    componentDidMount(){
        this.findAll();
    }

    findAll = async () => {
        await axios.get(`http://localhost:8080/api/product/all`)
        .then(response=>{
            const products = response.data;
            this.setState({products});
            console.log(products);

        }).catch(error=>{
            console.log(error.response)
        })
    }

    findFilter = async () =>{
        let params = "?";

        if (this.state.id != '') {
            if (params != "?") {
                params = `${params}&`;
            }
            params = `${params}id=${this.state.id}`
        }

        if (this.state.name != '') {
            if (params != "?") {
                params = `${params}&`;
            }
            params = `${params}name=${this.state.name}`
        }
        if (this.state.owner != '') {
            if (params != "?") {
                params = `${params}&`;
            }
            params = `${params}owner=${this.state.owner}`
        }
        if (this.state.expirationDate != '') {
            if (params != "?") {
                params = `${params}&`;
            }
            params = `${params}expirationDate=${this.state.expirationDate}`
        }

       
        await axios.get(`http://localhost:8080/api/product/filter${params}`)
        .then(response=>{
            const products = response.data;
            this.setState({products});
            console.log(products);

        }).catch(error=>{
            console.log(error.response)
        }
            
        )

    }
    

    
    remove = (ProdID) => {
        axios.delete(`http://localhost:8080/api/product/${ProdID}`)
    .then(response =>
        {
            this.findFilter()
        }
    ).catch(error =>
        {
            console.log(error.response)
        }
    )

    }
    edit = (ProductId) => {
        this.props.history.push(`/updateproduct/${ProductId}`)
        window.location.reload();
    }

    render() {
        return (
            <div className='product-view'>
                <div className="main-container">
                    <BigForm submit={this.findFilter} action="Buscar">
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
                                    <input className='form-control' type="date" placeholder='Data' id='date' onChange={(e) => { this.setState({ expirationDate: e.target.value }) }} />
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
