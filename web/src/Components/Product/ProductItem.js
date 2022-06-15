
import React, { Fragment } from 'react'
import { Card } from 'react-bootstrap'
export default function ProductItem(props) {
    const product = props.productProps;
    const type_display = props.type_display;

    let optrender
    if (type_display === "Card") {
        optrender =
            <Card className='card_item'>
                <Card.Img variant="top" src="/imgs/computer.png" alt='Lỗi tải ảnh' />
                <Card.Body>
                    <Card.Title>{product.brand + ' ' + product.model}</Card.Title>
                    <div className='card_item__icons'>
                        <p className='card_item__icons__icon'><img src='/icons/ic_cpu.png' alt="Lỗi tải icon" className='card_item__icons__icon--width'></img> {product.cpu.code} </p>
                        <p className='card_item__icons__icon'><img src='/icons/ic_weight.png' alt="Lỗi tải icon" className='card_item__icons__icon--width'></img> {product.ram} </p>
                        <p className='card_item__icons__icon'><img src='/icons/ic_memory.png' alt="Lỗi tải icon" className='card_item__icons__icon--width'></img> {product.memory} </p>
                        <p className='card_item__icons__icon'><img src='/icons/ic_monitor.png' alt="Lỗi tải icon" className='card_item__icons__icon--width'></img> {product.monitor} </p>
                    </div>
                    <div className='card_item__price'>
                        <p className='card_item__price--new'> {product.new_price + ' đ'}</p>
                        <p className='card_item__price--old'> {product.original_price + ' đ'}</p>

                    </div>
                    {/* <Card.Link to={`/products/${product.id}`} className='stretched-link' /> */}
                    <a href={`/products/product/${product.id}`} className="stretched-link"> </a>
                </Card.Body>

            </Card>;
    }
    else {
        optrender =
            <>
                <div className='Stack'>
                    <img src='/imgs/computer.png' width={150} alt="Không tải được ảnh" className='Stack__img' />
                    <div className='Stack__info'>
                        <p className='Stack__info__model'>
                            {product.brand + ' ' + product.model}
                        </p>
                        <p className='Stack__info__price'>
                            <label className='Stack__info__price--new'>
                                {product.new_price}
                            </label>
                            <label className='Stack__info__price--old'> {product.original_price}</label>
                        </p>
                    </div>
                </div>
            </>

    }
    return (
        <>{optrender}</>
    )
}
