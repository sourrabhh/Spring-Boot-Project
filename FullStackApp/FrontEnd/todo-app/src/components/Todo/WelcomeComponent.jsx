import {useParams,Link } from "react-router-dom"
import { useContext } from "react"
import { AuthContext } from "./security/AuthenticationContext"

export default function WelcomeComponent(){
    const {username} = useParams()

    const authContext = useContext(AuthContext)
    console.log(authContext.number)
    // console.log(username)
    return(
        <div className="Welcome Component">
            <h2>Welcome {username} </h2>
            <div >
                Manage Your ToDos <Link to='/todos'>Go Here </Link>
            </div>
        </div>
    )
}
