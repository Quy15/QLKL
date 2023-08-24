import axios from "axios";
import cookie from "react-cookies";

const SERVER_CONTEXT = "/QuanLyKhoaLuan/";
const SERVER = "http://localhost:8080";
export const endpoints = {
    "users" : `${SERVER_CONTEXT}api/users/`,
    "login" : `${SERVER_CONTEXT}api/login/`,
    "change-password" : `${SERVER_CONTEXT}api/change-password/`,
    "current-user" : `${SERVER_CONTEXT}api/current-user/`,
}

export const authApi = () => {
    return axios.create({
        baseURL: SERVER,
        headers: {
            "Authorization": cookie.load("token")
        }
    })
}
export default axios.create({
    baseURL : SERVER
})