import React, { useState } from 'react';
import {
  MDBCol,
  MDBContainer,
  MDBRow,
  MDBCard,
  MDBCardBody,
  MDBCardText,
 } from 'mdb-react-ui-kit';
 import Modal from 'react-modal';
import { Button, Col, Form } from 'react-bootstrap';
const DefenseCommittee = () => {
    const [isModalOpen, setModalOpen] = useState(false);

    const openModal = () => {
        setModalOpen(true);
    };

    const closeModal = () => {
        setModalOpen(false);
    };
    return <>
        <h1>List hội đồng bảo vệ luận án</h1>
        <MDBContainer className="py-4">
        <Button onClick={openModal} stylevariant="primary">Thêm mới</Button>
        <hr></hr>
        <MDBRow>
          <MDBCol lg="4">
            <MDBCard className="mb-4">
              <MDBCardBody className="text-center">
               
              </MDBCardBody>
            </MDBCard>       
          </MDBCol>
        </MDBRow>
      </MDBContainer>
        <Modal
            isOpen={isModalOpen}
            onRequestClose={closeModal}
            contentLabel="Example Modal"
            size="lg" centered
            style={{
                overlay: { backgroundColor: 'rgba(0, 0, 0, 0.5)' },
                content: { },
              }}
        >
            <form>
            <MDBCardBody>
                <MDBCol sm="12">
                <MDBCardText style={{ fontWeight: 'bold', marginLeft: '40%' }}>Thêm hội đồng khóa luận</MDBCardText>
                <hr />
                <MDBCardText></MDBCardText>
                <MDBCardText></MDBCardText>
                </MDBCol>
                <MDBRow >
                <Col sm="12">
                    <Form.Control type="text" placeholder="Tên hội đồng bảo vệ khóa luận" />
                </Col>
                </MDBRow>
            </MDBCardBody>
            <Button type="submit" stylevariant="primary"  style={{marginLeft: '40%', marginBottom: '2%', marginTop: '2%'}} >Xác nhận</Button>
            </form>
        </Modal>
    </>
}

export default DefenseCommittee;