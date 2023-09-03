import React, { useContext, useState } from 'react';
import {
  MDBCol,
  MDBContainer,
  MDBRow,
  MDBCard,
  MDBCardText,
  MDBCardBody,
  MDBCardImage,
} from 'mdb-react-ui-kit';
import {  Button, Col, Container, Form } from 'react-bootstrap';
import { MyUserContext } from '../App';
import Apis, { endpoints } from '../configs/Apis';
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const UserInfo = () => {
  const [oldPassword, setOldPassword] = useState('');
  const [newPassword, setNewPassword] = useState('');
  const [confirmNewPassword, setConfirmNewPassword] = useState('');
  
  const [showChangePasswordForm, setShowChangePasswordForm] = useState(false);
  const [user] = useContext(MyUserContext);
  console.info(user)
  const handleToggleForm = () => {
    setShowChangePasswordForm(!showChangePasswordForm);
  };
  const handleCancel = () => {
    setShowChangePasswordForm(false);
  };
  const handleSubmit = (event) => {
    event.preventDefault();
    if (!oldPassword || !newPassword || !confirmNewPassword) {
      toast.warning("Vui lòng điền đủ thông tin mật khẩu !!")
      return;
    }
    if (newPassword !== confirmNewPassword) {
      toast.warning("Mật khẩu nhập lần hai không chính xác !!")
      return;
    }
    
    const process = async () => {
        try {
            let res = await Apis.post(endpoints['change-password'],{
              "username": user.username,
              "oldPassword": oldPassword,
              "newPassword": newPassword
          });
          if (res.status === 200) {
            toast.success(res.data)
            setShowChangePasswordForm(false);
          }
          // window.alert(res.data)
        } catch (error) {
          if (error.response && error.response.status === 401) {
            toast.warning('Mật khẩu bạn nhập bị sai !!')
          } else {
            window.alert('Có lỗi xảy ra khi gọi API.');
          }
        }
      }
      process();
  };
  return (
    <section style={{ backgroundColor: '#eee' }}>
      <Container>
        <MDBContainer className="py-4">
          <Button onClick={handleToggleForm} stylevariant="primary">Đổi mật khẩu</Button>
          {showChangePasswordForm && (
            <Button onClick={handleCancel} style={{ marginLeft: 5, backgroundColor: 'gray' }}>
              Hủy
            </Button>
          )}
          <hr></hr>
          <MDBRow>
            <MDBCol lg="4">
              <MDBCard className="mb-4">
                <MDBCardBody className="text-center">
                  <MDBCardImage
                    src={user.avatar}
                    alt="avatar"
                    className="rounded-circle"
                    style={{ width: '150px' }}
                    fluid />
                </MDBCardBody>
              </MDBCard>


            </MDBCol>
            <MDBCol lg="8">
              <MDBCard className="mb-4">
                <MDBCardBody>
                  <MDBRow>
                    <MDBCol sm="3">
                      <MDBCardText>Họ</MDBCardText>
                    </MDBCol>
                    <MDBCol sm="9">
                      <MDBCardText className="text-muted">{user.firstName}</MDBCardText>
                    </MDBCol>
                  </MDBRow>
                  <hr />
                  <MDBRow>
                    <MDBCol sm="3">
                      <MDBCardText>Tên</MDBCardText>
                    </MDBCol>
                    <MDBCol sm="9">
                      <MDBCardText className="text-muted"> {user.lastName}</MDBCardText>
                    </MDBCol>
                  </MDBRow>
                  <hr />
                  <MDBRow>
                    <MDBCol sm="3">
                      <MDBCardText>Email</MDBCardText>
                    </MDBCol>
                    <MDBCol sm="9">
                      <MDBCardText className="text-muted">{user.email}</MDBCardText>
                    </MDBCol>
                  </MDBRow>
                  <hr />
                  <MDBRow>
                    <MDBCol sm="3">
                      <MDBCardText>Tài khoản</MDBCardText>
                    </MDBCol>
                    <MDBCol sm="9">
                      <MDBCardText className="text-muted">{user.username}</MDBCardText>
                    </MDBCol>
                  </MDBRow>
                
                </MDBCardBody>
                <div>
                  {showChangePasswordForm && (
                    <form onSubmit={handleSubmit} >
                      <hr />
                      <MDBCardBody>
                        <MDBCol sm="12">
                          <MDBCardText style={{ color: 'red', fontWeight: 'bold', marginLeft: '50%' }}>Đổi mật khẩu</MDBCardText>
                          <MDBCardText></MDBCardText>
                          <MDBCardText></MDBCardText>
                        </MDBCol>
                        <MDBRow>
                          <Col sm="12">
                            <Form.Control type="password" placeholder="Mật khẩu cũ" onChange={e => setOldPassword(e.target.value)} />
                          </Col>
                          <Col sm="12" style={{marginTop: 10}}>
                            <Form.Control type="password" placeholder="Mật khẩu mới" onChange={e => setNewPassword(e.target.value)}/>
                          </Col>
                          <Col sm="12" style={{marginTop: 10}}>
                            <Form.Control type="password" placeholder="Nhập lại mật khẩu mới"  onChange={e => setConfirmNewPassword(e.target.value)}/>
                          </Col>
                        </MDBRow>
                      </MDBCardBody>
                      <Button type="submit" stylevariant="primary"  style={{marginLeft: '50%', marginBottom: '2%'}} >Xác nhận</Button>
                    </form>
                  )}
                </div>
              </MDBCard>
            </MDBCol>
          </MDBRow>
        </MDBContainer>
      </Container>
    </section>
  );
}

export default UserInfo;