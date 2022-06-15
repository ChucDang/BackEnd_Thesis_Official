import React, { useEffect, useState } from 'react'
import { Container, Row, Col } from 'react-bootstrap';
import ajax from '../../Services/fechServices';
import ProductItem from './ProductItem';

function ProductDetail() {
    const productId = window.location.href.split("/products/product/")[1];
    const [currentProduct, setCurrentProduct] = useState(null)
    const [productRecommend, setproductRecommend] = useState(null)
    useEffect(() => {
        ajax(`/api/products/product/${productId}`, "GET")
            .then((productResponse) => {
                const data = productResponse.product;
                setCurrentProduct(data)
            }).catch(error => {
                console.log(error);
            })
    }, [])
    useEffect(() => {
        let caterCode
        if (currentProduct) {
            caterCode = currentProduct.catergory.code
        } else {
            caterCode = 'phone'
        }
        ajax(`/api/products/catergory/${caterCode}`, "GET")
            .then((productResponse) => {
                let productData = productResponse;
                console.log(productData)
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
                            productRecommend ? productRecommend.map(product =>

                                <ProductItem
                                    key={product.id}
                                    productProps={product}
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
                            <div className='row_detail__description--name'>{currentProduct.brand + ' ' + currentProduct.model + ' ' + currentProduct.ram +
                                ' ' + currentProduct.cpu.code} </div>

                            <div className='row_detail__description__price'>
                                <p className='row_detail__description__price--new'> {currentProduct.new_price + ' đ'}</p>
                                <p className='row_detail__description__price--old'> {currentProduct.original_price + ' đ'}</p>

                            </div>
                            <div className='row_detail__description--fontInfo'>{currentProduct.description}</div>
                        </> : <> </>
                        }

                    </Col>
                </Row>

            </Container>


        </>
    )
}

export default ProductDetail