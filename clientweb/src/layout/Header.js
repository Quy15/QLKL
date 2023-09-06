import { useContext } from "react";
import { Container, Nav, NavDropdown, Navbar } from "react-bootstrap";
import { Link } from "react-router-dom";
import { MyUserContext } from "../App";
const Header = () => {
  const [user, dispatch] = useContext(MyUserContext);
  const logout = () => {
    dispatch({
      "type": "logout"
    })
  }
  // const headerStyle = {
  //   marginBottom: 20,
  // };
  return <>
    <Navbar expand="lg" className="bg-body-tertiary">
      <Container>
        <Navbar.Brand as={Link} to="/">
          <div  style={{width:'50px', height:"50px"}}>
          <img src="https://res.cloudinary.com/dt3oasocf/image/upload/v1691420822/logo_pikxic.png" class="img-fluid" alt="" 
          style={{width:'100%', height:"100%"}}/>
          </div>
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            {user && user.userRole === "ROLE_GV" ? (
              <>
                <Nav.Link as={Link} to="/">Trang chủ</Nav.Link>
                <Nav.Link as={Link} to="/ThesisScore">Chấm điểm</Nav.Link>
              </>
            ) : user && user.userRole === "ROLE_SV" ? (
              <>
                <Nav.Link as={Link} to="/">Trang chủ</Nav.Link>
                <Nav.Link as={Link} to="/ViewScore">Điểm</Nav.Link>
              </>
            ) : user && user.userRole === null}
          </Nav>
        </Navbar.Collapse>
        {/* Right links */}
        <Nav pullRight>
          {user === null ? <Nav.Link as={Link} to="Login" className="btn-get-started">Đăng nhập</Nav.Link> : <>
            <Nav.Link as={Link} to="Login" style={{ color: 'black', fontWeight: 'bold' }}>Chào {user.username}</Nav.Link>
            <NavDropdown eventKey={1}
              title={
                <div className="pull-left">
                  <img src={user.avatar}
                    className='rounded-circle'
                    height='40'
                    alt='Avatar'
                    loading='lazy'
                  />
                </div>
              }
              id="basic-nav-dropdown">

              <NavDropdown.Item eventKey={1.1} as={Link} to="/UserInfo" >Thông tin tài khoản</NavDropdown.Item>
              <NavDropdown.Item divider />
              <NavDropdown.Item eventKey={1.3} as={Link} to="/Login" onClick={logout}>
                <div className="fa fa-sign-out">Thoát</div>
              </NavDropdown.Item>
            </NavDropdown>
          </>}
        </Nav>
      </Container>
    </Navbar>
  </>;
}

export default Header;