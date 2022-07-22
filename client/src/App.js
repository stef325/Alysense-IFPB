
import './App.css';
import 'bootswatch/dist/journal/bootstrap.css';
import NavBar from './components/navs/NavBar';
import AppRoutes from './main/AppRoutes';
import Register from './screens/user/register/Register';
import ProductUpdate from './screens/product/productUpdate/ProductUpdate';
import { BrowserRouter as Router, Route, Switch, withRouter } from "react-router-dom";
import EventUpdate from './screens/event/eventUpdate/EventUpdate';
import 'toastr/build/toastr.css';
import 'toastr/build/toastr.min.js';
import Login from './screens/user/login/Login'
import Avaliation from './screens/avaliation/avaliate/Avaliation'
import SessionProvider from './main/SessionProvider'
function App() {
  return (
    <div className="App">
      <SessionProvider>
        <Router>
          <Switch>

            <Route exact path="/" component={Register} />
            <Route path="/login" component={Login} />
            <Route path="/avaliation" component={Avaliation} />
            <Route component={ProductUpdate} path="/updateproduct/:id" />
            <Route component={EventUpdate} path="/EventUpdate/:id" />
            <div>
              <NavBar userType={localStorage.getItem('typeUser')}></NavBar>
              <AppRoutes></AppRoutes>
            </div>
          </Switch>
        </Router>
      </SessionProvider>

    </div>
  );
}

export default App;
