<%-- 
    Document   : searchFriends
    Created on : Oct 16, 2012, 8:46:55 PM
    Author     : Mayank
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <head>
         <!-- <c:set var="url">${pageContext.request.requestURL}</c:set> -->
        <base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="width:100%;height: 100%;display:block;overflow: auto;">
            
        <c:forEach items="${requestScope.friendsList}" var="friends">
            
           
            <div style="display:block;width:90%;margin-left: 5%;margin-right: 5%;margin-top: 2%;border-bottom: 1px solid black;float:left;padding-bottom: 2%;">
            
                <div style="width:80px; height: 80px;display: inline;float:left">
                    <img  style="width:inherit;height: inherit"src="resources/users/<c:out value="${friends.userId}"></c:out>/profilepic/thumbs/<c:out value="${friends.profilePicId}${'.jpg'}"></c:out>"/>    
                </div>
                
                    <span style="font-size: 1.2em;margin-left: 4%;display:inline;float:left"><c:out value="${friends.firstName}"></c:out>&nbsp;
                <c:out value="${friends.lastName}"></c:out></span></br>
            
                <span>
                    
                    <button class="addToSlambookButton" style="float:left; display: inline;padding:1%;margin-top: 5%;margin-left: 2%;background-color: #61b832;color:white;border-radius: 5px" userId="<c:out value="${friends.userId}"></c:out>">Join His Slambook</button>
                    
                
                </span>
                
            </div>
            
            
        </c:forEach>
        </div>
    </body>
</html>
