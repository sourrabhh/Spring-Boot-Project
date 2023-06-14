import { BrowserRouter,Route,Routes } from 'react-router-dom'
import './TodoApp.css'

import LoginComponent from './LoginComponent'
import HeaderComponent from './HeaderComponent'
import ListTodosComponet from './ListTodosComponet'
import LogoutComponent from './LogoutComponent'
import ErrorComponent from './ErrorComponent'
import WelcomeComponent from './WelcomeComponent'
// import FooterComponent from './FooterComponent'

export default function TodoApp()
{
    return(
        <div className="TodoApp">
            <BrowserRouter >
                <HeaderComponent />
                <Routes>
                    <Route path='/' element={<LoginComponent />} > </Route>
                    <Route path='/login' element={<LoginComponent />} > </Route>
                    <Route path='/welcome/:username' element={<WelcomeComponent />} ></Route>
                    <Route path='/todos' element={<ListTodosComponet />}></Route>
                    <Route path='/logout' element={<LogoutComponent /> } ></Route>

                    <Route path='*' element={<ErrorComponent  />}></Route>

                </Routes>
            </BrowserRouter>        
        </div>
    )
}

