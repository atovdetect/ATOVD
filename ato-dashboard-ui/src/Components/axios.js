import axios from "axios";
import { API } from "./index.js";

const apiClient = axios.create({
  baseURL: `${API}`,
  withCredentials: false,
  headers: {
     Accept: "application/json",
             "Content-Type": "application/json",
             "appId" : "1253712357"
    }
});

export default apiClient;