import { useContext } from 'react';
import { MerchContext } from '../../contexts/MerchContext';
import IMerchContext from '../../interfaces/IMerchContext';
import IPurchaseMerch from '../../interfaces/IPurchaseMerch';

const PurchaseMerch: React.FC<IPurchaseMerch> = ({ id }) => {

    const {merch, getMerchById} = useContext(MerchContext) as IMerchContext;

    // Lagre i localStorage - JSON.stringify
    const addToCart = async () => {
        const selectedItem = merch.find(item => item.id === id);

        if(selectedItem) {
            const result = await getMerchById(id);
        
            if(result){
                const addedToCart = JSON.parse(localStorage.getItem('cart items') || "[]");
                addedToCart.push(result);
                localStorage.setItem('cart items', JSON.stringify(addedToCart));
            } 
        }
    }

    return(
        <section>
            <div>
                <button className="btn btn-success" onClick={addToCart}>Add to cart</button>
            </div>
        </section>
    )
}

export default PurchaseMerch;