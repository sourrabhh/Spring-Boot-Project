import { useEffect, useState } from "react"
import {DeleteTodoApi, RetrieveAllTodosForUsernameApi} from './api/TodoAPIService'

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

    useEffect( () => RefreshTodos(),[] )
    const [message, setMessage] =  useState(null)

    function RefreshTodos(){
            RetrieveAllTodosForUsernameApi('sourabh')
                .then(response => {
                    // console.log(response.data)
                    setTodos(response.data)
                } )
            }
            
    function deleteTodo(id)
    {
        console.log("Delete Todo Clicked" +id)
        DeleteTodoApi('Sourabh', id)
             .then(
                () => {
                    setMessage(`Delete of Todo with ${id} Successfully`)
                    RefreshTodos()
                }

             )
             .catch(error => console.log(error))
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
                            </tr>
                        </thead>

                        <tbody>
                        {   todos.map(todo => (
                                                <tr key={todo.id}>
                                                    <td>{todo.id}</td>
                                                    <td>{todo.description}</td>
                                                    <td>{todo.done.toString()}</td>
                                                    <td>{todo.targetDate.toString()}</td>
                                                    <td> <button className="btn btn-warning" 
                                                                onClick={() => deleteTodo(todo.id)}>Delete</button> </td>
                                                </tr>
                                                )
                                    )    
                        }
                        </tbody>
                    </table>
                </div>
        </div>
    )
}
