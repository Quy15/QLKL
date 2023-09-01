import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./layout/Header";
import Footer from "./layout/Footer";
import Home from "./component/Home";
import 'bootstrap/dist/css/bootstrap.min.css';
import '@fortawesome/fontawesome-free/css/all.min.css';
import Login from "./layout/Login";
import UserInfo from "./layout/UserInfo";
import ThesisScore from "./layout/ThesisScore";
import Main from "./layout/Main";
import { createContext, useReducer } from "react";
import MyUserReducers from "./reducers/MyUserReducers";
import cookie from "react-cookies";

export const MyUserContext = createContext();
const App = () =>{
  const [user, dispatch] = useReducer(MyUserReducers, cookie.load("user") || null);
  const footerStyle = {
    marginBottom: 20,
    display: 'flex', flexDirection: 'column', minHeight: '65vh'
  };
  return(
    <MyUserContext.Provider value={[user, dispatch]}>
        <BrowserRouter>
          <Header/>
          <div style={footerStyle}>
            <Routes>
                <Route path="/" element={<Main/>}/>
                <Route path="/Login" element={<Login/>}/>
                <Route path="/UserInfo" element={<UserInfo/>}/>
                <Route path="/ThesisScore" element={<ThesisScore/>}/>
                <Route path="/Home" element={<Home/>}/>
              </Routes>
              </div>
          <Footer style={{flexShrink: 0}}/>
        </BrowserRouter>
      </MyUserContext.Provider>

  )
}

export default App;
