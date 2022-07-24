import React from 'react'
import { Col, Container, Row } from 'react-bootstrap';
import ADNavbar from '../Components/NavBar/ADNavbar';
import { useLoading } from '../../Services/LoadingProvider';
import { useEffect } from 'react';
import ajax from '../../Services/fechServices';
import { useLocalState } from '../../Services/useLocalStorage';

export default function ListUser() {
    const loading = useLoading();
    const [jwt, setJwt] = useLocalState('jwt', '')
    const [users, setUsers] = useLocalState('users', null)
    useEffect(() => {
        ajax('/admin/users', 'GET', jwt).then(response => {
            setUsers(response);
        })
    }, [jwt])
    return (
        <>
            <ADNavbar />
            <Container>
                <Row>
                    <Col>Họ và tên</Col>
                    <Col>Giới tính</Col>
                    <Col>Email</Col>
                    <Col>Phone</Col>

                </Row>
                {users ? users.map(item => {
                    return <Row>
                        {item.fullname}
                    </Row>
                }) : <></>}


            </Container>
            : <></>



        </>
    )
}

