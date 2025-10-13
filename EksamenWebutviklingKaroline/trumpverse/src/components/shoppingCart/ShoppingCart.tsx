import { useEffect, useState } from "react";
import MerchItem from "../merch/MerchItem";

const ShoppingCart = () => {

    const [cart, setCart] = useState<any[]>([]);

    useEffect(()=>{
        setCart(getCart());
        console.log(getCart());
    }, [])

    // Hente fra localstorage
    const getCart = () => {
        const itemsInCart = localStorage.getItem('cart items');
        if(itemsInCart) {
            return JSON.parse(itemsInCart);
        } else {
            return[];
        }
    }

    // Slette fra cart/localstorage
    const removeFromCart = (id: string) => {
        const updatedCart = cart.filter((item) => item.id !== id);
        setCart(updatedCart);
        // Oppdaterer localstorage
        localStorage.setItem('cart items', JSON.stringify(updatedCart));
        console.log("Produkt id", id, " er fjernet");
    }

    // Lage JSX
    const createAndGetMerchInCartJSX = () => {
        const merchInCartJSX = cart.map((item, index) => {
            if (item.id != null) {
                return (
                    <div className="col-md-4 mb-4" key={index}>
                        <MerchItem
                            name={item.name}
                            image={item.image}
                            price={item.price}
                        />
                        {/* https://stackoverflow.com/questions/51977823/type-void-is-not-assignable-to-type-event-mouseeventhtmlinputelement | onClick={() => this.fetchData("dfd")} */}
                        <button id={item.id} className="btn btn-danger" onClick={ () => removeFromCart (item.id) }>Remove from Cart</button>
                    </div>
                );
            }
            return null; 
        });

        return merchInCartJSX;
    };

    return(
        <section className="container mt-4">
            <div className="row g-3">
                {createAndGetMerchInCartJSX()}
            </div>
        </section>
    )
}

export default ShoppingCart;