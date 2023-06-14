import {useParams,Link } from "react-router-dom"


export default function WelcomeComponent(){
    const {username} = useParams()
    console.log(username)
    return(
        <div className="Welcome Component">
            <h2>Welcome {username} </h2>
            <div >
                Manage Your ToDos <Link to='/todos'>Go Here </Link>
            </div>
        </div>
    )
}
