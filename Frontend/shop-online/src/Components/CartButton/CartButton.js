import * as Icon from 'react-bootstrap-icons';
import {useNavigate} from "react-router-dom"
import "./CartButton.css"

const CartButton = ()=>{
    const navigate = useNavigate();

    const openCart = (event)=>{
        navigate("/cart")
    }

    return(
        <button className="cartButton" onClick={openCart}><Icon.Cart size="30" color="black"></Icon.Cart></button>
    )
}
export default CartButton;