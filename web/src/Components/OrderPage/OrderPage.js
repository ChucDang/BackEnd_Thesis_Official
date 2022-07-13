import React, { useEffect, useState } from 'react'
import { Badge, Button, Card, Col, Container, Row } from 'react-bootstrap'
import NavBarComponent from '../NavBar/NavBarComponent'
import ajax from '../../Services/fechServices';
import { useLocalState } from '../../Services/useLocalStorage';
import './OrderPage.scss'
export default function OrderPage() {
    const [jwt, setJwt] = useLocalState('jwt', '')
    const [orders, setOrders] = useState([])

    useEffect(() => {
        ajax('/order', 'GET', jwt).then((response) => {
            setOrders(response)
        })
    }, [orders.length, jwt])

    const handleDeleteOrder = async (idOrder) => {
        const response = await fetch(`/order/delete/${idOrder}`, {
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Bearer ${jwt}`
            },
            method: "DELETE",
        })
        alert((await response.text()).toString())
        await setOrders([])
    }
    return (
        <>
            <NavBarComponent />
            <Container>
                {orders ? orders.map(item => {
                    let total = 0
                    return <Card as={Row} className="orderitem">

                        <Card.Header className='orderitem__header'>
                            <div className='orderitem__header--name'>Trần Dương Hoài</div>
                            <div className='orderitem__header--status'><Badge bg="primary">Waiting</Badge></div>

                            <img value={item.id} className='orderitem__header--icon' src='/icons/ic_trash.png' alt="Lỗi tải icon"
                                onClick={() => handleDeleteOrder(item.id)} />


                        </Card.Header>
                        <Card.Body className='orderitem__body'>
                            {item.cartLines.map(line => {

                                total = total + line.product.new_price * line.amount
                                return <>
                                    <div className='orderitem__body__nameproduct'>{line.product.brand + ' ' + line.product.model}</div>
                                    <div className='orderitem__body__info'>Số lượng: {line.amount}</div>
                                    <div className='orderitem__body__info'>Tổng tiền:
                                        {' ' + Number(line.product.new_price * line.amount).toLocaleString('vn') + ' đ'}
                                    </div>
                                    <Card.Text className='orderitem__body__sale'>
                                        Đã áp dụng mã giảm giá 20%
                                    </Card.Text>
                                </>
                            }



                            )}

                            <Row className='.d-flex justify-content-end px-5 py-2'>Tổng cộng: {Number(total).toLocaleString('vn') + ' đ'}</Row>
                        </Card.Body>
                    </Card>
                }
                )


                    : <Row>Bạn chưa có Order nào</Row>}
            </Container>
        </>

    )
}
