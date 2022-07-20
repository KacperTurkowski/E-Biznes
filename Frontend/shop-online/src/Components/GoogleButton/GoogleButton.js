import * as Icon from 'react-bootstrap-icons';

const GoogleButton = ()=>{
    return(
        <a href='http://localhost:8080/auth' rel='noopener noreferrer'>
            <button  >
                <Icon.Google size="30" color="black"/>
            </button>
        </a>
    )
}
export default GoogleButton;