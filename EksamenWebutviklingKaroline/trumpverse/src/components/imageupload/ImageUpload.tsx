import { useState, ChangeEvent } from "react";
import ImageUploadService from "../../services/ImageUploadService";

const ImageUpload = () => {

    const [image, setImage] = useState<File | null>(null);

    const setImageHandler = (event: ChangeEvent<HTMLInputElement>) => {
        const {files} = event.target;
        if(files != null) {
            const file = files[0];
            setImage(file);
        }
    }

    const imageUpload = () => {
        if(image != null) {
            ImageUploadService.uploadImage;
            console.log("Bildet er lastet opp");
        } else {
            console.log("Feil ved opplasting av bilde")
        }
    }

    return(
        <section className="mb-5">
            <form action="">
                <section className="row g-3">
                    <div className="col-12">
                        <input className="form-control" onChange={setImageHandler} type="file"/>
                    </div>
                    <div className="col-12 d-flex justify-content-center mt-4">
                        <input className="btn btn-primary form-control" onClick={imageUpload} type="button" value="Upload image"/>
                    </div>
                </section>
            </form>
        </section>
    )
}

export default ImageUpload;

