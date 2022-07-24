import React, { useState } from 'react'
import { Navigate } from 'react-router-dom';
import ajax from '../../Services/fechServices';
import { useLocalState } from '../../Services/useLocalStorage';

const Index = ({ children }) => {
    const [jwt, setJwt] = useLocalState('jwt', null)
    const [isLoading, setIsLoading] = useState(true)
    const [isValid, setIsValid] = useState(null)
    if (jwt) {
        ajax(`/api/auth/validate`, "GET", jwt).then(isValid => {

            setIsValid(isValid)
            setIsLoading(false)
        })

    } else {
        return <Navigate to="/login" />
    }
    return isLoading ? <Navigate to="/register" /> : isValid === true ? children : <Navigate to="/login" />
}
export default Index;
