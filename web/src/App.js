import { Route, Routes } from 'react-router-dom';
import './App.css';
import Dashboard from './Components/Dashboard';
import HomePage from './Components/HomePage';
import Login from './Components/Login';
import PrivateRoute from './Components/PrivatePages/PrivateRoute';


function App() {

  return (
    <Routes>
      <Route path='/' element={<HomePage />
      } >
      </Route>

      <Route path='dashboard' element={
        <PrivateRoute>
          <Dashboard />
        </PrivateRoute>}>
      </Route>
      <Route path='login' element={<Login />}></Route>
    </Routes>

  );
}

export default App;
