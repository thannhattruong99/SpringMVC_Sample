<%-- 
    Document   : product
    Created on : Sep 1, 2021, 1:34:18 PM
    Author     : truongtn
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 class="text-center text-danger">Manage products</h1>
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>
<c:url value="/admin/products" var="action"/>
<form:form method="post" action="" modelAttribute="product" enctype="multipart/form-data">
    <form:errors path="*" cssClass="alert alert-danger" element="div"/>
    <div class="form-group">
        <label for="name">Product name</label>
        <form:input type="text" id="name" cssClass="form-control" path="name"/>
        <form:errors path="name" cssClass="text-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="description">Description</label>
        <form:textarea id="description" cssClass="form-control" path="description"/>
    </div>
    <div class="form-group">
        <label for="price">Price</label>
        <form:input type="text" id="price" cssClass="form-control" path="price"/>
        <form:errors path="price" cssClass="text-danger" element="div"/>
    </div>
     <div class="form-group">
        <label for="price">Category</label>
        <form:select id="category" cssClass="form-control" path="category">
            <c:forEach var="cate" items="${categories}">
                <option value="${cate.id}">${cate.name}</option>
            </c:forEach>
        </form:select>
        <%--<form:input type="text" id="category" cssClass="form-control" path="category"/>--%>
        <form:errors path="category" cssClass="text-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="file">Product image</label>
        <form:input type="file" id="images" cssClass="form-control" path="file"/>
    </div>
    <div class="form-group">
        <input type="submit" value="Add Product" class="btn btn-danger"/>
    </div>
</form:form>