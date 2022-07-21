const baseurl = "http://localhost:8080";

const getCategories = async ()=>{
    const url = baseurl+"/category";
    const response = await fetch(url,{
        headers: {'Content-Type' : 'application/json'}
    });
    return response.json();
}

const getCart = async ()=>{
    const url = baseurl+"/cart";
    const response = await fetch(url,{
        credentials:"include",
        headers: {'Content-Type' : 'application/json'}
    });
    return response.json();
}

const addToCart = async (productId)=>{
    const url = baseurl+'/cart';
    await fetch(url,{
        method: 'POST',
        credentials:"include",
        body: JSON.stringify(productId),
        headers: {'Content-Type' : 'application/json'}
    });
}

const getProducts = async (categoryId)=>{
    const url = baseurl+"/category/"+categoryId;
    const response = await fetch(url,{
        headers: {'Content-Type' : 'application/json'}
    });
    return response.json();
}

const removeFromCart = async (product)=>{
    const url = baseurl+'/cart';
    await fetch(url,{
        method: 'DELETE',
        credentials:"include",
        body: JSON.stringify(product.id),
        headers: {'Content-Type' : 'application/json'}
    });
}

const createOrder = async (address)=>{
    const url = baseurl+'/order';
    await fetch(url,{
        credentials:"include",
        method: 'PUT',
        body: JSON.stringify(address),
        headers: {'Content-Type' : 'application/json'}
    });
}

const cleanCart = async ()=>{
    const url = baseurl+'/cart/all';
    await fetch(url,{
        credentials:"include",
        method: 'DELETE',
        headers: {'Content-Type' : 'application/json'}
    });
}

const getOrders = async ()=>{
    const url = baseurl+'/order';
    const response = await fetch(url,{
        credentials:"include",
        headers: {'Content-Type' : 'application/json'}
    });
    return response.json();
}

module.exports = {
    getCategories,
    getCart,
    getProducts,
    removeFromCart,
    addToCart,
    createOrder,
    cleanCart,
    getOrders
}