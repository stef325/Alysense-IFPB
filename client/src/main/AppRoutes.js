import React from 'react'
import {Route,BrowserRouter} from "react-router-dom";


import ProductCreate from '../screens/product/productCreate/ProductCreate';
import ProductView from '../screens/product/productView/ProductView'
import EventCreate from '../screens/Event/EventCreate/EventCreate';
import EventFeed from '../screens/Event/EventFeed/EventFeed';
import home from '../screens/home'



function AppRoutes() {
    return(
        <BrowserRouter>
                <Route component={ProductCreate} path="/newProduct" />
                <Route component={ProductView} path="/ProductView" />
                <Route component={EventCreate} path="/newEvent" />
                <Route component={EventFeed} path="/EventFeed" />
                <Route component={home} path="/home" />

        </BrowserRouter>

    );
}


export default AppRoutes;