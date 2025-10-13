import axios from "axios";
import ITrumpMerch from "../interfaces/ITrumpMerch";

//the service contains all the code that uses axios as a communication to the backend part of the project
const TrumpMerchService = (()=> {

    const trumpMerchControllerEndpoint = "http://localhost:5033/api/TrumpMerch";
    const imageUploadControllerEndpoint = "http://localhost:5033/api/imageUpload";
    const merchTypeImageEndpoint = "http://localhost:5033/images";

    const getAll = async () => {
        const result = await axios.get(trumpMerchControllerEndpoint);
        return {success: true, data: result.data};
    }

    
    const postMerch = async (newMerchType: ITrumpMerch, newMerchTypeImage: File) => {
        try{
            const result = await axios.post(trumpMerchControllerEndpoint, newMerchType)
        
            const formData = new FormData();
            formData.append("file", newMerchTypeImage)

            const resultUpload = await axios({
                url: imageUploadControllerEndpoint,
                method: "POST",
                data: formData,
                headers: { "Content-Type": "multipart/form-data"}
            });

            return {success: true, data: resultUpload.data};
        }
        catch{
            return {success: false, data: "Error posting merch"}
        }

    }

    const imageEndpoint = () => {
        return merchTypeImageEndpoint;
    }

    const getById = async (id: number) => {
        try{
            const result = await axios.get(`${trumpMerchControllerEndpoint}/${id}`)
            return {success: true, data: result.data}
        }
        catch{
            return {success: false, data: "Error fetching merch!"}
        }
    }

    const getByTitle = async (title: string) => {
        try{
            const result = await axios.get(`${trumpMerchControllerEndpoint}/title/${title}`)
            return {success: true, data: result.data}
        }
        catch{
            return {success: false, data: "Error fetching merch!"}
        }
    }

    const putMerch = async (updatedMerch : ITrumpMerch) : Promise<ITrumpMerch | null> => {
        try{
            const result = await axios.put(
                `${trumpMerchControllerEndpoint}/${updatedMerch.id}`, 
                updatedMerch
            );
            console.log(result);
            return result.data;
        }
        catch{
            return null;
        }
    }

    const deleteMerch = async (id: number) => {
        try {
            console.log("delete in service");
            const result = await axios.delete(`${trumpMerchControllerEndpoint}/${id}`);
        } catch {
            return {success: false, data: "Error deleting merch"};
        }
    }
    

    return {
        getAll,
        postMerch,
        imageEndpoint,
        getById,
        getByTitle,
        putMerch,
        deleteMerch
    }
}) ();

export default TrumpMerchService;