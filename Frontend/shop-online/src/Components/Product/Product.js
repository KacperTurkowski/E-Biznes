import CardContent from "@mui/material/CardContent";
import Typography from "@mui/material/Typography";
import Card from "@mui/material/Card";

import PlusButton from "../PlusButton/PlusButton";

const Product = (props)=>{
    const{
        product
    } = props;

return(
    <Card id="product">
        <CardContent>
            <Typography id="productName" variant="h5" component="div">
                {product.name}
            </Typography>
            <Typography id="productPrice" sx={{ mb: 1.5 }} color="text.secondary">
                {product.price} PLN
            </Typography>
            <Typography id="productDescription" variant="body2">
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