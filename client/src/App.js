
import './App.css';
import 'bootswatch/dist/journal/bootstrap.css'

import NavBar from './components/nav/NavBar';
import AppRoutes from './main/AppRoutes'

function App() {
  return (
    <div className="App">
      <NavBar userType="ADMIN"></NavBar>
      <AppRoutes></AppRoutes>
    </div>
  );
}

export default App;
