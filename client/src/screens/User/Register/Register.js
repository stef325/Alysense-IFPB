import React from 'react';

import "./RegisterStyle.css"


import { MdEmail } from "react-icons/md";
import { FaBirthdayCake } from "react-icons/fa";
import { RiBallPenFill } from "react-icons/ri";
import { RiLockPasswordFill } from "react-icons/ri";

import FormGroup from '../../../components/forms/FormGroup'
import BigForm from '../../../components/forms/BigForm'
import UserApiService from '../../../services/UserApiService';
import{showSucessMessage, showErrorMessage, showWarningMessage} from '../../../components/Toastr/Toastr'
export default class Register extends React.Component {

    state={
        name:'',
        date:'',
        email:'',
        password:''
    }
    
    constructor(){
        super();
        this.service = new UserApiService();
    }

    validate = () =>{
        const errors = [];

        if(!this.state.name){
            errors.push('Campo Nome é obrigatório!')
        }
        if(!this.state.date){
            errors.push('informe sua data de nascimento!')
        }
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

    submit = async() => { 
        const errors = this.validate();
        if(errors.length>0){
            errors.forEach((message,index)=>{
                showErrorMessage(message)
            });
            return false;
        }
        await this.service.create({
      name: this.state.name,
      birthDate: this.state.date,
      email:this.state.email,
      password: this.state.password,


    }).then(response =>{
        showSucessMessage("Conta criada!");
        localStorage.setItem('loggedUser', JSON.stringify(response.data));
        console.log(response);
        this.props.history.push(`/EventFeed/`);
    }).catch(error =>{
      console.log(error.response)
    });
    console.log("request finished");
    }

    render() {
        return (

            <div className="register">
                <div className='register-container'>
                    <div className='register-form'>
                        <BigForm title="CADASTRO" submit={this.submit} action="Cadastrar-se">
                            <div className="input-container">
                                <FormGroup htmlFor="" label="">
                                    <RiBallPenFill />
                                    <input className='form-control' type="text" placeholder='Nome' id='name' onChange={(e) => { this.setState({ name: e.target.value }) }} />
                                </FormGroup>
                            </div>

                            <div className="input-container">
                                <FormGroup htmlFor="" label="">
                                    <FaBirthdayCake />
                                    <input className='form-control' type="date" placeholder='Data' id='date' onChange={(e) => { this.setState({ date: e.target.value }) }} />
                                </FormGroup>
                            </div>

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
                    <h6>Já tem uma conta? <a href="http://localhost:3000/login">clique aqui</a> para fazer Login</h6>
                </div>

            </div>
        );
    }

}