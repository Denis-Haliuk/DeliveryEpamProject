<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Delivery</title>
    <%@include file="links.jspf" %>

    <style>

        .parent {
            display: grid;
            grid-template-columns: repeat(5, 1fr);
            grid-template-rows: repeat(5, 1fr);
            grid-column-gap: 20px;
            grid-row-gap: 20px;
        }

        .div1 {
            grid-area: 1 / 1 / 6 / 4;
        }

        .div2 {
            grid-area: 1 / 4 / 3 / 6;
        }

        .div3 {
            grid-area: 3 / 4 / 6 / 6;
        }

        .div4 {
            grid-area: 1 / 1 / 3 / 4;
        }

        .div5 {
            grid-area: 1 / 4 / 3 / 6;
        }

        .block {
            display: block;
            width: 100%;
            height: 100%;
            border: none;
            color: white;
            padding: 20px 20px 20px 20px;
            margin: 20px 20px 20px 20px;
            cursor: pointer;
            border: 1px black;
            border-radius: 35px;
            text-decoration: none;
        }

        .block:hover {
            background-color: #ddd;
            color: black;
        }
    </style>
</head>
<body>

<%@ include file="header.jspf" %>

<div class="container-md">
    <div class="parent">
        <div class="div1">
            <a href="delivery" style="background-color: #ac0dbd; font-size: 30px;
             text-align: left;"
               class="block">Create delivery</a>
        </div>
        <div class="div2">
            <a href="tariffs"
               style="margin-bottom: 10px; background-color: #37bd80; font-size: 23px; text-align: center;"
               class="block">Package tariffs</a>
        </div>
        <div class="div3">
            <a href="directions"
               style="background-color: cadetblue; font-size: 23px; text-align: center;"
               class="block">Directions</a>
        </div>
    </div>
</div>

<div class="container-md" style="margin-top: 20px">
    <div class="parent">
        <c:if test="${loginedUser.role == \"admin\"}">
            <div class="div4">
                <a href="users"
                   style="background-color: #d0516d; font-size: 23px; text-align: center;"
                   class="block">user deliveries</a>
            </div>
            <div class="div5">
                <a href="userPage"
                   style="background-color: #ccd061; font-size: 23px; text-align: center;"
                   class="block">my page</a>
            </div>
        </c:if>
    </div>

</div>


</body>
</html>
