import { useState, ChangeEvent } from "react";
import TrumpMerchService from "../../services/TrumpMerchService";
import ITrumpMerch from "../../interfaces/ITrumpMerch";


//this code allows the user to create new types of merch

const RegisterMerch = () => {
    const [title, setTitle] = useState("");
    const [image, setImage] = useState<File | null>(null)
    const [colour, setColour] = useState("")
    const [size, setSize] = useState("")

    const [showErrorMessage, setShowErrorMessage] = useState(false);
    const [errorMessage, setErrorMessage] = useState("");


    const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
        switch(e.target.name) {
            case "title":
                setTitle(e.target.value)
            break;
            case "image":
                if (e.target.files){
                    setImage(e.target.files[0]);
                }
            break;
            case "size":
                setSize(e.target.value)
            break;
            case "colour":
                setColour(e.target.value)
            break;
        }
    }
    
    const registerMerchType = async () => {
        if (!title || !image || !colour || !size) {
            setShowErrorMessage(true);
            setErrorMessage("Property not found");
            return;
        }
        
        const newMerchType:Omit<ITrumpMerch, "id"> = {
            title,
            image: image.name,
            size,
            colour
        };

        await TrumpMerchService.postMerch(newMerchType, image);
    }
        
    //input is taken for all the properties needed to create the object
    return (
        <section>
            <header>
                <h3>Register new merch</h3>
            </header>
            <section>
                <div>
                    <label>Merch</label>
                    <input 
                        name = "title"
                        type = "text"
                        onChange={handleChange}
                        value={title}
                    />
                    
                </div>
                <div>
                    <label>Image</label>
                    <input 
                        name = "image"
                        type="file"
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <label>Size</label>
                    <input 
                        name = "size"
                        type = "text"
                        onChange={handleChange}
                        value={size}
                    />
                    
                </div>
                <div>
                    <label>Colour</label>
                    <input 
                        name = "colour"
                        type = "text"
                        onChange={handleChange}
                        value={colour}
                    />
                    
                </div>
                <button onClick={registerMerchType}>Register new merch</button>
                {
                    showErrorMessage
                    ?
                    <p>{errorMessage}</p>
                    :
                    <></>
                }
            </section>
        </section>
    )
}

export default RegisterMerch;