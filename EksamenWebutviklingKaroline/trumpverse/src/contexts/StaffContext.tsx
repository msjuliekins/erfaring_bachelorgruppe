import { useState, useEffect, createContext, FC } from "react";
import IStaff from "../interfaces/IStaff";
import IStaffContext from "../interfaces/IStaffContext";
import IProps from "../interfaces/IProp";
import StaffService from "../services/StaffService";

export const StaffContext = createContext<IStaffContext | null>(null);

export const StaffProvider : FC<IProps> = ({children}) => {

    const [staff, setStaff] = useState<IStaff[]>([]);

    useEffect(()=>{
        getAndSetStaff();
    }, []);

    const getAndSetStaff = async () => {
        const staffList = await StaffService.getAll();
        if (staffList != null) {
            console.log(staffList);
            setStaff(staffList);
        }
        return null;
    }

    const getStaffById = async (id: number) : Promise<IStaff | null> => {
        if (id != null && id != undefined && id.toString().length > 0) {
            const staffById = await StaffService.getById(id);
            console.log(staffById);
            return staffById;
        }
        return null;
    }

    const getStaffByName = async (firstName: string, lastName: string) : Promise<IStaff | null> => {
        if (firstName != null && firstName != undefined && firstName.toLowerCase() || lastName != null && lastName != undefined && lastName.toLowerCase()) {
            const staffByName = await StaffService.getByName(firstName, lastName);
            console.log(staffByName);
            return staffByName;
        } 
        return null;
    }

    const postStaff = async (newStaff: IStaff) : Promise<IStaff | null> => {
        const result = await StaffService.postStaff(newStaff);
        if (result != null) {
            setStaff([result, ...staff]);
        }
        return result;
    }

    const putStaff = async (updatedStaff: IStaff) : Promise<IStaff | null> => {
        const result = await StaffService.putStaff(updatedStaff);
        if (result != null) {
            getAndSetStaff();
            return updatedStaff;
        }
        return null;
    }

    const deleteStaff = async (id: number) => {
        await StaffService.deleteStaff(id);
        getAndSetStaff();
    }

    return(
        <StaffContext.Provider value={{staff, getStaffById, getStaffByName, postStaff, putStaff, deleteStaff}}>
            {children}
        </StaffContext.Provider>
    )
}