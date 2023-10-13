<%-- 
    Document   : login
    Created on : Jun 26, 2023, 7:22:13 AM
    Author     : 84398
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="LoginServlet" method="post">
            <p><input type="text" name="txtid" placeholder="Enter your User ID" required=""/></p>
            <p><input type="password" name="txtpassword" placeholder="Enter your password" required=""/></p>
            <p><input type="submit" value="Login"/></p>
        </form>


    </body>
</html>
