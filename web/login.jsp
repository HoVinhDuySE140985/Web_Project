<%-- 
    Document   : login
    Created on : Mar 2, 2021, 10:46:33 PM
    Author     : くろくん
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login page</title>
    </head>
    <body>
        <form action="Main_Controller" >
            UserName <input type="text" name="txtusername" value="" required="true"> </br>
            PassWord <input type="password" name="txtpassword" value="" required="true"> </br>
            <input type="submit" name="btaction" value="Login">
            <a href="create_user.jsp">register </a> </br>
            <a href="shopping_user.jsp"> GO SHOPPING </a>
            
        </form>
    </body>
</html>
