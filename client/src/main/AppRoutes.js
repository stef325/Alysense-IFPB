import React from 'react'
import {Route,BrowserRouter} from "react-router-dom";

/*import Home from '../Screens/Home/Home';*/

import ProductCreate from '../screens/product/productCreate/ProductCreate';
import EventCreate from '../screens/Event/EventCreate/EventCreate';
import FeedEvento from '../screens/Event/EventFeed/EventFeed';


function AppRoutes() {
    return(
        <BrowserRouter>
            {/*<Route component={Home} path="/home"/>*/}
                <Route component={ProductCreate} path="/newProduct" />
                <Route component={EventCreate} path="/newEvent" />
                <Route component={FeedEvento} path="/FeedEvent" />

        </BrowserRouter>

    );
}


export default AppRoutes;