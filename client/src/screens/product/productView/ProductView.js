import React from 'react';

import ProductApiService from '../../../services/ProductApiService';
import BigForm from '../../../components/forms/BigForm'
import FormGroup from '../../../components/forms/FormGroup'
import ProductViewTable from '../../../components/tables/Product/ProductViewTable'
import{showSucessMessage, showErrorMessage, showWarningMessage} from '../../../components/Toastr/Toastr'
import "../../../styles/createForms.css"
import "./ProductView.css"
export default class ProductView extends React.Component {

    state = {
        id:0,
        name: '',
        owner: '',
        expirationDate: '',
        idUser: 0,
        products: []
    }

    constructor(){
        super();
        this.service = new ProductApiService();
    }

    componentDidMount(){
        this.findFilter();
    }

    //ainda não necessario
   /* findAll = async () => {
        await this.service.findAll()
        .then(response=>{
            const products = response.data;
            this.setState({products});
            console.log(products);

        }).catch(error=>{
            console.log(error.response)
        })
    }*/

    getLoggedUser=()=>{
        var value = localStorage.getItem('loggedUser');
        var user = JSON.parse(value);
        return user;
      }


    findFilter = async () =>{
        this.state.idUser = this.getLoggedUser().id
        var params = "?";

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

        if (this.state.idUser != '') {
            if (params != "?") {
                params = `${params}&`;
            }
            params = `${params}userId=${this.state.idUser}`
        }

       
        await this.service.find(`/filter/${params}`)
        .then(response=>{
            const products = response.data;
            this.setState({products});
            console.log(products);

        }).catch(error=>{
            console.log(error.response)
        }
            
        )

    }
    

    
    remove = async (ProdID) => {
        await this.service.delete(ProdID)
    .then(response =>
        {
            this.findFilter()
        }
    ).catch(error =>
        {
            showWarningMessage("Produto relacionado a um Evento ainda!")
            console.log(error.response)
        }
    )

    }
    edit = (ProductId) => {
        this.props.history.push(`/updateproduct/${ProductId}`)
        //window.location.reload();
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
