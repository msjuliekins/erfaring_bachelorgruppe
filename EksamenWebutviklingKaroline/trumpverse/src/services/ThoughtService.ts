import axios from "axios";
import IThought from "../interfaces/IThought";

const ThoughtService = (()=>{
    
    const thoughtControllerEndpoint = "http://localhost:5229/api/thought/";

    const getAll = async () : Promise<IThought[] | null> => {
        try {
            const result = await axios.get(thoughtControllerEndpoint);
            console.log(result);
            return result.data as IThought[];
        } catch (e) {
            console.log("Feil ved henting fra database", e)
            return null;
        }
    }

    const getById = async (id: number) : Promise<IThought | null> => {
        if (id != null && id != undefined && !isNaN(id) && id.toString().length > 0 ) {
            try {
                const result = await axios.get(thoughtControllerEndpoint + id);
                console.log(result);
                return result.data as IThought;
            } catch (e) {
                console.log("Feil ved henting med id fra database", e);
                return null;
            }
        } else {
            console.log("Fant ikke id");
            return null;
        }
    }

    const getByTitle = async (title: string) : Promise<IThought | null> => {
        if (title != null && title != undefined && title.toLowerCase() ) {
            try {
                const result = await axios.get(thoughtControllerEndpoint + title);
                console.log(result);
                return result.data as IThought;
            } catch (e) {
                console.log("Feil ved henting med tittel fra database", e); 
                return null;
            }
        } else {
            console.log("Fant ikke tittel");
            return null;
        }   
    }

    const postThought = async (newThought : IThought) : Promise<IThought | null> => {
        try {
            const result = await axios.post(thoughtControllerEndpoint, newThought);
            console.log(result);
            return result.data;
        } catch (e) {
            console.log("Feil ved oppretting av ny thought", e)
            return null;
        }
    }

    const putThought = async (updatedThought : IThought) : Promise<IThought | null> => {
        try {
            const result = await axios.put(thoughtControllerEndpoint, updatedThought);
            console.log(result);
            return result.data;
        } catch (e) {
            console.log("Feil ved oppdatering av thought", e)
            return null;
        } 
    }

    const deleteThought = async (id: number) : Promise<IThought | null> => {
        if (id != null && id != undefined && !isNaN(id) && id.toString().length > 0 ) {
            try {
                const result = await axios.delete(thoughtControllerEndpoint + id);
                console.log(result);
                return result.data;
            } catch (e) {
                console.log("Feil ved sletting fra database", e);
                return null;
            }
        } else {
            console.log("Fant ikke id");
            return null;
        }
    }
    
    return{
        getAll,
        getByTitle,
        getById,
        postThought,
        putThought, 
        deleteThought
    }
})();

export default ThoughtService;