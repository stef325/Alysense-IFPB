import React from 'react';

//import "./Register.css"


import { MdEmail } from "react-icons/md";
import { RiLockPasswordFill } from "react-icons/ri";
import FormGroup from '../../../components/forms/FormGroup'
import BigForm from '../../../components/forms/BigForm'
import{showSucessMessage, showErrorMessage} from '../../../components/toastr/Toastr'
import UserApiService from '../../../services/UserApiService';
export default class Login extends React.Component {

    state={
        email:'',
        password:''
    }

    constructor(){
        super();
        this.service = new UserApiService();
    }

    validate = () =>{
        const errors = [];
        if(!this.state.email){
            errors.push('Campo E-mail é obrigatório!')
        }
        else if(!this.state.email.match(/^[a-z0-9.]+@[a-z0-9]+\.[a-z]/)){
            errors.push('Email inválido!')
        }
        if(!this.state.password){
            errors.push('Campo senha é obrigatório!')
        }
        
        return errors;
    };

    submit =async ()=>{
        const errors = this.validate();
        if(errors.length>0){
            errors.forEach((message,index)=>{
                showErrorMessage(message)
            });
            return false;
        }
        var params = '?';

        if(this.state.email != ''){
            if(params != '?'){
                params = `${params}&`;
            }
        params = `${params}email=${this.state.email}`;
        }

        if(this.state.password != ''){
            if(params != '?'){
                params = `${params}&`;
            }
        params = `${params}password=${this.state.password}`;
        }
        
        await this.service.find(`/${params}`)
        .then(response => {
            localStorage.setItem('loggedUser', JSON.stringify(response.data[0]));
            console.log(JSON.stringify(response.data))
            showSucessMessage("Login efetuado!")
            this.props.history.push(`/EventFeed/`);
        }).catch(error =>{
            console.log(error.response);
            showErrorMessage("Usuário não encontrado!")
        })
    }

    render() {
        return (

            <div className="register">
                <div className='register-container'>
                    <div className='register-form'>
                        <BigForm title="LOGIN" submit={this.submit} action="Login">

                            <div className="input-container">
                                <FormGroup htmlFor="" label="">
                                    <MdEmail />
                                    <input className='form-control' type="email" placeholder='E-mail' id='email' onChange={(e) => { this.setState({ email: e.target.value }) }} />
                                </FormGroup>
                            </div>
                            <div className="input-container">
                                <FormGroup htmlFor="" label="">
                                    <RiLockPasswordFill />
                                    <input className='form-control' type="password" placeholder='Senha' id='password' onChange={(e) => { this.setState({ password: e.target.value }) }} />
                                </FormGroup>
                            </div>

                        </BigForm>
                        
                        

                    </div>
                    <h6>Ainda não tem uma conta? <a href="http://localhost:3000/">clique aqui</a> para se cadastrar.</h6>
                </div>

            </div>
        );
    }

}