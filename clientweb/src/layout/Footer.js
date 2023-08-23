import React from 'react';
import {
  MDBFooter,
  MDBContainer,
  MDBCol,
  MDBRow,
  MDBIcon
} from 'mdb-react-ui-kit';
const Footer = () => {
    const footerStyle = {
        marginTop: 20,
        // position: 'absolute', bottom: 0, width: '100%',
      };
    return (
        <MDBFooter bgColor='light' className='text-center text-lg-left' style={footerStyle}>
      <section className=''>
        <MDBContainer className='text-center text-md-start mt-5'>
          <MDBRow className='mt-3'>
            <MDBCol md="3" lg="4" xl="3" className='mx-auto mb-4 mt-3'>
              <h6 className='text-uppercase fw-bold mb-4'>
                <MDBIcon icon="gem" className="me-3" />
                Đề tài
              </h6>
              <p>
                  Quản lý khóa luận tốt nghiệp
              </p>
            </MDBCol>

            <MDBCol md="2" lg="2" xl="2" className='mx-auto mb-4 mt-3'>
              <h6 className='text-uppercase fw-bold mb-4'>Họ tên</h6>
              <p>
                <a href='#!' className='text-reset'>
                  Nguyễn Phú Vang
                </a>
              </p>
              <p>
                <a href='#!' className='text-reset'>
                  Trần Hùng Quý
                </a>
              </p>
            </MDBCol>

            <MDBCol md="4" lg="3" xl="3" className='mx-auto mb-md-0 mb-4 mt-3'>
              <h6 className='text-uppercase fw-bold mb-4'>Contact</h6>
              <p>
                <MDBIcon icon="envelope" className="me-3" />
                2051050559quy@ou.edu.vn
              </p>
              <p>
                <MDBIcon icon="envelope" className="me-3" />
                2051050559vang@ou.edu.vn
              </p>
              <p>
                <MDBIcon icon="phone" className="me-3" /> + 01 234 567 88
              </p>
              <p>
                <MDBIcon icon="print" className="me-3" /> + 01 234 567 89
              </p>
            </MDBCol>
          </MDBRow>
        </MDBContainer>
      </section>
    
          <div className='text-center p-3' style={{ backgroundColor: 'rgba(0, 0, 0, 0.2)' }}>
            &copy; {new Date().getFullYear()} Copyright:{' '}
            <a className='text-dark' href='/'>
              Nhóm 21: Quản lý khóa luận tốt nghiệp
            </a>
          </div>
        </MDBFooter>
      );
}

export default Footer;