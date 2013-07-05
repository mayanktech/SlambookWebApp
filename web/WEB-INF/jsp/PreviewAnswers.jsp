<%-- 
    Document   : PreviewAnswers
    Created on : Nov 22, 2012, 10:57:54 PM
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
        <div style="width: 100%;height: 100%; overflow: auto;">    
            
            <table id="editProfileTable"style="width: 80%;margin-left: 10%;margin-right: 10%;background-color: #0070a3;height: 100%;overflow: hidden">
                
                
                <tr><td>Loved Ones Call Me</td><td><input type="text" id="ans1" value="<c:out value="${requestScope.slambookAnswers.ans1}"></c:out>"/></td></tr>
                <tr><td>My Zodiac</td><td><input type="text" id="ans2" value="<c:out value="${requestScope.slambookAnswers.ans2}"></c:out>"/></td></tr>
                <tr><td>I Was On Cloud 9 When</td><td><textarea id="ans3"><c:out value="${requestScope.slambookAnswers.ans3}"></c:out></textarea></td></tr>
                <tr><td>My Secret Desire</td><td><textarea id="ans4"><c:out value="${requestScope.slambookAnswers.ans4}"></c:out></textarea></td></tr>
                <tr><td>Person I Admire The Most</td><td><textarea id="ans5"><c:out value="${requestScope.slambookAnswers.ans5}"></c:out></textarea></td></tr>
                <tr><td>My Ideal Vacation Spot</td><td><textarea id="ans6"><c:out value="${requestScope.slambookAnswers.ans6}"></c:out></textarea></td></tr>
                <tr><td>I Define Love As</td><td><textarea id="ans7"><c:out value="${requestScope.slambookAnswers.ans7}"></c:out></textarea></td></tr>
                <tr><td>I Would Like To Go On a Date With</td><td><textarea id="ans8"><c:out value="${requestScope.slambookAnswers.ans8}"></c:out></textarea></td></tr>
                <tr><td>One Thing Missing In My Life</td><td><textarea id="ans9"><c:out value="${requestScope.slambookAnswers.ans9}"></c:out></textarea></td></tr>
                <tr><td>Oops! I Made A Mistake When</td><td><textarea id="ans10"><c:out value="${requestScope.slambookAnswers.ans10}"></c:out></textarea></td></tr>
                <tr><td>I Am Proud Of</td><td><textarea id="ans11"></textarea><c:out value="${requestScope.slambookAnswers.ans11}"></c:out></td></tr>
                <tr><td>I Like You Bcoz U Are</td><td><textarea id="ans12"><c:out value="${requestScope.slambookAnswers.ans12}"></c:out></textarea></td></tr>
                <tr><td>My Latest Crush</td><td><textarea id="ans13"><c:out value="${requestScope.slambookAnswers.ans13}"></c:out></textarea></td></tr>
                <tr><td><button id="acceptRequest" friendId="<c:out value="${requestScope.slambookAnswers.senderId}"></c:out>" style="padding:5px;font-size:1.1em;background-color: #69A74E;color: #FFF">Accept Request</button></td><<td><button id="cancelRequest" style="padding:5px;font-size:1.1em;background-color: #69A74E;color: #FFF" friendId="<c:out value="${requestScope.slambookAnswers.senderId}"></c:out>">Cancel Request</button></td></tr>
            
            </table>
        </div>
    </body>
</html>
