<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form action="edit_handler.do">
    <br/>
    Id: <input type="text" name="id" value="${toy.id}"> <br/>
    Name: <input type="text" name="name" value="${toy.name}"> <br/>
    Price: <input type="number" name="price" min="0" value="${toy.price}"> <br/>
    Expired date: <input type="date" name="expDate" value="${toy.expDate}"> <br/>
    Brand: <input type="text" name="brand" value="${toy.brand}"> <br/>
    <br/>
    <button type="submit" value="Edit">Edit</button>
</form>
    <br/>
<i style="color: red">${errMsg}</i>
