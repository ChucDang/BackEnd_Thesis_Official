import { Navigate } from "react-router-dom";

function ajax(url, requestmethod, jwt, requestBody) {

    const fetchData = {
        headers: {
            "Content-Type": "application/json"
        },
        method: requestmethod
    }
    if (jwt) {
        fetchData.headers.Authorization = `Bearer ${jwt}`
    }
    if (requestBody) {
        fetchData.body = JSON.stringify(requestBody)
    }
    return fetch(url, fetchData).then(response => {
        if (response.status === 200) {
            if (typeof response === 'object') return response.json();
            return response.text()
        }
        else if (response.status === 401 || response.status === 403) {
            return <Navigate to={'/notfound'} />
        }
    })
}
export default ajax