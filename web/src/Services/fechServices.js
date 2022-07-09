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
        console.log('status', response.status)
        if (response.status === 200) return response.json()
        if (response.status === 401) {
            alert('Token đã hết hạn, vui lòng đăng nhập lại');
            localStorage.setItem('jwt', '')
            localStorage.setItem('user', '');
            <Navigate to="/" />;
        }
    }).catch((error) => { console.log('error', error) })
}
export default ajax