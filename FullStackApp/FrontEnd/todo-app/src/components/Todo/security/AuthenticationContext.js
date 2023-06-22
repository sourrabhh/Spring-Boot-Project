import { createContext, useContext, useState } from "react";
import { ExecuteBasicAuthenticationService } from "../api/HelloWorldAPIService";
import { apiClient } from "../api/APIClient";

export const AuthContext = createContext()
export const useAuth = () => useContext(AuthContext)


export default function AuthenticationProvider({ children })
{
    // const [number,setNumber] = useState(0)
    const [isAuthenticated, setAuthenticated] = useState(false)

    const [username, setUsername] = useState(null)

    const [token, setToken] = useState(null)


    async function login(username, password)
    {
        const basicAuthToken = 'Basic ' + window.btoa(username + ":" + password)

        try{
                const response = await ExecuteBasicAuthenticationService(basicAuthToken)
                
                if(response.status===200)
                {
                    setAuthenticated(true)   // setting flag to true 
                    setUsername(username)
                    setToken(basicAuthToken)

                    apiClient.interceptors.request.use(
                        (config) => {
                            console.log('Intercepting and Adding a Token')
                            config.headers.Authorization = basicAuthToken
                            return config
                        }
                    )

                    return true
                }
                else{
                    // setAuthenticated(false)   // setting flag to true 
                    // setUsername(null)
                    // setToken(null)  OR
                    logout()
                    return false                       
                }
            }
            catch(error){
                    // setAuthenticated(false)   // setting flag to true 
                    // setUsername(null)
                    // setToken(null)
                    logout()
                    return false
            }
    }
    
    function logout()
    {
        setAuthenticated(false)
        setToken(null)
    }

    return(
        <AuthContext.Provider value={{isAuthenticated, login,logout,username, token}}>
            { children }
        </AuthContext.Provider>
    )
}