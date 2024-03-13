<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JDBC DEMO</title>
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
            }
        </style>
    </head>
    <body>
        <h1>JDBC DEMO</h1>
        <hr/>
        <!--view-->
        <jsp:include page="/WEB-INF/views/${controller}/${action}.jsp"/>
        <hr/>
        <div>
            Copyright &copy; 2024 ABCDEFGH 
        </div>
    </body>
</html>
