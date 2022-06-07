import React from 'react'
import { Card, Button } from 'react-bootstrap'
export default function ProductItem(props) {
    const product = props.productProps;
    const type_display = props.type_display;
    let optrender
    if (type_display === "Card") {
        optrender =
            <Card className='item_product'>
                <Card.Img variant="top" src="/imgs/computer.png" alt='Lỗi tải ảnh' />
                <Card.Body>
                    <Card.Title>{product.id}</Card.Title>
                    <Card.Text>
                        <span> {product.name}</span>
                    </Card.Text>
                    <Card.Text>

                    </Card.Text>
                    <Button variant="primary">Go somewhere</Button>
                </Card.Body>
            </Card>;
    } else {
        optrender =
            <div className='bg-primary my-2'>
                <img src='/imgs/computer.png' width={150} alt="Không tải được ảnh" className='mx-1' />
                {product.name}
            </div>;
    }
    return (
        // Hiển thị dạng Card
        // <Card className='item_product'>
        //     <Card.Img variant="top" src="/imgs/computer.png" alt='Lỗi tải ảnh' />
        //     <Card.Body>
        //         <Card.Title>{product.id}</Card.Title>
        //         <Card.Text>
        //             <span> {product.name}</span>
        //         </Card.Text>
        //         <Card.Text>

        //         </Card.Text>
        //         <Button variant="primary">Go somewhere</Button>
        //     </Card.Body>
        // </Card>
        <>{optrender}</>


    )
}
