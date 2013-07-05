<%-- 
    Document   : getAlbumImages
    Created on : Oct 13, 2012, 10:44:40 AM
    Author     : Mayank
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        
       
        <div style="width:100%;height: 80%;  overflow-y:auto;overflow-x: hidden;padding-bottom: 10%;padding-top: 2%">
            
        <c:forEach items="${requestScope.imagesList}" var="images" varStatus="0">
        <div class="imagesDiv">
            
            <a class="fancybox" rel="<c:out value="${images.albumId}"></c:out>" href="resources/users/<%= session.getAttribute("userId") %>/albums/<c:out value="${images.albumId}"></c:out>/<c:out value="${images.imageId}"></c:out>.jpg"><img  src="resources/users/<%= session.getAttribute("userId") %>/albums/<c:out value="${images.albumId}"></c:out>/thumbs/<c:out value="${images.imageId}"></c:out>.jpg"  style="width:100%; height: 78%; clear: both"/></a>
            <span class="deleteUserAlbumImage" albumId="<c:out value="${images.albumId}"></c:out>" imageId="<c:out value="${images.imageId}"></c:out>" style=" clear: both;  z-index:1000000;position:relative; left: 94%;bottom:10%;display:none"><img albumId="<c:out value="${images.imageId}"></c:out>" src="images/wrong.png"  /></span>
            <c:choose>
                <c:when test="${images.alreadyLiked == false}">
            <div albumId = "<c:out value="${images.albumId}"></c:out>" imageId = "<c:out value="${images.imageId}"></c:out>" class="addImageLikes" style="cursor: pointer;float:left;margin-left:4%;text-align: center;display:block;width:100%">Like</div>
                </c:when>
                <c:otherwise>
                    <div albumId = "<c:out value="${images.albumId}"></c:out>" imageId = "<c:out value="${images.imageId}"></c:out>" class="removeImageLikes" style="cursor: pointer;float:left;margin-left:4%;text-align: center;display:block;width:100%">UnLike</div>
                </c:otherwise>
            </c:choose>
            
                    <a style="text-decoration: none;color:black" class="fancybox fancybox.iframe imageLikesfancybox"  href="GetImageLikesInfo?imageId=<c:out value="${images.imageId}"></c:out>"><span albumId = "<c:out value="${images.albumId}"></c:out>" imageId = "<c:out value="${images.imageId}"></c:out>" class="addImageLikesInfo" style="cursor: pointer;float:left; color:black;margin-left:4%"><c:out value="${images.imageLikesCount}"></c:out>&nbsp;Likes</span></a><a class="fancybox fancybox.iframe imageCommentsfancybox"  href="ImageComments/getImageComments/<c:out value="${images.albumId}"></c:out>/<c:out value="${images.imageId}"></c:out>"><span style="float:right;margin-right: 4%;text-decoration: none;color:black" class="imageComments" albumId="<c:out value="${images.albumId}"></c:out>" imageId="<c:out value="${images.imageId}"></c:out>"><c:out value="${images.imageCommentCount}"></c:out>&nbsp;Comments</span></a>
            
        </div>
        </c:forEach>
        
        <div class="clear"></div>
            
        
        </div>
        
        
        
    </body>
</html>
