<%-- 
    Document   : friendsNotifications
    Created on : Dec 17, 2012, 5:32:28 PM
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
        
         
        <div class="friendsNotifications" style="width:100%;height:100%;clear: both">
        <c:set var="videoClassName" scope="page" value="com.slambook.model.AddVideoNotification"/>
         <c:set var="imageClassName" scope="page" value="com.slambook.model.AddImageNotification"/>
         <c:set var="albumClassName" scope="page" value="com.slambook.model.AddAlbumNotification"/>
         <c:set var="profilePicClassName" scope="page" value="com.slambook.model.AddProfilePicNotification"/>
        <c:forEach items="${requestScope.notifications}" var="notification">
            
            <c:set var="className" scope="page" value="${notification.getClass().name}"/>
            
                      
            <c:choose>
                
                <c:when test="${className == videoClassName}">

            
                    <div class="notificationsMainDiv">
                        
                        <div class="friendprofilePic">
                            
                            <img src="users/<c:out value="${notification.friendId}"></c:out>/profilepic/thumbs/<c:out value="${notification.currentProfilePic}"></c:out>.jpg"/>
                            
                        </div>
                            <div class="bubble" style="height:30px"> <c:out value="${notification.friendName}"></c:out>&nbsp;uploaded a new video&nbsp;<a class="fancybox fancybox.iframe" href="GetVideoComments?videoId=<c:out value="${notification.videoId}"></c:out>"><c:out value="${notification.videoDescription}"></c:out></a></div>
                        
                    </div>
                    
                    

                </c:when>

                <c:when test="${className == imageClassName}">

                    <div class="notificationsMainDiv">
                        
                        <div class="friendprofilePic">
                            
                            <img src="users/<c:out value="${notification.friendId}"></c:out>/profilepic/thumbs/<c:out value="${notification.currentProfilePic}"></c:out>.jpg"/>
                            
                        </div>
                            
                                    <div class="bubble" style="height:30px"><c:out value="${notification.friendName}"></c:out>&nbsp;uploaded new images to an album&nbsp;<span class="getFriendsAlbum" friendId="<c:out value="${notification.friendId}"></c:out>" albumId="<c:out value="${notification.albumId}"></c:out>"><c:out value="${notification.albumName}"></c:out></span></div>        
                    </div>

                </c:when>

                <c:when test="${className == albumClassName}">

                    <div class="notificationsMainDiv">
                        
                        <div class="friendprofilePic">
                            
                            <img src="users/<c:out value="${notification.friendId}"></c:out>/profilepic/thumbs/<c:out value="${notification.currentProfilePic}"></c:out>.jpg"/>
                            
                        </div>
                          
                                    <div class="bubble" style="height:30px"> <c:out value="${notification.friendName}"></c:out>&nbsp;created a new album&nbsp;<span class="getFriendsAlbum" friendId="<c:out value="${notification.friendId}"></c:out>" albumId="<c:out value="${notification.albumId}"></c:out>"><c:out value="${notification.albumName}"></c:out></span>        </div>
                        
                    </div>

                </c:when>

                <c:when test="${className == profilePicClassName}">

                    <div class="notificationsMainDiv">
                        
                        <div class="friendprofilePic">
                            
                            <img src="users/<c:out value="${notification.friendId}"></c:out>/profilepic/thumbs/<c:out value="${notification.profilePicId}"></c:out>.jpg"/>
                            
                        </div>
                            
                                    <div class="bubble" style="height:30px"> <c:out value="${notification.friendName}"></c:out>&nbsp;changed his profile picture </div>
                    </div>

                </c:when>

            </c:choose>
            
             
        </c:forEach>
        </div>
    </body>
</html>
