<%-- 
    Document   : GetImageLikesInfo
    Created on : Dec 30, 2012, 9:36:05 PM
    Author     : Mayank
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="width:250px;height:200px; overflow-x: hidden; overflow-y: auto;">   
    <c:forEach items="${requestScope.imageLikes}" var="imageLikes">
     <div style="width:100%;height:25%; margin-bottom: 5%;">
    <div style="width:20%;height:100%;display:block;float: left;margin-right:1%;"><img src="users/<c:out value="${imageLikes.friendId}"></c:out>/profilepic/thumbs/<c:out value="${imageLikes.currentProfilePic}"></c:out>.jpg" style="width:100%;height:60px; position: relative;top:8%;"/></div>
    <span style="color: #2191c0;font-size: 1em;float:left"><c:out value="${imageLikes.friendName}"></c:out></span>
     </div>                                      
        
    </c:forEach>
        </div>
        
    </body>
</html>
