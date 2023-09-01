import '../../src/App.css';
import React, { useState, useContext } from 'react';
import {
  MDBBtn,
  MDBContainer,
  MDBCard,
  MDBCardBody,
  MDBIcon,
  MDBRow,
  MDBCol,
}
from 'mdb-react-ui-kit';
import { Button, Container, Form } from 'react-bootstrap';
import Apis, { authApi, endpoints } from "../configs/Apis";
import cookie from "react-cookies";
import { MyUserContext } from '../App';
import { Navigate } from 'react-router';

const Login = () => {
  const [user, dispatch] = useContext(MyUserContext);
  const [username, setUsername] = useState();
  const [password, setPassword] = useState();

  const login = (evt) => {
    evt.preventDefault();

    const process = async () => {
    try {
        let res = await Apis.post(endpoints['login'],{
        "username": username,
        "password": password
      });
      cookie.save("token", res.data);

      let {data} = await authApi().get(endpoints['current-user']);
      cookie.save("user", data);

      dispatch({
        "type": "login",
        "payload": data
      });
    } catch (ex) {
        window.alert("Đăng nhập thất bại")
        console.error(ex)
      }
    }
    process();
  }
  if (user !== null)
    return <Navigate to="/"/>
  return <>
    <Container>
      <MDBContainer fluid className='my-5'>

        <MDBRow className='g-0 align-items-center'>
          <MDBCol col='6'>

            <MDBCard className='my-5 cascading-right' style={{background: 'hsla(0, 0%, 100%, 0.55)',  backdropFilter: 'blur(30px)'}}>
              <MDBCardBody className='p-5 shadow-5'>

                <h2 className="fw-bold mb-5  text-center">Đăng nhập</h2>
                <Form onSubmit={login}>
                  <Form.Group className='mb-3'>
                    <Form.Label>Tài khoản</Form.Label>
                    <Form.Control wrapperClass="mb-4" id="form3" type="text"
                    value={username} onChange={e => setUsername(e.target.value)}/>
                  </Form.Group>
                  <Form.Group className='mb-3'>
                    <Form.Label>Mật khẩu</Form.Label>
                    <Form.Control wrapperClass="mb-4" id="form4" type="password"
                    value={password} onChange={e => setPassword(e.target.value)}/>
                  </Form.Group>
                  <Form.Group className='mb-3'>
                    <Button type="submit" className='w-100 mb-4' size='md'>Đăng nhập</Button>
                  </Form.Group>
                </Form>
                <div className="text-center">

                  <p>or sign up with:</p>

                  <MDBBtn tag='a' color='none' className='mx-3' style={{ color: '#1266f1' }}>
                    <MDBIcon fab icon='facebook-f' size="sm"/>
                  </MDBBtn>

                  <MDBBtn tag='a' color='none' className='mx-3' style={{ color: '#1266f1' }}>
                    <MDBIcon fab icon='twitter' size="sm"/>
                  </MDBBtn>

                  <MDBBtn tag='a' color='none' className='mx-3' style={{ color: '#1266f1' }}>
                    <MDBIcon fab icon='google' size="sm"/>
                  </MDBBtn>

                  <MDBBtn tag='a' color='none' className='mx-3' style={{ color: '#1266f1' }}>
                    <MDBIcon fab icon='github' size="sm"/>
                  </MDBBtn>

                </div>
              
              </MDBCardBody>
            </MDBCard>
          </MDBCol>

          <MDBCol col='6'>
            <img src="https://mdbootstrap.com/img/new/ecommerce/vertical/004.jpg" class="w-100 rounded-4 shadow-4"
              alt="" fluid/>
          </MDBCol>

        </MDBRow>

      </MDBContainer>
    </Container>
    </>;
}

export default Login;