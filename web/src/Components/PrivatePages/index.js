import React, { useState } from 'react'
import { Navigate } from 'react-router-dom';
import { useLocalState } from '../../util/useLocalStorage'
import ajax from '../../Services/fechServices';

const Index = ({ children }) => {
    const [jwt, setJwt] = useLocalState("", "jwt");
    const [isLoading, setIsLoading] = useState(true)
    const [isValid, setIsValid] = useState(null)
    if (jwt) {
        ajax(`/api/auth/validate?token=${jwt}`, "GET", jwt).then(isValid => {
            if (!isValid) {
                setJwt("")
            }
            setIsValid(isValid)
            setIsLoading(false)
        })

    } else {
        return <Navigate to="/login" />
    }
    return isLoading ? <div>Loading...</div> : isValid === true ? children : <Navigate to="/login" />
}
export default Index;
