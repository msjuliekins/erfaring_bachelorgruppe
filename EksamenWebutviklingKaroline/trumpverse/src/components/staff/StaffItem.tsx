import { FC, useContext } from "react";
import IStaff from "../../interfaces/IStaff";
import { StaffContext } from "../../contexts/StaffContext";
import IStaffContext from "../../interfaces/IStaffContext";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faTrash } from "@fortawesome/free-solid-svg-icons"; 

const StaffItem : FC<IStaff> = ({id, firstName, lastName, image, phoneNumber, position}) => {

    const imagePath = `http://localhost:5229/images/${image}`;
    const {deleteStaff} = useContext(StaffContext) as IStaffContext;

    const handleDelete = () => {
        if (id != null) {
            console.log("Slettknappen er trykket på staff nr.: ", id)
            deleteStaff(id);
        }
    }

    return (
        <article>
            <h3 className="heading">{firstName} {lastName}</h3>
            <img src={imagePath} className="img-fluid rounded" style={{width: "100px", height: "150px" , objectFit: "cover"}} alt="" />
            <p>{position}</p>
            <p>Phone number: {phoneNumber}</p>
            <div>
                <button type="button" className="btn" onClick={handleDelete}><FontAwesomeIcon icon={faTrash} aria-label="Icon of a trash can. Delete button."/></button>
            </div>
        </article>
    )
}

export default StaffItem;