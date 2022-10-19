<%--
  Created by IntelliJ IDEA.
  User: liliy
  Date: 15.10.2022
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create delivery</title>
    <%@include file="links.jspf" %>
</head>
<body>

<%@ include file="header.jspf" %>


<div class="container-md">

    <h3>Create new delivery</h3>
    <hr>
    <form action="delivery" method="post">
        <ul class="nav nav-tabs" id="myTab" role="tablist">
            <li class="nav-item" role="presentation">
                <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button"
                        role="tab" aria-controls="home" aria-selected="true">Sender
                </button>
            </li>
            <li class="nav-item" role="presentation">
                <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button"
                        role="tab" aria-controls="profile" aria-selected="false">Package
                </button>
            </li>
            <li class="nav-item" role="presentation">
                <button class="nav-link" id="contact-tab" data-bs-toggle="tab" data-bs-target="#contact" type="button"
                        role="tab" aria-controls="contact" aria-selected="false">Receiver
                </button>
            </li>
        </ul>
        <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                <input type="hidden" name="user_id" value="${loginedUser.getId()}">
                <label for="full_name" class="form-label">Full Name</label>
                <input type="text" name="full_name" class="form-control" required="required" id="full_name">

                <label for="sender_phone" class="form-label">Phone</label>
                <input type="tel" placeholder="0501234455" name="sender_phone" required="required" class="form-control"
                       id="sender_phone" pattern="[0-9]{10}">
            </div>
            <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                <div class="mb-3">
                    <label for="selectType" class="form-label">Type</label>
                    <select id="selectType" class="form-select" name="type_id" required="required">
                        <option value="1">letter</option>
                        <option value="2">s_package</option>
                        <option value="3">m_package</option>
                        <option value="4">l_package</option>
                        <option value="5">xl_package</option>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="weight" class="form-label">Weight</label>
                    <input type="number" id="weight" name="weight" class="form-control" required="required"
                           placeholder="Enter weight">
                </div>
            </div>
            <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">
                <label for="receiver_name" class="form-label">Full Name</label>
                <input type="text" name="receiver_name" class="form-control" required="required" id="receiver_name">

                <label for="receiver_phone" class="form-label">Phone</label>
                <input type="text" placeholder="0501234455" name="receiver_phone" required="required"
                       class="form-control" id="receiver_phone" pattern="[0-9]{10}">


                <div class="mb-3">
                    <label for="selectCity" class="form-label">City</label>
                    <select id="selectCity" class="form-select" name="direction_id" required="required">
                        <option value="1">Kyiv</option>
                        <option value="2">Kharkiv</option>
                        <option value="3">Poltava</option>
                        <option value="4">Lviv</option>
                        <option value="5">Odesa</option>
                        <option value="6">Ivano-Frankivs`k</option>
                        <option value="7">Donets`k</option>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="address" class="form-label">Address</label>
                    <input type="text" id="address" name="receiver_address" class="form-control" required="required"
                           placeholder="Enter address">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </div>

    </form>
</div>


</body>
</html>
