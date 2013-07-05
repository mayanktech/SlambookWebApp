<%-- 
    Document   : editProfile
    Created on : Oct 4, 2012, 10:24:21 AM
    Author     : Mayank
--%>

<%@page import="com.slambook.Entity.UserInfo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        
        
        
        <%
        
        
        UserInfo userInfo = (UserInfo)request.getAttribute("userInfo");
        
        
        %>
        <%!
        
        String gender;
        
        %>
       
        <div style="width: 100%;height: 100%; overflow: auto;">    
            
            <table id="editProfileTable"style="width: 80%;margin-left: 10%;margin-right: 10%;background-color: #0070a3;height: 100%;overflow: hidden">
                
                <tr><td>TagLine</td><td><input type="text" id="edittagline" value="<c:out value="${userInfo.getTagline()}"></c:out>"/></td></tr>
                <tr><td style="padding:4%;">Introduction</td><td><textarea id="editintroduction"><c:out value="${userInfo.getIntroduction()}"></c:out></textarea></td></tr>
                <tr><td style="padding: 2%">Bragging Rights</td><td><textarea id="editbraggingRights"><c:out value="${userInfo.getBraggingRights()}"></c:out></textarea></td></tr>
                <tr><td style="padding: 1%">Places Lived</td><td><textarea id="editplacesLived"><c:out value="${userInfo.getPlacesLived()}"></c:out></textarea></td></tr>
                <tr><td>Looking For</td><td><select id="editlookingFor"><option>Friendship</option><option>Relationship</option></select></td></tr>
                <tr><td>Birthday</td><td><input type="text" id="editbirthday" style="margin-right: 1%;" value="<c:out value="${userInfo.getBirthday()}"></c:out>"/></td></tr>
                <tr><td>Email</td><td><input type="text" id="editemail" value="<c:out value="${userInfo.getEmail()}"></c:out>"/></td></tr>
                <tr><td>Relationship Status</td><td><input type="text" id="editrelationshipStatus" value="<c:out value="${userInfo.getRelationshipStatus()}"></c:out>"/></td></tr>
                <tr><td>School</td><td><input type="text" id="editschool" value="<c:out value="${userInfo.getSchool()}"></c:out>"/></td></tr>
                <tr><td>College</td><td><input type="text" id="editcollege" value="<c:out value="${userInfo.getCollege()}"></c:out>"/></td></tr>
                <tr><td>Employment</td><td><input type="text" id="editoccupation" value="<c:out value="${userInfo.getCollege()}"></c:out>"/></td></tr>
                <tr><td>Website</td><td><input type="text" id="editwebsite" value="<c:out value="${userInfo.getWebsite()}"></c:out>"/></td></tr>
                <tr><td colspan="2"><button id="editProfileButton" style="padding:5px;font-size:1.1em;background-color: #69A74E;color: #FFF">Edit Profile</button></td></tr>
            </table>
        </div>
        
 