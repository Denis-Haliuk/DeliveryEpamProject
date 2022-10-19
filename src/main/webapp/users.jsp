<%--
  Created by IntelliJ IDEA.
  User: liliy
  Date: 08.09.2022
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Users</title>
    <%@include file="links.jspf"%>
</head>

<body>
<%@ include file="header.jspf" %>

<h1>Users</h1>

<jsp:useBean id="userList" scope="request" type="java.util.List"/>

<div class="col" style="display: flex; justify-content: space-around">
    <c:forEach var="user" items="${userList}">
        <div class="card" style="width: 18rem;">
            <img src="https://picsum.photos/200">
            <div class="card-body">
                <h5 class="card-title"><c:out value="${user.getEmail()}"/></h5>
                <ul class="card-text">
                    <li>id: <c:out value="${user.getId()}"/></li>
                    <li>email: <c:out value="${user.getEmail()}"/></li>
                    <li>role: <c:out value="${user.getRole()}"/></li>
                </ul>
                <a href="<c:url value="/userDeliveries?userId=${user.getId()}"/>" class="btn btn-primary">deliveries🥰</a>
            </div>
        </div>
    </c:forEach>
</div>



</body>
</html>
