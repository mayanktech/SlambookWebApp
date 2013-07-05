<%-- 
    Document   : demo
    Created on : 23 Apr, 2013, 11:26:58 AM
    Author     : Mayank
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.slambook.Entity.UserInfo"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
               
              
        <c:out value="${requestScope.userInfo.firstName}"></c:out>  
        
        Friends<c:forEach items="${requestScope.userInfo.friendsList}" var="friends" varStatus="pageNumber">
            
            hii
            
        </c:forEach>         
                
        Albums <c:forEach items="${requestScope.userInfo.allalbumsList}" var="albums">


                <option value="<c:out value="${albums.albumId}"></c:out>"><c:out value="${albums.albumName}"></c:out></option>


            </c:forEach>
                
            <%


            UserInfo user = (UserInfo) request.getAttribute("userInfo");
            String profilePic = Integer.toString(user.getProfilePic()) + ".jpg";
            pageContext.setAttribute("profilePic",profilePic);
        %>    

        <c:forEach items="${requestScope.userInfo.albumList}" var="albums">
            
        </c:forEach>
        
        <c:forEach items="${requestScope.userInfo.videoList}" var="video" varStatus="0">
            
        </c:forEach>
        
        <c:forEach items="${requestScope.userInfo.slambookAnswersList}" var="answers">
            
        </c:forEach>
         
    </body>
</html>
