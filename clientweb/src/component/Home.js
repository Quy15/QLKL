import { useEffect, useState } from "react";
import Apis, { endpoints } from "../configs/Apis";
import { Button, Card, Col, Container, Row } from "react-bootstrap";
import  MySpinner  from '../layout/MySpinner';

const Home = () => {
    const [user, setUsers] = useState(null);

    useEffect(() => {
        const loadUsers = async () => {
           try {
            let res = await Apis.get(endpoints['users']);
            setUsers(res.data);
            } catch(ex){
                console.error(ex);
            }
        }
        loadUsers();
    }, []);

    if (user === null)
        return <MySpinner/>;
    return <>
    <Container>
        <Row>
            {user.map(u => {
                return <Col xs={12} md={3} className="mt-2 mb-2">
                            <Card>
                                <div style={{ height: '150px', width: '300px'}} >
                                    <Card.Img variant="top" src={u.avatar}
                                    style={{ height: '100%',
                                        width: '100%',
                                        objectFit: 'cover'}}/>
                                  </div>
                                <Card.Body>
                                    <Card.Title> {u.firstName} {u.lastName}</Card.Title>
                                    <Card.Text></Card.Text>
                                    <Button variant="primary">Go somewhere</Button>
                                </Card.Body>
                            </Card>
                </Col>
            })}
        </Row>
        </Container>
    </>
}

export default Home;