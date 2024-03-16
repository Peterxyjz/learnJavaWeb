<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>You shopping cart</title>
    </head>
    <body>
        <h1>You shopping cart</h1>
        <a href="${pageContext.request.contextPath}/">Back to shopping page</a>
        <table border="1">
            <tr>
                <th>Product ID</th>
                <th>Product Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Amount</th>
                <th>Operation</th>
            </tr>
            <tbody>
                <c:forEach var="item" items="${cart.items}">
                <form action="update">
                    <tr>
                        <td>${item.product.id}
                            <input type="hidden" name="id" value="${item.id}" />
                        </td>
                        <td>${item.product.name}</td>
                        <td>${item.product.description}</td>
                        <td><fmt:formatNumber value="${item.product.price}" type="currency"/></td>
                        <td><input type="number" name="quantity" value="${item.quantity}" min="0" /></td>
                        <td><fmt:formatNumber value="${item.cost}" type="currency"/></td>
                        <td> <button type="submit" class="btn btn-link">Update</button> </td>
                    </tr>
                </form>
            </c:forEach>
        </tbody>
        <h3>Total money: ${cart.totalCost}</h3>
    </table>
</body>
</html>
