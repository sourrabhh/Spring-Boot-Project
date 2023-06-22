import { useEffect, useState } from "react"
import {DeleteTodoApi, RetrieveAllTodosForUsernameApi} from './api/TodoAPIService'
import { useAuth } from "./security/AuthenticationContext"
import { useNavigate } from "react-router-dom"


export default function ListTodosComponet()
{
    //  const today = new Date()
    //  const targetDateVal = new Date(today.getFullYear() + 12 ,today.getMonth(), today.getDay())
    
    const [todos, setTodos] =  useState([])
    // const todos = [
    //             //     {id:1, description:'Learn AWS', done:false, targetDate: targetDateVal},
    //             //     {id:2, description:'Learn AZURE' , done:false, targetDate: targetDateVal},
    //             //     {id:3, description:'Learn DevOps' , done:false, targetDate: targetDateVal}
    //               ]

    const authContext = useAuth()
    const username = authContext.username
    useEffect( () => RefreshTodos())
    const [message, setMessage] =  useState(null)
    const navigate = useNavigate()

    function RefreshTodos(){
            RetrieveAllTodosForUsernameApi(username)
                .then(response => {
                    setTodos(response.data)
                } )
            }
            
    function deleteTodo(id)
    {
        console.log("Delete Todo Clicked" +id)
        DeleteTodoApi(username, id)
             .then( () => {
                    setMessage(`Delete of Todo with ${id} Successfully`)
                    RefreshTodos()
                }
             )
             .catch(error => console.log(error))
    }

    function updateTodo(id)
    {
        console.log(" Todo Clicked" +id)
        navigate(`/todo/${id}`)
    }

    function addNewTodo()
    {
        navigate(`/todo/-1`)
    }
                

    return(
        <div className='container'>
            <h2>Things You Want to Do !!</h2>
                {message && <div className="alert alert-warning">{message}</div> }
                <div>
                    <table className='table'>
                        <thead>
                            <tr>
                                <th>Description</th>
                                <th>Is Done?</th>
                                <th>Target Date</th>
                                <th>Delete</th>
                                <th>Update</th>
                            </tr>
                        </thead>

                        <tbody>
                        {   todos.map(todo => (
                                                <tr key={todo.id}>
                                                    {/* <td>{todo.id}</td> */}
                                                    <td>{todo.description}</td>
                                                    <td>{todo.done.toString()}</td>
                                                    <td>{todo.targetDate.toString()}</td>
                                                    <td> <button className="btn btn-warning" 
                                                                onClick={() => deleteTodo(todo.id)}>Delete</button> </td>
                                                    <td> <button className="btn btn-success" 
                                                                onClick={() => updateTodo(todo.id)}>Update</button> </td>
                                                </tr>
                                                )
                                    )    
                        }
                        </tbody>
                    </table>
                </div>

                <div className="btn btn-success m-3" onClick={addNewTodo}> Add Todo  </div>
        </div>
    )
}
