import React from 'react'
import { Button, Col, Container, Row, Table } from 'react-bootstrap';
import ADNavbar from '../Components/NavBar/ADNavbar';
import { useLoading } from '../../Services/LoadingProvider';
import { useEffect } from 'react';
import ajax from '../../Services/fechServices';
import { useLocalState } from '../../Services/useLocalStorage';
import './ListUser.scss'

import PersonAddIcon from '@mui/icons-material/PersonAdd';
import EditButton from './EditButton';
export default function ListUser() {
    const loading = useLoading();
    const [users, setUsers] = useLocalState('users', null)
    useEffect(() => {
        ajax('/admin/users', 'GET', loading.jwt).then(async response => {
            const result = await response.json()
            setUsers(result);
        })
    }, [loading.jwt])
    const handleDelete = async (id) => {
        ajax(`/admin/deleteAUser/${id}`, 'DELETE', loading.jwt).then(async response => {
            const msg = (await response.text()).toString()
            const usersCopy = [...users];
            const i = usersCopy.findIndex((item) => item.id === id);
            usersCopy.splice(i, 1);
            alert(msg)
            setUsers(usersCopy)
        })
    }


    return (
        <>
            <ADNavbar />

            {/* <img src='/icons/ic_plus.png' alt='Loading...' className='icon_addUser' /> */}
            <Button variant='success' className='icon_addUser'>Add a acount</Button>

            <Container className='listUser'>
                <Row className='listUser__search'>

                    <input type='text' className='listUser__search__input'></input>
                    <button type="button" className="listUser__search__btn" > Search </button>

                </Row>


                <Table as={Row} striped bordered hover>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Fullname</th>
                            <th>Gender</th>
                            <th>Phone</th>
                            <th>Email</th>
                            <th>Authority</th>
                            <th>Manage</th>
                        </tr>
                    </thead>
                    <tbody>
                        {users ? users.map(item => {
                            return <tr>
                                <td>{item.id}</td>
                                <td> {item.fullname}</td>
                                <td>{item.gender ? 'Nam' : 'Nữ'}</td>
                                <td>{item.phone}</td>

                                <td>{item.email}</td>
                                <td>
                                    {item.authorities[0].authority.split("ROLE_")[1]}
                                </td>
                                <td>
                                    <EditButton className='me-2' user={item} />
                                    <Button value={item.id} variant='danger' onClick={(e) => handleDelete(e.target.value)}>Delete</Button>

                                </td>
                            </tr>
                        }) : <></>}


                    </tbody>
                </Table>

            </Container>
            : <></>



        </>
    )
}

