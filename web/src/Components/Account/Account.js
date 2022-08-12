import React from 'react'
import { Container, Row, Col, Form, Button } from 'react-bootstrap';
import { useLoading } from '../../Services/LoadingProvider';
import useLocationForm from '../../Services/useLocationForm';
import NavBarComponent from '../NavBar/NavBarComponent';
import Select from 'react-select';
import './Account.scss'
import { useState } from 'react';
export default function Account() {
    const loading = useLoading();

    const [input, setInput] = useState({
        id: loading.user.id,
        fullname: loading.user.fullname,
        email: loading.user.email,
        gender: loading.user.gender,
        birthday: loading.user.birthday,
        phone: loading.user.phone,
        username: loading.user.username,
        password: loading.user.password,
        confirmPassword: loading.user.confirmPassword,
        note: loading.user.note,
        address: loading.user.address
    })
    const address = loading.user ? loading.user.address.split(', ') : null
    const location =
    {
        "city": address[2],
        "district": address[1],
        "ward": address[0]
    }
    const { state, onCitySelect, onDistrictSelect, onWardSelect } =
        useLocationForm(location)
    const {
        cityOptions,
        districtOptions,
        wardOptions,
        selectedCity,
        selectedDistrict,
        selectedWard,
    } = state;

    const onInputChange = e => {
        const { name, value } = e.target;
        setInput(prev => ({
            ...prev,
            [name]: value
        }));

    }



    return (
        <>
            <NavBarComponent />
            {
                input.id ? <>
                    <Container className='info-user'>
                        <Row className='info-user__header'> Thông tin cá nhân</Row>
                        <Form as={Row}>
                            <Form.Group as={Col} xs={4} >
                                <Form.Label>Họ và tên</Form.Label>
                                <Form.Control type="text" name="fullname" value={input.fullname} />
                            </Form.Group>
                            <Form.Group as={Col} xs={4}>
                                <Form.Label>Email</Form.Label>
                                <Form.Control type="email" name="email" value={input.email} />
                            </Form.Group>



                            <Form.Group as={Col} xs={4}>
                                <Form.Label>Ngày sinh</Form.Label>
                                <Form.Control type="date" name="dateOfBirth" value={input.dateOfBirth} />
                            </Form.Group>
                            <Form.Group as={Col} xs={4}>
                                <Form.Label>Số điện thoại</Form.Label>
                                <Form.Control type="tel" name="phone" value={input.phone} />
                            </Form.Group>
                            <Form.Group as={Col} xs={4}>
                                <Form.Label>Giới tính</Form.Label>
                                <Form.Select
                                    value={input.phone}

                                >
                                    <option></option>

                                    <option value={true}>Nam</option>
                                    <option value={false}>Nữ</option>
                                </Form.Select>
                            </Form.Group>
                        </Form>

                        <Row className='info-user__header'>
                            Địa chỉ giao hàng
                        </Row>
                        <Form as={Row}>
                            <Form.Group as={Col} xs={4}>
                                <Form.Label>Tỉnh</Form.Label>
                                <Form.Select

                                    onChange={(option) => {
                                        onCitySelect(option)
                                    }}
                                >
                                    <option></option>
                                    {cityOptions ? console.log() : <></>}
                                    {cityOptions ? cityOptions.map(item => { return <option key={item.value} value={item.value}>{item.label}</option> }) : <></>}
                                </Form.Select>
                            </Form.Group>
                        </Form>
                        <Row>
                            <Col xs={3}>
                                {/* <Select
                                    name="cityId"
                                    key={`cityId_${selectedCity?.value}`}
                                    isDisabled={cityOptions.length === 0}
                                    options={cityOptions}
                                    onChange={(option) => onCitySelect(option)}
                                    placeholder="Tỉnh/Thành"
                                    defaultValue={selectedCity}
                                    value={selectedCity}
                                /> */}
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
                        <Form as={Row}>


                            <Form.Group as={Col}>
                                <Form.Label>Ghi chú</Form.Label>
                                <Form.Control as="textarea" rows={4} value={input.note}
                                />

                            </Form.Group>


                        </Form>
                        <Row className='info-user__btn'>
                            <Button variant="success" type="submit" className='info-user__btn__save'>
                                Save Changes
                            </Button>
                            <Button variant="danger" type="submit" className='info-user__btn__reset'>
                                Reset
                            </Button>
                        </Row>
                    </Container>
                </> : <></>

            }

        </>
    )
}
