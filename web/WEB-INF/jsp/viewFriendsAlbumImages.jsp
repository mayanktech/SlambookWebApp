<%-- 
    Document   : viewFriendsAlbumImages
    Created on : Nov 12, 2012, 10:59:24 AM
    Author     : Mayank
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="width:100%;height: 83%;  overflow-y:auto;overflow-x: hidden;padding-bottom: 10%;">
        
        <c:forEach items="${requestScope.imagesList}" var="images" varStatus="0">
        <div class="imagesDiv">
            
            <a class="fancybox" rel="<c:out value="${images.albumId}"></c:out>" href="resources/users/<c:out value="${requestScope.friendId}"></c:out>/albums/<c:out value="${images.albumId}"></c:out>/<c:out value="${images.imageId}"></c:out>.jpg"><img  src="resources/users/<c:out value="${requestScope.friendId}"></c:out>/albums/<c:out value="${images.albumId}"></c:out>/thumbs/<c:out value="${images.imageId}"></c:out>.jpg"  style="width:100%; height: 78%;"/></a>
            
            <c:choose>
                <c:when test="${images.alreadyLiked == 'false'}">
            <div albumId = "<c:out value="${images.albumId}"></c:out>" imageId = "<c:out value="${images.imageId}"></c:out>" class="addImageLikes" style="cursor: pointer;float:left;margin-left:4%;text-align: center;display:block;width:100%">Like</div>
                </c:when>
                <c:otherwise>
                    <div albumId = "<c:out value="${images.albumId}"></c:out>" imageId = "<c:out value="${images.imageId}"></c:out>" class="removeImageLikes" style="cursor: pointer;float:left;margin-left:4%;text-align: center;display:block;width:100%">UnLike</div>
                </c:otherwise>
            </c:choose>
            
            <span albumId = "<c:out value="${images.albumId}"></c:out>" imageId = "<c:out value="${images.imageId}"></c:out>" class="addImageLikesInfo" style="cursor: pointer;float:left;margin-left:4%"><c:out value="${images.imageLikesCount}"></c:out>&nbsp;Likes</span><a class="fancybox fancybox.iframe imageCommentsfancybox" href="ImageComments/getFriendsImageComments/<c:out value="${images.albumId}"></c:out>/<c:out value="${images.imageId}"></c:out>/<c:out value="${requestScope.friendId}"></c:out>"><span style="float:right;margin-right: 4%;text-decoration: none;color:black" class="imageComments" albumId="<c:out value="${images.albumId}"></c:out>" imageId="<c:out value="${images.imageId}"></c:out>"><c:out value="${images.imageCommentCount}"></c:out>&nbsp;Comments</span></a>
            
        </div>
        </c:forEach>
        
        <div class="clear"></div>
            
        
        </div>
        
    </body>
</html>
