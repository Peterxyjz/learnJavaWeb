<%-- 
    Document   : equation1
    Created on : Jan 24, 2024, 8:40:54 PM
    Author     : HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Equation1</title>
    </head>
    <body>
        <h1>Equation1: ax + b = 0</h1>
        <hr/>
        <form action="equation1">
            Faction a: <input type="number"  value="${param.a}" name="a" placeholder="Enter value for a"><br/>
            Faction b: <input type="number" value="${param.b}" name="b" placeholder="Enter value for a"><br/>
            <br/>
            <input type="submit" value="Solve">
            <input type="reset" value="Reset">
        </form>
        <hr/>
        Result: ${result}
    </body>
</html>
