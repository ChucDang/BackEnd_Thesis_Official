import React from 'react'
import { useState } from 'react';
import { Button, Col, Container, Form, FormControl, Offcanvas, Row } from 'react-bootstrap'
import Select from 'react-select';
import { ROLE_ENUM } from '../../Constants/roles';
export default function EditButton({ user }) {
    console.log('User trong props', user)
    const [show, setShow] = useState(false);
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const roles = [
        {
            label: "Quản trị",
            value: ROLE_ENUM.ADMIN,
        },
        {
            label: "Nhân Viên",
            value: ROLE_ENUM.STAFF,
        }
    ];
    const status = [
        {
            label: "Enable",
            value: true,
        },
        {
            label: "Disable",
            value: false,
        },
    ]

    return (
        <>
            <Button variant='success' className='me-2' onClick={handleShow}>Edit</Button>
            <Offcanvas show={show} onHide={handleClose} placement='center' className='edit'>
                <Offcanvas.Header closeButton>
                    <Offcanvas.Title className='fs-2 fw-bold align-self-center'>Edit User</Offcanvas.Title>
                </Offcanvas.Header>
                <Offcanvas.Body>
                    <Form>
                        <Row>
                            <Form.Group className="mb-3">
                                <Form.Text className="text-dark ">
                                    Thông tin Account
                                </Form.Text>
                                <Form.Text className="text-success ">
                                    Bạn không thể chỉnh sửa ở vùng này
                                </Form.Text>
                            </Form.Group>
                        </Row>
                        <Row>
                            <Form.Group as={Col} xs={4} >
                                <Form.Label>Họ và tên</Form.Label>
                                <Form.Control type="text" value={user.fullname} readOnly />
                            </Form.Group>
                            <Form.Group as={Col} xs={4} >
                                <Form.Label>Số điện thoại</Form.Label>
                                <Form.Control type="text" value={user.phone} readOnly />
                            </Form.Group>

                        </Row>
                        <Row>
                            <Form.Group as={Col} xs={6} >
                                <Form.Label>Email</Form.Label>
                                <Form.Control type="text" value={user.email} readOnly />
                            </Form.Group>
                            <Form.Group as={Col} xs={2} >
                                <Form.Label>Giới tính</Form.Label>
                                <Form.Control type="text" value={user.gender ? 'Nam' : 'Nữ'} readOnly />
                            </Form.Group>

                        </Row>
                        <Row>
                            <Form.Group className="mb-3">
                                <Form.Text className="text-dark ">
                                    Phân quyền và thiết lập trạng thái
                                </Form.Text>

                            </Form.Group>
                        </Row>
                        <Row>
                            <Form.Group as={Col} xs={4}>
                                <Form.Label>Authority</Form.Label>
                                <Select as={FormControl}
                                    name="roleId"
                                    // key={`roleId${selectedDistrict?.value}`}
                                    options={roles}
                                    // onChange={(option) => onDistrictSelect(option)}
                                    defaultValue={user.authorities[0].authority}
                                // value={selectedDistrict}
                                />
                            </Form.Group>
                            <Form.Group as={Col} className="mb-3" xs={3}>
                                <Form.Label className="text-dark ">
                                    Trạng thái hoạt động
                                </Form.Label>
                                <Select as={FormControl}
                                    name="statusId"
                                    // key={`roleId${selectedDistrict?.value}`}
                                    options={status}
                                    // onChange={(option) => onDistrictSelect(option)}
                                    defaultValue={true}
                                // value={selectedDistrict}
                                />
                            </Form.Group>

                        </Row>

                        <Form.Group as={Row}>
                            <Form.Label>Ghi chú</Form.Label>
                            <Form.Control type='text'></Form.Control>
                        </Form.Group>



                    </Form>
                </Offcanvas.Body>
            </Offcanvas>
        </>
    )
}
