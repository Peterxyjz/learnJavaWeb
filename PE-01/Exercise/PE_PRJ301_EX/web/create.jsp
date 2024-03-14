<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creating Employee</title>
    </head>
    <body>
        <h1>Creating Employee</h1>
        <hr/>
        <!--your code here-->
        <form action="">
            Full Name:
            <input type="text" name="fullName" value="${param.fullName}" minlength="3" maxlength="50"> <br/>
            <br/>Date of Birth:
            <input type="date" name="dob" value="${param.dob}" min="0" > <br/>
            <br/>Salary: 
            <input type="number" name="salary" value="${param.salary}" min="0" > <br/><br/>
            <button type="submit" name="op" value="create_handler">Create</button>        
        </form>
    </body>
</html>
