import * as Icon from 'react-bootstrap-icons';
import {useNavigate} from "react-router-dom"
import "./HomeButton.css"

const HomeButton = ()=>{
    const navigate = useNavigate();

    const openLogin = (event)=>{
        navigate("/")
    }

    return(
        <button className="homeButton" onClick={openLogin}><Icon.House size="30" color="black"></Icon.House></button>
    )
}
export default HomeButton;