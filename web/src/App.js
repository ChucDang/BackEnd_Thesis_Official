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
import { Routes, Route, useNavigate, Navigate } from 'react-router-dom';
import ProductComponent from './Components/Product/ProductComponent';
import LoginComponent from './Components/Login/LoginComponent';
import FooterComponent from './Components/Footer/FooterComponent';
import RegisterComponent from './Components/Register/RegisterComponent';
import CarouselComponent from './Components/NavBar/CarouselComponent';
import ProductDetail from './Components/Product/ProductDetail';
import Loading from './Components/Loading/Loading';
import Cart from './Components/Cart/Cart';
import ADNavbar from './Admin/Components/NavBar/ADNavbar';
import ListUser from './Admin/ListUser/ListUser';
import OrderPage from './Components/OrderPage/OrderPage';
import { useLocalState } from './Services/useLocalStorage';
import PrivateRoute from './PrivateRoute/PrivateRoute';
import { useEffect, useState } from 'react';
import { ROLE_ENUM } from './Constants/roles';
import ErrorPage from './Components/ErrorPage/ErrorPage';
import { useLoading } from './Services/LoadingProvider';
import StockComponent from './Admin/Stock/StockComponent';
import FlashSale from './Admin/FlashSale/FlashSale';
import ProductAdmin from './Admin/Product/ProductAdmin';
import EditProductAdmin from './Admin/Product/EditProductAdmin';
import Account from './Components/Account/Account';

function App() {
    const loading = useLoading();
    return (
        <div>
            <Routes>
                {/* Danh sách điều hướng của Khách Hàng */}
                <Route path='/order' element={
                    <PrivateRoute>
                        <OrderPage />
                    </PrivateRoute>
                }></Route>
                <Route path="/" element={
                    <>

                        <ProductComponent />

                    </>


                }></Route>
                <Route path="cart" element={
                    <PrivateRoute>
                        <NavBarComponent />
                        <Cart />
                    </PrivateRoute>

                } />
                <Route path='/register' element={
                    <>
                        <NavBarComponent />
                        <RegisterComponent />
                    </>

                } />
                <Route path="forget" element={
                    <>
                        <Loading />

                    </>
                }
                />
                <Route path="/products/category/:categoryCode" element={
                    <>

                        <ProductComponent />

                    </>
                }
                />
                <Route path="/products/product/:productId" element={
                    <>
                        <NavBarComponent />
                        <ProductDetail />
                        <FooterComponent />
                    </>
                }
                />
                <Route path="/account" element={
                    <>
                        <Account />
                    </>
                }
                />

                {/* Điều hướng cho ADMIN */}
                <Route path='admin' element={
                    loading.user && loading.user.authorities[0].authority === ROLE_ENUM.ADMIN ?
                        <PrivateRoute>
                            <ListUser />
                        </PrivateRoute> :
                        <ErrorPage />
                } />
                <Route path='stock' element={
                    loading.user && loading.user.authorities[0].authority === ROLE_ENUM.ADMIN ?
                        <PrivateRoute>
                            <StockComponent />
                        </PrivateRoute> :
                        <ErrorPage />
                } />
                <Route path='/admin/product' element={
                    loading.user && loading.user.authorities[0].authority === ROLE_ENUM.ADMIN ?
                        <PrivateRoute>
                            <ProductAdmin />
                        </PrivateRoute> :
                        <ErrorPage />
                } />
                <Route path='/admin/product/create/:id' element={
                    loading.user && loading.user.authorities[0].authority === ROLE_ENUM.ADMIN ?
                        <PrivateRoute>
                            <EditProductAdmin />
                        </PrivateRoute> :
                        <ErrorPage />
                } />
                <Route path='/notfound' element={<ErrorPage />} />

            </Routes >

        </div >
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
