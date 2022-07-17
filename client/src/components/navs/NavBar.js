import React from 'react';

import NavBarItem from './NavBarItem'
import "./NavBarStyle.css"

export default class NavBar extends React.Component {

    render() {
        return (
            <div className="nav-bar" id="nav-bar">
                <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
                    <div className="container-fluid">
                        <a className="navbar-brand" href="#">{this.props.userType}</a>
                        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
                            <span className="navbar-toggler-icon"></span>
                        </button>

                        <div className="collapse navbar-collapse" id="navbarColor01">
                            <ul className="navbar-nav me-auto">
                                <NavBarItem href="/home" label="Home"/>

                                <NavBarItem href="/newProduct" label="Adicionar Produto"/>
                                <NavBarItem href="/ProductView" label="Seus Produtos"/>
                                <NavBarItem href="/newEvent" label="Criar Evento"/>
                                <NavBarItem href="/EventFeed" label="Seus Eventos"/>
                                
                            </ul>
                           
                        </div>
                    </div>
                </nav>
            </div>
        );

    }
}