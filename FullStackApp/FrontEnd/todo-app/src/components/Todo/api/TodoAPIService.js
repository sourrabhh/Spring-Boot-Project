import axios from "axios"

 

const apiClient = axios.create(
    {
        baseURL:'http://localhost:8080'
    }
)

export const RetrieveAllTodosForUsername = (username) =>apiClient.get(`/users/${username}/todos`)

// export const RetrieveAllTodosForUsername(username) = (username) => apiClient.get(`/users/${username}/todos`);
// users/Sourabh/todos