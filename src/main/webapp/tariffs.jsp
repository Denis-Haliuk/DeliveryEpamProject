<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Tariffs</title>
    <%@include file="links.jspf" %>
</head>
<body>

<%@ include file="header.jspf" %>

<jsp:useBean id="tariffList" scope="request" type="java.util.List"/>
<br>

<div class="container-md">
    <div class="row">
        <div class="col col-4">
            <a class="btn btn-primary" href="<c:url value="/directions"/>">Directions</a>
            <hr>
            <a class="btn btn-success" href="<c:url value="/calc"/>">Calculate delivery price</a>
        </div>

        <div class="col col-8">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Cargo type</th>
                    <th scope="col">Price
                        <div class="dropdown">
                            <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown"
                                    aria-expanded="false">
                                <i class="fa-sharp fa-solid fa-sort"></i>
                            </button>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="<c:url value="/tariffs?sort=asc"/>"><i
                                        class="fa-solid fa-sort-up"></i></a></li>
                                <li><a class="dropdown-item" href="<c:url value="/tariffs?sort=desc"/>"><i
                                        class="fa-solid fa-sort-down"></i></a></li>
                            </ul>
                        </div>
                    </th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="tariff" items="${tariffList}">
                    <tr>
                        <td>${tariff.getCargoType()}</td>
                        <td>${tariff.getPrice()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
