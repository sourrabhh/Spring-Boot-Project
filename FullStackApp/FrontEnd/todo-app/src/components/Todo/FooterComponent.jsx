import { AuthContext } from "./security/AuthenticationContext"
import { useContext } from "react"

export default function FooterComponent()
{
    const authContext = useContext(AuthContext)
    console.log(` Footer Component- ${authContext.number}`)

    return(
        <footer className='Footer'>
            <div className='container'>
                 Footer                  
            </div>
        </footer>
    )
}