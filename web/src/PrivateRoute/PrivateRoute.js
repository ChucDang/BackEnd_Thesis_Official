import { Navigate } from "react-router-dom";
import { useUser } from "../UserProvider";
import { useState, useEffect } from "react";
import ajax from "../Services/fetchService";
import Loading from "../Components/Loading/Loading";

const PrivateRoute = (props) => {
    const [isLoading, setIsLoading] = useState(true);
    const [isValid, setIsValid] = useState(null);
    const { children } = props;
    let jwt = localStorage.getItem('jwt')

    const response = ajax(`/api/auth/validate`, "get", jwt)
    if (response.status === 200) {
        setIsValid(isValid);
        setIsLoading(false);
    }
    else {
        return <Navigate to="/" />;
    }

    return isLoading ? (
        <Loading />
    ) : isValid === true ? (
        children
    ) : (
        <Navigate to="/" />
    );
};

export default PrivateRoute;
