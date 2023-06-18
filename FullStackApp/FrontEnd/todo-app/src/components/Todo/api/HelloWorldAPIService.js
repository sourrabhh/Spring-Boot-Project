import axios from "axios"

// export function RetrieveHelloWorldBean()
// {
//     return axios.get('http://localhost:8080/helloworldbean')

// }
// OR 

const apiClient = axios.create(
    {
        baseURL:'http://localhost:8080'
    }
)

export const RetrieveHelloWorldBean = () => apiClient.get('/helloworldbean')

export const RetrieveHelloWorldBeanPathVariable = (username) => apiClient.get(`/helloworld/pathvariable/${username}`)