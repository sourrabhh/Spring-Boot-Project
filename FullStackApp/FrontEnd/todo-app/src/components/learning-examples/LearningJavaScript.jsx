const person ={
    name: 'Sourabh Shinde',
    address : {
        line1: 'Borale Ves',
        city: 'Solapur'
    },
    profiles: ['twitter', 'linkedin', 'instgram'],

    printProfile: () => {
            person.profiles.map(
                profile=>console.log(profile) )                   
                         }
            }


export default function LearningJavaScript() 
{
    return (
        <>
            <div> {person.name} </div>
            <div> {person.address.line1} </div>
            <div> {person.address.city} </div>
            {/* <div> {person.profiles[0]} </div> */}
            <div> {person.printProfile()} </div>
        </>
        
    )    
}