<%-- 
    Document   : checkout
    Created on : Mar 15, 2021, 11:06:50 PM
    Author     : くろくん
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>your bill</title>
    </head>
    <body>
        <c:set var="user" value="${sessionScope.LOGIN_USER}"/>
        <h1>USER NAME: ${user.fullname}</h1>
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
                    <c:set var="sum" value="0"/>
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
                            <c:set var="sum" value="${sum = sum+pro}"/>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <h1>TOTAL BILL :${sum}</h1>    

        </table>
        <form action="Main_Controller">
            <table>
                <tr>
                    <th>Ten khách hàng</th>
                    <td><input type="text" name="txtName" value="" required="true" </td>
                </tr>
                <tr>
                    <th>Số điện thoại</th>
                    <td><input type="text" name="txtSDT" value="" required="true"</td>
                </tr>
                <tr>
                    <th>Địa chỉ</th>
                    <td><input type="text" name="txtAdd" value="" required="true"</td>
                </tr>
                <tr>
                    <th>Phương thức thanh toán</th>
                    <td><select name="txtP">
                            <option>PAYPAL</option>
                            <option>MOMO</option>
                            <option>CASH</option>
                        </select>
                    </td>
                </tr>
            </table>

            <input type="submit" name="btaction" value="Confirm">
            <input type="hidden" name="txtTPrice" value="${sum}">
        </form>
    </c:if>
</body>
</html>
