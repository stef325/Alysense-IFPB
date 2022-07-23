import React from 'react';

import NavBarItem from './NavBarItem'
import "./NavBarStyle.css"
import { AuthConsumer } from '../../main/SessionProvider';

    function NavBar (props) {
        console.log(props)
        return (
            <div className="nav-bar" id="nav-bar">
                <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
                    <div className="container-fluid">
                        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
                            <span className="navbar-toggler-icon"></span>
                        </button>

                        <div className="collapse navbar-collapse" id="navbarColor01">
                            <ul className="navbar-nav me-auto">
                                <NavBarItem href="/home" label="Home"/>
                                <NavBarItem render={props.isAuthenticated} href="/newProduct" label="Adicionar Produto"/>
                                <NavBarItem render={props.isAuthenticated} href="/ProductView" label="Seus Produtos"/>
                                <NavBarItem render={props.isAuthenticated} href="/newEvent" label="Criar Evento"/>
                                <NavBarItem render={props.isAuthenticated} href="/EventFeed" label="Seus Eventos"/>
                                <NavBarItem render={props.isAuthenticated} href="/login" onClick={props.logout} label="Sair"/>
                            </ul>
                           
                        </div>
                    </div>
                </nav>
            </div>
        );

    }

export default() =>{
    <AuthConsumer>
        {(context)=>(
            <NavBar isAuthenticated={context.isAuthenticated} logout={context.end} />
        )}
    </AuthConsumer>
}