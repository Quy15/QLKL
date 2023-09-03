import { useContext, useEffect, useMemo, useState } from "react";
import { Alert, Button, Container, Form, ListGroup, Modal, Table } from "react-bootstrap";
import Apis, { endpoints } from "../configs/Apis";
import { MyUserContext } from "../App";
import MySpinner from "./MySpinner";
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const ThesisScore = () => {
  const [thesisScore, setThesisScore] = useState('');
  const [defenseCommittee, setDefenseCommitee] = useState(null);
  const [user] = useContext(MyUserContext);

  const [selectedDefenseCommitteeId, setSelectedDefenseCommitteeId] = useState(null);
  const [selectedDefenseCommitteeDetails, setSelectedDefenseCommitteeDetails] = useState([]);
  const [selectedThesisScoreId, setSelectedThesisScoreId] = useState(null);

  const [clickedDetailId, setClickedDetailId] = useState(null);
  // const [clickedScoreId, setClickedScoreId] = useState(null);

  const [criteriaByThesisScore, setCriteriaByThesisScore] = useState(null);
  // const [detailIds, setDetailIds] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const detailIdArray = [];

  const handleSubmit = (event) => {
    event.preventDefault();
    if (thesisScore >= 0 && thesisScore <= 10) {
      const process = async () => {
        try {
          let res = await Apis.post(endpoints['cham-diem'], {
            "thesisScoreId": selectedThesisScoreId, 
            "score": thesisScore
          });
          if (res.status === 200) {
            toast.success(res.data + ". Vui lòng nhấn vào Chi tiết để làm mới làm điểm vừa nhập", {
              position: "top-right",
              autoClose: 3000,
              hideProgressBar: false,
            });
            setShowModal(false);
          }
        } catch (error) {
          console.error(error);
        }
      }
      process();
    } else {
      toast.error("Điểm phải nằm trong khoảng từ 0 đến 10");
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
      // console.info(res.data);
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
          <h1 className="mt-5 text-center">Chấm điểm</h1>
          {Array.from(thesisIdMap).map(([thesisId, details]) => (
            <div key={thesisId}>
              <h3>Khóa luận: {details[0].thesisId.name}</h3>
              <ListGroup>
                {details.map((detail, index) => {
                  detailIdArray.push(detail.id);
                  const order = index + 1;
                  return (
                    <Table striped bordered hover key={detail.id}>
                      <thead>
                        <tr>
                          <th className="text-center">Tiêu chí</th>
                          <th className="text-center">Điểm</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td className="text-center">{order}</td>
                          <td className="text-center">{detail.score}</td>
                          <td className="text-center">
                            <Button onClick={() => {
                              handleScoreClick(detail.id);
                              setSelectedThesisScoreId(detail.id);
                            }}>Chấm điểm</Button>
                          </td>
                        </tr>
                      </tbody>
                    </Table>
                  );
                })}
              </ListGroup>
            </div>
          ))}
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
                <form onSubmit={handleSubmit}>
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
                          return (<td>{c.criteriaId.name}</td>);
                        })}
                        <td>
                          <Form.Control type="number" onChange={e => setThesisScore(e.target.value)}></Form.Control>
                        </td>
                      </tr>
                    </tbody>
                  </Table>
                  <hr />
                  <div className="d-flex justify-content-end align-items-center">
                    <Button variant="secondary" onClick={() => setShowModal(false)}>
                      Đóng
                    </Button>
                    <Button variant="primary" type="submit">Lưu</Button>
                  </div>
                </form>
              </Modal.Body>
            </Modal.Dialog>
          </div>
        </div>
      )}
    </Container>
  </>

};

export default ThesisScore;