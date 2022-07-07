
import './App.css';
import 'bootswatch/dist/journal/bootstrap.css';
import NavBar from './components/nav/NavBar';
import AppRoutes from './main/AppRoutes';
import Register from './screens/User/Register/Register';
import ProductUpdate from './screens/product/productUpdate/ProductUpdate';
import {BrowserRouter as Router, Route, Switch, withRouter} from "react-router-dom";
import EventUpdate from './screens/Event/EventUpdate/EventUpdate';
import 'toastr/build/toastr.css';
import 'toastr/build/toastr.min.js';
import Login from './screens/User/login/Login'

function App() {
  return (
    <div className="App">
      <Router>
        <Switch>
          <Route exact path="/" component={Register} />
          <Route exact path="/login" component={Login} />
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
