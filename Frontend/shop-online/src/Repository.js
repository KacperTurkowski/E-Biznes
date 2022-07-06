const baseurl = "http://localhost:8080";

const getCategories = async ()=>{
    const url = baseurl+"/category";
    const response = await fetch(url,{
        headers: {'Content-Type' : 'application/json'}
    });
    return response.json();
}

const getCart = async ()=>{
    const url = baseurl+"/cart/1";
    const response = await fetch(url,{
        headers: {'Content-Type' : 'application/json'}
    });
    return response.json();
}

const getProducts = async (categoryId)=>{
    const url = baseurl+"/category/"+categoryId;
    const response = await fetch(url,{
        headers: {'Content-Type' : 'application/json'}
    });
    return response.json();
}

module.exports = {
    getCategories,
    getCart,
    getProducts
}