<%-- 
    Document   : create_user
    Created on : Mar 6, 2021, 10:52:03 AM
    Author     : くろくん
--%>

<%@page import="duy.dto.UserError_DTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> register user </title>
    </head>
    <body>
        <%
            UserError_DTO Error = (UserError_DTO) request.getAttribute("DARA");
            if (Error == null) {
                Error = new UserError_DTO("", "", "", "");
            }
        %>
        <form action="Main_Controller" method="POST" >
            UserName: <input type="text" name="txtusername" required="true">
            <%=Error.getUsernameError()%></br>
            PassWord: <input type="text" name="txtpassword" required="true"> 
            <%=Error.getPasswordError()%></br>
            FullName: <input type="text" name="txtfullname" required="true"> 
            <%=Error.getFullnameError()%></br>
            Role: <input type="text" name="txtrole" required="true"> 
            <%=Error.getRoleError()%></br>
            <input type="submit" name="btaction" value="Create_Users" >
            <input type="reset" name="btaction" value="Reset" >
        </form>
    </body>
</html>
