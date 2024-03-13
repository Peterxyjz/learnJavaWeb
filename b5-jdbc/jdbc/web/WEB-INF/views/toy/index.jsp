<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>List of Toys</h3>
<hr/>
<a href="create.do">Create</a>
<br/>
<br/>
<table >
    <thead>
        <tr>
            <th>Id</th>
            <th style="text-align: left">Name</th>
            <th>Price</th>
            <th>Expired Date</th>
            <th>Brand Id</th>
            <th>Operations</th>

        </tr>
    </thead>
    <tbody>
        <c:forEach var="toy" items="${list}" >
            <tr>
                <!--truy cập property id của toy-->
                <th>${toy.id}</th>
                <th style="text-align: left">${toy.name}</th>
                <th>${toy.price}</th>
                <th>${toy.expDate}</th>
                <th>${toy.brand}</th>
                <td>
                    <a href="edit.do?id=${toy.id}">Edit</a> |
                    <a href="delete.do?id=${toy.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<i>${errMsg}</i>