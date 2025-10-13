import { useEffect, useState} from "react";
import ITrumpMerch from "../../interfaces/ITrumpMerch";
import TrumpMerchService from "../../services/TrumpMerchService";
import "./MerchItem.css";


//this code shows all items in the database
const MerchList = () => {
    const [merch, setMerch] = useState<ITrumpMerch[]>([]);
    const [showErrorMessage, setShowErrorMessage] = useState(false);
    const [errorMessage, setErrorMessage] = useState("");

    useEffect(()=> {
        getMerchFromService();
    }, []);

    const getMerchFromService = async () => {
        const merchFromService = await TrumpMerchService.getAll();

        console.log("From service", merchFromService);

        if(merchFromService.success){
            setMerch(merchFromService.data as ITrumpMerch[]);
        }
        else{
            setShowErrorMessage(true);
            setErrorMessage(merchFromService.data as string);
        }
        
    }

    //this code is the same as in merchItem, but because of the way merch
    //is set in this file it returns more than one item
    const createAndGetJSX = () => {
        const merchJSX = merch.map((merchType, index) => {
            return (
                <article className="col-xs-12 col-sm-6 col-md-4" key={"merchType-" + index}>
                    <h3>{merchType.title}</h3>
                    <p>Size: {merchType.size}</p>
                    <p>Colour: {merchType.colour}</p>
                    <img className="img-responsive" src={`${TrumpMerchService.imageEndpoint()}/${merchType.image}`} alt={merchType.title}/>
                </article>
            )
        });

        return merchJSX;
    }

    return (
        <section>
            <h3>All merch</h3>
            <section className="grid-12-column">
            
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
            </section>
        </section>
        
    )
}

export default MerchList;