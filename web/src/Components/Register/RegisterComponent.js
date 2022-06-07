
import React, { useEffect, useState } from 'react'
import useLocationForm from '../../Services/useLocationForm';
import Select from 'react-select';
import { Container, Row, Col, Form, Button } from 'react-bootstrap';
import './RegisterComponent.scss'
function RegisterComponent() {
    const [_name, setName] = useState("");
    const [_email, setEmail] = useState("");
    const [_sex, setSex] = useState(null);
    const [_date, setDate] = useState("");
    const [_phone, setPhone] = useState("");
    const [_username, setUserName] = useState("");
    const [_password, setPassword] = useState("");
    const [_passwordCP, setPasswordCP] = useState("");
    const [_note, setNote] = useState("");
    const [isChecked, setIsChecked] = useState(null);
    // Các state xử lý địa chỉ hành chính
    const { state, onCitySelect, onDistrictSelect, onWardSelect, onSubmit } =
        useLocationForm()

    const {
        cityOptions,
        districtOptions,
        wardOptions,
        selectedCity,
        selectedDistrict,
        selectedWard,
    } = state;

    const sexs = [
        {
            label: "Nam",
            value: true,
        },
        {
            label: "Nữ",
            value: "false",
        }
    ];
    return (
        <Container className='registerForm'>
            <Row className='registerForm__title'> Thông tin cá nhân</Row>
            <Form as={Row}>
                <Form.Group as={Col} xs={4} >
                    <Form.Label>Họ và tên</Form.Label>
                    <Form.Control type="text" onChange={e => setName(e.target.value)} />
                </Form.Group>
                <Form.Group as={Col} xs={4}>
                    <Form.Label>Email</Form.Label>
                    <Form.Control type="email" onChange={e => setEmail(e.target.value)} />
                </Form.Group>

                <Form.Group as={Col} xs={2} className='registerForm_sexs'>
                    <Form.Label>Giới tính</Form.Label>
                    <select onChange={e => setSex(e.target.value)}>
                        {sexs.map((option) => (
                            <option value={option.value} key={`sexId_${option.value}`}>{option.label}</option>
                        ))}
                    </select>
                </Form.Group>
                <Row>
                    <Form.Group as={Col} xs={4}>
                        <Form.Label>Ngày sinh</Form.Label>
                        <Form.Control type="date" />
                    </Form.Group>
                    <Form.Group as={Col} xs={4}>
                        <Form.Label>Số điện thoại</Form.Label>
                        <Form.Control type="tel" />
                    </Form.Group>
                </Row>
                <Row className='registerForm__title'>
                    Thông tin tài khoản
                </Row>
                <Row>
                    <Form.Group as={Col} xs={3}>
                        <Form.Label>Username</Form.Label>
                        <Form.Control type="text" />
                    </Form.Group>
                    <Form.Group as={Col} xs={4}>
                        <Form.Label>Password</Form.Label>
                        <Form.Control type="password" />
                    </Form.Group>
                    <Form.Group as={Col} xs={4}>
                        <Form.Label>Nhập lại Password</Form.Label>
                        <Form.Control type="password" />
                    </Form.Group>


                </Row>
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
                        />
                    </Col>

                </Row>
                <Row>
                    <Form.Group as={Col}>
                        <Form.Label>Ghi chú</Form.Label>
                        <Form.Control type="text" />
                    </Form.Group>
                </Row>
                <Row className='registerForm__button'>
                    <Button variant="primary" type="submit" onClick={() => onSubmit()}>
                        Submit
                    </Button>
                </Row>

            </Form>
        </Container>

    );
}

export default RegisterComponent