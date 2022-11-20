import axios from 'axios'

const USER_API_BASE_URL = 'http://localhost:8080/api/v1/auth'

class LoginService{
    getLogInfo(){
        return axios.get(USER_API_BASE_URL);
    }
}

export default new LoginService()