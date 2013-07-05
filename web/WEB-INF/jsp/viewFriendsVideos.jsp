<%-- 
    Document   : viewFriendsVideos
    Created on : Nov 12, 2012, 12:14:25 PM
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
        
                   
                            
                           
                            
       <div style="width:100%;height:75%;  overflow-y:auto;overflow-x: hidden;padding-top:5%;padding-bottom:10%">
           <div class="friendsVideos">
                           
           <c:forEach items="${requestScope.videoList}" var="video" varStatus="0">
                                
                                <div class="videosDiv" style="box-shadow: 0px 0px 20px 10px  #FFFFFF;width:40%;float:left;display:block;margin-left:5%;margin-right: 5%" title="<c:out value="${video.videoDescription}"></c:out>">
                                    <iframe title="<c:out value="${video.videoDescription}"></c:out>" class="videoPlayer" width="100%" height="240px" src="http://www.youtube.com/embed/<c:out value="${video.videoUrl}"></c:out>" frameborder="0" allowfullscreen style="margin-bottom: 0;">
                                    </iframe>
                                    <c:choose>
                                            <c:when test="${video.alreadyLiked == 'false'}">
                                                <div videoId = "<c:out value="${video.videoId}"></c:out>" class="addVideoLikes" style="cursor: pointer;float:left;margin-left:4%;text-align: center;display:block;width:100%">Like</div>
                                            </c:when>
                                            <c:otherwise>
                                                <div videoId = "<c:out value="${video.videoId}"></c:out>" class="removeVideoLikes" style="cursor: pointer;float:left;margin-left:4%;text-align: center;display:block;width:100%">UnLike</div>
                                            </c:otherwise>
                                    </c:choose>
                                      <span videoId = "<c:out value="${video.videoId}"></c:out>" class="addVideoLikesInfo" style="cursor: pointer;float:left;margin-left:4%"><c:out value="${video.videoLikesCount}"></c:out>&nbsp;Likes</span> 
                                        <a class="videofancybox fancybox fancybox.iframe" href="GetVideoComments?videoId=<c:out value="${video.videoId}"></c:out>"><span style="float:right;margin-right: 4%;text-decoration: none;color:white" class="videoComments" videoId="<c:out value="${video.videoId}"></c:out>"><c:out value="${video.videoCommentsCount}"></c:out>&nbsp;Comments</span></a>
                                    
                                </div>
                    
                             
                            </c:forEach>
           </div>
            <div style="width:100%;text-align: center"><button id="loadMoreFriendsVideos" style="text-align: center;padding:1%">Load More..</button></div>                                              
           </div>       
           
       
                   
    
    </body>
</html>
