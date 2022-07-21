import CardContent from "@mui/material/CardContent";
import Typography from "@mui/material/Typography";
import Card from "@mui/material/Card";
import * as Icon from "react-bootstrap-icons";
import Repository from "../../Repository";
import PlusButton from "../PlusButton/PlusButton";

const Product = (props)=>{
    const{
        product
    } = props;

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
                <PlusButton product={product} />
                <br />
            </Typography>
        </CardContent>
    </Card>
)
}
export default Product;