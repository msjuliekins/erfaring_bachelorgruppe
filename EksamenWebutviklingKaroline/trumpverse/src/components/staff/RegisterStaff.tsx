import { useState, useContext } from "react";
import { StaffContext } from "../../contexts/StaffContext";
import IStaffContext from "../../interfaces/IStaffContext";
import StaffService from "../../services/StaffService";
import ImageUploadService from "../../services/ImageUploadService";
import StaffItem from "./StaffItem";

const RegisterStaff = () => {

    const { postStaff } = useContext(StaffContext) as IStaffContext;

    // State
    // https://stackoverflow.com/questions/59125973/react-typescript-argument-of-type-is-not-assignable-to-parameter-of-type
    const [image, setImage] = useState<any>(null);
	const [firstName, setFirstName] = useState<string>("");
	const [lastName, setLastName] = useState<string>("");
	const [position, setPosition] = useState<string>("");
    const [phoneNumber, setPhoneNumber] = useState<string>("");
    const [newStaffMember, setNewStaffMember] = useState<any>(null); //state for ny staff

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        switch(e.target.name){
            case "firstname":
                setFirstName(e.target.value);
                break;
            case "lastname":
                setLastName(e.target.value);
                break;
            case "image":
                // https://stackoverflow.com/questions/61573872/typescript-object-is-possibly-null-when-getting-files-from-event
                
                if (e.target.files != null) {
                    const file = e.target.files[0]; // den første tingen som ligger inne i input file boksen
                    setImage(file);
                  }
                break;
            case "position":
                setPosition(e.target.value);
                break;
            case "phonenumber":
                setPhoneNumber(e.target.value);
                break;
        }
    }

    // Registrerer ny staff

    const registerStaff = async () => {
        try {
            console.log("Firstname ", firstName);
            console.log("Lastname ", lastName);
            console.log("Image", image);
            console.log("Position ", position);
            console.log("PhoneNumber ", phoneNumber);

            const newStaff = {
                firstName: firstName,
                lastName: lastName,
                image: image.name,
                position: position,
                phoneNumber: phoneNumber
            };

            if(image) {
                await ImageUploadService.uploadImage(image);
                console.log("Bildet ble lastet opp");
            }

            const result = await StaffService.postStaff(newStaff);
            if (result) {
                postStaff(result);
                setNewStaffMember(result);
                console.log("Staff registrert");
            }

        } catch (e) {
            console.error("Feil ved registrering av staff ", e);
        }
    }

    // Printer ny staff til siden
    
    const createAndGetNewStaffJSX = () => {
        if(newStaffMember != null) {
            return (
                <section>
                    <div className="d-flex justify-content-center align-items-center">
                        <h3 className="heading">New staff member registered: </h3>
                    </div>
                <section className="d-flex justify-content-center align-items-center">
                    <div className="col-md-4 mb-4 d-flex justify-content-center align-items-center" key={newStaffMember.id}>
                        <StaffItem
                            firstName={newStaffMember.firstName}
                            lastName={newStaffMember.lastName}
                            image={newStaffMember.image}
                            phoneNumber={newStaffMember.phoneNumber}
                            position={newStaffMember.position}
                        />  
                    </div>
                </section>
                </section>
            )
        };
    }

    // https://getbootstrap.com/docs/4.1/components/forms/ 
    
    return (
        <section>
            <header>
	                <h2 className="flag-banner bottom-border text-center display-2 mb-4">Register new staff</h2>
                    <div className="mb-4 m-2">
                        <p className="lead text-center text-box">President-elect Donald J. Trump is in the process of finalizing his team for his upcoming term. The administration will include key cabinet members and senior staff to lead the country’s executive departments and advisory roles. Please update this page regularly as new appointments and announcements are made.</p>
                    </div>
	            </header>
	            <section className="pcontainer d-flex justify-content-center align-items-center mt-4" style={{ width: "100%" }}>
                    <section className="background-box border">
	                    <div className="m-3">
                            <label>First name</label>
	                        <input className="form-control" placeholder="First name" name="firstname" type="text" onChange={handleChange} value={firstName} />
	                    </div>
	                    <div className="m-3">
                            <label>Last name</label>
	                        <input className="form-control" placeholder="Last name" name="lastname" type="text" onChange={handleChange} value={lastName} />
	                    </div>
	                    <div className="m-3">
                            <label>Image</label>
	                        <input className="form-control" placeholder="Image" name="image" type="file" onChange={handleChange} />
	                    </div>
	                    <div className="m-3">
                            <label>Position</label>
	                        <input className="form-control" placeholder="Position" name="position" type="text" onChange={handleChange} value={position} />
	                    </div>
	                    <div className="m-3">
                            <label>Phone number</label>
	                        <input className="form-control" placeholder="1-212-000-000" name="phonenumber" type="text" onChange={handleChange} value={phoneNumber} />
	                    </div>
                        <div className="d-flex justify-content-center m-3">
	                        <button className="save-btn" onClick={registerStaff}>Save</button>
                        </div>
                    </section>
            </section>
            <section className="container mt-4">
                <div className="row g-3">
                    {createAndGetNewStaffJSX()}
                </div>
            </section>
        </section>
    );
}

export default RegisterStaff;