import { useContext } from "react";
import {  Container, Nav, NavDropdown, Navbar } from "react-bootstrap";
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
            <Navbar.Brand as={Link} to="/">Nhóm 21</Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
              <Nav className="me-auto">
                {user ?(
                <>
                    <Nav.Link as={Link} to="/Home">Trang chủ</Nav.Link>
                    <Nav.Link as={Link} to="/ThesisScore">Chấm điểm</Nav.Link>
                    <NavDropdown title="Thiết lập" id="basic-nav-dropdown">
                      <NavDropdown.Item as={Link} to="/ThesisScore">Chấm điểm</NavDropdown.Item>
                      <NavDropdown.Item as={Link} to="#">Vai trò thành viên hội đồng</NavDropdown.Item>
                      <NavDropdown.Item as={Link} to="#">Khóa luận</NavDropdown.Item>
                      <NavDropdown.Divider />
                      <NavDropdown.Item as={Link} to="#">Giảng viên hướng dẫn</NavDropdown.Item>
                      <NavDropdown.Item as={Link} to="#">Sinh viên tham gia</NavDropdown.Item>
                      <NavDropdown.Divider />
                      <NavDropdown.Item href="#action/3.4">Tiêu chí</NavDropdown.Item>
                    </NavDropdown>
                    </>
                ) : null}
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
                    <NavDropdown.Item eventKey={1.3} as={Link} to="/Login" onClick={logout }>
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