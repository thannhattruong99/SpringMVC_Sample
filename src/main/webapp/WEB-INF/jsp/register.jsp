<%-- 
    Document   : register
    Created on : Sep 1, 2021, 8:02:24 PM
    Author     : truongtn
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">Registry</h1>
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<c:url value="/register" var="action"/>
<form:form method="post" action="${action}" modelAttribute="user">
    <div class="form-group">
        <label>Username</label>
        <form:input type="text" id="username" path="username" class="form-control"/>
    </div>
    <div class="form-group">
        <label>First name</label>
        <form:input type="text" id="firstName" path="firstName" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Last name</label>
        <form:input type="text" id="lastName" path="lastName" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Email</label>
        <form:input type="email" id="email" path="email" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Password</label>
        <form:input type="password" id="password" path="password" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Re-type password</label>
        <form:input type="password" id="confirm-password" path="confirmPassword" class="form-control"/>
    </div>
    <div class="form-group">
        <input type="submit" value="Login"/>
    </div>
</form:form>
