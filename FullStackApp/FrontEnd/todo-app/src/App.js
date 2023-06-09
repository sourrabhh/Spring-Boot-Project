import './App.css';
import {Component} from 'react'

function App() {
  return (
    <div className="App">
      <FirstComponent></FirstComponent>
      <SecondComponent></SecondComponent>
      <ThirdComponet></ThirdComponet>
      <FourthComponent/>
    </div>
  );
}

function FirstComponent()
{
  return(
    <div className="FirstComponent"> FIRST COMPONENT </div>
  )
}

function SecondComponent() {
  return(
    <div className="SecondComponet">Second Component </div>
  )  
}

class ThirdComponet extends Component
{
  render() {
    return(
      <div className="ThirdComponet">Third Component </div>
    ) 
  }
}

class FourthComponent extends Component
{
  render() {
    return(
      <div className='FourthComponent'>Fourth Component</div>
    )
  }
}


export default App;
