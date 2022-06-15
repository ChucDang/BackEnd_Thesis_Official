import React, { useEffect } from 'react'
import { Button, Offcanvas, Form, Container, DropdownButton, Dropdown, Row, Col, Alert } from 'react-bootstrap'
import { useState } from 'react';
import PersonIcon from '@mui/icons-material/Person'
import "./Login.scss"
import { useUser } from '../../UserProvider';
import { useNavigate } from "react-router-dom";

export default function LoginComponent() {
    const user = useUser();
    const navigate = useNavigate();
    const [show, setShow] = useState(false);
    const [name, setName] = useState("");
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [errorMsg, setErrorMsg] = useState(null);

    function sendLoginRequest() {
        setErrorMsg("");
        const reqBody = {
            username: username,
            password: password,
        };
        fetch("/api/auth/login", {
            headers: {
                "Content-Type": "application/json",
            },
            method: "post",
            body: JSON.stringify(reqBody)
        })
            .then((response) => {
                if (response.status === 200) {
                    return response.text()
                }
                else if (response.status === 401 || response.status === 403) {
                    return setErrorMsg("Invalid username or password");
                } else {
                    return setErrorMsg(
                        "Something went wrong, try again later"
                    );
                }
            })
            .then((data) => {
                if (data) {
                    user.setJwt(data);
                    console.log("jwt là " + user.jwt)
                    let obj = JSON.parse(user.jwt)
                    setName(obj.fullname)
                    setShow(false)
                    alert("Đăng Nhập thành công")

                }
            });
    }

    function handle_Logout() {
        user.setJwt(undefined);

        setName("")
        alert("Đăng xuất thành công")
        navigate("/");
    }
    var icon_login;
    if (name.length === 0) {
        icon_login = <><PersonIcon onClick={handleShow} /></>;
    } else {
        icon_login =
            <>
                <DropdownButton
                    variant="outline-secondary"
                    title={name}
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

    }

    return (
        <Container>

            {icon_login}
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

