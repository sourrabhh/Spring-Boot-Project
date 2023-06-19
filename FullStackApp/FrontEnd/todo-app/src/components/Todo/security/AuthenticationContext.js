import { createContext, useContext, useState } from "react";

export const AuthContext = createContext()
export const useAuth = () => useContext(AuthContext)


export default function AuthenticationProvider({ children })
{
    // const [number,setNumber] = useState(0)
    const [isAuthenticated, setAuthenticated] = useState(false)

    const [username, setUsername] = useState(null)

    function login(username, password)
    {
        if(username==='sourabh' && password==='qwe')
        {
            setAuthenticated(true)   // setting flag to true 
            setUsername(username)
            return true
        }
        else{
            setAuthenticated(false)   // setting flag to true 
            setUsername(null)
            return false
                    
        }
    }
    
    function logout()
    {
        setAuthenticated(false)
    }

    return(
        <AuthContext.Provider value={{isAuthenticated, login,logout,username}}>
            { children }
        </AuthContext.Provider>
    )
}