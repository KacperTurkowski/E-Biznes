import * as Icon from 'react-bootstrap-icons';
import {useNavigate} from "react-router-dom"
import "./HomeButton.css"

const HomeButton = ()=>{
    const navigate = useNavigate();

    const openLogin = ()=>{
        navigate("/")
    }

    return(
        <button id = "homeButton" className="homeButton" onClick={openLogin}><Icon.House size="30" color="black"></Icon.House></button>
    )
}
export default HomeButton;