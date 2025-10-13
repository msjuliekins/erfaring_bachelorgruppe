import { useContext, ChangeEvent, useState, useEffect } from "react";
import { StaffContext } from "../../contexts/StaffContext";
import IStaffContext from "../../interfaces/IStaffContext";
import StaffItem from "./StaffItem";
import IStaff from "../../interfaces/IStaff";

// https://dev.to/alais29dev/building-a-real-time-search-filter-in-react-a-step-by-step-guide-3lmm
// https://www.kindacode.com/article/how-to-create-a-filter-search-list-in-react

const StaffList = () => {

    const {staff} = useContext(StaffContext) as IStaffContext;

    const [searchStaff, setSearchStaff] = useState<string>("");
    const [filteredStaff, setFilteredStaff] = useState<IStaff[]>(staff);

    // Setter staff som default før og når ingenting er skrevet i søkefeltet
    useEffect(()=>{
        setFilteredStaff(staff)
    }, [staff]);

    // Filtrere når brukeren søker
    const handleChange = (e: ChangeEvent<HTMLInputElement>) => { 
        const searchFirstAndLastName = e.target.value;
        setSearchStaff(searchFirstAndLastName);

        const filteredItems = staff.filter((staffMember) => 
            staffMember.firstName?.toLowerCase().includes(searchFirstAndLastName.toLowerCase()) ||
            staffMember.lastName?.toLowerCase().includes(searchFirstAndLastName.toLowerCase())
            );
        
        setFilteredStaff(filteredItems);
      }

    // Printer staff member  
    const createAndGetStaffJSX = () => {
        if(filteredStaff.length === 0) {
            return <p className="lead text-center">We couldn't find what you're looking for. Try a different phrase or keyword.</p>
        } else {
            return filteredStaff.map((staffMember) => (
                <section className="col-md-4 mb-4 d-flex justify-content-center align-items-center">
                    <div key={staffMember.id}>
                        <StaffItem
                            id={staffMember.id}
                            firstName={staffMember.firstName}
                            lastName={staffMember.lastName}
                            image={staffMember.image}
                            phoneNumber={staffMember.phoneNumber}
                            position={staffMember.position}
                        />
                    </div>
                </section>
            ));
        }
    }

    // https://mdbootstrap.com/docs/standard/forms/search/
    return(
        <section className="container">
            <section className="d-flex justify-content-center my-4">
                <input className="search" type="text" value={searchStaff} onChange={handleChange} placeholder='Type to search staff'/>
            </section>
            <div className="d-flex justify-content-center">
                <div className="row w-100 p-3">
                    {createAndGetStaffJSX()}
                </div>
            </div>
        </section>
    )
}

export default StaffList;