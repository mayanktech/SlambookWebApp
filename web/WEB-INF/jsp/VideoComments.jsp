<%-- 
    Document   : ImageComments
    Created on : Nov 26, 2012, 11:47:03 PM
    Author     : Mayank
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
  
  if(e.keyCode==13){

    $(this).attr('disabled','disabled');
    var commenterId = $(this).attr('userId');
var videoId = $(this).attr('videoId');
var commentText = $('.commentTextArea').val();
var currentProfilePic = window.parent.$('#currentProfilePic').val();
 var commenterName = window.parent.$('#currentUserName').val();
        
//alert(userId+" "+imageId+" "+commentText);

$.ajax({
    
    url:'VideoComments/addVideoComment',
    type:'post',
    data:{commenterId:commenterId,videoId:videoId,commentText:commentText}
    
}).success(function(data){
  
  $('.commentTextArea').removeAttr('disabled');
  $('.commentTextArea').val("");
 window.parent.showHomeNotification("Comment Added SuceesFully");
 $('.commentText').append('<div class="singleCommentDiv"><div style="width:20%;height:60px;display:block;float: left;margin-right:1%;"><img src="resources/users/'+commenterId+'/profilepic/thumbs/'+currentProfilePic+'.jpg" style="width:100%;height:60px; position: relative;top:8%;"/></div><span style="color: #2191c0;font-size: 1em;float:left">'+commenterName+'</span>&nbsp;&nbsp;'+commentText+'<div style="float:left;font-size: 0.8em;text-align: left;width: 100%;position: relative;top: 5px">'+new Date()+'</div></div>');
            
    
}).error(function(){
    
    alert('Bye');
});

    
    }
    
})

$('.enterComment').live('click',function(){



});


/*Image Comments*/
      
function showHomeNotification(msg){
    
    $('#Homemessage').html(msg);
    
    $('#Homenotifications').slideDown(1000).delay(3000).slideUp(1000);
   
}      
        </script>
    </head>
    <body>
        <div style="width:100%;height:500px; background-color:tan; overflow: hidden">

            <div class="imagesCommentsDiv">

                <iframe width="100%" height="100%" src="http://www.youtube.com/embed/<c:out value="${requestScope.videoCode}"></c:out>" frameborder="0" allowfullscreen style="margin-bottom: 2%;">
                </iframe>

            </div>

            <div class="commentsDiv">



                <div class="commentText">
                    <c:forEach items="${requestScope.videoCommentsList}" var="comments">

                        <div class="singleCommentDiv">
                            
                                        <div style="float: left">
                                            <img src="resources/users/<c:out value="${comments.commenterId}"></c:out>/profilepic/thumbs/<c:out value="${comments.currentProfilePicId}"></c:out>.jpg" style="width:20%;height:60px; margin-left: 0px; display: inline;float:left"/>
                                            <span style="float:left;margin-left: 1%;"><c:out value="${comments.name}"></c:out></span></br>
                                            <span style="float:left;margin-left: 1%;"><c:out value="${comments.commentText}"></c:out></span>
                                        </div> 
                                    
                                        <div style="float:left">
                                            
                                            <c:out value="${comments.date}"></c:out>
                                        </div>
                                    
                        </div>

                    </c:forEach>
                </div>

                <div class="newComment">

                    <textarea userId="<c:out value="${sessionScope.userId}"></c:out>" videoId="<c:out value="${requestScope.videoId}"></c:out>" placeholder="Enter Your Comment .... " class="commentTextArea"></textarea>
                 
                </div>

            </div>

        </div>
    </body>
</html>
