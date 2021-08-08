<%-- 
    Document   : shopping
    Created on : Mar 1, 2021, 3:28:20 PM
    Author     : くろくん
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="duy.dao.Product_DAO"%>
<%@page import="java.util.List"%>
<%@page import="duy.dto.Product_DTO"%>
<%@page import="duy.dto.User_DTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>admin management</title>
    </head>
    <body>
        <%
            String result = request.getParameter("txtsearch");
            if (result == null) {
                result = "";
            }
        %>
        <c:set var="ad" value="${sessionScope.LOGIN_USER}"/>
        <h1>WELCOME TO COFFEE SHOP: ${ad.fullname}</h1>

        <form action="Main_Controller" >
            SEARCH <input type="text" name="txtsearch" value="<%=result%>" >
            <input type="submit" name="btaction" value="SEARCH" > </br>
            <input type="submit" name="btaction" value="LOG_OUT" >
        </form>

        <%
            List<Product_DTO> list = (List<Product_DTO>) request.getAttribute("SEARCHRESULTS");
            Product_DAO dao = new Product_DAO();
            if (list == null) {
                list = dao.getListProduct("");
            }
            if (list != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>NO.</th>
                    <th>ProductID</th>
                    <th>ProductName</th>
                    <th>Quantity</th>
                    <th>Prices</th>
                    <th>UPDATE</th>
                    <th>DELETE</th>
                </tr>
            </thead>

            <%
                int count = 1;
                for (Product_DTO dto : list) {
            %>
            <form action="Main_Controller">
                <tr>
                    <td><%=count++%></td>
                    <td><%=dto.getProID()%></td>
                    <td><input type="text" name="txtproname" value="<%=dto.getProName()%>"</td>
                    <td><input type="text" name="txtquantity" value="<%=dto.getQuantity()%>"</td>
                    <td><input type="text" name="txtprices" value="<%=dto.getPrice()%>"</td>
                    <td>
                        <input type="hidden" name="proID" value="<%=dto.getProID()%>">
                        <input type="hidden" name="txtsearch" value="<%=request.getParameter("txtsearch")%>">
                        <input type="submit" name="btaction" value="UPDATE" >
                    </td> 
                    <td>
                        <a href="Main_Controller?txtsearch=<%=request.getParameter("txtsearch")%>&btaction=DELETE&proID=<%=dto.getProID()%>">DELETE</a>
                    </td>
            </form>
        </tr>
        <%
            }
        %>

    </table>
    <form action="Main_Controller">
        <td>
            <a href="createproduct.jsp">Create Product</a>
        </td>
    </form>

    <%
        }
    %>
</body>
</html>
