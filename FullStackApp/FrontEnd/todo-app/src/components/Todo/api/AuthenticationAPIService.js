import { apiClient } from "./APIClient"

export const ExecuteBasicAuthenticationService 
        = (token) => apiClient.get(`/basicauth`,
        {
            headers:{
                Authorization: token
            }
        })

export const ExecuteJWTAuthenticationService 
        = (username, password) => 
                apiClient.post(`/authenticate`,{ username, password })