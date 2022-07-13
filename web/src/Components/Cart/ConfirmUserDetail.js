import React, { useEffect } from 'react'
import { useState } from 'react';
import { Button, Col, Container, Form, Offcanvas, Row } from 'react-bootstrap';
import { useLocalState } from '../../Services/useLocalStorage';
import useLocationForm from '../../Services/useLocationForm';
import Select from 'react-select';
export default function ConfirmUserDetail() {
    const [show, setShow] = useState(false);
    const [user, setUser] = useLocalState('user', null)
    const address = user.address.split(', ')
    const location =
    {
        "city": address[2],
        "district": address[1],
        "ward": address[0]
    }
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
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


    return (
        <>
            <Button className='cart__label__btn' variant="success" onClick={() => handleShow()}>Đặt hàng</Button>
            <Offcanvas show={show} onHide={handleClose} placement='center' className='confirm'>
                <Offcanvas.Header closeButton>
                    <Offcanvas.Title className='fs-2 fw-bold align-self-center'>Thông tin nhận hàng</Offcanvas.Title>
                </Offcanvas.Header>
                <Offcanvas.Body>
                    <Form as={Container} className='confirm__container' fluid>
                        <Form.Group as={Row} controlId="formBasicEmail" className='confirm__container__user'>
                            <Col xs={5}>
                                <Form.Label className='fw-bold'>Họ và tên</Form.Label>
                                <Form.Control type="text" value={user.fullname} />
                            </Col>
                            <Col xs={5} className='mx-5'>
                                <Form.Label className='fw-bold'>Phone</Form.Label>
                                <Form.Control type="text" value={user.phone} />

                            </Col>

                        </Form.Group>

                        <Form.Group className="confirm__container__address" controlId="formBasicPassword">
                            <Form.Label as={Col} xs={12} className='fw-bold mb-3 mx-2'>Địa chỉ giao hàng</Form.Label>

                            <Select className='confirm__container__address__select'
                                name="cityId"
                                key={`cityId_${selectedCity?.value}`}
                                isDisabled={cityOptions.length === 0}
                                options={cityOptions}
                                onChange={(option) => onCitySelect(option)}
                                placeholder="Tỉnh/Thành"
                                defaultValue={selectedCity}
                            // value={selectedCity}
                            />

                            <Select className='confirm__container__address__select'
                                name="districtId"
                                key={`districtId_${selectedDistrict?.value}`}
                                isDisabled={districtOptions.length === 0}
                                options={districtOptions}
                                onChange={(option) => onDistrictSelect(option)}
                                placeholder="Quận/Huyện"
                                defaultValue={selectedDistrict}
                            // value={selectedDistrict}
                            />

                            <Select className='confirm__container__address__select'
                                name="wardId"
                                key={`wardId_${selectedWard?.value}`}
                                isDisabled={wardOptions.length === 0}
                                options={wardOptions}
                                placeholder="Phường/Xã"
                                onChange={(option) => onWardSelect(option)}
                                defaultValue={selectedWard}
                            // value={selectedWard}
                            />




                        </Form.Group>




                    </Form>
                </Offcanvas.Body>
            </Offcanvas>
        </>
    )
}
