import { Container, Nav, NavDropdown, Navbar } from "react-bootstrap";
import { Link } from "react-router-dom";
const Header = () => {
  const headerStyle = {
    marginBottom: 20,
  };
    return (
        <Navbar expand="lg" className="bg-body-tertiary" style={headerStyle}>
          <Container>
            <Navbar.Brand href="#home">Nhóm 21</Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
              <Nav className="me-auto">
                <Nav.Link as={Link} to="/">Trang chủ</Nav.Link>
                <Nav.Link href="#link">Link</Nav.Link>
                <NavDropdown title="Dropdown" id="basic-nav-dropdown">
                  <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
                  <NavDropdown.Item href="#action/3.2">
                    Another action
                  </NavDropdown.Item>
                  <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
                  <NavDropdown.Divider />
                  <NavDropdown.Item href="#action/3.4">
                    Separated link
                  </NavDropdown.Item>
                </NavDropdown>
                <Nav.Link as={Link} to="Login">Đăng nhập</Nav.Link>
              </Nav>
            </Navbar.Collapse>
             {/* Right links */}
             <Nav pullRight>
            <NavDropdown eventKey={1} 
                title={
                    <div className="pull-left">
                        <img src='https://mdbootstrap.com/img/new/avatars/2.jpg'
                              className='rounded-circle'
                              height='40'
                              alt='Avatar'
                              loading='lazy'
                        />
                    </div>
                } 
                id="basic-nav-dropdown">

                <NavDropdown.Item eventKey={1.1} as={Link} to="/UserInfo">Thông tin tài khoản</NavDropdown.Item>
                <NavDropdown.Item divider />
                <NavDropdown.Item eventKey={1.3} as={Link} to="/Login">
                    <div className="fa fa-sign-out">Thoát</div>
                </NavDropdown.Item>
            </NavDropdown>
        </Nav>
          </Container>
        </Navbar>
      );
}

export default Header;