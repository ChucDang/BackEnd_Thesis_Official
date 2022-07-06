
import React, { useState } from 'react'
import useLocationForm from '../../Services/useLocationForm';
import Select from 'react-select';
import { Container, Row, Col, Form, Button } from 'react-bootstrap';
import './RegisterComponent.scss'
import { useNavigate } from 'react-router-dom';
function RegisterComponent() {
    const navigate = useNavigate();
    const [input, setInput] = useState({
        fullname: '',
        email: '',
        gender: null,
        dateOfBirth: null,
        phone: '',
        username: '',
        password: '',
        confirmPassword: '',
        note: ''
    })
    const [errorMsg, setErrorMsg] = useState(null);
    // Các state xử lý địa chỉ hành chính
    const { state, onCitySelect, onDistrictSelect, onWardSelect } =
        useLocationForm()
    const {
        cityOptions,
        districtOptions,
        wardOptions,
        selectedCity,
        selectedDistrict,
        selectedWard,
    } = state;

    const genders = [
        {
            label: "Nam",
            value: true,
        },
        {
            label: "Nữ",
            value: false,
        }
    ];

    const onInputChange = e => {
        const { name, value } = e.target;
        setInput(prev => ({
            ...prev,
            [name]: value
        }));

    }

    function createAndLoginUser() {
        if (input.password !== input.confirmPassword) setErrorMsg("Vui lòng nhập mật khẩu khớp nhau")
        const reqBody = {
            username: input.username,
            password: input.password,
            fullname: input.fullname,
            dateOfBirth: input.dateOfBirth,
            phone: input.phone,
            gender: input.gender,
            note: input.note,
            email: input.email,
            address: state.selectedCity.label + "," + state.selectedDistrict.label + "," + state.selectedWard.label
        };

        fetch("/api/auth/users/register", {
            headers: {
                "Content-Type": "application/json",
            },
            method: "post",
            body: JSON.stringify(reqBody),
        })
            .then((response) => {
                if (response.status === 200)
                    return Promise.all([response.json(), response.headers]);
                else return Promise.reject("Invalid login attempt");
            })
            .then(([body, headers]) => {

                alert("Đăng ký thành công");
                navigate("/");
            })
            .catch((message) => {
                alert(message);
            });
    }
    return (
        <Container className='registerForm'>
            <Row className='registerForm__title'> Thông tin cá nhân</Row>
            <Form as={Row}>
                <Form.Group as={Col} xs={4} >
                    <Form.Label>Họ và tên</Form.Label>
                    <Form.Control type="text" name="fullname" value={input.fullname} onChange={onInputChange} />
                </Form.Group>
                <Form.Group as={Col} xs={4}>
                    <Form.Label>Email</Form.Label>
                    <Form.Control type="email" name="email" value={input.email} onChange={onInputChange} />
                </Form.Group>

                <Form.Group as={Col} xs={2} className='registerForm_sexs'>
                    <Form.Label>Giới tính</Form.Label>
                    <select onChange={onInputChange} value={input.gender}>
                        {genders.map((option) => (
                            <option value={option.value} key={`sexId_${option.value}`}>{option.label}</option>
                        ))}
                    </select>
                </Form.Group>
                <Row>
                    <Form.Group as={Col} xs={4}>
                        <Form.Label>Ngày sinh</Form.Label>
                        <Form.Control type="date" name="dateOfBirth" value={input.dateOfBirth} onChange={onInputChange} />
                    </Form.Group>
                    <Form.Group as={Col} xs={4}>
                        <Form.Label>Số điện thoại</Form.Label>
                        <Form.Control type="tel" name="phone" value={input.phone} onChange={onInputChange} />
                    </Form.Group>
                </Row>
                <Row className='registerForm__title'>
                    Thông tin tài khoản
                </Row>
                <Row>
                    <Form.Group as={Col} xs={3}>
                        <Form.Label>Username</Form.Label>
                        <Form.Control type="text" value={input.username} name="username" onChange={onInputChange} />
                    </Form.Group>
                    <Form.Group as={Col} xs={4}>
                        <Form.Label>Password</Form.Label>
                        <Form.Control type="password" value={input.password} name="password" onChange={onInputChange} />
                    </Form.Group>
                    <Form.Group as={Col} xs={4}>
                        <Form.Label>Nhập lại Password</Form.Label>
                        <Form.Control type="password" value={input.confirmPassword} name="confirmPassword" onChange={onInputChange} />
                    </Form.Group>


                </Row>
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
                <Row className='registerForm__title'>Địa chỉ giao hàng</Row>
                <Row>
                    <Col xs={3}>
                        <Select
                            name="cityId"
                            key={`cityId_${selectedCity?.value}`}
                            isDisabled={cityOptions.length === 0}
                            options={cityOptions}
                            onChange={(option) => onCitySelect(option)}
                            placeholder="Tỉnh/Thành"
                            defaultValue={selectedCity}
                            value={selectedCity}
                        />
                    </Col>
                    <Col>
                        <Select
                            name="districtId"
                            key={`districtId_${selectedDistrict?.value}`}
                            isDisabled={districtOptions.length === 0}
                            options={districtOptions}
                            onChange={(option) => onDistrictSelect(option)}
                            placeholder="Quận/Huyện"
                            defaultValue={selectedDistrict}
                            value={selectedDistrict}
                        />
                    </Col>
                    <Col>
                        <Select
                            name="wardId"
                            key={`wardId_${selectedWard?.value}`}
                            isDisabled={wardOptions.length === 0}
                            options={wardOptions}
                            placeholder="Phường/Xã"
                            onChange={(option) => onWardSelect(option)}
                            defaultValue={selectedWard}
                            value={selectedWard}
                        />
                    </Col>

                </Row>
                <Row>
                    <Form.Group as={Col}>
                        <Form.Label>Ghi chú</Form.Label>
                        <Form.Control type="text" value={input.note} name="note" onChange={onInputChange} />
                    </Form.Group>
                </Row>
                <Row className='registerForm__button'>
                    <Button variant="primary" type="submit" onClick={() => createAndLoginUser()}>
                        Submit
                    </Button>
                </Row>

            </Form>
        </Container>

    );
}

export default RegisterComponent