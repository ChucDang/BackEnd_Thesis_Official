import React, { useState } from 'react'
import { Navbar, Nav, Form } from 'react-bootstrap'
import { FormControl, NavDropdown, Offcanvas, Carousel } from 'react-bootstrap'
import LocalMallIcon from '@mui/icons-material/LocalMall';
import MailIcon from '@mui/icons-material/Mail';
import NotificationsIcon from '@mui/icons-material/Notifications';
import LoginComponent from '../Login/LoginComponent';
import "./NavBar.scss"
import { useUser } from '../../UserProvider';
export default function NavBarComponent() {
    const user = useUser();
    const [name, setName] = useState("");
    function onNameChange() {
        if (user.jwt) {
            let obj = JSON.parse(user.jwt)
            setName(obj.fullname)
        }
    }
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
                    <span className="mx-3 fs-2 fw-bold align-self-center">MY LIFE</span>
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
                            <Nav.Link href="#action1">Điện Thoại</Nav.Link>
                            <Nav.Link href="#action2">Laptop</Nav.Link>
                            <Nav.Link href="#action2">Đồng Hồ</Nav.Link>
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
                            {/* <Button variant="outline-success">Search</Button> */}
                        </Form>
                    </Offcanvas.Body>
                </Navbar.Offcanvas>
                <div className='grpicon d-flex flex-row ms-auto fw-bold p-2'>
                    <a href="#link" className='my_custom p-2' > <LocalMallIcon /> </a>
                    <a href="#link" className='p-2' > <NotificationsIcon /> </a>
                    <a href="#link" className='p-2' > <MailIcon /> </a>
                    <a href="#link" className='p-2' >  <LoginComponent handleShowName={() => onNameChange()} /></a>
                </div>
            </Navbar>

        </>


    )
}
