import React, { useEffect, useState } from 'react'
import { Badge, Button, Card, Col, Container, Row } from 'react-bootstrap'
import NavBarComponent from '../NavBar/NavBarComponent'
import ajax from '../../Services/fechServices';
import { useLocalState } from '../../Services/useLocalStorage';
import './OrderPage.scss'
import { useLoading } from '../../Services/LoadingProvider';
import Loading from '../Loading/Loading';
import DeleteIcon from '@mui/icons-material/Delete';
export default function OrderPage() {
    const [jwt, setJwt] = useLocalState('jwt', '')
    const [orders, setOrders] = useState([])
    const loading = useLoading();
    useEffect(() => {
        ajax('/order', 'GET', jwt).then(async (response) => {
            const result = await response.json()
            await setOrders(result)
            loading.setIsLoading(false)
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
    return (loading.isLoading ? (
        <Loading />
    ) : <>
        <NavBarComponent />
        <Container>
            {orders.length ? orders.map(item => {
                let total = 0
                return <Card as={Row} className="orderitem">

                    <Card.Header className='orderitem__header'>
                        <div className='orderitem__header--name'>Trần Dương Hoài</div>
                        <div className='orderitem__header--status'><Badge bg="success">Waiting</Badge></div>
                        < DeleteIcon className='orderitem__header--icon' onClick={() => handleDeleteOrder(item.id)} />
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

                        <Row className='.d-flex justify-content-end px-5 pt-2'>Tổng cộng: {Number(total).toLocaleString('vn') + ' đ'}</Row>
                    </Card.Body>
                </Card>
            }
            )


                :
                <div className='noticeNoneValue'>Hiện tại bạn chưa có Order nào trên hệ thống</div>}
        </Container>
    </>

    )
}
