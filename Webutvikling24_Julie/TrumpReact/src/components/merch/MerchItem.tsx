import { useState,ChangeEvent} from "react";
import ITrumpMerch from "../../interfaces/ITrumpMerch";
import TrumpMerchService from "../../services/TrumpMerchService";


//This code takes input from the user in order to either show a
//spesific item that they can modify or delete
const MerchItem = () => {
    const [merch, setMerch] = useState<ITrumpMerch[]>([]);
    const [showErrorMessage, setShowErrorMessage] = useState(false);
    const [errorMessage, setErrorMessage] = useState("");
    const [title, setTitle] = useState("");
    const [image, setImage] = useState<File | null>(null);
    const [id, setId] = useState<number | null>(null);
    const [colour, setColour] = useState("")
    const [size, setSize] = useState("")


    const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
        console.log("test");
        switch(e.target.name) {
            case "title":
                console.log("Title input value:", e.target.value);
                setTitle(e.target.value)
            break;
            case "id":
                setId(Number(e.target.value));
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
    
    const getMerchById = async () => {
        if (!id) {
            setShowErrorMessage(true);
            setErrorMessage("ID not found");
            return;
        }


        const merchFromService = await TrumpMerchService.getById(id);

        if (merchFromService.success) {
            setMerch([merchFromService.data as ITrumpMerch]);
        }
        else {
            setShowErrorMessage(true);
            setErrorMessage(merchFromService.data as string);
        }
    }

    const getMerchByTitle = async () => {
        console.log("Attempting to fetch by title:", title);
        if (!title) {
            setShowErrorMessage(true);
            setErrorMessage("Title not found");
            return;
        }

        const merchFromService = await TrumpMerchService.getByTitle(title);

        if (merchFromService.success) {
            console.log("setting merch from title");
            setMerch([merchFromService.data as ITrumpMerch]);
        }
        else {
            setShowErrorMessage(true);
            setErrorMessage(merchFromService.data as string);
        }
    }

    const updateMerch = async () => {
        if (!title || !image || !size || !colour) {
            setShowErrorMessage(true);
            setErrorMessage("Property not found");
            return;
        }
        if (id == null) {
            return;
        }
        const merchUpdate : ITrumpMerch = {
            
            id,
            title,
            image: image.name,
            size,
            colour
        };

        const result = await TrumpMerchService.putMerch(merchUpdate);
        if (result) {
            console.log("Update successful", result);
        } else {
            throw new Error("Update failed");
        }
    }

    const deleteMerch = async () => {
        console.log("delete in component");
        if (id == null) {
            setShowErrorMessage(true);
            setErrorMessage("ID not found");
            return;
        }
        
        try {
            const result = await TrumpMerchService.deleteMerch(id);
            if (result) {
                console.log("Delete successful");
                setShowErrorMessage(false);
                setErrorMessage("");
            } else {
                throw new Error("Delete failed");
            }
        } catch (error) {
            setShowErrorMessage(true);
            setErrorMessage("Error deleting merch!");
            console.error("Delete error:", error);
        }
    }
    
    //this part of the code is what creates the setup and shows the item
    const createAndGetJSX = () => {
        const merchJSX = merch.map((merchType, index) => {
            return (
                <article className="col-xs-12 col-sm-6" key={"merchType-" + index}>
                    <h3>{merchType.title}</h3>
                    <p>Size: {merchType.size}</p>
                    <p>Colour: {merchType.colour}</p>
                    <img className="img-responsive" src={`${TrumpMerchService.imageEndpoint()}/${merchType.image}`} alt={merchType.title}/>
                </article>
            )
        });

        return merchJSX;
    }

    //here input is taken to determine what item the user wishes
    //to see, change or delete
    return (
        <section>
            <div>
                <label>Search by ID</label>
                <input 
                    name = "id"
                    type = "text"
                    onChange={handleChange}
                />
                </div>
                <button onClick={getMerchById}>Get by ID</button>
                <div>
                    <label>Search by title</label>
                    <input 
                        name="title" 
                        type="text" 
                        onChange={handleChange} 
                        />
                </div>
                <button onClick={getMerchByTitle}>Get by title</button>
                { 
                    merch.length > 0
                    ?
                    createAndGetJSX()
                    :
                    <p>No merch to show yet</p>
                }

                {
                    showErrorMessage
                    ?
                    <p>{errorMessage}</p>
                    :
                    <></>
                }
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
                <button onClick={updateMerch}>Update merch</button>
                <div>
                    <button onClick={deleteMerch}>Delete merch</button>
                </div>
                
            </section>
    )
}

export default MerchItem;