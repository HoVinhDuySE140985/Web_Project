<%-- 
    Document   : createproduct
    Created on : Mar 5, 2021, 10:09:01 AM
    Author     : くろくん
--%>

<%@page import="duy.dto.ProductError_dto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>create a new product</title>
    </head>
    <body>
        <%
            ProductError_dto error = (ProductError_dto) request.getAttribute("ERROR");
            if (error == null) {
                error = new ProductError_dto("", "", "", "");
            }
        %>
        <form action="Main_Controller" method="POST">
            ProductID <input type="text" name="txtproductid" required="true" >
            <%=error.getProductID_ERROR()%> </br>
            ProductName <input type="text" name="txtproductname" required="true" > 
            <%=error.getProductName_ERROR()%> </br>
            Prices <input type="text" name="txtprices" required="true" > 
            <%=error.getPrices_ERROR()%> </br>
            Quantity <input type="text" name="txtquantity" required="true" > 
            <%=error.getQuantity_ERROR()%> </br>
            <input type="submit" name="btaction" value="Create" >
            <input type="submit" name="btaction" value="Reset" >
        </form>
    </body>
</html>
