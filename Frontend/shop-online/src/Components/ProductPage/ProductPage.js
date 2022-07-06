import {useEffect, useState} from "react";
import Repository from "../../Repository";

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
    // console.log(products)
    return(
        <>{
            products.map((product, index)=>(
                <div key={index}>
                    <label>{product.name}</label>
                </div>
            ))
        }
        </>
    )
}
export default ProductPage;