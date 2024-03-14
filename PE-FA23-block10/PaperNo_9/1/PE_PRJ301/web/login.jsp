<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <!--your code here-->
        <form action="login">
            User ID:<br/>
            <input type="text" name="userId" /><br/>
            Password:<br/>
            <input type="password" name="password" /><br/><br/>
            <button type="submit" name="op" value="login">Login</button>
        </form>
        <i>${message}</i>
    </body>
        
</html>

