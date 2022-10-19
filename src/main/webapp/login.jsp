<%--
  Created by IntelliJ IDEA.
  User: liliy
  Date: 29.09.2022
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
    <%@include file="links.jspf" %>
</head>
<body>

<%@ include file="header.jspf" %>

<div class="col" style="display: flex; justify-content: space-around">
    <div style="width: 18rem">
        <form action="login" method="post">
            <div class="form-group">
                <label for="InputEmail">Email address</label>
                <input name="email" type="email" class="form-control" id="InputEmail" aria-describedby="emailHelp"
                       placeholder="Enter email">
                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
            </div>
            <div class="form-group">
                <label for="InputPassword">Password</label>
                <input name="password" type="password" class="form-control" id="InputPassword" placeholder="Password">
            </div>
            <button type="submit" class="btn btn-primary">Login</button>
        </form>
        <p>Don`t have an account?</p> <a href="register">Register</a>

    </div>
</div>


</body>
</html>
