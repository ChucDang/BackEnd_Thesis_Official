import React, { useEffect, useState } from 'react'
import { Button, Col, Container, Form, Offcanvas, Row } from 'react-bootstrap';
import ajax from '../../Services/fechServices';
import { useLoading } from '../../Services/LoadingProvider';
import ADNavbar from '../Components/NavBar/ADNavbar';
import OffCanvasCreateCPU from '../Components/OffCanvas/OffCanvasCreateCPU';
import './EditProductAdmin.scss'
import OffCanvasCreateRAM from '../Components/OffCanvas/OffCanvasCreateRAM';
import OffCanvasCreateStorage from '../Components/OffCanvas/OffCanvasCreateStorage';
import OffCanvasCreateSCREEN from '../Components/OffCanvas/OffCanvasCreateSCREEN';
import { Input, InputGroup, InputGroupText } from 'reactstrap';
import { Link, Navigate } from 'react-router-dom';


export default function EditProductAdmin() {

    const loading = useLoading()
    const [optBrands, setOptBrands] = useState([])
    const [optCPUs, setOptCPUs] = useState([])
    const [optScreen, setOptScreens] = useState([])
    const [optRams, setOptRams] = useState([])
    const [optStorages, setOptStorages] = useState([])
    const productId = window.location.href.split("/admin/product/create/")[1]
    const [file, setFile] = useState('');
    const [previewFile, setPreviewFile] = useState('');
    //Do component này dùng cả cho trang edit lẫn Create nên cần tạo state ban đầu tất cả thuộc tính
    // Nếu chỉ trang edit thôi thì không cần.
    // Lưu ý, các trường trống không nên để null, vì trong thẻ select sẽ không chấp nhận value = null
    const [editProduct, setEditProduct] = useState({
        amortization: '',
        amount: '',
        brand: { id: '', category: { id: '', code: '', name: '', }, name: '' },
        camera: "",
        cpu:
        {
            brand: '', buffer: '', bus: '', core: '', id: '', max_speed: '', sp_64bits: '', speed: '', thread: '',
            type: '', version: ''
        },
        description: '',
        display: '',
        feature: '',
        graphic: '',
        id: '',
        material: '',
        model: '',
        new_price: '',
        origin: '',
        original_price: '',
        os: '',
        pin: '',
        ram: { id: '', type: '', storage: '', speed: '', supportMaxSpeed: '' },
        rate: '',
        release_date: '',
        remainSlot: '',
        screen: {
            color: '',
            frequent: '',
            id: '',
            material: '',
            resolution: '',
            size: '',
            standard: '',
            tech: '',
        },
        selfie: '',
        size: '',
        slot: '',
        storage: { id: '', code: '', storage: '', type: '', supportOptane: '' },
        video: '',
        warranty: '',
        weight: ''
    })
    useEffect(() => {
        if (Number(productId)) {
            ajax(`/api/products/product/${productId}`, "GET")
                .then(async (productResponse) => {
                    const data = await productResponse.json();
                    // let cpuObj, ramObj, screenObj, storageObj
                    console.log('data', data)
                    setEditProduct(data)
                    handleGetBrands(data.brand.category.code)


                }).catch(error => {
                    console.log(error);
                })
        } else {
            setOptBrands('')
            setOptCPUs('')
            setOptRams('')
            setOptStorages('')
            setOptScreens('')
            loading.setIsLoading(false)
        }


    }, [])

    const handleGetBrands = (code) => {
        ajax(`/categories/${code}`, 'GET').then(async response => {

            let result = await response.json()
            console.log('result', result)
            setOptBrands(result.brands)
            setOptCPUs(result.cpus)
            setOptRams(result.rams)
            setOptStorages(result.storages)
            setOptScreens(result.screens)
            loading.setIsLoading(false)
        })
    }
    const handleCreateProduct = () => {
        const formData = new FormData();
        formData.append('file', file);
        formData.append('product', JSON.stringify(editProduct))

        fetch('/api/products/createOne', {
            method: 'post',
            body: formData,
            headers: {
                'Authorization': `Bearer ${loading.jwt}`
            }

        }).then(async res => {

            let result = (await res.json())
            alert(result.message)

        });

    }

    return (

        <>
            <ADNavbar />

            {editProduct && editProduct.brand.category ?

                <>


                    <Container fluid className='editProduct'>
                        <Row className='editProduct__header'>Thông Tin Chung</Row>
                        <Form as={Row} className='editProduct__body'>
                            <Form.Group as={Col} xs={3} md={2}>
                                <Form.Label>Category*</Form.Label>
                                <Form.Select
                                    key='category'
                                    value={editProduct.brand.category.code ? editProduct.brand.category.code : ''}
                                    onChange={(e) => {
                                        setEditProduct({
                                            ...editProduct,
                                            brand: {
                                                ...editProduct.brand,
                                                category: {
                                                    ...editProduct.brand.category,
                                                    code: e.target.value
                                                }
                                            }
                                        })
                                        handleGetBrands(e.target.value)

                                    }}
                                >
                                    <option></option>
                                    <option key='phone' value="phone">Phone</option>
                                    <option key='laptop' value="laptop">Laptop</option>
                                    <option key='clock' value="clock">Đồng hồ</option>
                                </Form.Select>
                            </Form.Group>
                            <Form.Group as={Col} xs={3} md={2}>
                                <Form.Label>Brand*</Form.Label>
                                <Form.Select
                                    key='brand'
                                    value={editProduct.brand ? editProduct.brand.id : ''}
                                    onChange={(e) => {

                                        setEditProduct({
                                            ...editProduct,
                                            brand: {

                                                ...editProduct.brand,
                                                id: e.target.value
                                            }
                                        })
                                    }}
                                >
                                    <option></option>
                                    {optBrands ? optBrands.map(item => {

                                        return <option key={item.id} value={item.id}>{item.name}</option>
                                    }) : <></>}

                                </Form.Select>
                            </Form.Group>
                            <Form.Group as={Col} xs={6} md={3}>
                                <Form.Label>OS</Form.Label>
                                <Form.Control type='text' value={editProduct.os}
                                    onChange={(e) => {
                                        setEditProduct({
                                            ...editProduct,
                                            os: e.target.value
                                        })
                                    }}
                                ></Form.Control>
                            </Form.Group>
                            <Form.Group as={Col} xs={6} md={2}>
                                <Form.Label>Original Price*</Form.Label>
                                <InputGroup>
                                    <Input type="number"
                                        value={editProduct.original_price ? editProduct.original_price / 1000 : ''}
                                        onChange={(e) => {
                                            setEditProduct({
                                                ...editProduct,
                                                original_price: 1000 * Number(e.target.value)
                                            })
                                        }}
                                    />
                                    <InputGroupText >
                                        ,000 đ
                                    </InputGroupText>
                                </InputGroup>
                            </Form.Group>
                            <Form.Group as={Col} xs={6} md={2}>
                                <Form.Label>New Price*</Form.Label>
                                <InputGroup>
                                    <Input type="number"

                                        value={editProduct.new_price ? editProduct.new_price / 1000 : ''}
                                        onChange={(e) => {
                                            setEditProduct({
                                                ...editProduct,
                                                new_price: e.target.value * 1000
                                            })
                                        }}

                                    />
                                    <InputGroupText>
                                        ,000 đ
                                    </InputGroupText>
                                </InputGroup>
                            </Form.Group>
                            <Form.Group as={Col} xs={6} md={1}>
                                <Form.Label>Hiển thị*</Form.Label>
                                <Form.Select
                                    value={editProduct.display ? editProduct.display : ''}
                                    onChange={(e) => {
                                        setEditProduct({
                                            ...editProduct,
                                            display: e.target.value
                                        })
                                    }}
                                >
                                    <option></option>

                                    <option value={true}>Yes</option>
                                    <option value={false}>No</option>
                                </Form.Select>
                            </Form.Group>
                            <Form.Group as={Col} xs={2} md={2}>
                                <Form.Label>Weight</Form.Label>
                                <Form.Control type='text' value={editProduct.weight}
                                    onChange={(e) => {
                                        setEditProduct({
                                            ...editProduct,
                                            weight: e.target.value
                                        })
                                    }}
                                ></Form.Control>
                            </Form.Group>

                            <Form.Group as={Col} xs={3} md={2}>
                                <Form.Label>Size</Form.Label>
                                <Form.Control type='text' value={editProduct.size}
                                    onChange={(e) => {
                                        setEditProduct({
                                            ...editProduct,
                                            size: e.target.value
                                        })
                                    }}
                                ></Form.Control>
                            </Form.Group>
                            <Form.Group as={Col} xs={6} md={2}>
                                <Form.Label>Warranty</Form.Label>
                                <Form.Control type='number' value={editProduct.warranty}
                                    onChange={(e) => {
                                        setEditProduct({
                                            ...editProduct,
                                            warranty: e.target.value
                                        })
                                    }}
                                ></Form.Control>
                            </Form.Group>
                            <Form.Group as={Col} xs={6} md={2}>
                                <Form.Label>Model*</Form.Label>
                                <Form.Control type='text' value={editProduct.model}
                                    onChange={(e) => {
                                        setEditProduct({
                                            ...editProduct,
                                            model: e.target.value
                                        })
                                    }}></Form.Control>
                            </Form.Group>
                            <Form.Group as={Col} xs={6} md={2}>
                                <Form.Label>Date Release</Form.Label>

                                <Form.Control type="date"
                                    name="dateOfBirth"

                                    value={editProduct.release_date}

                                    onChange={(e) => {
                                        setEditProduct({
                                            ...editProduct,
                                            release_date: e.target.value
                                        })
                                    }} />
                            </Form.Group>
                            <Form.Group as={Col} xs={6} md={2}>
                                <Form.Label>Trả góp*</Form.Label>
                                <Form.Select
                                    value={editProduct.amortization !== '' ? editProduct.amortization : ''}
                                    onChange={(e) => {
                                        setEditProduct({
                                            ...editProduct,
                                            amortization: e.target.value
                                        })
                                    }}
                                >
                                    <option></option>

                                    <option value={true}>Support</option>
                                    <option value={false}>No</option>
                                </Form.Select>
                            </Form.Group>
                            <Form.Group as={Col} xs={6} md={2}>
                                <Form.Label>Slot</Form.Label>
                                <Form.Control type='number' value={editProduct.slot}
                                    onChange={(e) => {
                                        setEditProduct({
                                            ...editProduct,
                                            slot: e.target.value
                                        })
                                    }}></Form.Control>
                            </Form.Group>
                            <Form.Group as={Col} xs={6} md={2}>
                                <Form.Label>Slot Remains</Form.Label>
                                <Form.Control type='number' value={editProduct.remainSlot}
                                    onChange={(e) => {
                                        setEditProduct({
                                            ...editProduct,
                                            remainSlot: e.target.value
                                        })
                                    }}></Form.Control>
                            </Form.Group>
                            <Form.Group as={Col} xs={2} md={6}>
                                <Form.Label>Pin</Form.Label>
                                <Form.Control type='text' value={editProduct.pin}
                                    onChange={(e) => {
                                        setEditProduct({
                                            ...editProduct,
                                            pin: e.target.value
                                        })
                                    }}></Form.Control>
                            </Form.Group>
                        </Form>
                        <Row className='editProduct__header'>Linh Kiện</Row>
                        <Form as={Row} className='editProduct__body'>

                            <Form.Group as={Col} xs={12} md={6}>
                                <Form.Label>CPU</Form.Label>
                                <Row className='editProduct__body__grp' >
                                    <Form.Select
                                        key={`cpu`}
                                        className='editProduct__body__grp__select'
                                        value={editProduct.cpu ? editProduct.cpu.id : ''}
                                        xs={8}
                                        onChange={(e) => {
                                            setEditProduct({
                                                ...editProduct,
                                                cpu: {
                                                    ...editProduct.cpu,
                                                    id: e.target.value
                                                }
                                            })
                                        }}
                                    >
                                        <option></option>
                                        {optCPUs ? optCPUs.map(item => <option key={item.id} value={item.id}>{item.brand + ' ' + item.version + ' ' + item.type + ' ' + item.core + ' core ' + item.thread + ' thread'}</option>) : <></>}


                                    </Form.Select>
                                    <OffCanvasCreateCPU />

                                </Row>
                            </Form.Group>
                            <Form.Group as={Col} xs={12} md={6}>
                                <Form.Label>RAM</Form.Label>
                                <Row className='editProduct__body__grp' >
                                    <Form.Select
                                        key={`ram`}
                                        className='editProduct__body__grp__select'
                                        value={editProduct.ram ? editProduct.ram.id : ''}
                                        xs={8}
                                        onChange={(e) => {
                                            setEditProduct({
                                                ...editProduct,
                                                ram: {
                                                    ...editProduct.ram,
                                                    id: e.target.value
                                                }
                                            })
                                        }}
                                    >
                                        <option></option>
                                        {optRams ? optRams.map(item => <option key={item.id} value={item.id}>{item.type + ' ' + item.storage + ' GB ' + item.speed + ' MHz'}</option>) : <></>}

                                    </Form.Select>
                                    <OffCanvasCreateRAM />
                                </Row>
                            </Form.Group>
                            <Form.Group as={Col} xs={12} md={6}>
                                <Form.Label>Storage</Form.Label>
                                <Row className='editProduct__body__grp' >
                                    <Form.Select
                                        key={`storage`}
                                        className='editProduct__body__grp__select'
                                        value={editProduct.storage ? editProduct.storage.id : ''}
                                        xs={8}
                                        onChange={(e) => {
                                            setEditProduct({
                                                ...editProduct,
                                                storage: {
                                                    ...editProduct.storage,
                                                    id: e.target.value
                                                }
                                            })
                                        }}
                                    >
                                        <option></option>
                                        {optStorages ? optStorages.map(item => <option key={item.id} value={item.id}>{item.type + ' ' + item.code + ' ' + item.storage} {item.supportOptane ? ' Optane' : ''}</option>) : <></>}


                                    </Form.Select>
                                    <OffCanvasCreateStorage />
                                </Row>
                            </Form.Group>
                            <Form.Group as={Col} xs={12} md={6}>
                                <Form.Label>Screen</Form.Label>
                                <Row className='editProduct__body__grp' >
                                    <Form.Select
                                        key={`screen`}
                                        className='editProduct__body__grp__select'
                                        value={editProduct.screen ? editProduct.screen.id : ''}
                                        xs={8}
                                        onChange={(e) => {
                                            setEditProduct({
                                                ...editProduct,
                                                screen: {
                                                    ...editProduct.screen,
                                                    id: e.target.value
                                                }
                                            })
                                        }}
                                    >
                                        <option></option>
                                        {optScreen ? optScreen.map(item => <option key={item.id} value={item.id}> {item.tech + ' ' + item.standard + ' ' + item.size + ' inch ' + item.resolution}</option>) : <></>}


                                    </Form.Select>
                                    <OffCanvasCreateSCREEN />
                                </Row>
                            </Form.Group>
                        </Form>
                        <Row className='editProduct__header'>Tính Năng</Row>

                        <Form.Text className="text-danger">
                            Phân cách mỗi tính năng bằng ký tự&emsp; *
                        </Form.Text><br />

                        <Form.Text className="text-success">
                            Example: Xóa phông nổi bật*Tùy chỉnh ánh sáng thông minh
                        </Form.Text>
                        <Form as={Row} className='editProduct__body'>

                            <Form.Group as={Col} xs={2} md={6}>
                                <Form.Label>Description</Form.Label>
                                <Form.Control as="textarea" rows={4} value={editProduct.description}
                                    onChange={(e) => {
                                        setEditProduct({
                                            ...editProduct,
                                            description: e.target.value
                                        })
                                    }} />
                            </Form.Group>
                            <Form.Group as={Col} xs={2} md={6}>
                                <Form.Label>Camera</Form.Label>
                                <Form.Control as="textarea" rows={4} value={editProduct.camera}
                                    onChange={(e) => {
                                        setEditProduct({
                                            ...editProduct,
                                            camera: e.target.value
                                        })
                                    }} />
                            </Form.Group>
                            <Form.Group as={Col} xs={2} md={6}>
                                <Form.Label>Video</Form.Label>
                                <Form.Control as="textarea" rows={4} value={editProduct.video}
                                    onChange={(e) => {
                                        setEditProduct({
                                            ...editProduct,
                                            video: e.target.value
                                        })
                                    }} />
                            </Form.Group>
                            <Form.Group as={Col} xs={2} md={6}>
                                <Form.Label>Feature</Form.Label>
                                <Form.Control as="textarea" rows={4} value={editProduct.feature}
                                    onChange={(e) => {
                                        setEditProduct({
                                            ...editProduct,
                                            feature: e.target.value
                                        })
                                    }} />
                            </Form.Group>
                            <Form.Group as={Col} xs={2} md={6}>
                                <Form.Label>Graphic</Form.Label>
                                <Form.Control as="textarea" rows={3} value={editProduct.graphic}
                                    onChange={(e) => {
                                        setEditProduct({
                                            ...editProduct,
                                            graphic: e.target.value
                                        })
                                    }} />
                            </Form.Group>
                            <Form.Group as={Col} xs={2} md={6}>
                                <Form.Label>Material</Form.Label>
                                <Form.Control as="textarea" rows={3} value={editProduct.material}
                                    onChange={(e) => {
                                        setEditProduct({
                                            ...editProduct,
                                            material: e.target.value
                                        })
                                    }} />
                            </Form.Group>
                        </Form>
                        <Row className='editProduct__header'>Hình Ảnh</Row>
                        <Form as={Row} className='editProduct__body'>
                            <Col md={5}>
                                <input type="file"

                                    onChange={(e) => {

                                        setPreviewFile(URL.createObjectURL(e.target.files[0]))
                                        setFile(e.target.files[0])

                                    }}
                                />

                            </Col>

                            <Col md={7}>

                                <img src={editProduct.image ? `data:image/png;base64,${editProduct.image.data}` : previewFile} alt='No images' className='editProduct__body--imgwidth' />
                            </Col>


                        </Form>
                        <Row className='editProduct__grpbtn'>
                            <Button className='editProduct__grpbtn--btnSave' variant='success' onClick={handleCreateProduct}>Save</Button>
                            <Link to='/admin/product' className='btn btn-danger editProduct__grpbtn--btnClear'> Cancel</Link>
                        </Row>

                    </Container>

                </>

                : <></>}

        </>
    )
}
