// Første forsøk på å hente objekt ved navn + kladdeark, beholder for å vise prosessen ved å komme frem til filtrering

// // import { ChangeEvent, useContext, useState } from "react";
// // import { StaffContext } from "../../contexts/StaffContext";
// // import IStaffContext from "../../interfaces/IStaffContext";
// // import StaffItem from "./StaffItem";
// // import IStaff from "../../interfaces/IStaff";

// // // https://dev.to/alais29dev/building-a-real-time-search-filter-in-react-a-step-by-step-guide-3lmm
// // const SearchStaff = () => {

// //     const {staff, getStaffByName} = useContext(StaffContext) as IStaffContext;

// //     const [searchStaff, setSearchStaff] = useState<string>("");
// //     const [filteredName, setFilteredName] = useState<IStaff[]>([]);

// //     const handleChange = (e: ChangeEvent<HTMLInputElement>) => { 
// //         const searchFirstAndLastName = e.target.value;
// //         setSearchStaff(searchFirstAndLastName);


// //         const filteredItems = staff.find((staffMember) => 
// //             staffMember.firstName?.toLowerCase().includes(searchFirstAndLastName.toLowerCase()) ||
// //             staffMember.lastName?.toLowerCase().includes(searchFirstAndLastName.toLowerCase())
// //             );
        
// //         setFilteredName(filteredItems);
// //       }

// //     const getByName = async (firstName: string, lastName: string) => {
// //         if(firstName && lastName) {
// //             try{
// //                 const staffMember = await getStaffByName(firstName, lastName);
// //                 console.log(staffMember);
// //                 return staffMember;
// //             } catch (e) {
// //                 console.log("Feil ved henting av navn i database", e);
// //             }
// //         }
// //     }

// //     const createAndGetSearchedStaffMember = () => {
// //             if(filteredName != null) {
// //                 return (
// //                     <section>
// //                         {filteredName.map((staffMember) => (
// //                             <StaffItem
// //                                 key={staffMember.id}
// //                                 firstName={staffMember.firstName}
// //                                 lastName={staffMember.lastName}
// //                             />
// //                         ))}
// //                     </section>
// //                 )
// //             } else {
                
// //             }
// //         }

// //     return(
// //         <section>
// //             <div>
// //             <input className="search" type="text" value={searchStaff} onChange={handleChange} placeholder='Type to search staff'/>
// //             </div>
// //             <div>
// //                 <button onClick={() => getByName(searchStaff, "")}>Search</button>
// //             </div>
// //             <section>
// //                 {createAndGetSearchedStaffMember()}
// //             </section>
// //         </section>
// //     )
// // }

// // export default SearchStaff;

// const createAndGetStaffJSX = () => {
//     if(filteredStaff != null) {
//         return (
//             <section>
//                 {filteredStaff.map((staffMember) => (
//                     <div key={staffMember.id}>
//                         <StaffItem
//                         firstName={staffMember.firstName}
//                         lastName={staffMember.lastName}
//                         image={staffMember.image}
//                         phoneNumber={staffMember.phoneNumber}
//                         position={staffMember.position}
//                         />  
//                     </div>
//                 ))}  
//             </section> 
//         )
//     } else {
//         const staffJSX = staff.map((staff) => {
//             return(
//                 <div key={staff.id}>
//                 <StaffItem
//                     firstName={staff.firstName}
//                     lastName={staff.lastName}
//                     image={staff.image}
//                     phoneNumber={staff.phoneNumber}
//                     position={staff.position}
//                     />  
//                 </div>
//             ) 
//         });
//         return staffJSX;
//     }
// }