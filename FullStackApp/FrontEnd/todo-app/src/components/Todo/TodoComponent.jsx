import { useNavigate, useParams } from "react-router-dom"
import { RetrieveTodoApi,UpdateTodoApi, createTodoApi } from "./api/TodoAPIService"
import { useAuth } from "./security/AuthenticationContext"
import { useEffect, useState } from "react"
import { ErrorMessage, Field, Form, Formik } from "formik"
import moment from "moment/moment"


export default function TodoComponent()
{

    const {id} =  useParams()
    const authContext = useAuth()
    const username = authContext.username

    const navigate = useNavigate()

    const [description, setDescription] = useState('')
    const [targetDate, setTargetDate] = useState('')

    useEffect(
            () => retrieveTodos())

    function retrieveTodos()
    {
        // eslint-disable-next-line eqeqeq
        if(id != -1)
        {
            RetrieveTodoApi(username, id)
                .then( response => {
                    setDescription(response.data.description)
                    setTargetDate(response.data.targetDate)
                } )
                .catch(error => console.log(error))
        }
    }

    function onSubmit(values)
    {
        console.log(values)
        const todo = {
            id: id,
            username: username,
            description : values.description, 
            targetDate : values.targetDate,
            done:false
        }
        console.log(todo)

        // eslint-disable-next-line eqeqeq
        if(id == -1)
        {
            createTodoApi(username, todo)
                .then(response => {
                    navigate('/todos')
                })
                .catch(error => console.log(error))
        }
        else{
            UpdateTodoApi(username,id,todo)
            .then( response => {
                navigate('/todos')
            } )
            .catch(error => console.log(error))
        }

        
            
    }

    function validate(values)
    {
        let error ={
            // description: 'Enter the Valid Description',
            // targetDate:'Enter the Valid Target Date'
        }
        if(values.description.length < 5)
        {
            error.description = "Enter at least 5 character"
        }

        // eslint-disable-next-line eqeqeq
        if(values.targetDate == null || values.targetDate ==''|| !moment(values.targetDate).isValid())
        {
            error.targetDate = "Enter valid Target Date"
        }
        console.log(values)
        return error
    }
    

    return(
        <div className="container">
            <h2>Enter Todo Details</h2>
            <div>
                <Formik initialValues={{description,targetDate}}
                    enableReinitialize = {true}
                    onSubmit={onSubmit}
                    validate={validate}
                    validateOnChange={false}
                    validateOnBlur={false}
                >
                {
                    (props) => (
                        <Form>

                            <ErrorMessage
                                name="description"
                                component="div"
                                className="alert alert-warning"
                            />

                            <ErrorMessage
                                name="targetDate"
                                component="div"
                                className="alert alert-warning"
                            />

                            <fieldset className="form-group">
                                <label>Description</label>
                                <Field type="text" className="form-control" name="description" />
                            </fieldset>
                            <fieldset className="form-group">
                                <label>Target Date</label>
                                <Field type="Date" className="form-control" name="targetDate" />
                            </fieldset>
                            
                            <div>
                                <button className="btn btn-success m-3" type="submit">Save</button>
                            </div>
                        </Form>
                    )
                }
                </Formik>
            </div>

        </div>
    )
}