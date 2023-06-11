// import {PropTypes} from 'prop-types'


export default function CounterButton({by, incrementMethod,decrementMethod})
{  // (0,f)

//   const [count, setCount] = useState(0)   //hook // count = variable :: setCount = function
    
//   function IncrementCounterFunction()
//   {
//         incrementMethod(by)
//     }

//   function DecrementCounterFunction()
//   {
//       decrementMethod(by)  
//   }

    return(
        <div className="Counter"> 
            {/* <span className='count'>{count} </span> */}
          <div>
            <button className='counterButton' 
                    onClick={() => incrementMethod(by)}
                    > +{by}                      
            </button>
          
            <button className='counterButton'
                    onClick={() => decrementMethod(by)}
                    > -{by}
            </button>
          </div>
        </div>
    )
}


// CounterButton.propTypes = {
//     by: PropTypes.number
// }

// CounterButton.defaultProps = { 
//     by: 1
// }