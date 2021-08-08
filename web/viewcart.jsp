<%-- 
    Document   : viewcart
    Created on : Mar 1, 2021, 3:28:48 PM
    Author     : くろくん
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>view your cart</title>
    </head>
    <body>
        <c:set var="cart" value="${sessionScope.CART}"/>
        <c:if test="${not empty cart}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>ProID</th>
                        <th>ProName</th>
                        <th>Quantity</th>
                        <th>Prices</th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="count" value="0"/>
                    <c:forEach var="rows" items="${cart}">
                        <tr>
                            <c:set var="count" value="${count+1}"/> 
                            <td>${count}</td>
                            <td>${rows.value.prodto.proID}</td>
                            <td>${rows.value.prodto.proName}</td>
                            <td>${rows.value.quantity}</td>
                            <c:set var="pro" value="${rows.value.prodto.price * rows.value.quantity}"/>
                            <td>${pro}</td>
                    <form action="Main_Controller">
                        <td><input type="submit" name="btaction" value="Remove"><input type="hidden" name="key" value="${rows.value.prodto.proID}"></td>
                    </form>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <form action="Main_Controller">
        <input type="submit" name="btaction" value="PayMent">
    </form>
</c:if>
<c:if test="${empty cart}">
    <h1>
        EMPTY CART !!!!!
    </h1>
    <a href="shopping_user.jsp">Add New Product To Cart</a>
</c:if>
</body>
</html>
