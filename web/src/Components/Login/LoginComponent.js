import React, { useEffect, useRef } from 'react'
import { Button, Offcanvas, Form, Container, DropdownButton, Dropdown, Row, Col } from 'react-bootstrap'
import { useState } from 'react';
import PersonIcon from '@mui/icons-material/Person'
import "./Login.scss"
import { Navigate, useNavigate } from 'react-router-dom';
import { useLocalState } from '../../Services/useLocalStorage';
import { useLoading } from '../../Services/LoadingProvider';

let icon_login
export default function LoginComponent() {
    const loading = useLoading();
    const [user, setUser] = useLocalState('user', null)
    const [jwt, setJwt] = useLocalState('jwt', null)
    const navigate = useNavigate();
    const [show, setShow] = useState(false);
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [errorMsg, setErrorMsg] = useState(null);

    async function sendLoginRequest() {
        setErrorMsg("");
        const reqBody = {
            username: username,
            password: password,
        };

        const response = await fetch("/api/auth/login", {
            headers: {
                "Content-Type": "application/json",
            },
            method: "post",
            body: JSON.stringify(reqBody)
        })

        if (response.status === 200) {
            let _jwt = response.headers.get('Authorization')
            let _user = await response.json()
            setUser(_user)
            loading.setDisplayName(_user.fullname)
            setJwt(_jwt)
            handleClose()
            alert("Đăng Nhập thành công")
        }
        else if (response.status === 401 || response.status === 403) {
            return setErrorMsg("Invalid username or password");
        } else {
            return setErrorMsg(
                "Something went wrong, try again later"
            )
        }

    }

    function handle_Logout() {
        setJwt(null)
        setUser(null)
        loading.setDisplayName('')
        loading.setCount(0)
        alert("Đăng xuất thành công")
        navigate("/");
    }
    return (
        <Container>

            {user ?
                <>
                    <DropdownButton
                        variant="outline-secondary"
                        title={loading.displayName}
                        id="input-group-dropdown-2"
                        align="end"
                    >
                        <Dropdown.Item href="#">Account</Dropdown.Item>
                        <Dropdown.Item href="#">My Coupons</Dropdown.Item>
                        <Dropdown.Item href="#">History invoices</Dropdown.Item>
                        <Dropdown.Divider />
                        <Dropdown.Item onClick={() => handle_Logout()}>Logout</Dropdown.Item>
                    </DropdownButton>
                </>
                :
                <>
                    <PersonIcon onClick={handleShow} />
                </>}
            <Offcanvas show={show} onHide={handleClose} placement='center' >
                <Offcanvas.Header closeButton>
                    <Offcanvas.Title className='fs-2 fw-bold align-self-center'>Login</Offcanvas.Title>
                </Offcanvas.Header>
                <Offcanvas.Body>
                    <Form>
                        <Form.Group className="mb-3">
                            <Form.Text className="text-muted ">
                                Hãy đăng nhập để trải nghiệm những dịch vụ tuyệt vời của chúng tôi
                            </Form.Text>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label className='fw-bold'>Địa chỉ Email</Form.Label>
                            <Form.Control type="text" placeholder="Enter email" onChange={(event) => setUsername(event.target.value)} />

                        </Form.Group>

                        <Form.Group className="mb-3" controlId="formBasicPassword">
                            <Form.Label className='fw-bold'>Mật khẩu</Form.Label>
                            <Form.Control type="password" placeholder="Password" onChange={(event) => setPassword(event.target.value)} />
                            <Form.Text className="text-muted">
                                Chúng tôi sẽ không tiết lộ thông tin cá nhân của bạn.
                            </Form.Text>
                        </Form.Group>
                        {errorMsg ? (
                            <Row className="justify-content-center mb-4">
                                <Col md="8" lg="6">
                                    <div className="" style={{ color: "red", fontWeight: "bold" }}>
                                        {errorMsg}
                                    </div>
                                </Col>
                            </Row>
                        ) : (
                            <></>
                        )}
                        <Form.Group className="mb-3" controlId="formBasicCheckbox">
                            <Form.Check type="checkbox" label="Nhớ mật khẩu" />

                        </Form.Group>
                        <Form.Group className="alink_custom mb-3" controlId="formBasicCheckbox">
                            <Button
                                id="submit"
                                type="button"
                                className='button_login'
                                onClick={() => sendLoginRequest()}

                            >
                                Login
                            </Button>
                            <div className='link_login'>
                                <a href='/register'>Đăng Ký</a>
                                <a href='/forget'>Quên mật khẩu?</a>
                            </div>

                        </Form.Group>
                    </Form>
                </Offcanvas.Body>
            </Offcanvas>
        </Container>
    )
}

