<%-- 
    Document   : index
    Created on : Aug 30, 2021, 3:24:37 PM
    Author     : truongtn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="<c:url value="/css/style.css"/>" rel="stylesheet"/>
    </head>
    <body>
        <a href="<c:url value="/test"/>">Redirect/forward</a>
        <div>
            <img src="<c:url value="/images/default.jpeg"/>" alt="test"/>
        </div>
        <h1>Welcome to home page</h1>
        <h1>Hello ${name}</h1>
        
        <c:if test="${full_name != null}">
            <h1>${full_name}</h1>
        </c:if>
        
            <ul>
                <c:forEach var="i" begin="1" end="10">
                    <c:choose>
                        <c:when test="${i%2==0}">
                            <li style="color:red">${i}</li>
                        </c:when>
                        <c:when test="${i%2==1}">
                            <li style="color:blue">${i}</li>
                        </c:when>
                    </c:choose>
                </c:forEach>
            </ul>
            
            <ol>
                <c:forEach var="u" items="${users}">
                    <li>${u.firstName} ${u.lastName}</li>
                </c:forEach>
            </ol>
            
            <ul>
                <c:forTokens var="f" delims="," items="Aplle,Lemon,Orange">
                    <li>${f}</li>
                </c:forTokens>
            </ul>
            
            <c:url var="action" value="/hello-post"/>
        <form:form method="post" action="${action}" modelAttribute="user">
            <spring:message code="label.firstName"/>
            <form:input path="firstName"/><br/>
            <spring:message code="label.lastName"/>
            <form:input path="lastName"/><br/>
            <input type="submit" value="Send"/>
        </form:form>
    </body>
</html>
