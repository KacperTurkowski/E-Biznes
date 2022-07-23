import {useEffect, useState} from "react";
import Repository from "../../Repository";
import ProductInCart from "../ProductInCart/ProductInCart";
import UserButton from "../UserButton/UserButton";
import HomeButton from "../HomeButton/HomeButton";
import TextField from '@mui/material/TextField';
import "./CartPage.css"

const CartPage = ()=>{
    const defaultValue = {};
    defaultValue.products = [];

    const [cart, setCart] = useState(defaultValue);
    const [address, setAddress] = useState('');

    useEffect(() => {
        Repository
            .getCart()
            .then(json => {
                setCart(json)
            })
    }, {});

    async function addOrder(){
        await Repository.createOrder(address);
        await Repository.cleanCart();
        window.location.reload()
    }

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
            <h4>Złóż zamówienie</h4>
            <TextField onChange={event => setAddress(event.target.value)} className="addressTextEdit" id="outlined-basic" label="Adres" variant="outlined" />
            <br/>
            <br/>
            <button id="orderButton" className="orderButton" onClick={addOrder}>Złóż zamówienie</button>
        </>
    )
}
export default CartPage;