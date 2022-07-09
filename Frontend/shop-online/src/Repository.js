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

const addToCart = async (productId)=>{
    const url = baseurl+'/cart';
    let temp = {}
    temp.productId = productId;
    temp.userId = 1
    await fetch(url,{
        method: 'POST',
        body: JSON.stringify(temp),
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
    let temp = {}
    temp.productId = product.id;
    temp.userId = 1
    await fetch(url,{
        method: 'DELETE',
        body: JSON.stringify(temp),
        headers: {'Content-Type' : 'application/json'}
    });
}

const createOrder = async (address)=>{
    const url = baseurl+'/order';
    let temp={}
    temp.userId = 1;
    temp.address = address;
    await fetch(url,{
        method: 'PUT',
        body: JSON.stringify(temp),
        headers: {'Content-Type' : 'application/json'}
    });
}

const cleanCart = async ()=>{
    const url = baseurl+'/cart/all';
    await fetch(url,{
        method: 'DELETE',
        body: JSON.stringify(1),
        headers: {'Content-Type' : 'application/json'}
    });
}

const getOrders = async (userId)=>{
    const url = baseurl+'/order/'+userId;
    const response = await fetch(url,{
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