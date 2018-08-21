<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html">
<html>
<script src="http://code.jquery.com/jquery-1.10.2.min.js"
type="text/javascript"></script>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>">


<title>Car catalog</title>

</head>

<body>
<header>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
<button class="navbar-toggler" type="button" data-toggle="collapse"
data-target="#navbarTogglerDemo01"
aria-controls="navbarTogglerDemo01" aria-expanded="false"
aria-label="Toggle navigation">
<span class="navbar-toggler-icon"></span>
</button>
<div class="collapse navbar-collapse" id="navbarTogglerDemo01">
<a class="navbar-brand" href="<c:url value="/"/>">Car catalog</a>
<ul class="navbar-nav mr-auto mt-2 mt-lg-0">


</ul>
<div align="right">
<ul class="navbar-nav mr-auto mt-2 mt-lg-0" align="right">

<c:if test="${user==null }">
    <li class="nav-item active"><a class="nav-link"
    href="<c:url value="/login.html"/>">Login</a></li>
    <li class="nav-item active"><a class="nav-link"
    href="<c:url value="/signup.html"/>">Signup</a></li>
</c:if>

<c:if test="${user!=null }">
    <li class="nav-item active"><a class="nav-link"
    href="<c:url value="/profile.html"/>">Profile</a></li>
    <li class="nav-item active"><a class="nav-link"
    href="<c:url value="/logout.html"/>">Logout</a></li>
</c:if>

</ul>
</div>
</div>
</nav>
</header>