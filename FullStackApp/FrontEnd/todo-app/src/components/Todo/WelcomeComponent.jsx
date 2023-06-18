import {useParams,Link } from "react-router-dom"
import { useContext, useState } from "react"
import { AuthContext } from "./security/AuthenticationContext"
import { RetrieveHelloWorldBean, RetrieveHelloWorldBeanPathVariable } from "./api/HelloWorldAPIService"

export default function WelcomeComponent(){
    const {username} = useParams()

    const [message, setMessage] = useState(null)



    const authContext = useContext(AuthContext)
    console.log(authContext.number)
    // console.log(username)

    function CallHelloWorldRestAPI() {
        console.log("called")

            // axios.get('http://localhost:8080/helloworld')
            //     .then( (response) => SuccessfulResponse(response) )
            //     .catch( (error) => ErrorResponse(error) )
            //     .finally( () => console.log("Clean Up") )

            // RetrieveHelloWorldBean()
            //     .then( (response) => SuccessfulResponse(response) )
            //     .catch( (error) => ErrorResponse(error) )
            //     .finally( () => console.log("Clean Up") )

            RetrieveHelloWorldBeanPathVariable('Sourabh')
                .then( (response) => SuccessfulResponse(response) )
                .catch( (error) => ErrorResponse(error) )
                .finally( () => console.log("Clean Up") )
    }

    function SuccessfulResponse(response)
    {
        console.log(response)
        setMessage(response.data.message)
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

            <div className="text-info"> {message} </div>
        </div>
    )
}
