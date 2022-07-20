import * as Icon from 'react-bootstrap-icons';

const GithubButton = ()=>{
    return(
        <a href='http://localhost:8080/auth_github' rel='noopener noreferrer'>
            <button>
                <Icon.Github size="30" color="black"/>
            </button>
        </a>
    )
}
export default GithubButton;