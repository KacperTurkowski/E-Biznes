import {useEffect, useState} from "react";
import Repository from "../../Repository";
import Product from "../Product/Product";

const ProductPage = (props)=>{
    const{
        categoryId
    } = props;

    const [products, setProducts] = useState([]);

    useEffect(() => {
        Repository
            .getProducts(categoryId)
            .then(json => {
                setProducts(json)
            })
    }, []);

    return(
        <>{
            products.map((product, index)=>(
                <>
                    <Product product = {product}/>
                <br/>
                </>
            ))
        }
        </>
    )
}
export default ProductPage;