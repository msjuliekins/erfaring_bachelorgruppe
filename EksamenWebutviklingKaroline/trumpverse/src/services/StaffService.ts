import axios from "axios";
import IStaff from "../interfaces/IStaff";

const StaffService = (()=>{

    const staffControllerEndpoint = "http://localhost:5229/api/staff/";

    const getAll = async () : Promise<IStaff[] | null> => {
        try {
            const result = await axios.get(staffControllerEndpoint);
            console.log(result.data);
            return result.data as IStaff[];
        } catch (e) {
            console.log("Feil ved henting fra database", e);
            return null;
        }
    }

    const getById = async (id: number) : Promise<IStaff | null> => {
        if (id != null && id != undefined && !isNaN(id) && id.toString().length > 0 ) {
            try {
                const result = await axios.get(staffControllerEndpoint + id);
                console.log(result.data);
                return result.data as IStaff;
            } catch (e) {
                console.log("Feil ved henting med id fra database", e);
                return null;
            }
        } else {
            console.log("Fant ikke id")
            return null;
        }
    }

    const getByName = async (firstname: string, lastname : string) : Promise<IStaff | null> => {
        if (firstname != null && firstname != undefined && firstname.toLowerCase() || lastname != null && lastname != undefined && lastname.toLowerCase() ) {
            try {
                const result = await axios.get(staffControllerEndpoint + firstname + lastname);
                console.log(result.data);
                return result.data as IStaff;
            } catch (e) {
                return null;
            }
        } else {
            console.log("Fant ikke navnet");
            return null;
        }
    }

    const postStaff = async (newStaff : IStaff) : Promise<IStaff | null> => {
        try {
            const result = await axios.post(staffControllerEndpoint, newStaff);
            console.log(result.data);
            return result.data;
        } catch (e) {
            console.log("Feil ved oppretting av ny staff", e);
            return null;
        }
    }

    const putStaff = async (updatedStaff : IStaff) : Promise<IStaff | null> => {
        try {
            const result = await axios.put(staffControllerEndpoint, updatedStaff);
            console.log(result.data);
            return result.data;
        } catch (e) {
            console.log("Feil ved oppdatering av staff", e);
            return null;
        }
    }

    const deleteStaff = async (id: number) : Promise<IStaff | null> => {
        if (id != null && id != undefined && !isNaN(id) && id.toString().length > 0 ) {
            try {
                const result = await axios.delete(staffControllerEndpoint + id);
                console.log(result.data);
                return result.data;
            } catch (e) {
                console.log("Feil ved sletting i database", e);
                return null;
            }
        } else {
            console.log("Fant ikke id");
            return null;
        }
    }

    return{
        getAll,
        getById,
        getByName,
        postStaff,
        putStaff,
        deleteStaff
    }

})();

export default StaffService;