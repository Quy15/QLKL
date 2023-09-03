import { useContext, useEffect, useState } from "react";
import { Container, Table } from "react-bootstrap";
import Apis, { endpoints } from "../configs/Apis";
import { MyUserContext } from "../App";
import MySpinner from "./MySpinner";

const ViewScore = () => {
    const [avgScore, setAvgScore] = useState([]);
    const [user] = useContext(MyUserContext);

    useEffect(() => {
        const loadScoreByUser = async () => {
            try {
                let res = await Apis.get(endpoints['thesis-by-user'] + `${user.id}`);
                setAvgScore(res.data);
            } catch (ex) {
                console.error(ex);
            }
        }
        loadScoreByUser();
    }, [user.id]);
    if (avgScore === [])
        return <MySpinner />;
    return <>
        <Container>
            <h1 className="text-center mt-5 mb-5">Xem điểm khóa luận</h1>
            <Table striped bordered hover>
                <thead>
                    <tr>
                        {/* <th className="text-center">Id</th> */}
                        <th className="text-center" style={{ width: '950%' }}>Khóa luận</th>
                        <th className="text-center">Điểm</th>
                    </tr>
                </thead>
                <tbody>
                    {avgScore.map(as => (
                        <tr key={as.id}>
                            {/* <td className="text-center">{as.thesisId}</td> */}
                            <td className="text-left" >
                                {as.thesisName}
                            </td>
                            <td className="text-center">
                                {as.diemTB}
                            </td>
                        </tr>
                    ))}
                </tbody>
            </Table>
        </Container>
    </>
}

export default ViewScore;