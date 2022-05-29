import React from 'react';

import "./Register.css"


import { MdEmail } from "react-icons/md";
import { FaBirthdayCake } from "react-icons/fa";
import { RiBallPenFill } from "react-icons/ri";
import { RiLockPasswordFill } from "react-icons/ri";

import FormGroup from '../../../components/forms/FormGroup'
import BigForm from '../../../components/forms/BigForm'
export default class Register extends React.Component {

    submit = () => { }
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
                                    <input className='form-control' type="password" placeholder='Senha' id='password' onChange={(e) => { this.setState({ name: e.target.value }) }} />
                                </FormGroup>
                            </div>

                        </BigForm>
                        
                        

                    </div>
                    <h6>Já tem uma conta? <a href="">clique aqui</a> para fazer Login</h6>
                </div>

            </div>
        );
    }

}