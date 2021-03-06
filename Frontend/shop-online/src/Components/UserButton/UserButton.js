import * as Icon from 'react-bootstrap-icons';
import "./UserButton.css"
import {useNavigate} from "react-router-dom";
import {useCookies} from "react-cookie";


const UserButton = ()=>{
    let navigate = useNavigate();
    const [cookies] = useCookies(['user_session']);
    let isLogged = cookies.user_session !== undefined;

    function openLogin() {
        navigate("/login")
    }


    if(!isLogged){
        return(
            <button id="userButtonUnloggedUser" className="userButton" onClick={openLogin}>
                <Icon.Person size="30" color="black"/>
            </button>
        )
    }else{
        return(
            <a href='http://localhost:8080/auth/logout' rel='noopener noreferrer' style={{color: "black", fontSize: "large", marginLeft: '10px', textDecoration: 'none'}}>
                <button id="userButtonLoggedUser" className="userButton">
                    <Icon.DoorOpen size="30" color="black"/>
                </button>
            </a>
        )
    }

}
export default UserButton;