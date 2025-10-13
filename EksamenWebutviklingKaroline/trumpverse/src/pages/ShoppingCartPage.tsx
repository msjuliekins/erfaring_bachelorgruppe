import ShoppingCart from "../components/shoppingCart/ShoppingCart";
import { MerchProvider } from "../contexts/MerchContext";

const ShoppingCartPage = () => {
    return(
        <section>
            <MerchProvider>
                <ShoppingCart/>
            </MerchProvider> 
        </section>
    )
}

export default ShoppingCartPage;