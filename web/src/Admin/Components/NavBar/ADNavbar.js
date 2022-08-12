import React, { useEffect } from 'react'
import { useLoading } from '../../../Services/LoadingProvider';
import { Badge, Dropdown, DropdownButton, Form, FormControl, Nav, Navbar, NavDropdown, Offcanvas } from 'react-bootstrap';
import { useLocalState } from '../../../Services/useLocalStorage';
import LocalMallIcon from '@mui/icons-material/LocalMall';
import MailIcon from '@mui/icons-material/Mail';
import NotificationsIcon from '@mui/icons-material/Notifications';
import { useNavigate } from 'react-router-dom';
import { ROLE_ENUM } from '../../../Constants/roles';
import convert_vi_to_en from '../../../Services/convert_vi_to_en';
export default function ADNavbar({ handleSearch }) {
  const loading = useLoading();
  const navigate = useNavigate()
  const [jwt, setJwt] = useLocalState('jwt', '')
  const [user, setUser] = useLocalState('user', null)
  async function handle_Logout() {

    await loading.setUser(null)
    await loading.setDisplayName('')
    await loading.setJwt('')
    window.localStorage.clear()
    navigate('/')
    alert("Đăng xuất thành công")
  }


  return (
    <>
      <Navbar bg="dark" variant="dark" expand="xl" sticky="top">
        <Navbar.Brand href="/" className='d-flex'>
          <img
            alt="Không load được hình"
            src="/icons/ic_store.png"
            width="50"
            height="50"
            className="d-inline-block align-top"
          />{' '}
          <span className="mx-3 fs-2 fw-bold align-self-center" style={{ color: '#e1dee6', }}>Hi-Tech</span>
        </Navbar.Brand>

        <Navbar.Toggle id="offcanvasNavbarLabel-expand-sm" />
        {/* Test Offcanvas */}
        <Navbar.Offcanvas
          id='offcanvasNavbar-expand-sm'
          aria-labelledby='offcanvasNavbarLabel-expand-sm'
          placement="end"
        >
          <Offcanvas.Header closeButton>
            <Offcanvas.Title id='offcanvasNavbarLabel-expand-sm'>
              Offcanvas
            </Offcanvas.Title>
          </Offcanvas.Header>
          <Offcanvas.Body>
            <Nav className="justify-content-end flex-grow-1 pe-3">
              <Nav.Link href="/admin">Users</Nav.Link>
              <Nav.Link href="/products/category/laptop">Dashboard</Nav.Link>
              <Nav.Link href="/flash_sale">Flash-Sale</Nav.Link>
              <Nav.Link href="/stock">Stocks</Nav.Link>
              <Nav.Link href="/admin/product">Products</Nav.Link>

            </Nav>
            <Form className="d-flex">
              <FormControl
                type="search"
                placeholder="Search"
                className="me-2"
                aria-label="Search"
                onChange={(e) => handleSearch(e.target.value)}
              />
            </Form>
          </Offcanvas.Body>
        </Navbar.Offcanvas>

        <div className='grpicon'>
          <a href="/cart" className='grpicon__item' >
            <NotificationsIcon />
            <Badge bg="light" text="dark" className='grpicon__item--badge'>
              10
            </Badge>
          </a>
          <a href="#link" className='grpicon__item' >
            <MailIcon />
            <Badge bg="light" text="dark" className='grpicon__item--badge'>
              10
            </Badge>
          </a>

          {loading.displayName ? <>
            <DropdownButton
              variant="outline-secondary"
              title={loading.displayName}
              id="input-group-dropdown-2"
              align="end"
            >
              <Dropdown.Item href="/admin">Users</Dropdown.Item>
              <Dropdown.Item href="#">Doashboard</Dropdown.Item>
              <Dropdown.Item href="#">Flash-Sale</Dropdown.Item>
              <Dropdown.Divider />
              <Dropdown.Item onClick={() => handle_Logout()}>Logout</Dropdown.Item>
            </DropdownButton>
          </> : <></>
          }
        </div>
      </Navbar>

    </>


  )
}
