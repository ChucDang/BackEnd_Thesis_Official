import React from 'react'
import { useLoading } from '../../../Services/LoadingProvider';
import { Badge, Dropdown, DropdownButton, Form, FormControl, Nav, Navbar, NavDropdown, Offcanvas } from 'react-bootstrap';
import { useLocalState } from '../../../Services/useLocalStorage';
import LocalMallIcon from '@mui/icons-material/LocalMall';
import MailIcon from '@mui/icons-material/Mail';
import NotificationsIcon from '@mui/icons-material/Notifications';
import { useNavigate } from 'react-router-dom';
export default function ADNavbar() {
  const loading = useLoading();
  const navigate = useNavigate()
  const [jwt, setJwt] = useLocalState('jwt', '')
  const [user, setUser] = useLocalState('user', null)
  async function handle_Logout() {
    await setJwt(null)
    await setUser(null)
    await loading.setDisplayName('')
    await loading.setCount(0)
    alert("Đăng xuất thành công")
    navigate("/");
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
          <span className="mx-3 fs-2 fw-bold align-self-center">Hi-Tech</span>
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
              <Nav.Link href="/products/catergory/phone">Users</Nav.Link>
              <Nav.Link href="/products/catergory/laptop">Dashboard</Nav.Link>
              <Nav.Link href="/products/catergory/clock">Flash-Sale</Nav.Link>
              <NavDropdown
                title="Products"
                id='offcanvasNavbarDropdown-expand-sm'
              >
                <NavDropdown.Item href="#action3">Điện Thoại</NavDropdown.Item>
                <NavDropdown.Item href="#action4">
                  Laptop
                </NavDropdown.Item>

                <NavDropdown.Item href="#action5">
                  Đồng Hồ
                </NavDropdown.Item>
              </NavDropdown>
            </Nav>
            <Form className="d-flex">
              <FormControl
                type="search"
                placeholder="Search"
                className="me-2"
                aria-label="Search"
              />
            </Form>
          </Offcanvas.Body>
        </Navbar.Offcanvas>

        <div className='grpicon'>
          <a href="/cart" className='grpicon__item' >
            <LocalMallIcon />
            {loading.count > 0 && <Badge bg="light" text="dark" className='grpicon__item--badge'>
              {loading.count}
            </Badge>}

          </a>
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
          <a href="#link" className='p-2' >
            {loading.displayName ? <>
              <DropdownButton
                variant="outline-secondary"
                title={loading.displayName}
                id="input-group-dropdown-2"
                align="end"
              >
                <Dropdown.Item href="#">Account</Dropdown.Item>
                <Dropdown.Item href="#">Users</Dropdown.Item>
                <Dropdown.Item href="#">Doashboard</Dropdown.Item>
                <Dropdown.Item href="#">Flash-Sale</Dropdown.Item>
                <Dropdown.Divider />
                <Dropdown.Item onClick={() => handle_Logout()}>Logout</Dropdown.Item>
              </DropdownButton>
            </> : <></>
            }
          </a>
        </div>
      </Navbar>

    </>


  )
}
