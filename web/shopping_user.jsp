<%-- 
    Document   : shopping_user
    Created on : Mar 7, 2021, 11:44:56 AM
    Author     : くろくん
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="duy.dao.Product_DAO"%>
<%@page import="duy.dto.Product_DTO"%>
<%@page import="java.util.List"%>
<%@page import="duy.dto.User_DTO"%>
<%@page import="duy.dto.UserError_DTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>shopping</title>
    </head>

    <body>

        <%
            String result = request.getParameter("txtsearch");
            if (result == null) {
                result = "";
            }
        %>
        <c:set var="user" value="${sessionScope.LOGIN_USER}"/>
        <h1>WELCOME TO COFFEE SHOP: ${user.fullname}</h1>
        <form action="Main_Controller">
            SEARCH <input type="text" name="txtsearch" value="<%=result%>" >
            <input type="submit" name="btaction" value="SEARCH">
            <%
                String id = (String) session.getAttribute("use");
                if (id == null) {
                    id = "0";
                }
                if (id.equalsIgnoreCase("1")) {
            %>
            <input type="submit" name="btaction" value="LOG_OUT">
            <%}%>
        </form>
        <%
            List<Product_DTO> listpro = (List<Product_DTO>) request.getAttribute("SEARCHRESULTS");
            Product_DAO dao = new Product_DAO();
            if (listpro == null) {
                listpro = dao.getListProduct("");
            }
            if (listpro != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>NO.</th>
                    <th>ProductID</th>
                    <th>ProductName</th>
                    <th>Quantity</th>
                    <th>Prices</th>
                </tr>
            </thead>
            <%
                int count = 1;
                for (Product_DTO dto : listpro) {
            %>
            <tbody>
            <form action="Main_Controller">
                <tr>
                    <td><%=count++%></td>
                    <td><%=dto.getProID()%></td>
                    <td><%=dto.getProName()%></td>
                    <td><%=dto.getQuantity()%></td>
                    <td><%=dto.getPrice()%></td>
                    <td>
                        <input type="hidden" name="proID" value="<%=dto.getProID()%>">
                        <input type="submit" name="btaction" value="ADD TO CART" >

                    </td> 
                </tr>

            </form>
        </tbody>
        <%
            }
        %>
    </table>

    <%
        }
    %>
    <a href="viewcart.jsp">View Cart</a>
</body>
</html>
