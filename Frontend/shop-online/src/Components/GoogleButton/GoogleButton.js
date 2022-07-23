import * as Icon from 'react-bootstrap-icons';

const GoogleButton = ()=>{
    return(
        <a href='http://localhost:8080/auth' rel='noopener noreferrer'>
            <button id="googleButton" style={{
                width: "100px"
            }}>
                <Icon.Google size="30" color="black"/>
                <h4>Google</h4>
            </button>
        </a>
    )
}
export default GoogleButton;