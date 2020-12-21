import { wait } from "@testing-library/react";
import axios from "axios";

const API_URL = "http://localhost:8080/api/1.0";

const register = (username, password) => {
  return axios.post(API_URL + "/signup", {
    username,
    password,
  });
};

const login = (username, password) => {
  return axios
    .post(API_URL + "/login", {
      username,
      password,
    })
    .then((response) => {
      if (response.data.data) {
        // token
        localStorage.setItem("user", JSON.stringify(response.data.data));
      }
      return response.data.data;
    });
};

const logout = () => {
  localStorage.removeItem("user");
};

export default {
  register,
  login,
  logout,
};
