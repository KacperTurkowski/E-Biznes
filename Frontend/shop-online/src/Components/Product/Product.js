import CardContent from "@mui/material/CardContent";
import Typography from "@mui/material/Typography";
import Card from "@mui/material/Card";
import * as Icon from "react-bootstrap-icons";
import Repository from "../../Repository";

const Product = (props)=>{
    const{
        product
    } = props;

    function AddProduct(event) {
        event.stopPropagation()
        Repository.addToCart(product.id);
        alert("Do kosza dodano: "+product.name)
    }

return(
    <Card >
        <CardContent>
            <Typography variant="h5" component="div">
                {product.name}
            </Typography>
            <Typography sx={{ mb: 1.5 }} color="text.secondary">
                {product.price} PLN
            </Typography>
            <Typography variant="body2">
                {product.description}
                <br />
            </Typography>
            <Typography variant="body2">
                <button className="deleteButton" onClick={AddProduct}><Icon.Plus size="30" color="black"></Icon.Plus></button>
                <br />
            </Typography>
        </CardContent>
    </Card>
)
}
export default Product;