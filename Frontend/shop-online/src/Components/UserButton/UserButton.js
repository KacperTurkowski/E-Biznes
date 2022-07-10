import * as Icon from 'react-bootstrap-icons';
import {useNavigate} from "react-router-dom"
import "./UserButton.css"

const UserButton = ()=>{
    const navigate = useNavigate();


    const openLogin = ()=>{
        navigate("/login/")
    }

    return(
        <button className="userButton" onClick={openLogin}><Icon.Person size="30" color="black"></Icon.Person></button>
    )
}
export default UserButton;