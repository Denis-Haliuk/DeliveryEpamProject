
<%--
  Created by IntelliJ IDEA.
  User: liliy
  Date: 29.09.2022
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Page</title>
    <%@include file="links.jspf"%>
</head>
<body>

<%@ include file="header.jspf" %>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">#</th>
        <th scope="col">Receiver name</th>
        <th scope="col">Receiver phone</th>
        <th scope="col">Address</th>
        <th scope="col">Date</th>
        <th scope="col">state</th>

        <c:if test="${loginedUser.role == \"admin\"}">
            <th scope="col">state</th>
            <th>update</th>
        </c:if>
    </tr>
    </thead>

    <tbody>
    <jsp:useBean id="deliveryList" scope="request" type="java.util.List"/>
    <c:forEach var="delivery" items="${deliveryList}">
    <tr>
        <th scope="row"><c:out value="${delivery.getId()}"/></th>
        <th ><c:out value="${delivery.getReceiverName()}"/></th>
        <th ><c:out value="${delivery.getReceiverPhone()}"/></th>
        <td><c:out value="${delivery.getReceiverAddress()}"/></td>
        <td><c:out value="${delivery.getDate()}"/></td>
        <td><c:out value="${delivery.getStateId()}"/></td>


        <c:if test="${loginedUser.role == \"admin\"}">
            <td>
                <form action="userPage" method="post">
                    <input hidden name="idDelivery" value="<c:out value="${delivery.getId()}"/>">

                    <select id="selectType" class="form-select" name="stateId" required="required">
                        <option value="1">created</option>
                        <option value="2">shipping</option>
                        <option value="3">delivered</option>
                    </select>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </td>
        </c:if>

    </tr>
    </c:forEach>
    </tbody>
</table>




</body>
</html>
