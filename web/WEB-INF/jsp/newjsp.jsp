<%-- 
    Document   : newjsp
    Created on : Sep 20, 2012, 1:42:20 AM
    Author     : Mayank
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" type="text/css" rel="stylesheet" />

<noscript><meta http-equiv="refresh" content="0; URL=home.html"/></noscript>

<style>
    
    #container_wrapper{
        
        
        padding-left:10% !important;
        
        
    }  
    
</style>

    </head>
    <body>

    <c:forEach items="${requestScope.userInfo.NotificationsList}" var="messages">
    1
    </c:forEach> 
        
        
    </body>
</html>
