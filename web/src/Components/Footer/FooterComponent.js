
import React from 'react'
import { Col, Container, Row } from 'react-bootstrap'
import './Footer.scss'
function FooterComponent() {
    return (
        <Container fluid className='footer'>
            <Row>
                <Col xs={3} className="footer__header"> ĐIỀU HƯỚNG</Col>
                <Col xs={6}>
                    <div className="footer__logo" >
                        <img
                            alt="Không load được hình"
                            src="/icons/ic_store.png"
                            className='footer__logo--img'
                        />
                        <span className="footer__logo--brand">MY LIFE</span>
                    </div>
                    <div className='footer__slogan'>Hãy tận hưởng những tiện ích từ hệ sinh thái của chúng tôi</div>
                    <input type='email' placeholder='Email' className='footer__email'></input>
                </Col>
                <Col>
                    <div className="footer__header">THÔNG TIN LIÊN HỆ</div>
                    <div className='footer--normal'>108/17 Trần Quang Diệu, An Thới, Bình Thủy, Cần Thơ</div>
                    <div className='footer--normal'>0868285890</div>
                    <div className='footer--normal'>violympic1998@gmail.com</div>
                    <div className='footer--normal'>chucb1706677@student.ctu.edu.vn</div>
                </Col>
            </Row>
        </Container>
    )

}
export default FooterComponent