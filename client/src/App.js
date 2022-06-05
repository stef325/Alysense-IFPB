
import './App.css';
import 'bootswatch/dist/journal/bootstrap.css';

import NavBar from './components/nav/NavBar';
import AppRoutes from './main/AppRoutes';
import Register from './screens/User/Register/Register';
import EventUpdate from './screens/Event/EventUpdate/EventUpdate';
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";


function App() {
  return (
    <div className="App">
      <Router>
        <Switch>
          <Route exact path="/" component={Register} />
          <Route path="/EventUpdate" component={EventUpdate} />
              <div>
                <NavBar userType="ADMIN"></NavBar>
                <AppRoutes></AppRoutes>
              </div>
          </Switch>
      </Router>
    </div>
  );
}

export default App;
