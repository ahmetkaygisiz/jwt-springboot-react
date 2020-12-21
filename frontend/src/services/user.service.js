import axios from "axios";
import authHeader from "./auth-header";

const API_URL = "http://localhost:8080/api/1.0";

const home = () => {
  return axios.get(API_URL + "/home", { headers: authHeader() });
};

export default {
  home,
};
