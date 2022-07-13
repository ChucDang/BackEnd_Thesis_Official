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
        if (response.status === 500) {
            console.log("505 error")
        } else
            if (response.status === 200 && typeof response === 'object') return response.json()
            else if (response.status === 200 && typeof response !== 'object') return response.text()
            else if (response.status === 401) {
                alert('Token đã hết hạn, vui lòng đăng nhập lại');
                localStorage.setItem('jwt', '')
                localStorage.setItem('user', '');
                <Navigate to="/" />;
            } else {

            }
    }).catch(console.log('come to catch'))
}
export default ajax