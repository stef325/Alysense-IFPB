import React from 'react'
import {Route,BrowserRouter} from "react-router-dom";

/*import Home from '../Screens/Home/Home';*/
import Register from '../screens/User/Register/Register';

import ProductCreate from '../screens/product/productCreate/ProductCreate';
import EventCreate from '../screens/Event/EventCreate/EventCreate'




function AppRoutes() {
    return(
        <BrowserRouter>
            {/*<Route component={Home} path="/home"/>*/}
            <Route component={Register} path="/" exact/>

            <Route component={ProductCreate} path="/newProduct" />

            <Route component={EventCreate} path="/newEvent" />
            


            

        </BrowserRouter>
    );
}

export default AppRoutes;