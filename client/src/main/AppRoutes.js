import React from 'react'
import {Route,BrowserRouter} from "react-router-dom";


import ProductCreate from '../screens/product/productCreate/ProductCreate';
import ProductView from '../screens/product/productView/ProductView'
import EventCreate from '../screens/event/eventCreate/EventCreate';
import EventFeed from '../screens/event/eventFeed/EventFeed';
import home from '../screens/home'
import Result from '../screens/avaliation/results/Result';



function AppRoutes() {
    return(
        <BrowserRouter>
                <Route component={ProductCreate} path="/newProduct" />
                <Route component={ProductView} path="/ProductView" />
                <Route component={EventCreate} path="/newEvent" />
                <Route component={EventFeed} path="/EventFeed" />
                <Route component={home} path="/home" />
                <Route component={Result} path="/result" />

        </BrowserRouter>

    );
}


export default AppRoutes;