
import React, { useEffect, useState } from 'react'
import { Container, Row, Col, Button, Tabs, Tab } from 'react-bootstrap';
import ajax from '../../Services/fechServices';
import ProductItem from './ProductItem';
import './ProductComponent.scss'
import { Rating } from 'react-simple-star-rating';
import ProductTab from './ProductTab';
import { useLocalState } from '../../Services/useLocalStorage';
import { useLoading } from '../../Services/LoadingProvider';
function ProductDetail() {
    const productId = window.location.href.split("/products/product/")[1]
    const [currentProduct, setCurrentProduct] = useState(null)
    const [productRecommend, setproductRecommend] = useState(null)
    //Amount này là số lượng tùy chỉnh muốn mua
    const [amount, setAmount] = useState(1)
    const [rating, setRating] = useState(0) // initial rating value
    //Tuy chỉ dùng để đọc jwt, nếu gọi trực tiếp localStorage.getItem thì sẽ ra như sau "jwt", 
    // dùng như vầy thì đọc sẽ không có ""
    const [jwt, setJwt] = useLocalState('jwt', null)
    const [idCart, setIdCart] = useLocalState('idCart', null)
    //Count là số order đang có trong giỏ hàng.
    const loading = useLoading()
    // Catch Rating value
    const handleRating = (rate) => {
        setRating(rate)
        // other logic
    }
    useEffect(() => {
        ajax(`/api/products/product/${productId}`, "GET")
            .then((productResponse) => {
                const data = productResponse;
                setCurrentProduct(data)
            }).catch(error => {
                console.log(error);
            })
    }, [productId])
    const handleAddCart = () => {
        const reqBody = {
            productId: currentProduct.id,
            amount: amount
        }
        ajax('/cart/addCart', 'POST', jwt, reqBody).then(res => {
            setIdCart(res)
            loading.setCount(loading.count + 1)
        })

    }
    useEffect(() => {
        let caterCode
        if (currentProduct) {
            caterCode = currentProduct.catergory.code
        } else {
            caterCode = 'phone'
        }
        ajax(`/api/products/catergory/?code=${caterCode}&page=${0}&size=${4}`, "GET")
            .then((productResponse) => {
                let productData = productResponse.product;

                setproductRecommend(productData)
            }).catch(error => {
                console.log(error);
            })
    }, [])

    return (
        <>
            <Container fluid>
                <Row className='row_detail'>
                    <Col xs={3} className='row_detail__recommend'>
                        {
                            productRecommend ? productRecommend.map(item =>

                                <ProductItem
                                    key={item.id}
                                    recommendProps={item}
                                    type_display="Stack"
                                />



                            ) : <></>
                        }
                    </Col>
                    <Col xs={4} className='row_detail__mainimg'>
                        <img src='/imgs/computer.png' alt='Không tải được ảnh' className='row_detail__mainimg--width' />
                    </Col>

                    <Col className='row_detail__description'>
                        {currentProduct ? <>
                            <div className='row_detail__description--name'>{currentProduct.brand + ' ' + currentProduct.model + ' ' + currentProduct.ram.storage +
                                'GB ' + currentProduct.cpu.brand + ' ' + currentProduct.cpu.version + ' ' + currentProduct.cpu.type} </div>

                            <div className='row_detail__description__price'>
                                <p className='row_detail__description__price--new'> {Number(currentProduct.new_price).toLocaleString('vn') + ' đ'}</p>
                                <p className='row_detail__description__price--old'> {Number(currentProduct.original_price).toLocaleString('vn') + ' đ'}</p>

                            </div>
                            <div className='row_detail__description--fontInfo'>{currentProduct.description}</div>
                            <div className='row_detail__description__amount'>
                                <button

                                    className='row_detail__description__amount--minus'
                                    onClick={() => { (amount >= 2) && setAmount(amount - 1) }}

                                >
                                    -
                                </button>
                                <input className='row_detail__description__amount--quantity' value={amount} />
                                <button

                                    className='row_detail__description__amount--plus'
                                    onClick={() => { setAmount(amount + 1) }}

                                >
                                    +
                                </button>
                                <Button className='row_detail__description__amount--cart'
                                    onClick={() => handleAddCart()}>Add to Cart</Button>
                            </div>
                        </> : <> </>
                        }

                    </Col>
                </Row>
                <Row className="tab-section">
                    <Tabs

                        id="uncontrolled-tab-example"
                    >
                        <Tab eventKey="home" title="Thông số chi tiết">
                            <ProductTab product={currentProduct} />
                        </Tab>
                        <Tab className='tab-section__item' eventKey="profile" title="Đánh giá">

                            <Rating className='tab-section__item--stars'
                                onClick={handleRating}
                                ratingValue={rating}
                                initialValue={3.5}
                            />

                            <label>69 người đánh giá</label>
                        </Tab>

                        <Tab eventKey="contact" title="Thông tin bảo hành">
                            <Container className='info-tab'>
                                <Row className='info-tab__row' >
                                    <label className='info-tab__row--item'>
                                        Hàng chính hãng - bảo hành 24 Tháng
                                    </label>
                                    <label className='info-tab__row--item'>
                                        Đổi trả 1 - 1 nếu sản phẩm lỗi
                                    </label>
                                    <label className='info-tab__row--item'>
                                        Trả góp 0%
                                    </label>
                                    <label className='info-tab__row--item'>
                                        Giao hành miễn phí toàn quốc
                                    </label>
                                </Row>
                            </Container>
                        </Tab>
                    </Tabs>
                </Row>
            </Container>


        </>
    )
}

export default ProductDetail