import React, { useEffect } from 'react'
import { useState } from 'react';
import { Button, Col, Container, Form, Offcanvas, Row } from 'react-bootstrap';
import { useLocalState } from '../../Services/useLocalStorage';
import useLocationForm from '../../Services/useLocationForm';
import Select from 'react-select';
import { useLoading } from '../../Services/LoadingProvider';

import { useNavigate } from 'react-router-dom';
export default function ConfirmUserDetail() {
    const [jwt, setJwt] = useLocalState('jwt', '')
    const [user, setUser] = useLocalState('user', null)
    const [idCart, setIdCart] = useLocalState('idCart', null)
    const [orders, setOrders] = useLocalState('orders', null)
    const loading = useLoading();
    const navigate = useNavigate();
    const [confirm, setConfirm] = useState({
        fullname: user.fullname ? user.fullname : '',
        phone: user.phone ? user.phone : '',
        address: user.address,
        note: user.note ? user.note : '',
    })
    const address = user.address.split(', ')
    const location =
    {
        "city": address[2],
        "district": address[1],
        "ward": address[0]
    }
    const [show, setShow] = useState(false);
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
    const onConfirmChange = async e => {
        const { name, value } = e.target;
        console.log('name', name)
        console.log('value', value)
        await setConfirm(prev => ({
            ...prev,
            [name]: value
        }));

    }
    const handleBuy = async () => {
        const reqBody = {
            ...confirm,
            address: selectedWard.label + ', ' + selectedDistrict.label + ', ' + selectedCity.label,
            idCart: idCart,
            cartLines: orders,
        };
        const response = await fetch('/order/save', {
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Bearer ${jwt}`
            },
            method: "POST",
            body: JSON.stringify(reqBody)
        })

        if (response.status === 200) {
            await loading.setCount(0)
            await setOrders(null)
            navigate("/order")

        } else {
            console.log('Thất bại')
        }
    }

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
                                <Form.Control type="text" name='fullname' value={confirm.fullname} onChange={(e) => onConfirmChange(e)} />
                            </Col>
                            <Col xs={5} className='mx-5'>
                                <Form.Label className='fw-bold'>Phone</Form.Label>
                                <Form.Control type="text" name='phone' value={confirm.phone} onChange={(e) => onConfirmChange(e)} />

                            </Col>

                        </Form.Group>

                        <Form.Group className="confirm__container__address" controlId="formBasicPassword">
                            <Form.Label as={Col} xs={12} className='fw-bold mb-3 mx-2'>Địa chỉ giao hàng</Form.Label>

                            <Select className='confirm__container__address__select'
                                name="cityId"
                                key={`cityId_${selectedCity?.value}`}
                                isDisabled={cityOptions.length === 0}
                                options={cityOptions}
                                onChange={(option) => {
                                    onCitySelect(option)
                                }}
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
                        <Form.Group as={Row} controlId="formBasicEmail" className='confirm__container__note'>
                            <Col xs={12}>
                                <Form.Label className='fw-bold mb-2'>Ghi chú</Form.Label>

                                <Form.Control type="text" name='note' value={confirm.note} onChange={(e) => onConfirmChange(e)} />
                            </Col>


                        </Form.Group>
                        <Form.Group as={Row} controlId="formBasicEmail" className='confirm__container__btn' >
                            <Button className='confirm__container__btn--cancel' onClick={() => handleClose()}>Hủy Bỏ</Button>
                            <Button className='confirm__container__btn--order' onClick={() => handleBuy()}>Đặt Hàng</Button>


                        </Form.Group>



                    </Form>
                </Offcanvas.Body>
            </Offcanvas>
        </>
    )
}
