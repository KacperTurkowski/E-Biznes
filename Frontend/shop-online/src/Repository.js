const baseurl = "http://localhost:8080";

const getCategories = async ()=>{
    const url = baseurl+"/category";
    const response = await fetch(url,{
        headers: {'Content-Type' : 'application/json'}
    });
    return response.json();
}

module.exports = {
    getCategories
}