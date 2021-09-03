<%-- 
    Document   : header
    Created on : Aug 31, 2021, 8:16:29 PM
    Author     : truongtn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="#">Home</a>
    </li>
    <c:forEach var="cat" items="${categories}">
        <li class="nav-item">
        <a class="nav-link" href="#">${cat.name}</a>
        </li>
    </c:forEach>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/cart" />">Cart</a>
    </li>
    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <li class="nav-item">
            <a class="nav-link text-danger" href="<c:url value="/login"/>">Login</a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-danger" href="<c:url value="/register"/>">Registry</a>
        </li>
    </c:if>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <li class="nav-item">
            <a class="nav-link text-danger" href="<c:url value="/login"/>">${pageContext.request.userPrincipal.name}</a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-danger" href="<c:url value="/logout"/>">Logout</a>
        </li>
    </c:if>
  </ul>
</nav>