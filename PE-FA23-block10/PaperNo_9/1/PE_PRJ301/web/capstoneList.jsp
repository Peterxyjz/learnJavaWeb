<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Capstone list</title>
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;    
            }
        </style>
    </head>
    <body>
        <!--your code here-->
        Welcome ${user.fullName} |
        <a href="MainController?action=logout">Logout</a>
        <br/>
        <br/>
        <form action="search">
            <input type="text" name="search_input"> 
            <button type="submit" >Search</button> 
        </form>
        <br/>
        <c:if test="${not empty caList}">
            <table>
                <thead>
                    <tr>
                        <td>No</td>
                        <td>Id</td>
                        <td>Description</td>
                        <td>UserId</td>
                        <td>Operation</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="capstone" items="${caList}" varStatus="loop">
                        <tr>
                            <td>${loop.count}</td>
                            <td>${capstone.id}</td>
                            <td>${capstone.description}</td>
                            <td>${capstone.userId}</td>
                            <td>
                                <a href="MainController?action=delete&id=${capstone.id}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

    </body>
</html>
