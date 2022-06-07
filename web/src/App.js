// import { Route, Routes } from 'react-router-dom';
import './App.scss';
// import Dashboard from './Components/Dashboard';
// import HomePage from './Components/HomePage';
// import Login from './Components/Login';
// import Index from './Components/PrivatePages';
// import AssignmentView from './Components/AssignmentView';
import NavBarComponent from "./Components/NavBar/NavBarComponent";
// import CarouselComponent from './Components/Casourel/CasourelComponent';
// import ProductComponent from './Components/Product/ProductComponent';
import { Routes, Route } from 'react-router-dom';
import ProductComponent from './Components/Product/ProductComponent';
import LoginComponent from './Components/Login/LoginComponent';
import ProductDetail from './Components/Product/ProductDetail';
import FooterComponent from './Components/Footer/FooterComponent';
import RegisterComponent from './Components/Register/RegisterComponent';
import CarouselComponent from './Components/NavBar/CarouselComponent';
function App() {
    return (
        <div>
            <Routes>
                <Route path="/" element={
                    <>
                        <NavBarComponent />
                        <CarouselComponent />
                        <ProductComponent />
                        <FooterComponent />
                    </>
                }></Route>
                <Route path="login" element={<LoginComponent />} />
                <Route path="details" element={<ProductDetail />} />
                <Route path='register' element={
                    <>
                        <NavBarComponent />
                        <RegisterComponent />
                        <FooterComponent />
                    </>

                } />
            </Routes>

        </div>
    );
}

export default App;






// function App() {
//
//   return (
//     <Routes>
//       <Route path='/' element={<HomePage />
//       } >
//       </Route>
//
//       <Route path='dashboard' element={
//         <Index>
//           <Dashboard />
//         </Index>}>
//       </Route>
//       <Route path='/assignments/:id' element={<Index>
//         <AssignmentView />
//       </Index>}></Route>
//       <Route path='login' element={<Login />}></Route>
//     </Routes>
//
//   );
// }
//
// export default App;
