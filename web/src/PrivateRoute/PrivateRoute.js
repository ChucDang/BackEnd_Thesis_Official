import { Navigate } from "react-router-dom";
import { useState, useEffect } from "react";
import Loading from "../Components/Loading/Loading";
import ajax from '../Services/fechServices';
import { useLocalState } from '../Services/useLocalStorage';
import ErrorPage from '../Components/ErrorPage/ErrorPage';
const PrivateRoute = async (props) => {
    const [user, setUser] = useLocalState('user', null)
    const [jwt, setJwt] = useLocalState('jwt', '')
    const [isLoading, setIsLoading] = useState(true);
    const [isValid, setIsValid] = useState(null);
    const { children } = props;
    console.log('user', user)

    const _jwt = await jwt
    const _user = await user;
    console.log('_user', _user)
    if (jwt && user) {
        ajax('/api/auth/validate', 'GET', jwt).then((isValid) => {
            setIsValid(isValid);
            setIsLoading(false);
        });
    } else {
        return <ErrorPage />;
    }

    return isLoading ? (
        <div>Loading...</div>
    ) : isValid === true ? (
        children
    ) : (
        <Navigate to="/" />
    );
};

export default PrivateRoute;