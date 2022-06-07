import React, { useState, useEffect } from 'react'
import { Row } from 'react-bootstrap';
import ajax from "../../Services/fechServices";
import { useLocalState } from "../../util/useLocalStorage";
import ProductItem from './ProductItem';
// import AssignmentView from './../AssignmentView';
const ProductComponent = () => {
    const [jwt, setJwt] = useLocalState("", "jwt")
    const [products, setProducts] = useState(null)
    useEffect(() => {
        ajax("/products", "GET", jwt)
            .then((productResponse) => {
                let productData = productResponse;
                console.log("come here")
                setProducts(productData)
            }).catch(error => {
                console.log(error);
            })
    }, [])

    // const deletePr = (employeeId) => {
    //     ProductService.deleteEmployee(employeeId).then((response) => {
    //         getAllProduct();

    //     }).catch(error => {
    //         console.log(error);
    //     })

    // }

    return (
        <Row xs={1} md={2} xl={4} className="justify-content-between mx-4">

            {
                products ? products.map(product =>

                    <ProductItem
                        key={product.id}
                        productProps={product}
                        type_display="Card"
                    />



                ) : <></>
            }
        </Row>
    )
}

export default ProductComponent
