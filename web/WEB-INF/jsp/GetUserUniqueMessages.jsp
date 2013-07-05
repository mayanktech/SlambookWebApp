<%-- 
    Document   : GetUserUniqueMessages
    Created on : Dec 24, 2012, 6:29:41 PM
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
                        <c:forEach items="${requestScope.messageList}" var="messages">
                            <div style="width:100%; border-bottom: 1px solid #888;display: block;float:left;margin-top: 1%; padding-bottom: 1%;" >
                                <div style="float:left;width:50px; height: 50px;"> <img style="width:inherit;height:inherit" src="resources/users/<c:out value="${messages.senderId}"></c:out>/profilepic/thumbs/<c:out value="${messages.currentProfilePic}"></c:out>.jpg"/> </div>
                                <div class="bubble"><p style="position:relative;right:8%"><c:out value="${messages.senderName}"></c:out>&nbsp;said:   
                                        <c:out value="${messages.message}"></c:out></p>
                            
                             <button class="viewMessageConversation" senderId="<c:out value="${messages.senderId}"></c:out>">View All Messages</button>
                            </div>
                               </div>
                        </c:forEach>
    </body>
</html>
