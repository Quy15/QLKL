import { useContext, useEffect, useMemo, useState } from "react";
import { Alert, Button, Container, Form, ListGroup, Modal, Table } from "react-bootstrap";
import Apis, { endpoints } from "../configs/Apis";
import { MyUserContext } from "../App";
import MySpinner from "./MySpinner";

const ThesisScore = () => {
  const [defenseCommittee, setDefenseCommitee] = useState(null);
  const [user] = useContext(MyUserContext);

  const [selectedDefenseCommitteeId, setSelectedDefenseCommitteeId] = useState(null);
  const [selectedDefenseCommitteeDetails, setSelectedDefenseCommitteeDetails] = useState([]);

  const [clickedDetailId, setClickedDetailId] = useState(null);
  const [clickedScoreId, setClickedScoreId] = useState(null);

  const [criteriaByThesisScore, setCriteriaByThesisScore] = useState(null);
  const [detailIds, setDetailIds] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const detailIdArray = [];

  const [value, setValue] = useState('');
  const [error, setError] = useState('');

  const handleChange = (e) => {
    const inputValue = e.target.value;
    setValue(inputValue);

    if (inputValue < 0 || inputValue > 10) {
      setError('Giá trị phải nằm trong khoảng từ 0 đến 10.');
    } else {
      setError('');
    }
  };

  const handleSubmitScore = (e) => {
    e.preventDefault();
    if (error) {
      alert('Vui lòng nhập giá trị hợp lệ.');
    } else {
      alert('Giá trị đã được gửi.');
    }
  };

  useEffect(() => {
    const loadDFList = async () => {
      try {
        let res = await Apis.get(endpoints['userDefense'] + `${user.id}`);
        setDefenseCommitee(res.data);
      } catch (ex) {
        console.error(ex);
      }
    }
    loadDFList();
  }, [user.id]);

  const handleDetailClick = async (id) => {
    try {
      let res = await Apis.get(`${endpoints['thesiscores']}${id}`);
      setSelectedDefenseCommitteeId(id);
      setSelectedDefenseCommitteeDetails(res.data);
    } catch (ex) {
      console.error(ex);
    }
  };

  const handleScoreClick = async (id) => {
    try {
      let res = await Apis.get(`${endpoints['criteria-thesis-score']}${id}`);
      setShowModal(true);
      // setSelectedDefenseCommitteeId(id);
      setCriteriaByThesisScore(res.data);
      console.info(res.data);
    } catch (ex) {
      console.error(ex);
    }
  };

  const thesisIdMap = useMemo(() => {
    const map = new Map();
    selectedDefenseCommitteeDetails.forEach(detail => {
      const thesisId = detail.thesisId.id;
      if (!map.has(thesisId)) {
        map.set(thesisId, []);
      }
      map.get(thesisId).push(detail);
    });
    return map;
  }, [selectedDefenseCommitteeDetails]);

  // console.info(thesisIdMap)
  // console.info(detailIds)
  // useEffect(() => {
  //   const detailIdArray = detailIds.map(detail => detail.id);

  //   const fetchDataForDetail  = async (detailId) => {
  //     try {
  //       const response = await Apis.get(`${endpoints['criteria-thesis-score']}${detailId}`); 
  //       return response.data;
  //     } catch (error) {
  //       console.error(error);
  //       return null;
  //     }
  //   };

  //   Promise.all(detailIdArray.map(detailId => fetchDataForDetail(detailId)))
  //   .then(dataArray => {
  //     const validDataArray = dataArray.filter(data => data !== null);
  //     setCriteriaByThesisScore(validDataArray);
  //   });
  // },[detailIds]);
  // console.info(criteriaByThesisScore)
  if (defenseCommittee === null)
    return <>
      <Container>
        <MySpinner />
        <Alert variant="danger">Bạn không ở trong hội đồng nào</Alert>
      </Container>
    </>
  return <>
    <Container>
      <h1 className="mt-5 text-center">Danh sách hội đồng</h1>
      <ListGroup>
        {defenseCommittee.map(dc => {
          return <div className={clickedDetailId === dc.id ? 'mark' : ''}>
            <ListGroup.Item key={dc.id} className="d-flex justify-content-between align-items-center">
              <span >{dc.defenseCommitteeId.name}</span>
              <Button variant="info" className="ml-2"
                onClick={() => {
                  handleDetailClick(dc.id);
                  setClickedDetailId(dc.id);
                }}>Chi tiết</Button>
            </ListGroup.Item>
          </div>
        })}
      </ListGroup>
      {selectedDefenseCommitteeId && (
        <Container>
          {Array.from(thesisIdMap).map(([thesisId, details]) => (
            
            <div key={thesisId}>
              <h1 className="mt-5 text-center">Chấm điểm</h1>
              <h3>Khóa luận: {details[0].thesisId.name}</h3>
              <ListGroup>
                {details.map(detail => {
                  detailIdArray.push(detail.id);

                  return (
                    <ListGroup.Item key={detail.id} className="d-flex justify-content-between align-items-center">
                      <h3>{detail.id}</h3>
                      <Button onClick={() => { handleScoreClick(detail.id) }}>Chấm điểm</Button>
                    </ListGroup.Item>
                  );
                })}
              </ListGroup>
            </div>
          ))}
          {/* {setDetailIds((detailIdArray))} */}
          {/* {console.info(detailIds)} */}
        </Container>
      )}
      {showModal && (
        <div className="modal-container">
          <div className="modal show" style={{ display: 'block', position: 'initial' }}>
            <Modal.Dialog>
              <Modal.Header>
                <Modal.Title>Chấm điểm</Modal.Title>
              </Modal.Header>

              <Modal.Body>
                <Table striped bordered hover>
                  <thead>
                    <tr>
                      <th>Tiêu chí</th>
                      <th>Điểm</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      {criteriaByThesisScore.map(c => {
                        return (
                          <td>{c.criteriaId.name}</td>
                        );
                      })}
                      <td>
                        <Form onSubmit={handleSubmitScore}>
                          <Form.Control type="number" value={value}
                            onChange={handleChange}
                            isInvalid={!!error}>

                          </Form.Control>
                          <Form.Control.Feedback type="invalid">
                            {error}
                          </Form.Control.Feedback>
                        </Form>
                      </td>
                    </tr>
                  </tbody>
                </Table>
                {/* {criteriaByThesisScore.map(c => {
                  return (
                    <p>{c.criteriaId.name}</p>
                  );
                })} */}
              </Modal.Body>

              <Modal.Footer>
                <Button variant="secondary" onClick={() => setShowModal(false)}>
                  Đóng
                </Button>
                <Button variant="primary" type="submit">Lưu</Button>
              </Modal.Footer>
            </Modal.Dialog>
          </div>
        </div>
      )}
    </Container>
  </>

};

export default ThesisScore;