<%-- 
    Document   : GetFriendsConversationMessages
    Created on : Dec 24, 2012, 2:19:54 PM
    Author     : Mayank
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        
        <% 

        Collections.reverse((ArrayList)request.getAttribute("messages"));

        %>
        
        <c:set var="sessionUserId" value="${sessionScope.userId}"></c:set>
        <c:forEach items="${requestScope.messages}" var="messages" begin="0" end="2" step="1">
            
            
            <c:choose>
                <c:when test="${messages.senderId == sessionUserId}">
                                        
                    <div class="messageBox" messageId="<c:out value="${messages.messageId}"></c:out>" style="width:100%;display: block;float:left;margin-top: 1%; padding-bottom: 1%" >
                                <div style="float:right;width:60px; height: 60px;margin-right: 3%;"> <img style="width:inherit;height:inherit" src="resources/users/<c:out value="${messages.senderId}"></c:out>/profilepic/thumbs/<c:out value="${messages.currentProfilePic}"></c:out>.jpg"/> </div>
                                <div class="bubbleright"><p style="position:relative;left:6%"><c:out value="${messages.senderName}"></c:out>&nbsp;said:   
                                        <c:out value="${messages.message}"></c:out></p>
                            
                             
                            </div>
                    </div>
                                    
                </c:when>
            
            <c:otherwise>
                
                    <div class="messageBox" messageId="<c:out value="${messages.messageId}"></c:out>" style="width:100%;display: block;float:left;margin-top: 1%; padding-bottom: 1%;padding-left: 2%" >
                                <div style="float:left;width:60px; height: 60px;"> <img style="width:inherit;height:inherit" src="users/<c:out value="${messages.senderId}"></c:out>/profilepic/thumbs/<c:out value="${messages.currentProfilePic}"></c:out>.jpg"/> </div>
                                <div class="bubble"><p style="position:relative;right:14%"><c:out value="${messages.senderName}"></c:out>&nbsp;said:   
                                        <c:out value="${messages.message}"></c:out></p>
                            
                             
                            </div>
                    </div>
                
                
            </c:otherwise>
            </c:choose>
        </c:forEach>  
    </body>
</html>
