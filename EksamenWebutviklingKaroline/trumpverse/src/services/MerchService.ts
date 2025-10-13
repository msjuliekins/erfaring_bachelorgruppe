import axios from "axios";
import IMerch from "../interfaces/IMerch";

const MerchService = (()=>{
    const merchControllerEndpoint = "http://localhost:5229/api/merch/";

    const getAll = async () : Promise<IMerch[] | null> => {
        try {
            const result = await axios.get(merchControllerEndpoint);
            console.log(result.data);
            return result.data as IMerch[];
        } catch (e) {
            console.log("Feil ved henting fra database", e)
            return null;
        }
    }

    const getById = async (id: number) : Promise<IMerch | null> => {
        if (id != null && id != undefined && !isNaN(id) && id.toString().length > 0) {
            try {
                const result = await axios.get(merchControllerEndpoint + id);
                console.log(result.data);
                return result.data as IMerch;
            } catch (e) {
                console.log("Feil ved henting med id fra database", e)
                return null;
            }
        } else {
            console.log("Fant ikke id");
            return null;
        }    
    }

    const getByName = async (name: string) : Promise<IMerch | null> => {
        if (name != null && name != undefined && name.toLowerCase()) {
            try {
                const result = await axios.get(merchControllerEndpoint + name);
                console.log(result.data);
                return result.data as IMerch;
            } catch (e) {
                console.log("Feil ved henting med navn fra database", e)
                return null;
            }
        } else {
            return null;
        }  
    }

    const postMerch = async (newMerch : IMerch) : Promise<IMerch | null> => {
        try {
            const result = await axios.post(merchControllerEndpoint, newMerch);
            console.log(result.data);
            return result.data;
        } catch (e) {
            console.log("Feil ved oppretting av ny merch", e);
            return null;
        }
    }

    const putMerch = async (updatedMerch : IMerch) : Promise<IMerch | null> => {
        try {
            const result = await axios.put(merchControllerEndpoint, updatedMerch);
            console.log(result.data);
            return result.data;
        } catch (e) {
            console.log("Feil ved oppdatering av merch", e);
            return null;
        }   
    }

    const deleteMerch = async (id: number) : Promise<IMerch | null> => {
        if (id != null && id != undefined && !isNaN(id) && id.toString().length > 0 ) {
            try {
                const result = await axios.delete(merchControllerEndpoint + id);
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
        postMerch,
        putMerch, 
        deleteMerch
    }
})();

export default MerchService;