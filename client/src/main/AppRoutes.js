import React from 'react'
import {Route,BrowserRouter} from "react-router-dom";

/*import Home from '../Screens/Home/Home';*/

import ProductCreate from '../screens/product/productCreate/ProductCreate';
import ProductView from '../screens/product/productView/ProductView'
import EventCreate from '../screens/Event/EventCreate/EventCreate';
import EventFeed from '../screens/Event/EventFeed/EventFeed';


function AppRoutes() {
    return(
        <BrowserRouter>
            {/*<Route component={Home} path="/home"/>*/}
                <Route component={ProductCreate} path="/newProduct" />
                <Route component={ProductView} path="/ProductView" />
                <Route component={EventCreate} path="/newEvent" />
                <Route component={EventFeed} path="/EventFeed" />

        </BrowserRouter>

    );
}


export default AppRoutes;