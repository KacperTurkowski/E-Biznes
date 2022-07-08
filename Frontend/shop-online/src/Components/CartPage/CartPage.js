import {useEffect, useState} from "react";
import Repository from "../../Repository";
import ProductInCart from "../ProductInCart/ProductInCart";
import UserButton from "../UserButton/UserButton";
import HomeButton from "../HomeButton/HomeButton";


const CartPage = ()=>{
    const defaultValue = {};
    defaultValue.products = [];

    const [cart, setCart] = useState(defaultValue);

    useEffect(() => {
        Repository
            .getCart()
            .then(json => {
                setCart(json)
            })
    }, {});

    return(
        <>
            <h1>Twój sklep</h1>
            <h3>Twój koszyk zakupowy</h3>
            <UserButton/>
            <HomeButton/>
            <div id="div" className="mainPanel">
                {
                    cart.products.map((product, index) => (
                        <>
                            <ProductInCart key={index} product={product}/>
                            <br/>
                        </>
                    ))
                }
            </div>
        </>
    )
}
export default CartPage;