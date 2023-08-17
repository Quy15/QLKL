import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./layout/Header";
import Footer from "./layout/Footer";
import Home from "./component/Home";
import 'bootstrap/dist/css/bootstrap.min.css';
import '@fortawesome/fontawesome-free/css/all.min.css';
import { Container } from "react-bootstrap";
import Login from "./layout/Login";
import UserInfo from "./layout/UserInfo";

const App = () =>{
  const footerStyle = {
    marginBottom: 20,
    position: 'relative',display: 'flex', flexDirection: 'column', minHeight: '65vh'
  };
  return(
      <BrowserRouter>
        <Header/>
         <Container style={footerStyle}>
          <Routes>
              <Route path="/" element={<Home/>}/>
              <Route path="/Login" element={<Login/>}/>
              <Route path="/UserInfo" element={<UserInfo/>}/>
            </Routes>
          </Container>
        <Footer/>
      </BrowserRouter>

  )
}

export default App;
