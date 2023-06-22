// import axios from "axios"
import { apiClient } from "./APIClient"


export const RetrieveHelloWorldBean = () => apiClient.get('/helloworldbean')

export const RetrieveHelloWorldBeanPathVariable 
        = (username, token) => apiClient.get(`/helloworld/pathvariable/${username}`,
        // {
        //     headers:{
        //         Authorization: token
        //     }
        // }
        )

