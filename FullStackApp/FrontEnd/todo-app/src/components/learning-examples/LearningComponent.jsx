import FirstComponent from './FirstComponent'
import SecondComponent from './SecondComponent';
import ThirdComponet from './ThirdComponent';
import FourthComponet from './FourthComponent';
import { FifthComponent } from './FirstComponent';
import LearningJavaScript from './LearningJavaScript';

export default function LearningComponent() 
{
    return (
      <div className="App">
        <FirstComponent></FirstComponent>
        <SecondComponent></SecondComponent>
        <ThirdComponet></ThirdComponet>
        <FourthComponet></FourthComponet>
        <FifthComponent></FifthComponent>  {/* defined in FirstComponent.jsx */}
        <LearningJavaScript />
      </div>
    );
  }