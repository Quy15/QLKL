import React, { useState } from 'react';
import {
  MDBCol,
  MDBContainer,
  MDBRow,
  MDBCard,
  MDBCardText,
  MDBCardBody,
  MDBCardImage,
} from 'mdb-react-ui-kit';
import { Button, Col, Form } from 'react-bootstrap';

const UserInfo = () => {
  const [showChangePasswordForm, setShowChangePasswordForm] = useState(false);

  const handleToggleForm = () => {
    setShowChangePasswordForm(!showChangePasswordForm);
  };
  const handleCancel = () => {
    setShowChangePasswordForm(false);
  };
  const handleSubmit = (event) => {
    event.preventDefault();
    // Thực hiện logic xử lý khi nút "Submit" được nhấn
    // Sau đó, ẩn form bằng cách đặt trạng thái showChangePasswordForm thành false
    setShowChangePasswordForm(false);
  };
  return (
    <section style={{ backgroundColor: '#eee' }}>
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
                  src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp"
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
                    <MDBCardText>First Name</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText className="text-muted">Johnatan</MDBCardText>
                  </MDBCol>
                </MDBRow>
                <hr />
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>Last Name</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText className="text-muted"> Smith</MDBCardText>
                  </MDBCol>
                </MDBRow>
                <hr />
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>Email</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText className="text-muted">example@example.com</MDBCardText>
                  </MDBCol>
                </MDBRow>
                <hr />
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>User</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText className="text-muted">(097) 234-5678</MDBCardText>
                  </MDBCol>
                </MDBRow>
                <hr />
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>Password</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText className="text-muted">(098) 765-4321</MDBCardText>
                  </MDBCol>
                </MDBRow>
                <hr />
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>Nghành</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText className="text-muted">(098) 765-4321</MDBCardText>
                  </MDBCol>
                </MDBRow>
                <hr />
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>Vai trò</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText className="text-muted">(098) 765-4321</MDBCardText>
                  </MDBCol>
                </MDBRow>
              </MDBCardBody>
              <div>
                {showChangePasswordForm && (
                  <form onSubmit={handleSubmit} >
                    {/* Đây là form đổi mật khẩu */}
                    <hr />
                    <MDBCardBody>
                      <MDBCol sm="12">
                        <MDBCardText style={{ color: 'red', fontWeight: 'bold', marginLeft: '50%' }}>Đổi mật khẩu</MDBCardText>
                        <MDBCardText></MDBCardText>
                        <MDBCardText></MDBCardText>
                      </MDBCol>
                      <MDBRow >
                        <Col sm="12">
                          <Form.Control type="password" placeholder="Mật khẩu cũ" />
                        </Col>
                        <Col sm="12" style={{marginTop: 10}}>
                          <Form.Control type="password" placeholder="Mật khẩu mới" />
                        </Col>
                        <Col sm="12" style={{marginTop: 10}}>
                          <Form.Control type="password" placeholder="Nhập lại mật khẩu mới" />
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
    </section>
  );
}

export default UserInfo;