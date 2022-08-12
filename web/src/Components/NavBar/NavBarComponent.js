import React, { useEffect } from 'react'
import { Navbar, Nav, Form, Badge } from 'react-bootstrap'
import { FormControl, NavDropdown, Offcanvas } from 'react-bootstrap'
import LocalMallIcon from '@mui/icons-material/LocalMall';
import MailIcon from '@mui/icons-material/Mail';
import NotificationsIcon from '@mui/icons-material/Notifications';
import LoginComponent from '../Login/LoginComponent';
import "./NavBar.scss"
import { useLoading } from '../../Services/LoadingProvider';
import { useNavigate } from 'react-router-dom';
import { useLocalState } from '../../Services/useLocalStorage';
import { ROLE_ENUM } from '../../Constants/roles';

export default function NavBarComponent() {
    const loading = useLoading();
    const navigate = useNavigate();
    useEffect(() => {
        if (loading.user && loading.user.authorities[0].authority === ROLE_ENUM.ADMIN)
            navigate('/admin')
    })
    return (
        <>
            <Navbar bg="dark" variant="dark" expand="xl" sticky="top">
                <Navbar.Brand href="/" className='d-flex'>
                    <img
                        alt="Không load được hình"
                        src="/icons/ic_store.png"
                        width="50"
                        height="50"
                        className="d-inline-block align-top"
                    />{' '}
                    <span className="storeName">Hi-Tech</span>
                </Navbar.Brand>

                <Navbar.Toggle id="offcanvasNavbarLabel-expand-sm" />
                {/* Test Offcanvas */}
                <Navbar.Offcanvas
                    id='offcanvasNavbar-expand-sm'
                    aria-labelledby='offcanvasNavbarLabel-expand-sm'
                    placement="end"
                >
                    <Offcanvas.Header closeButton>
                        <Offcanvas.Title id='offcanvasNavbarLabel-expand-sm'>
                            Offcanvas
                        </Offcanvas.Title>
                    </Offcanvas.Header>
                    <Offcanvas.Body>
                        <Nav className="justify-content-end flex-grow-1 pe-3">
                            <Nav.Link href="/products/category/phone">Điện Thoại</Nav.Link>
                            <Nav.Link href="/products/category/laptop">Laptop</Nav.Link>
                            <Nav.Link href="/products/category/clock">Đồng Hồ</Nav.Link>
                            <NavDropdown
                                title="Phụ kiện khác"
                                id='offcanvasNavbarDropdown-expand-sm'
                            >
                                <NavDropdown.Item href="#action3">Tai nghe</NavDropdown.Item>
                                <NavDropdown.Item href="#action4">
                                    Sạc dự phòng
                                </NavDropdown.Item>

                                <NavDropdown.Item href="#action5">
                                    Dây sạc
                                </NavDropdown.Item>
                            </NavDropdown>
                        </Nav>
                        <Form className="d-flex">
                            <FormControl
                                type="search"
                                placeholder="Search"
                                className="me-2"
                                aria-label="Search"
                            />
                        </Form>
                    </Offcanvas.Body>
                </Navbar.Offcanvas>

                <div className='grpicon'>
                    <a href="/cart" className='grpicon__item' >
                        <LocalMallIcon />
                        <Badge bg="light" text="dark" className='grpicon__item--badge'>
                            {loading.count}
                        </Badge>
                    </a>
                    <a href="/cart" className='grpicon__item' >
                        <NotificationsIcon />
                        <Badge bg="light" text="dark" className='grpicon__item--badge'>
                            10
                        </Badge>
                    </a>
                    <a href="#link" className='grpicon__item' >
                        <MailIcon />
                        <Badge bg="light" text="dark" className='grpicon__item--badge'>
                            10
                        </Badge>
                    </a>
                    <a href="#" className='p-2' >  <LoginComponent /></a>
                    {/* <LoginComponent /> */}
                </div>
            </Navbar>

        </>


    )
}
