
import './App.css';
import 'bootswatch/dist/journal/bootstrap.css';
import NavBar from './components/navs/NavBar';
import AppRoutes from './main/AppRoutes';
import 'toastr/build/toastr.css';
import 'toastr/build/toastr.min.js';
import SessionProvider from './main/SessionProvider'
import React from 'react';
export default class App extends React.Component{
  render(){
    return (
      <div className="App">
        <SessionProvider>
            <NavBar userType={localStorage.getItem('typeUser')}></NavBar>
            <AppRoutes/>
        </SessionProvider>
      </div>
    );
  }
}
