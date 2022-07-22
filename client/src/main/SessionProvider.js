import React from 'react';


import AuthenticationApiService from '../services/AuthenticationApiService';

export const AuthContext = React.createContext();
export const AuthConsumer = AuthContext.Consumer;
const AuthProvider = AuthContext.Provider;

export default class SessionProvider extends React.Component {
    state = {
        loggedUser:null,
        loading:true
    }

    constructor(){
        super();
        this.authService = new AuthenticationApiService();
    }

    async componentDidMount() {
        const isAuthenticated = await this.authService.isAuthenticated()

        if (isAuthenticated) {
            this.start();
        }

        this.setState({loading:false})

    }

    async login(username,password){
        const user = await this.authService.login(username,password)

        if (user) {
            this.start()
            return user;
        }
        else{
            return null
        }
        
    }

    start(){
        const loggedUser = this.authService.getLoggedUser
        const token = this.authService.getToken

        this.setState({loggedUser})
        this.authService.registerToken(token)

    }

    end(){
        this.setState({loggedUser:null})
        this.authService.logout()
    }

    isAuthenticated(){
        return this.state.loggedUser != null
    }

    render() {
        if (this.state.loading) {
            return false
        }

        const context = {
            loggedUser: this.state.loggedUser,
            isAuthenticated: this.isAuthenticated(),
            start: this.start,
            end: this.end,
            login:this.login
        }
        return(
            <AuthProvider value={context}>{this.props.children}</AuthProvider>
        )

    }
}
