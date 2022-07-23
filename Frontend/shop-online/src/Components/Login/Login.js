import GoogleButton from "../GoogleButton/GoogleButton";
import GithubButton from "../GithubButton/GithubButton";
import HomeButton from "../HomeButton/HomeButton";

const LoginPage = ()=>{
    return(
        <>
            <HomeButton/>
            <h1> Zaloguj się </h1>
            <GoogleButton/>
            <br/>
            <br/>
            <GithubButton/>
        </>
    )
}
export default LoginPage;