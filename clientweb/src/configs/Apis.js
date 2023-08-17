import axios from "axios";

const SERVER_CONTEXT = "/QuanLyKhoaLuan/";
export const endpoints = {
    "users" : `${SERVER_CONTEXT}api/users/`,
}
export default axios.create({
    baseURL : "http://localhost:8080"
})