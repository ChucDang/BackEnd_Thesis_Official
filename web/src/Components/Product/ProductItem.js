
import React from 'react'
import { Card } from 'react-bootstrap'
export default function ProductItem(props) {

    const type_display = props.type_display;
    const product = props.productProps;
    const item = props.recommendProps;

    let optrender
    if (type_display === "Card") {

        optrender =
            <Card className='card_item'>
                <Card.Img variant="top" src="/imgs/computer.png" alt='Lỗi tải ảnh' />
                <Card.Body>
                    <Card.Title>{product.brand + ' ' + product.model}</Card.Title>
                    <div className='card_item__icons'>
                        <p className='card_item__icons__icon'><img src='/icons/ic_cpu.png' alt="Lỗi tải icon" className='card_item__icons__icon--width'></img> {product.cpu.version} </p>
                        <p className='card_item__icons__icon'><img src='/icons/ic_weight.png' alt="Lỗi tải icon" className='card_item__icons__icon--width'></img> {product.weight} </p>
                        <p className='card_item__icons__icon'><img src='/icons/ic_memory.png' alt="Lỗi tải icon" className='card_item__icons__icon--width'></img> {product.storage.storage} </p>
                        <p className='card_item__icons__icon'><img src='/icons/ic_size.png' alt="Lỗi tải icon" className='card_item__icons__icon--width'></img> {product.screen.size + ' inch'} </p>
                        <p className='card_item__icons__icon'><img src='/icons/ic_monitor.png' alt="Lỗi tải icon" className='card_item__icons__icon--width'></img> {product.screen.tech + ' ' + product.screen.standard} </p>
                    </div>
                    <div className='card_item__price'>
                        <p className='card_item__price--new'> {Number(product.new_price).toLocaleString('vn') + ' đ'}</p>
                        <p className='card_item__price--old'> {Number(product.original_price).toLocaleString('vn') + ' đ'}</p>

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
                            {item.brand + ' ' + item.model}
                        </p>
                        <p className='Stack__info__price'>
                            <p className='Stack__info__price--new'>
                                {Number(item.new_price).toLocaleString('vn') + 'đ'}
                            </p>
                            <p className='Stack__info__price--old'>
                                {Number(item.original_price).toLocaleString('vn') + 'đ'}
                            </p>
                        </p>
                    </div>
                    <a href={`/products/product/${item.id}`} className="stretched-link"> </a>

                </div>

            </>

    }
    return (
        <>{optrender}</>
    )
}
