import React, { useState, useEffect } from 'react'
import { Col, Container, Row } from 'react-bootstrap'
import { useLocalState } from '../../util/useLocalStorage'
import ajax from '../../Services/fechServices'
import ProductItem from './ProductItem'
function ProductDetail() {
    const [jwt, setJwt] = useLocalState("", "jwt")
    const [products, setProducts] = useState(null)
    useEffect(() => {
        ajax("/products", "GET", jwt)
            .then((productResponse) => {
                let productData = productResponse.slice(0, 4)
                setProducts(productData)
            }).catch(error => {
                console.log(error);
            })
    }, [])
    return (
        <>
            <Container fluid>
                <Row className='p-4 font-weight-bold'>Sản phẩm</Row>
                <Row>
                    <Col>
                        {
                            products ? products.map(product =>

                                <ProductItem
                                    key={product.id}
                                    productProps={product}
                                // type_display="Card"
                                />



                            ) : <></>
                        }
                    </Col>
                    <Col xs={4}>
                        <img src='/imgs/computer.png' alt='Không tải được ảnh' className="img_detail"></img>
                    </Col>
                    <Col xs={4}>
                        {
                            products ? products.map(product =>

                                <ProductItem
                                    key={product.id}
                                    productProps={product}
                                // type_display="Card"
                                />



                            ) : <></>
                        }
                    </Col>

                </Row>
            </Container>
            {/* <Col>

                {
                    products ? products.map(product =>

                        <ProductItem
                            key={product.id}
                            productProps={product}
                        // type_display="Card"
                        />



                    ) : <></>
                }
            </Col> */}
        </>
    )
}

export default ProductDetail