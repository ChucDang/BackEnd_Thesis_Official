import { Navigate } from "react-router-dom";
import { useState, useEffect } from "react";
import Loading from "../Components/Loading/Loading";
import ajax from '../Services/fechServices';
import ErrorPage from '../Components/ErrorPage/ErrorPage';
import { useLoading } from "../Services/LoadingProvider";
const PrivateRoute = (props) => {
    const loading = useLoading()
    const [isLoading, setIsLoading] = useState(true);
    const [isValid, setIsValid] = useState(null);
    const { children } = props;
    useEffect(() => {
        if (loading && loading.jwt) {
            ajax('/api/auth/validate', 'GET', loading.jwt).then(async (response) => {
                const isValid = await response.json()
                setIsValid(isValid);
                setIsLoading(false);
            });
        } else {
            return <ErrorPage />;
        }
    }, [])


    return isLoading ? (
        <Loading />
    ) : isValid === true ? (
        children
    ) : (
        <Navigate to="/" />
    );
};

export default PrivateRoute;