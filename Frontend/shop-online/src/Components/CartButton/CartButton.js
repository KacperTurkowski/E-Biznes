import * as Icon from 'react-bootstrap-icons';
import {useNavigate} from "react-router-dom"
import "./CartButton.css"
import {useCookies} from "react-cookie";

const CartButton = ()=>{
    const navigate = useNavigate();

    const openCart = ()=>{
        navigate("/cart")
    }
    const [cookies] = useCookies(['user_session']);
    let isLogged = cookies.user_session !== undefined;
    if(isLogged){
        return(
            <button id="cart-Button" className="cartButton" onClick={openCart}><Icon.Cart size="30" color="black"></Icon.Cart></button>
        )
    }
    else{
        return(<></>)
    }

}
export default CartButton;