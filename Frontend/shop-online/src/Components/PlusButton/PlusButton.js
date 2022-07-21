import * as Icon from "react-bootstrap-icons";
import Repository from "../../Repository";
import {useCookies} from "react-cookie";

const PlusButton = (props)=>{
    const{
        product
    } = props;

    function AddProduct(event) {
        event.stopPropagation()
        Repository.addToCart(product.id);
        alert("Do kosza dodano: "+product.name)
    }
    const [cookies] = useCookies(['user_session']);
    let isLogged = cookies.user_session !== undefined;

    if(isLogged){
        return(
            <button className="deleteButton" onClick={AddProduct}><Icon.Plus size="30" color="black"></Icon.Plus></button>
        )
    }
    else{
        return(<></>)
    }

}
export default PlusButton;