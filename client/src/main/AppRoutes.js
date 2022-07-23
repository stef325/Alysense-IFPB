import React from 'react'
import Login from '../screens/user/login/Login';
import Register from '../screens/user/register/Register';
import Avaliation from '../screens/avaliation/avaliate/Avaliation';
import ProductUpdate from '../screens/product/productUpdate/ProductUpdate';
import EventUpdate from '../screens/event/eventUpdate/EventUpdate';
import ProductCreate from '../screens/product/productCreate/ProductCreate';
import ProductView from '../screens/product/productView/ProductView'
import EventCreate from '../screens/event/eventCreate/EventCreate';
import EventFeed from '../screens/event/eventFeed/EventFeed';
import home from '../screens/home'
import Result from '../screens/avaliation/results/Result';
import {Route, BrowserRouter, Switch, Redirect} from "react-router-dom";
import {AuthConsumer} from '../main/SessionProvider'

function RestrictedRoute( { component: Component, show, ...props}){
    return(
        <Route exact {...props} render={(componentProps) =>{
            if(show){
                return(
                    <Component {...componentProps} />
                )
            }else{
                return(
                    <Redirect to={ {pathname: '/login', state :{ from: componentProps.location}}} />
                )
            }
        }} />
    )
}


function AppRoutes(props) {
    return(
        <BrowserRouter>
            <Switch>
                <Route exact path="/" component={Register} />
                <Route path="/login" component={Login} />
                <RestrictedRoute show={props.isAuthenticated} component={Avaliation} path="/avaliation"/>
                <RestrictedRoute show={props.isAuthenticated} component={ProductUpdate} path="/updateproduct/:id" />
                <RestrictedRoute show={props.isAuthenticated} component={EventUpdate} path="/EventUpdate/:id" />
                <RestrictedRoute show={props.isAuthenticated} component={ProductCreate} path="/newProduct" />
                <RestrictedRoute show={props.isAuthenticated} component={ProductView} path="/ProductView" />
                <RestrictedRoute show={props.isAuthenticated} component={EventCreate} path="/newEvent" />
                <RestrictedRoute show={props.isAuthenticated} component={EventFeed} path="/EventFeed" />
                <RestrictedRoute show={props.isAuthenticated} component={home} path="/home" />
                <RestrictedRoute show={props.isAuthenticated} component={Result} path="/result" />
            </Switch>
        </BrowserRouter>

    );
}


export default()=>(
    <AuthConsumer>
        {(context) => (<AppRoutes isAuthenticated={context.isAuthenticated} />)}
    </AuthConsumer>
)