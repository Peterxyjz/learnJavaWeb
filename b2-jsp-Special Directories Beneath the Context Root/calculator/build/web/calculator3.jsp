

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Caculator nè!</h1>
        <hr>
        <form action="calculator3" method="post"> 
            <!--mặc định là method: get-->
            <label for="n1">Number1:</label>
            <input type="number" name="num1" id="n1" value="${param.num1}"><br>
            <label for="n2">Number2:</label>
            <input type="number" name="num2" id="n2" value="${param.num2}"><br>
            <br>
            <input type="submit" value="Add" name="op">
            <input type="submit" value="Sub" name="op">
            <input type="submit" value="Mul" name="op">
            <input type="submit" value="Div" name="op">
        </form>
        <hr/>
        Result: ${result}
    </body>
</html>
