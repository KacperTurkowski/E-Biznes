import * as Icon from 'react-bootstrap-icons';
import {useNavigate} from "react-router-dom"
import "./OrdersButton.css"
import {useCookies} from "react-cookie";

const OrdersButton = ()=>{
    const navigate = useNavigate();

    const [cookies] = useCookies(['user_session']);
    let isLogged = cookies.user_session !== undefined;

    const openOrders = ()=>{
        navigate("/orders")
    }

    if(isLogged){
        return(
            <button className="ordersButton" onClick={openOrders}><Icon.ClockHistory size="30" color="black"></Icon.ClockHistory></button>
        )
    }
    else{
        return (<></>)
    }
}
export default OrdersButton;