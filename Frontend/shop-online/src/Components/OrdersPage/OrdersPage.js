import {useEffect, useState} from "react";
import Repository from "../../Repository";
import CardContent from "@mui/material/CardContent";
import Typography from "@mui/material/Typography";
import Card from "@mui/material/Card";
import "./OrdersPage.css"
import HomeButton from "../HomeButton/HomeButton";

const OrdersPage = ()=>{
    const [orders, setOrders] = useState([]);

    useEffect(() => {
        Repository
            .getOrders()
            .then(json => {
                setOrders(json)
            })
    }, []);
    return(
        <>
            <h1 id="historyTitle">Historia zamówień</h1>
            <HomeButton/>
            {
            orders.map((order, index)=>(
                <>
                    <Card key = {index} id="order" className = "order">
                        <CardContent>
                            <Typography id={'order_date_'+index} variant="h5" component="div">
                                {order.date}
                            </Typography>
                            <Typography id={'order_price_'+index} sx={{ mb: 1.5 }} color="text.secondary">
                                {order.price} PLN
                            </Typography>
                            <Typography id={'order_address_'+index} variant="h7">
                                {order.address}
                                <br />
                                <br />
                                <br />
                            </Typography>
                            <Typography variant="body2">
                                {
                                order.products.map((product, innerindex)=>(
                                    <>
                                        <label key={"product"+innerindex}>{product.name}</label>
                                        <br/>
                                    </>
                                    )
                                )
                            }
                                <br />
                            </Typography>
                        </CardContent>
                    </Card>
                    <br/>
                </>
            ))
        }
        </>
    )
}
export default OrdersPage;