import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import Typography from "@mui/material/Typography";
import "./ProductInCart.css"
import * as Icon from "react-bootstrap-icons";
import Repository from "../../Repository";

const ProductInCart = (props)=>{
    const{
        product
    } = props;

    function DeleteProduct(event){
        event.stopPropagation()
        Repository.removeFromCart(product.product);
        window.location.reload()
    }

    return(
        <Card>
            <CardContent>
                <Typography variant="h5" component="div">
                    {product.product.name}
                </Typography>
                <Typography sx={{ mb: 1.5 }} color="text.secondary">
                    {product.product.price} PLN
                </Typography>
                <Typography variant="body2">
                    {product.product.description}
                    <br />
                    Ilość produktów w koszyku: {product.count}
                </Typography>

                <button className="deleteButton" onClick={DeleteProduct}><Icon.Trash size="30" color="black"></Icon.Trash></button>
            </CardContent>
        </Card>
    )
}
export default ProductInCart;