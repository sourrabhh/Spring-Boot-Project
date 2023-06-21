import axios from "axios"

 

const apiClient = axios.create(
    {
        baseURL:'http://localhost:8080'
    }
)

export const RetrieveAllTodosForUsernameApi = (username) =>
                            apiClient.get(`/users/${username}/todos`)

export const DeleteTodoApi = 
                (username,id) => apiClient.delete(`/users/${username}/todos/${id}`)

export const RetrieveTodoApi = 
                (username,id) => apiClient.get(`/users/${username}/todos/${id}`)

export const UpdateTodoApi = 
                (username,id,todo) => apiClient.put(`/users/${username}/todos/${id}`,todo)






// export const RetrieveAllTodosForUsername(username) = (username) => apiClient.get(`/users/${username}/todos`);
// users/Sourabh/todos