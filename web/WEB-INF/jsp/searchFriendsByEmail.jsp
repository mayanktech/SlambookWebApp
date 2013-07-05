<%-- 
    Document   : searchFriends
    Created on : Oct 16, 2012, 8:46:55 PM
    Author     : Mayank
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <c:forEach items="${requestScope.friendsList}" var="friends">
            
            
            <c:out value="${friends.userId}"></c:out>
            <c:out value="${friends.firstName}"></c:out>
            <c:out value="${friends.lastName}"></c:out>
            
            
        </c:forEach>
        
    </body>
</html>
