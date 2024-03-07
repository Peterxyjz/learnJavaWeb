<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form action="create_handler.do">
    <br/>
    Id: <input type="text" name="id" value="${param.id}"> <br/>
    Name: <input type="text" name="name" value="${param.name}"> <br/>
    Price: <input type="number" name="price" min="0" value="${param.price}"> <br/>
    Expired date: <input type="date" name="expDate" value="${param.expDate}"> <br/>
    Brand: <input type="text" name="brand" value="${param.brand}"> <br/>
    <br/>
    <button type="submit" value="create">Create</button>
</form>
    <br/>
<i style="color: red">${errMsg}</i>
