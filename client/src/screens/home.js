import React from 'react';


export default class Home extends React.Component {

    state={
        
    }
    componentDidMount(){
        this.enter();
    }

    enter = () => {
        // conexão

        alert("Usuário ADMIN")
        localStorage.setItem('typeUser', 'ADMIN');
        this.props.history.push('/newProduct')

    }
    render() {
        return (

            <div className="Home">
               
            </div>
        );
    }

}