import { useParams } from "react-router-dom"
import { RetrieveTodoApi } from "./api/TodoAPIService"
import { useAuth } from "./security/AuthenticationContext"
import { useEffect, useState } from "react"
import { ErrorMessage, Field, Form, Formik } from "formik"


export default function TodoComponent()
{

    const {id} =  useParams()
    const authContext = useAuth()
    const username = authContext.username

    const [description, setDescription] = useState('')
    const [targetDate, setTargetDate] = useState()

    useEffect(
            () => retrieveTodos())

    function retrieveTodos()
    {
        RetrieveTodoApi(username, id)
            .then( response => {
                setDescription(response.data.description)
                setTargetDate(response.data.targetDate)
            } )
            .catch(error => console.log(error))
    }

    function onSubmit(values)
    {
        console.log(values)
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

        if(values.targetDate == null)
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
                                <Field type="Date" className="form-control" name="target date" />
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