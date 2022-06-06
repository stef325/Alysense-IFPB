
import './App.css';
import 'bootswatch/dist/journal/bootstrap.css';

import NavBar from './components/nav/NavBar';
import AppRoutes from './main/AppRoutes';
import Register from './screens/User/Register/Register';
import ProductView from './screens/product/productView/ProductView';
import ProductUpdate from './screens/product/productUpdate/ProductUpdate'
import {BrowserRouter as Router, Route, Switch, withRouter} from "react-router-dom";
import EventUpdate from './screens/Event/EventUpdate/EventUpdate'

function App() {
  return (
    <div className="App">
      <Router>
        <Switch>
          <Route exact path="/" component={Register} />
          <Route component={ProductUpdate} path="/updateproduct/:id" />
          <Route component={EventUpdate} path="/EventUpdate/:id"/>
              <div>
                <NavBar userType={localStorage.getItem('typeUser')}></NavBar>
                <AppRoutes></AppRoutes>
              </div>
          </Switch>
      </Router>
    </div>
  );
}

export default App;
