import React from 'react'
import { useLocalState } from '../util/useLocalStorage';
export default function Dashboard() {
    const [jwt, setJwt] = useLocalState("", "jwt")
    // useEffect(() => {
    //     if (!jwt) {
    //         const reqBody = {
    //             "username": "chucdang",
    //             "password": "Alpha2398"
    //         };
    //         fetch("api/auth/login", {
    //             headers: {
    //                 "Content-Type": "application/json",
    //             },
    //             method: "post",
    //             body: JSON.stringify(reqBody),
    //         }).then((response) => Promise.all([response.json(), response.headers]))
    //             .then(([body, headers]) => {
    //                 setJwt(headers.get("authorization"));
    //             });
    //     }
    // }, []);
    // useEffect(() => {
    //     console.log(`JWT value is ${jwt}`)
    // }, [jwt])
    function createAssignment() {
        fetch("/api/assignments", {
            headers: {
                'Content-Type': "application/json",
                Authorization: `Bearer ${jwt}`,
            },
            method: "post",
        }).then(response => {
            if (response.status === 200) return response.json();
        }).then(data => {
            console.log(data)
        });
    }
    return (
        <div>
            <h1>Dashboard is here</h1>
            <button onClick={() => createAssignment()}>Submit new Brand</button>
        </div>

    )
}
