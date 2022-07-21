import * as Icon from 'react-bootstrap-icons';

const GithubButton = ()=>{
    return(
        <a href='http://localhost:8080/auth_github' rel='noopener noreferrer'>
            <button style={{
                width: "100px"
            }}>
                <Icon.Github size="30" color="black"/>
                <h4>Github</h4>
            </button>
        </a>
    )
}
export default GithubButton;