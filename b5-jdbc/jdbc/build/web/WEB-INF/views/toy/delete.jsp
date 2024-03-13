<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form action="delete_handler.do">
    <br/>
    <h4>Are you sure to delete this toy (id = ${id})?</h4>
    <input type="hidden" name="id" value="${id}"/>
    <br/>
    <button type="submit" value="yes" name="op">YES</button>
    <button type="submit" value="no" name="op">NO</button>
</form>
    <br/>
<i style="color: red">${errMsg}</i>
