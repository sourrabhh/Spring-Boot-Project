import {Link } from 'react-router-dom'
import { useAuth } from './security/AuthenticationContext'
// import { useContext } from 'react'

export default function HeaderComponent()
{
    const authContext = useAuth()
    // console.log(authContext.number)
 
    const isAuthenticated = authContext.isAuthenticated
    // console.log(authContext)

    function logout()
    {
        authContext.logout()
    }

    return(
        <header className="border-bottom border-light border-5 mb-5 p-2">
        <div className="container">
            <div className="row">
                <nav className="navbar navbar-expand-lg">
                    <a className="navbar-brand ms-2 fs-10 fw-bold text-black" href="https://www.google.com">Google</a>
                        <ul className="navbar-nav" id='menu'>
                            <li className="nav-item fs-10" >
                                {isAuthenticated && 
                                    <Link className="nav-link" to="/welcome/sourabh">Home</Link>}   
                            </li>                  
                            <li className="nav-item fs-10">
                                {isAuthenticated && 
                                    <Link className="nav-link" to="/todos">Todos</Link>}                               
                            </li>
                        </ul>
                    
                    <ul className="navbar-nav">
                        <li className="nav-item fs-10">
                            {!isAuthenticated && <Link className="nav-link" to="/login">Login </Link> }
                        </li>

                        <li className="nav-item fs-10">
                            {isAuthenticated && <Link className="nav-link" to="/logout" onClick={logout}>Logout</Link> }
                        </li>
                    </ul>                    
                </nav>
            </div>
        </div>
    </header>
    )
}
