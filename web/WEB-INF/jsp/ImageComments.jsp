<%-- 
    Document   : ImageComments
    Created on : Nov 26, 2012, 11:47:03 PM
    Author     : Mayank
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- <c:set var="url">${pageContext.request.requestURL}</c:set> -->
        <base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/style.css" type="text/css" rel="stylesheet"/>
        <title>JSP Page</title>
            
        <script type="text/javascript" src="resources/js/jquery-1.8.0.min.js"></script>
       
       
        <script>
            
            
/*Image Comments*/
$('.commentTextArea').live('keyup',function(e){
    
    if(e.keyCode == 13){
        
        $(this).attr('disabled','disabled');
        var commenterId = $(this).attr('userId');
        var imageId = $(this).attr('imageId');
        var commentText = $('.commentTextArea').val();
        var currentProfilePic = window.parent.$('#currentProfilePic').val();
        var commenterName = window.parent.$('#currentUserName').val();
        //alert(userId+" "+imageId+" "+commentText);

        $.ajax({

            url:'ImageComments/addImageComment',
            type:'post',
            data:{
                commenterId:commenterId,
                imageId:imageId,
                commentText:commentText
            }

        }).success(function(data){
           
       $('.commentTextArea').removeAttr('disabled');
  $('.commentTextArea').val("");
 window.parent.showHomeNotification("Comment Added SuceesFully");
 $('.commentText').append('<div class="singleCommentDiv"><div style="width:20%;height:60px;display:block;float: left;margin-right:1%;"><img src="resources/users/'+commenterId+'/profilepic/thumbs/'+currentProfilePic+'.jpg" style="width:100%;height:60px; position: relative;top:8%;"/></div><span style="color: #2191c0;font-size: 1em;float:left">'+commenterName+'</span>&nbsp;&nbsp;'+commentText+'<div style="float:left;font-size: 0.8em;text-align: left;width: 100%;position: relative;top: 5px">'+new Date()+'</div></div>');
    

        }).error(function(){

            alert('Bye');
        });
    
    }
    
});

    $('.enterComment').live('click',function(){

        
        var commenterId = $(this).attr('userId');
        var imageId = $(this).attr('imageId');
        var commentText = $('.commentTextArea').val();
        var currentProfilePic = window.parent.$('#currentProfilePic').val();
        var commenterName = window.parent.$('#currentUserName').val();
        //alert(userId+" "+imageId+" "+commentText);

        $.ajax({

            url:'AddImageComment',
            type:'post',
            data:{
                commenterId:commenterId,
                imageId:imageId,
                commentText:commentText
            }

        }).success(function(data){
           
       $('.commentTextArea').removeAttr('disabled');
  $('.commentTextArea').val("");
 window.parent.showHomeNotification("Comment Added SuceesFully");
 $('.commentText').append('<div class="singleCommentDiv"><div style="width:20%;height:60px;display:block;float: left;margin-right:1%;"><img src="users/'+commenterId+'/profilepic/thumbs/'+currentProfilePic+'.jpg" style="width:100%;height:60px; position: relative;top:8%;"/></div><span style="color: #2191c0;font-size: 1em;float:left">'+commenterName+'</span>&nbsp;&nbsp;'+commentText+'<div style="float:left;font-size: 0.8em;text-align: left;width: 100%;position: relative;top: 5px">'+new Date()+'</div></div>');
    

        }).error(function(){

            alert('Bye');
        });

    });



/*Image Comments*/
       
        </script>
    </head>
    <body style="background: url( ..resources/images/paper_by_francy84.jpg) !important;">
        <div style="width:100%;height:500px; background-color:tan;background: url( ../images/paper_by_francy84.jpg) !important; overflow: hidden">

            <div class="imagesCommentsDiv">

                <img src="resources/users/<c:out value="${sessionScope.userId}"></c:out>/albums/<c:out value="${requestScope.albumId}"></c:out>/<c:out value="${requestScope.imageId}"></c:out>.jpg" style="width:94%; height: 94%;margin: 3%"/>

            </div>

            <div class="commentsDiv">



                <div class="commentText">
                    <c:forEach items="${requestScope.imageComments}" var="comments">

                        <div class="singleCommentDiv">
                            
                                        
                                            <div style="width:20%;height:60px;display:block;float: left;margin-right:1%;"><img src="resources/users/<c:out value="${comments.commenterId}"></c:out>/profilepic/thumbs/<c:out value="${comments.currentProfilePicId}"></c:out>.jpg" style="width:100%;height:60px; position: relative;top:8%;"/></div>
                                            <span style="color: #2191c0;font-size: 1em;float:left"><c:out value="${comments.name}"></c:out></span>&nbsp;&nbsp;<c:out value="${comments.commentText}"></c:out>
                                            
                                         
                                    
                                        <div style="float:left;font-size: 0.8em;text-align: left;width: 100%;position: relative;top: 5px">
                                            
                                            <c:out value="${comments.date}"></c:out>
                                        </div>
                                    
                        </div>

                    </c:forEach>
                </div>

                <div class="newComment">

                    <textarea userId="<c:out value="${sessionScope.userId}"></c:out>" imageId="<c:out value="${requestScope.imageId}"></c:out>" placeholder="Enter Your Comment .... " class="commentTextArea"></textarea>
       
                </div>

            </div>

        </div>
    </body>
</html>
