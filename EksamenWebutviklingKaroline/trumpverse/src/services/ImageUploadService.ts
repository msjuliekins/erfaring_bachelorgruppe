import axios from "axios";

const ImageUploadService = (()=>{

    const imageUploadControllerEndpoint = "http://localhost:5229/api/imageupload/";
    const imageEndpoint = "http://localhost:5229/images/"

    const uploadImage = async (image: File) => {
        const formData = new FormData(); // Lager et objekt av en klasse
        formData.append("file", image);

        const result = await axios({
            url: imageUploadControllerEndpoint,
            method: "POST",
            data: formData,
            headers: {"Content-Type": "multipart/form-data"}
        });

        formData.delete("file"); // Slette det bildet som nettopp ble lastet opp
        return result.data;
    }

    const getImageEndpoint = () => {
        return imageEndpoint;
    }

    return{
        uploadImage,
        getImageEndpoint
    }
    
})();

export default ImageUploadService;