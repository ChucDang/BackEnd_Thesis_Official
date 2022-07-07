import React, { useState, useEffect } from 'react'
import { Row, Pagination } from 'react-bootstrap';
import ajax from "../../Services/fechServices";
import ProductItem from './ProductItem';
import './ProductComponent.scss'
import '../Loading/Loading.css';
import ErrorPage from '../ErrorPage/ErrorPage';
import Loading from '../Loading/Loading';
import { useLoading } from '../../Services/LoadingProvider';
const ProductComponent = () => {
    const isLoading = useLoading();
    let catergoryCode = window.location.href.split("/products/catergory/")[1];
    if (!catergoryCode) catergoryCode = 'phone'
    const [products, setProducts] = useState(null)
    const [page, setPage] = useState({
        page: 0,
        size: 2,
        total: ''
    })
    //Tính toán số trang
    let active = page.page + 1
    let items = [];
    for (let number = 1; number <= page.total; number++) {
        items.push(
            <Pagination.Item key={number} active={number === active} onClick={() => handlePageChange(number)}>
                {number}
            </Pagination.Item>,
        );
    }


    const handlePageChange = (number) => {
        if (number && (number <= page.total))
            setPage({ ...page, page: number - 1 })
    }
    let jwt = localStorage.getItem('jwt')
    useEffect(() => {
        ajax(`/api/products/catergory/?code=${catergoryCode}&page=${page.page}&size=${page.size}`, "GET", jwt)
            .then((productResponse) => {
                isLoading.setIsLoading(false)
                setProducts(productResponse.product)
                setPage({ ...page, total: productResponse.total })
            }).catch(
                <ErrorPage />
            )
    }, [catergoryCode, page.page, page.size])
    return isLoading.isLoading ? (
        <Loading />
    ) :

        <>
            {
                products ? <Row className='catergory_label'> {catergoryCode} </Row> : <></>
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
            <Row className="listPage">
                {
                    page.total > 1 ?
                        <>
                            <Pagination>
                                <Pagination.First onClick={() => handlePageChange(1)} />
                                <Pagination.Prev onClick={() => handlePageChange(page.page)} />
                                {items}
                                <Pagination.Next onClick={() => handlePageChange(page.page + 2)} />
                                <Pagination.Last onClick={() => handlePageChange(page.total)} />
                            </Pagination>

                        </> :
                        <></>
                }
            </Row>

        </>
}
export default ProductComponent
