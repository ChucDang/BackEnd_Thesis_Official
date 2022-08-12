import { Navigate } from "react-router-dom";

function ajax(url, requestmethod, jwt, requestBody) {

    const fetchData = {
        headers: {
            "Content-Type": "application/json"
        },
        method: requestmethod,

    }
    if (jwt) {
        fetchData.headers.Authorization = `Bearer ${jwt}`
    }
    if (requestBody) {
        fetchData.body = JSON.stringify(requestBody)
    }
    return fetch(url, fetchData).then(async response => {

        if (response.status === 200) {


            return response
        } else if (response.status === 500) {
            return response
        } else {
            return <Navigate to={'/notfound'} />
        }
    })
}
export default ajax