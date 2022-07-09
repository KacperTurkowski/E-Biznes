import * as Icon from 'react-bootstrap-icons';
import {useNavigate} from "react-router-dom"
import "./OrdersButton.css"

const OrdersButton = ()=>{
    const navigate = useNavigate();

    const openOrders = (event)=>{
        navigate("/orders")
    }

    return(
        <button className="ordersButton" onClick={openOrders}><Icon.ClockHistory size="30" color="black"></Icon.ClockHistory></button>
    )
}
export default OrdersButton;