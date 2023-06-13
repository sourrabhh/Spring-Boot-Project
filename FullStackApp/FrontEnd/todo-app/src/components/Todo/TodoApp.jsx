import { useState } from 'react'
import { BrowserRouter,Route,Routes,useNavigate } from 'react-router-dom'
import './TodoApp.css'

export default function TodoApp()
{
    return(
        <div className="TodoApp">
            <BrowserRouter >
                <Routes>
                    <Route path='/' element={<LoginComponent />} ></Route>
                    <Route path='/login' element={<LoginComponent />} ></Route>
                    <Route path='/welcome' element={<WelcomeComponet />} ></Route>
                </Routes>
            </BrowserRouter>
        </div>
    )
}

function LoginComponent()
{
    const[username, setUsername] = useState('sourabh')
    const[password, setPassword] = useState('')

    const[showSuccessMessage, setshowSuccessMessage] = useState(false)
    const[showErrorMessage, setshowErrorMessage] = useState(false)

    const navigate = useNavigate()

    function handleUsernameChange(event)
    {
        // console.log(event.target.value)
        setUsername(event.target.value)
    }

    function handlePasswordChange(event)
    {
        setPassword(event.target.value)
    }

    function handleSubmit()
    {
        if(username==='sourabh' && password==='qwerty')
        {
            setshowSuccessMessage(true)
            setshowErrorMessage(false)
            navigate('/welcome')
        }
        else{
            setshowSuccessMessage(false)
            setshowErrorMessage(true)        }
    }

/*
    function SuccessMessageComponent()
    { if(showSuccessMessage){return(<div className='successMessage'> Authenticated Successfully</div>)}
        return null}
    function ErrorMessageComponent(){
        if(showErrorMessage){return(<div className='errorMessage'> Authentication Failed. Please Check Your Credentials </div>)}
        return null}
    */

    return(

        <div className="Login">
            {showSuccessMessage && <div className='successMessage'> Authenticated Successfully</div>}
            {showErrorMessage && <div className='errorMessage'> Authentication Failed. 
                                                            Please Check Your Credentials </div>}
            
            {/* <SuccessMessageComponent /> */}
            {/* <ErrorMessageComponent /> */}

            <div className="LoginForm">
                <div>
                    <label>User Name</label>
                    <input type="text" name="username" value={username} onChange={handleUsernameChange} />
                </div>
                <div>
                    <label>Password</label>
                    <input type="password" name="password" value={password} onChange={handlePasswordChange} />
                </div>

                <div>
                    <button type="button" name="Login" onClick={handleSubmit}> Login </button>
                </div>
            </div>
        </div>
    )
}

function WelcomeComponet(){
    return(
        <div className="Welcome">
            Welcome Component
        </div>
    )
}