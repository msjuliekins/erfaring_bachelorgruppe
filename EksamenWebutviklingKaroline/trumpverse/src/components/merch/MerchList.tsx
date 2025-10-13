import { useContext} from "react";
import { MerchContext } from "../../contexts/MerchContext";
import IMerchContext from "../../interfaces/IMerchContext";
import MerchItem from "./MerchItem";
import PurchaseMerch from "./PurchaseMerch";


const MerchList: React.FC = () => {

    const {merch} = useContext(MerchContext) as IMerchContext;

    const createAndGetMerchJSX = () => {
        const merchJSX = merch.map((item) => {
            if (item.id != null) {
                return (
                    <section className="col-md-4 mb-4 d-flex justify-content-center align-items-center">
                        <div key={item.id}>
                            <MerchItem
                                name={item.name}
                                image={item.image}
                                price={item.price}
                            />
                            <PurchaseMerch id={item.id} />
                        </div>
                    </section>
                );
            }
            return null; 
        });

        return merchJSX;
    };

    return(
        <section className="container mt-4">
            <div className="row g-3">
                {createAndGetMerchJSX()}
            </div>
        </section>
    )
}

export default MerchList;