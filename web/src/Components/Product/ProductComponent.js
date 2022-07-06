import React, { useState, useEffect } from 'react'
import { Row } from 'react-bootstrap';
import ajax from "../../Services/fechServices";
import ProductItem from './ProductItem';
import './ProductComponent.scss'
import '../Loading/Loading.css';
import { Suspense } from 'react';
import Loading from '../Loading/Loading';
const ProductComponent = () => {
    let catergoryCode = window.location.href.split("/products/catergory/")[1];
    if (!catergoryCode) catergoryCode = 'phone'
    const [products, setProducts] = useState(null)

    useEffect(() => {
        ajax(`/api/products/catergory/${catergoryCode}`, "GET")
            .then((productResponse) => {
                let productData = productResponse;
                setProducts(productData)
            }).catch(error => {
                console.log(error);
            })
    }, [catergoryCode])

    return (
        <Suspense fallback={<Loading />}>
            {
                products ? <Row className='catergory_label'> {products[0].catergory.code} </Row> : <></>
            }


            < Row xs={1} md={2} xl={4} className="justify-content-between mx-4" >
                {
                    products ? products.map(product =>

                        <ProductItem
                            key={product.id}
                            productProps={product}
                            type_display="Card"
                        />




                    ) : <></>}
            </ Row >

        </Suspense>




    )

}
export default ProductComponent
