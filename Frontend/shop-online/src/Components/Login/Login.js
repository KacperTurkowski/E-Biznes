import GoogleButton from "../GoogleButton/GoogleButton";
import GithubButton from "../GithubButton/GithubButton";

const LoginPage = ()=>{
    return(
        <>
            <h1> Zaloguj się </h1>
            <GoogleButton/>
            <br/>
            <br/>
            <GithubButton/>
        </>
    )
}
export default LoginPage;