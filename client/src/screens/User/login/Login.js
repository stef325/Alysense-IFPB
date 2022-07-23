import React from 'react';

//import "./Register.css"


import { MdEmail } from "react-icons/md";
import { RiLockPasswordFill } from "react-icons/ri";
import FormGroup from '../../../components/forms/FormGroup'
import BigForm from '../../../components/forms/BigForm'
import{showSucessMessage, showErrorMessage} from '../../../components/Toastr/Toastr'
import UserApiService from '../../../services/UserApiService';
import  {AuthContext}  from '../../../main/SessionProvider';
import { withRouter } from 'react-router-dom';

class Login extends React.Component {

    state={
        username:'',
        password:''
    }

    constructor(){
        super();
        this.service = new UserApiService();
    }

    validate = () =>{
        const errors = [];
        if(!this.state.username){
            errors.push('Campo nome é obrigatório!')
        }
        if(!this.state.password){
            errors.push('Campo senha é obrigatório!')
        }
        
        return errors;
    };

    login = ()=>{
        const errors = this.validate();
        if(errors.length>0){
            errors.forEach((message,index)=>{
                showErrorMessage(message)
            });
            return false;
        }
        this.context.login(
            this.state.username,
            this.state.password
        ).then(user=>
            {
                if(user){
                    showSucessMessage(`Usuário ${user.name}, logado!`)
                    this.props.history.push('/EventFeed');
                }else{
                    showErrorMessage('Login inválido!')
                }
            }).catch(error =>{
                showErrorMessage('Erro na autenticação:', error);
            })
    }

    render() {
        return (

            <div className="register">
                <div className='register-container'>
                    <div className='register-form'>
                        <BigForm title="LOGIN" submit={this.login} action="Login">

                            <div className="input-container">
                                <FormGroup htmlFor="" label="">
                                    <MdEmail />
                                    <input className='form-control' type="username" placeholder='username' id='username' onChange={(e) => { this.setState({ username: e.target.value }) }} />
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
Login.contextType = AuthContext;
export default withRouter(Login);