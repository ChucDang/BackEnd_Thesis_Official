import React, { useEffect, useRef, useState } from 'react'
import './style.scss'
import { Container, Row, Col, Button } from 'react-bootstrap';
import ajax from '../../Services/fechServices';
import { useLocalState } from '../../Services/useLocalStorage.js'
import { useLoading } from '../../Services/LoadingProvider';
import { EnergySavingsLeaf } from '@mui/icons-material';
import { useNavigate } from 'react-router-dom';
import ConfirmUserDetail from './ConfirmUserDetail';
export default function Cart() {
    const [jwt, setJwt] = useLocalState('jwt', '')
    const [idCart, setIdCart] = useLocalState('idCart', null);
    const [orders, setOrders] = useLocalState('orders', null)
    const loading = useLoading();
    const totalPrice = useRef(0);
    const navigate = useNavigate();
    //handleDelete cần thực thi the sync để cập nhật lại ngay orders khi bấm button Delete
    const handleDelete = async (e) => {
        const response = await fetch(`/cart/deleteCartItem/${e.target.value}`, {
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Bearer ${jwt}`
            },
            method: "Delete",
        })

        if (response.status === 200) {
            const ordersCopy = [...orders];
            const i = ordersCopy.findIndex((item) => item.id === e.target.value);
            ordersCopy.splice(i, 1);
            await setOrders(ordersCopy);
            loading.setCount(loading.count - 1)
        }
    }

    const handleBuy = async () => {
        const reqBody = {
            idCart: idCart,
            cartLineList: orders,
        };
        const response = await fetch(`/order/save`, {
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Bearer ${jwt}`
            },
            method: "POST",
            body: JSON.stringify(reqBody)
        })

        if (response.status === 200) {
            loading.setCount(0)
            setOrders(null)
            navigate("/order")

        } else {
            console.log('Thất bại')
        }
    }
    // Rerender lại khi Loading thay đổi.
    useEffect(() => {
        totalPrice.current = 0
        console.log("Rerender")

        ajax('/cart', 'GET', jwt).then(async response => {
            await loading.setCount(0)
            if (typeof response !== 'undefined') {
                setIdCart(response.idCart)
                await loading.setCount(response.cartLineList.length)
                await setOrders(response.cartLineList)
            } else {
                await setOrders(null)
            }

        })
    }, [loading, totalPrice.current, jwt])
    return (

        <Container fluid className='cart'>
            <Row className='cart__label'>
                <Col>
                    Tên sản phẩm
                </Col>
                <Col> Hình ảnh minh họa</Col>
                <Col>
                    Giá khuyến mãi
                </Col>
                <Col>
                    Giá gốc
                </Col>
                <Col>
                    Số lượng
                </Col>
                <Col>
                    Số tiền
                </Col>
                <Col>
                    Quản lý
                </Col>
            </Row>
            {orders !== null ? orders.map(item => {
                totalPrice.current = totalPrice.current + item.product.new_price * item.amount

                //Row và return phải cùng hàng, xuống hàng thì sẽ lỗi
                return <Row className='cart__row' key={item.id}>
                    <Col>
                        {item.product.brand + ' ' + item.product.model}
                    </Col>
                    <Col >
                        <img className='cart__row__img' src='/imgs/computer.png' alt='Nothing to display' />
                    </Col>
                    <Col >
                        {Number(item.product.new_price).toLocaleString('vn') + ' đ'}
                    </Col>
                    <Col className='cart__row--strikethrough'>
                        {Number(item.product.original_price).toLocaleString('vn') + ' đ'}
                    </Col>
                    <Col>
                        {item.amount}
                    </Col>
                    <Col>{Number(item.product.new_price * item.amount).toLocaleString('vn') + ' đ'}</Col>
                    <Col className='cart__row__grpbtn'>
                        <Button className='cart__row__grpbtn__btn--margin' variant="success" value={item.id} >Buy</Button>

                        <Button className='cart__row__grpbtn__btn' variant="danger" value={item.id} onClick={(e) => {
                            handleDelete(e)
                            totalPrice.current = totalPrice.current - item.product.new_price * item.amount
                        }}>Delete</Button>
                    </Col>
                </Row>

            }
            ) :
                <Row className='text-success cart__row'> Bạn chưa có Order nào trong giỏ hàng </Row>
            }

            {totalPrice.current !== 0 &&
                (<Row className='cart__label'>
                    <Col>

                    </Col>
                    <Col> </Col>
                    <Col>

                    </Col>
                    <Col>

                    </Col>
                    <Col>
                        Tổng cộng
                    </Col>
                    <Col>
                        {Number(totalPrice.current).toLocaleString('vn') + ' đ'}

                    </Col>
                    <Col>
                        {/* <Button className='cart__label__btn' variant="success" onClick={() => handleBuy()}>Đặt hàng</Button> */}
                        <ConfirmUserDetail />
                    </Col>
                </Row>)
            }
        </Container>
    )
}
