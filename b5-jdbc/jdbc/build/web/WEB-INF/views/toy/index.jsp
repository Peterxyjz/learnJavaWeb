<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>List of Toys</h3>
<hr/>
<table>
    <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Expired Date</th>
            <th>Brand Id</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="toy" items="${list}" >
            <tr>
                <!--truy cập property id của toy-->
                <th>${toy.id}</th>
                <th>${toy.name}</th>
                <th>${toy.price}</th>
                <th>${toy.expDate}</th>
                <th>${toy.brand}</th>
            </tr>
        </c:forEach>
    </tbody>
</table>
<i>${errMsg}</i>