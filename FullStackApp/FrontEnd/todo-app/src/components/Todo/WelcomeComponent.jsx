import {useParams,Link } from "react-router-dom"
import { useContext } from "react"
import { AuthContext } from "./security/AuthenticationContext"
import axios, { Axios } from "axios"

export default function WelcomeComponent(){
    const {username} = useParams()

    



    const authContext = useContext(AuthContext)
    console.log(authContext.number)
    // console.log(username)

    function CallHelloWorldRestAPI() {
        console.log("called")
        axios.get('http://localhost:8080/helloworld')
            .then( (response) => SuccessfulResponse(response) )
            .catch( (error) => ErrorResponse(error) )
            .finally( () => console.log("Clean Up") )
    }

    function SuccessfulResponse(response)
    {
        console.log(response)
    }

    function ErrorResponse(error)
    {
        console.log(error)
    }

    return(
        <div className="Welcome Component">
            <h2>Welcome {username} </h2>
            <div >
                Manage Your ToDos <Link to='/todos'>Go Here </Link>
            </div>

            <div> 
                <button className="btn btn-success m-5" onClick={CallHelloWorldRestAPI}> Call Hello World
                </button>

            </div>
        </div>
    )
}
