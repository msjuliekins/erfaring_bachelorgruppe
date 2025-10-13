import { useState, useContext, ChangeEvent } from "react";
import { MerchContext } from "../../contexts/MerchContext";
import IMerchContext from "../../interfaces/IMerchContext";
import IMerch from "../../interfaces/IMerch";
import ImageUploadService from "../../services/ImageUploadService";
import MerchItem from "./MerchItem";

const EditMerch = () => {

    const { getMerchById, putMerch} = useContext(MerchContext) as IMerchContext;

    const [id, setId] = useState<string>("");
    const [name, setName] = useState<string>("");
    const [image, setImage] = useState<any>(null);
    const [price, setPrice] = useState<string>("");
    const [quantity, setQuantity] = useState<string>("");
    const [updatedMerch, setUpdatedMerch] = useState<any>(null); // State for oppdatert merch

    const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
        switch(e.target.name){
            case "id":
                setId(e.target.value);
                break;
            case "name":
                setName(e.target.value);
                break;
            // https://stackoverflow.com/questions/61573872/typescript-object-is-possibly-null-when-getting-files-from-event
            case "image":  
                if (e.target.files != null) {
                    const file = e.target.files[0]; // den første tingen som ligger inne i input file boksen
                    setImage(file);
                }
                break;
            case "price":
                setPrice(e.target.value);
                break;
            case "quantity":
                setQuantity(e.target.value);
                break;
        }
    }

    const getById = async () => {
        if(id) {
            try{
                const merch = await getMerchById(parseInt(id));
                console.log(merch);
    
                if(merch) {
                    setName(merch.name || "");
                    setImage(merch.image || "");
                    setPrice(merch.price?.toString() || "");
                    setQuantity(merch.quantity?.toString() || "");
                }
            } catch (e) {
                console.log("Feil ved henting av merch: ", e)
            }
        }
    }

    const updateMerch = async () => {
        const merchToUpdate : IMerch = {
            id: parseInt(id),
            name: name,
            image: image.name,
            price: parseInt(price),
            quantity: parseInt(quantity)
        }
        
        if(image) {
            await ImageUploadService.uploadImage(image);
            console.log("Bildet ble lastet opp");
        }

        console.log("Forsøker å oppdatere:", merchToUpdate);
        const result = await putMerch(merchToUpdate);

        if (result) {
            putMerch(result);
            setUpdatedMerch(result);
            console.log("Produktet ble oppdatert:", result);
        } else {
            console.error("Feil ved oppdatering av produkt");
        }
    }

    const createAndGetUpdatedMerchfJSX = () => {
        if(updatedMerch != null) {
            console.log(updatedMerch);
            return (
                <section>
                    <div className="d-flex justify-content-center align-items-center">
                        <h3 className="heading">Product updated successfully: </h3>
                    </div>
                    <section className="d-flex justify-content-center align-items-center">
                    <div className="col-md-4 mb-4 d-flex justify-content-center align-items-center" key={updatedMerch.id}>
                    <MerchItem
                        name={updatedMerch.name}
                        image={updatedMerch.image}
                        price={updatedMerch.price}
                        quantity={updatedMerch.quantity}
                    />  
                </div>
                </section>
                </section>
            )
        };
    }

    return(
        <section>
            <header className="flag-banner bottom-border">
                <h3 className="text-center display-3 mb-4">Edit a product here by using the product id</h3>
            </header>
            <section className="container d-flex justify-content-center align-items-center mt-4" style={{ width: "100%" }}>
            <section className="background-box border">
                <div className="m-3">
                    <label>Product id</label>
                    <input className="form-control" name="id" type="text" value={id} onChange={handleChange} placeholder="Product id"/>
                    <button className="save-btn mt-2" onClick={getById}>Fetch</button>
                </div>
                <div className="m-3">
                    <label>Product name</label>
                    <input className="form-control" name="name" type="text" onChange={handleChange} value={name} placeholder="Product name"/>
                </div>
                <div className="m-3">
                    <label>Image</label>
                    <input className="form-control" name="image" type="file" onChange={handleChange} placeholder="Image"/>
                </div>
                <div className="m-3">
                    <label>Price</label>
                    <input className="form-control" name="price" type="text" value={price} onChange={handleChange} placeholder="Price"/>
                </div>
                <div className="m-3">
                    <label>Quantity</label>
                    <input className="form-control" name="quantity" type="number" value={quantity} onChange={handleChange} placeholder="Quantity"/>
                </div>
                <div className="m-3">
                    <button className="save-btn" onClick={updateMerch}>Save</button>
                </div>
            </section>
        </section>
            <section>
                {createAndGetUpdatedMerchfJSX()}
            </section>
        </section>

        
    )
}

export default EditMerch;