import './App.css';
import Counter from './components/counter/Counter'




function App() {

  return (
    <div className="App">
        <Counter></Counter>    
        {/* <Propes></Propes> */}
    </div>
  );
}

// function Propes({property1, property2})
// {
//   console.log(property1)
//   console.log(property2)

//   return(
//     <div></div>
//   )
// }

// function Propes(propeties)
// {
//   console.log(propeties)
//   console.log(propeties.property1)
//   console.log(propeties.property2)

//   return(
//     <div>Propes</div>
//   )
// }

export default App;
