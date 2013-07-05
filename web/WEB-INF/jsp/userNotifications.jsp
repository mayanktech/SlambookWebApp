<%-- 
    Document   : userNotifications
    Created on : Dec 28, 2012, 2:06:25 PM
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
       <div class="userNotifications" style="width:100%; height: 100%; clear: both">
        <c:set var="videoCommentClassName" scope="page" value="com.slambook.model.VideoCommentNotifications"/>
         <c:set var="imageCommentClassName" scope="page" value="com.slambook.model.ImageCommentNotification"/>
         <c:set var="videoLikeClassName" scope="page" value="com.slambook.model.VideoLikeNotifications"/>
         <c:set var="imageLikeClassName" scope="page" value="com.slambook.model.ImageLikeNotifications"/>
        
         <c:forEach items="${requestScope.notifications}" var="notification">
            
            <c:set var="className" scope="page" value="${notification.getClass().name}"/>
            
                      
            <c:choose>
                
                <c:when test="${className == videoCommentClassName}">

            
                    <div class="notificationsMainDiv">
                        
                        <div class="friendprofilePic">
                            
                            <img src="users/<c:out value="${notification.friendId}"></c:out>/profilepic/thumbs/<c:out value="${notification.friendCurrentProfilePic}"></c:out>.jpg"/>
                            
                        </div>
                            <div class="bubble" style="height:30px"> <c:out value="${notification.friendName}"></c:out>&nbsp;commented on your video&nbsp;<a class="fancybox fancybox.iframe" href="GetVideoComments?videoId=<c:out value="${notification.videoId}"></c:out>"><c:out value="${notification.videoName}"></c:out></a></div>
                        
                    </div>
                    
                    

                </c:when>

                <c:when test="${className == imageCommentClassName}">

                    <div class="notificationsMainDiv">
                        
                        <div class="friendprofilePic">
                            
                            <img src="users/<c:out value="${notification.friendId}"></c:out>/profilepic/thumbs/<c:out value="${notification.friendCurrentProfilePic}"></c:out>.jpg"/>
                            
                        </div>
                            
                                  <div class="bubble" style="height:30px"><c:out value="${notification.friendName}"></c:out>&nbsp;commented in an image of album&nbsp;<span class="getFriendsAlbum" friendId="<c:out value="${notification.userId}"></c:out>" albumId="<c:out value="${notification.albumId}"></c:out>"><c:out value="${notification.albumName}"></c:out></span></div>        
                    </div>

                </c:when>

                <c:when test="${className == videoLikeClassName}">

                    <div class="notificationsMainDiv">
                        
                        <div class="friendprofilePic">
                            
                            <img src="users/<c:out value="${notification.friendId}"></c:out>/profilepic/thumbs/<c:out value="${notification.friendCurrentProfilePic}"></c:out>.jpg"/>
                            
                        </div>
                          
                                    <div class="bubble" style="height:30px"> <c:out value="${notification.friendName}"></c:out>&nbsp;likes your video&nbsp;<a class="fancybox fancybox.iframe" href="GetVideoComments?videoId=<c:out value="${notification.videoId}"></c:out>"><c:out value="${notification.videoName}"></c:out></a></div>
                        
                    </div>

                </c:when>

                <c:when test="${className == imageLikeClassName}">

                    <div class="notificationsMainDiv">
                        
                        <div class="friendprofilePic">
                            
                            <img src="users/<c:out value="${notification.friendId}"></c:out>/profilepic/thumbs/<c:out value="${notification.friendCurrentProfilePic}"></c:out>.jpg"/>
                            
                        </div>
                            
                                    <div class="bubble" style="height:30px"><c:out value="${notification.friendName}"></c:out>&nbsp;likes an image of album&nbsp;<span class="getFriendsAlbum" friendId="<c:out value="${notification.userId}"></c:out>" albumId="<c:out value="${notification.albumId}"></c:out>"><c:out value="${notification.albumName}"></c:out></span></div>        
                    </div>

                </c:when>

            </c:choose>
            
             
        </c:forEach>
        </div>
    </body>
</html>
