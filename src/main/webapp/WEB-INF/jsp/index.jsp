<%-- 
    Document   : index
    Created on : Aug 30, 2021, 3:24:37 PM
    Author     : truongtn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<h1 class="text-center text-danger">List of product</h1>

<sec:authorize access="hasRole('ROLE_ADMIN')">
   <div>
       <a href="<c:url value="/admin/products"/>" class="btn btn-danger">Manage product</a>
   </div> 
</sec:authorize>

<form action="">
    <div class="row">
        <div class="col-md-11">
            <input class="form-control" type="text" name="searchValue" placeholder="Search product"/>
        </div>
        <div class="col-md-1">
            <input type="submit" value="Search" class="btn btn-danger"/>
        </div>
    </div>
</form>
<div>
    <ul class="pagination">
        <c:forEach begin="1" end="${Math.ceil(counter/6)}" var="i">
             <li class="page-item"><a class="page-link" href="<c:url value=""/>?page=${i}">${i}</a></li>
        </c:forEach>
    </ul>
</div>
<div class="row">
    <c:forEach var="p" items="${products}">
        <div class="card col-md-4">
            <div class="card-body">
                <c:if test="${p.image != null && p.image.startsWith('https') == true}">
                    <image class="img-fluid" src="<c:url value="${p.image}"/>" alt="${p.name}"/>
                </c:if>
                <c:if test="${p.image == null || p.image.startsWith('https') == false}">
                    <image class="img-fluid" src="<c:url value="images/default.jpeg"/>" alt="${p.name}"/>
                </c:if>
            </div>
            <div class="card-footer bg-info">
                <h3>${p.name}</h3>
                <p>${p.price} VND</p>
            </div>
        </div>
    </c:forEach>
</div>
    