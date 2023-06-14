import { BrowserRouter,Navigate,Route,Routes } from 'react-router-dom'
import './TodoApp.css'

import LoginComponent from './LoginComponent'
import HeaderComponent from './HeaderComponent'
import ListTodosComponet from './ListTodosComponet'
import LogoutComponent from './LogoutComponent'
import ErrorComponent from './ErrorComponent'
import WelcomeComponent from './WelcomeComponent'
import AuthenticationProvider, { useAuth } from './security/AuthenticationContext'
// import FooterComponent from './FooterComponent'

export default function TodoApp()
{
    function AuthenticatedRoute({children})
    {
        const authContext = useAuth()
        if(authContext.isAuthenticated)
        {
            return(children)
        }    
        return <Navigate to="/"> </Navigate>      
    }

    return(
        <div className="TodoApp">
            <AuthenticationProvider>
                <BrowserRouter >
                    <HeaderComponent />
                    <Routes>
                        <Route path='/' element={<LoginComponent />} > </Route>
                        <Route path='/login' element={<LoginComponent />} > </Route>

                        <Route path='/welcome/:username' element={
                            <AuthenticatedRoute>
                                <WelcomeComponent />
                            </AuthenticatedRoute>
                            }>     
                        </Route>

                        <Route path='/todos' element={
                            <AuthenticatedRoute>
                                <ListTodosComponet />
                            </AuthenticatedRoute>
                            }>       
                        </Route>

                        <Route path='/logout' element={
                            <AuthenticatedRoute>
                                <LogoutComponent />
                            </AuthenticatedRoute>
                             } >
                        </Route>

                        <Route path='*' element={<ErrorComponent  />}></Route>

                    </Routes>
                    {/* <FooterComponent></FooterComponent> */}
                </BrowserRouter>
            </AuthenticationProvider>
        
        </div>
    )
}

