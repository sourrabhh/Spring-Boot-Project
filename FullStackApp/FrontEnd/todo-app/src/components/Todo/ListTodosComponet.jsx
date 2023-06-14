

export default function ListTodosComponet()
{
    const today = new Date()
    const targetDateVal = new Date(today.getFullYear() + 12 ,today.getMonth(), today.getDay())
    const todos = [
                    {id:1, description:'Learn AWS', done:false, targetDate: targetDateVal},
                    {id:2, description:'Learn AZURE' , done:false, targetDate: targetDateVal},
                    {id:3, description:'Learn DevOps' , done:false, targetDate: targetDateVal}
                  ]
    return(
        <div className='container'>
            <h2>Things You Want to Do !!</h2>
                <div>
                    <table className='table'>
                        <thead>
                            <tr>
                                <td>ID</td>
                                <td>Description</td>
                                <td>Is Done?</td>
                                <td>Target Date</td>
                            </tr>
                        </thead>

                        <tbody>
                        {   todos.map(todo => (
                                                <tr key={todo.id}>
                                                    <td>{todo.id}</td>
                                                    <td>{todo.description}</td>
                                                    <td>{todo.done.toString()}</td>
                                                    <td>{todo.targetDate.toDateString()}</td>
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
