<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee List</title>
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;    
            }
        </style>
    </head>
    <body>
        <h1>Employee List</h1>
        <hr/>
        <!--your code here-->
        Welcome  ${account.fullName} |
        <a href="MainController?op=logout">Logout</a> |
        <a href="MainController?op=create&roleId=${account.roleId}">Create</a> <br/>
        <br/>
        <table>
            <thead style="text-align: center">
                <tr>
                    <td> Id </td>
                    <td> Full Name </td>
                    <td> Date of Birth </td>
                    <td> Salary </td>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="employee" items="${eList}">
                    <tr>
                        <td> ${employee.id} </td>
                        <td> ${employee.fullName} </td>
                        <td> ${employee.dob} </td>
                        <td> ${employee.salary} </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
