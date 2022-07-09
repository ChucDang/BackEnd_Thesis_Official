import React, { useEffect, useState } from 'react'
import './style.scss'
import { Container, Row, Col, Button } from 'react-bootstrap';
import ajax from '../../Services/fechServices';
import { useLocalState } from '../../Services/useLocalStorage.js'
import { useLoading } from '../../Services/LoadingProvider';
export default function Cart() {
    const [jwt, setJwt] = useLocalState('jwt', '')
    const [orders, setOrders] = useLocalState('orders', null)
    const loading = useLoading();

    const handleDelete = async (e) => {
        const response = await fetch(`/cart/deleteCartItem/${e.target.value}`, {
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Bearer ${jwt}`
            },
            method: "Delete",
        })

        if (response.status === 200) {
            //Nếu không có await thì sẽ trả về một Promise Object, sau đó gọi json() thì ra
            // lỗi do response là string 
            let result = (await response.text()).toString()
            alert(result)
            const ordersCopy = [...orders];
            const i = ordersCopy.findIndex((item) => item.id === e.target.value);
            ordersCopy.splice(i, 1);
            setOrders(ordersCopy);
            loading.setCount(loading.count - 1)
        }
    }
    // Rerender lại khi Loading thay đổi.
    useEffect(() => {
        console.log("Rerender")
        ajax('/cart', 'GET', jwt).then(async response => {
            let count = response.length
            await loading.setCount(count)
            await setOrders(response)
        })
    }, [loading])
    return (

        <Container fluid className='cart'>

            <Row className='text-primary'>
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

                </Col>
            </Row>
            {orders.length !== 0 ? orders.map(item => {

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
                    <Col className='cart__row__grpbtn'>

                        <Button className='cart__row__grpbtn__btn' variant="danger" value={item.id} onClick={(e) => handleDelete(e)}>Delete</Button>
                    </Col>
                </Row>

            }) :
                <Row className='text-success cart__row'> Bạn chưa có Order nào trong giỏ hàng </Row>
            }
        </Container>
    )
}
