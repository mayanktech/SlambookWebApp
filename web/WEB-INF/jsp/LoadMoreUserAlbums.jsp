<%-- 
    Document   : LoadMoreUserAlbums
    Created on : Nov 21, 2012, 1:46:23 PM
    Author     : Mayank
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <%! int i = 0;%>
                    <c:forEach items="${requestScope.albumList}" var="albums">
                        <% i++ ;%>
                        
                        
                   <div class="albumsDiv getImages getFriendsAlbum" albumId="<c:out value="${albums.albumId}"></c:out>">
                  
                       <span class="deleteUserAlbum" albumId="<c:out value="${albums.albumId}"></c:out>" style="z-index:1000000;position:absolute;right:-7%;top:-7%;display:none"><img albumId="<c:out value="${albums.albumId}"></c:out>" src="resources/images/wrong.png" /></span>
                       <c:set var="albumId" value="${albums.coverImageId}"/>
                        
                       <c:choose>
                                
                                <c:when test="${albums.coverImageId == '0'}">
                                    
                                    <c:set var="albumId" value="0"/>
                                    <img src="resources/images/default_album_300_g4.png"  style="width:100%; height: 75%;"/> 
                        <div style="text-align: center; width: 100%">
                            <span style="width:100%"><c:out value="${albums.albumName}"></c:out></span></br>
                            <span style="width:100%"><c:out value="${albums.albumImageCount}"></c:out>&nbsp;Images</span>
                            
                        </div>
                    
                                    
                                </c:when>
                                <c:otherwise>
                                    
                                    
                                    <c:set var="albumCoverId" value="${albums.coverImageId}"/>
                                    <img src="resources/users/<c:out value="${requestScope.userId}"></c:out>/albums/<c:out value="${albums.albumId}"></c:out>/thumbs/<c:out value="${albumCoverId}"></c:out>.jpg"  style="width:100%; height: 75%;"/> 
                        <div style="text-align: center; width: 100%">
                            <span style="width:100%"><c:out value="${albums.albumName}"></c:out></span></br>
                            <span style="width:100%"><c:out value="${albums.albumImageCount}"></c:out>&nbsp;Images</span>
                            
                        </div>
                    
                                </c:otherwise>
                                
                            </c:choose>    
                            
                       
                       
                    </div>
                    <%
                        
                        if(i%2 == 0){
                        
                            out.print("<div class='clear'></div>");
                        }    
                        
                        %>
                        
                        
                    
                    </c:forEach>
                    
    </body>
</html>
