import React from 'react'
import { useState } from 'react';
import { Button, Col, Form, Offcanvas, Row } from 'react-bootstrap';
import { Input, InputGroup, InputGroupText } from 'reactstrap';
import ajax from '../../Services/fechServices';
import { useLoading } from '../../Services/LoadingProvider';
import '../../Components/ErrorPage/style.css';

export default function AddStockButton({ stocks, setStocks }) {
    const loading = useLoading()
    const [show, setShow] = useState(false);
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const [stock, setStock] = useState({
        id: '',
        price: '',
        amount: 0,
        product: '',
        remains: ''
    })
    const handleDisplayProduct = () => {
        ajax(`/api/products/product/${stock.id}`, "GET")
            .then(async (response) => {
                const data = await response.json();
                setStock({
                    ...stock,
                    product: data.brand.name + ' ' + data.model + ' ' + data.cpu.version + ' ' +
                        data.ram.storage + 'GB',
                    remains: data.amount,
                })
            }).catch(error => {
                console.log(error);
            })
    }
    const handleAddStock = () => {
        setStock({
            id: '',
            price: '',
            amount: 0,
            product: '',
            remains: ''
        })
        ajax(`/stock/${stock.id}/${stock.price}/${stock.amount}`, 'POST', loading.jwt).then(async response => {
            let newStocks = await response.json()
            newStocks.sort(function (a, b) { return a.product.id - b.product.id })
            setStocks(newStocks)
            alert('Nhập kho thành công')
        })
        handleClose()
    }

    return (
        <>
            <Button variant='success' style={{
                position: 'fixed',
                right: '3rem',
                bottom: '1rem',
            }} onClick={handleShow}>Nhập Kho</Button>
            <Offcanvas show={show} onHide={handleClose} placement='center'>
                <Offcanvas.Header closeButton>
                    <Offcanvas.Title className='fs-2 fw-bold align-self-center '>Nhập Kho</Offcanvas.Title>
                </Offcanvas.Header>
                <Offcanvas.Body>
                    <Form className='editForm'>
                        <Row>
                            <Form.Group as={Col} xs={6} >
                                <Form.Label>Nhập ID sản phẩm</Form.Label><br />
                                <Form.Text className="text-success">
                                    Thông tin về sản phẩm vừa nhập sẽ được hiển thị tự động
                                </Form.Text>
                                <Form.Control type="number" onChange={(e) => setStock({ ...stock, id: e.target.value })} onBlur={handleDisplayProduct} />
                            </Form.Group>
                        </Row>
                        <Row>
                            <Form.Group as={Col} xs={9} >
                                <Form.Label>Sản phẩm</Form.Label><br />

                                <Form.Control type="text" plaintext readOnly value={stock.product} />
                            </Form.Group>
                            <Form.Group as={Col} xs={3} >
                                <Form.Label>Tồn kho</Form.Label><br />

                                <Form.Control type="number" plaintext readOnly value={stock.remains} />
                            </Form.Group>
                        </Row>
                        <Row>
                            <Form.Group as={Col} xs={4} >
                                <Form.Label>Giá nhập</Form.Label><br />
                                <InputGroup>
                                    <Input type="number" onChange={(e) => setStock({
                                        ...stock,
                                        price: e.target.value * 1000
                                    })} />
                                    <InputGroupText>
                                        ,000 đ
                                    </InputGroupText>
                                </InputGroup>
                                {/* <Form.Control type="number" onChange={(e) => setStock({
                                    ...stock,
                                    price: e.target.value * 1000
                                })}
                                    placeholder=",000 đ" /> */}
                            </Form.Group>
                            <Form.Group as={Col} xs={6} >
                                <Form.Label>Số lượng</Form.Label><br />

                                <Form.Control type="number" onChange={(e) => {
                                    setStock({
                                        ...stock,
                                        amount: e.target.value
                                    })
                                }} />
                            </Form.Group>
                        </Row>
                        <Row className='editFrom__btn'>
                            <Button className='editFrom__btn--save' variant='success' onClick={handleAddStock}>Save</Button>
                            <Button className='editFrom__btn--cancel' variant='danger' onClick={handleClose}>Cancel</Button>
                        </Row>
                    </Form>
                </Offcanvas.Body>
            </Offcanvas>
        </>

    )
}
