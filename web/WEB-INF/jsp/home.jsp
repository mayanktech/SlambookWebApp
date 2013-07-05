<%--
    Document   : home
    Created on : 13 Sep, 2012, 11:00:05 PM
    Author     : Mayank
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.slambook.Entity.UserInfo"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!--Jai Shree Ganesh-->
<!DOCTYPE html>
<html>
    <head>
        <!-- <c:set var="url">${pageContext.request.requestURL}</c:set> -->
        <base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />

        <title>SlamBook - Home</title>
        <link rel="stylesheet" media="screen" type="text/css" href="resources/css/democss/style.css" />
        <link href="resources/css/style.css" type="text/css" rel="stylesheet" />
        <noscript><meta http-equiv="refresh" content="0; URL=home.html"/></noscript>
        <link type="text/css" href="resources/css/start/jquery-ui-1.8.23.custom.css" rel="stylesheet" />
        <script type="text/javascript" src="resources/js/jquery-1.8.0.min.js"></script>
        <script type="text/javascript" src="resources/js/jquery-ui-1.8.23.custom.min.js"></script>



        <link rel="stylesheet" href="resources/js/fanvybox/jquery.fancybox.css" type="text/css" media="screen" />
        <script type="text/javascript" src="resources/js/fanvybox/jquery.fancybox.pack.js"></script>

        <link href="resources/js/fanvybox/helpers/jquery.fancybox-buttons.css" type="text/css" rel="stylesheet"/>
        <script type="text/javascript" src="resources/js/fanvybox/helpers/jquery.fancybox-buttons.js"></script>

        <link href="resources/js/fanvybox/helpers/jquery.fancybox-thumbs.css" type="text/css" rel="stylesheet"/>
        <script type="text/javascript" src="resources/js/fanvybox/helpers/jquery.fancybox-thumbs.js"></script>

        <script src="resources/booklet/jquery.easing.1.3.js" type="text/javascript"></script>
        <script src="resources/booklet/jquery.booklet.1.4.0.min.js" type="text/javascript"></script>
        <link href="resources/booklet/jquery.booklet.1.4.0.css" type="text/css" rel="stylesheet" media="screen, projection, tv" />


        <script src="resources/js/FormController.js"></script>
        <script>




            var currentLastPageNumber;

            <%! int pageNumber1 = 0;%>
            <% pageNumber1 = 5;%>
            <c:forEach items="${requestScope.userInfo.friendsList}" var="friends" varStatus="pageNumber">

                <% pageNumber1 = pageNumber1 + 2;%>

                            currentLastPageNumber =  <%= pageNumber1%>;


            </c:forEach>
                    window.onload = function () {
                        if (typeof File == "undefined") alert("Sorry but your browser does not support the file API and this website will not work for you.");
                        var form = document.getElementById("uploader");
                        var addFiles = document.getElementById("addFiles");
                        FormController = new FormController();

                        FormController.addFormHandler(form);

                        form["upload[]"].addEventListener("change", FormController.updateFileList, false);
                        addFiles.addEventListener("click", function (ev) {
                            ev.preventDefault();
                            form["upload[]"].click();
                        }, false);
                    }

                    $('#acceptRequest').live('click',function(){

                        var friendId = $(this).attr('friendId');
                        var userId = $('#userId').val();

                        //alert(friendId+userId);

                        $.ajax({

                            url:'AcceptRequest',
                            type:'post',
                            data:{userId:userId,friendId:friendId}

                        }).success(function(data){


                            $('#previewRequestSlidesDiv').slideUp(2000);

                            $('#dialog').html('Friend Has been added to slambook').dialog({

                                width:'20%',
                                modal:true,
                                title:'Request Accepted',
                                draggable:'false',
                                resizable:'false',
                                buttons:{
                                    "Ok":function(){
                                        var pageNumber = (currentLastPageNumber + 2) - 4;
                                        $('#dialog').dialog('close');
                                        location.href="http://localhost:8084/SlamBook/Slambook?email="+getEmail()+"#/page/"+pageNumber;


                                    }
                                }

                            });

                        });

                    });
        </script>

        <script src="resources/js/script.js" type="text/javascript"></script>

        <style>

            #container_wrapper{


                padding-left:10% !important;


            }

        </style>
    </head>

    <body>

        <audio id="pageFlipSound" preload>

            <source src="resources/css/page-flip-1.wav"></source>


        </audio>
        <div id="Homenotifications">

            <div id="Homemessage">Hii</div>

        </div>
        <%!            String profilePic;
            String userId;

        %>

        <%


            UserInfo user = (UserInfo) request.getAttribute("userInfo");
            profilePic = Integer.toString(user.getProfilePic()) + ".jpg";
            userId = Integer.toString(user.getUserId());
//          userId = session.getAttribute("userId").toString();
            pageContext.setAttribute("profilePic", profilePic);
        %>



        <div id="dialog" style="display: none;">



        </div>
        
        <div id="settingsDiv" style="display: none;">

            <div id="userDesignAccordion">
                
                <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Design Settings</h3>
                <div>
                    
                    <div id="insideUserDesignAccordion">
                       <h3>SlamBook Pages Background Texture</h3> 
                       <div>

                        <table class="settingsTable">

                                <tr><td style="width:50%; height: 100px" class="slambookPagesBackgroundTexture1 slambookPagesBackgroundTexture" textureId="1"></td><td><input type="radio" name="slambookPagesBackgroundTexture" class="slambookPagesBackgroundTextureChooser" textureId="1"/></td></tr>
                                <tr><td style="width:50%; height: 100px" class="slambookPagesBackgroundTexture2 slambookPagesBackgroundTexture" textureId="2"></td><td><input type="radio" name="slambookPagesBackgroundTexture" class="slambookPagesBackgroundTextureChooser" textureId="2"/></td></tr>
                                <tr><td style="width:50%; height: 100px" class="slambookPagesBackgroundTexture3 slambookPagesBackgroundTexture" textureId="3"></td><td><input type="radio" name="slambookPagesBackgroundTexture" class="slambookPagesBackgroundTextureChooser" textureId="3"/></td></tr>
                                <tr><td style="width:50%; height: 100px" class="slambookPagesBackgroundTexture4 slambookPagesBackgroundTexture"  textureId="4"></td><td><input type="radio" name="slambookPagesBackgroundTexture" class="slambookPagesBackgroundTextureChooser" textureId="4"/></td></tr>
                                <tr><td style="width:50%; height: 100px" class="slambookPagesBackgroundTexture5 slambookPagesBackgroundTexture" textureId="5"></td><td><input type="radio" name="slambookPagesBackgroundTexture" class="slambookPagesBackgroundTextureChooser" textureId="5"/></td></tr>
                            
                            
                         </table>


                       </div>
                       
                       <h3>SlamBook Background Texture</h3> 
                       <div>

                        <table class="settingsTable">

                             <tr><td style="width:50%; height: 100px" class="backgroundTextture1 slambookBackgroundTexture" textureId="1"></td><td><input type="radio" name="slambookBackgroundTexture" class="slambookBackgroundTextureChooser" textureId="1"/></td></tr>
                                <tr><td style="width:50%; height: 100px" class="backgroundTextture2 slambookBackgroundTexture" textureId="2"></td><td><input type="radio" name="slambookBackgroundTexture" class="slambookBackgroundTextureChooser" textureId="2"/></td></tr>
                                <tr><td style="width:50%; height: 100px" class="backgroundTextture3 slambookBackgroundTexture" textureId="3"></td><td><input type="radio" name="slambookBackgroundTexture" class="slambookBackgroundTextureChooser" textureId="3"/></td></tr>
                                <tr><td style="width:50%; height: 100px" class="backgroundTextture4 slambookBackgroundTexture"  textureId="4"></td><td><input type="radio" name="slambookBackgroundTexture" class="slambookBackgroundTextureChooser" textureId="4"/></td></tr>
                                <tr><td style="width:50%; height: 100px" class="backgroundTextture5 slambookBackgroundTexture" textureId="5"></td><td><input type="radio" name="slambookBackgroundTexture" class="slambookBackgroundTextureChooser" textureId="5"/></td></tr>
                            
                         </table>


                       </div>
                       
                       <h3>Header Footer Background Texture</h3> 
                       <div>

                        <table class="settingsTable">

                             <tr><td><input type="radio" name="slambookPagesBackgroundTexture" class="slambookPagesBackgroundTextureChooser" textureId="1"/></td><td></td></tr>
                             <tr><td><input type="radio" name="slambookPagesBackgroundTexture" class="slambookPagesBackgroundTextureChooser" textureId="2"/></td><td></td></tr>
                             <tr><td><input type="radio" name="slambookPagesBackgroundTexture" class="slambookPagesBackgroundTextureChooser" textureId="3"/></td><td></td></tr>
                             <tr><td><input type="radio" name="slambookPagesBackgroundTexture" class="slambookPagesBackgroundTextureChooser" textureId="4"/></td><td></td></tr>
                             <tr><td><input type="radio" name="slambookPagesBackgroundTexture" class="slambookPagesBackgroundTextureChooser" textureId="5"/></td><td></td></tr>

                         </table>


                       </div>
                       
                    </div>
                    
                    
                    
                    
                </div>
                
                <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Account Settings</h3>
                <div>
                    
                    
                    
                </div>
                
                
            </div>

        </div>
        
        <div id="friendsConversationMessages">
            <div style="text-align: center; width: 100%;"><button style="margin-left:2%;padding:1%;" class="closeFriendsMessages">Close</button></div>
            <div id="InsidefriendsConversationMessages">
                
            </div>
        </div>
        <div id="friendsConversationMessagesThread">

            <div style="text-align: center; width: 100%;"><button style="padding:1%" class="loadMoreFriendsMessages">Load Previous Messages</button><button style="margin-left:2%;padding:1%;" class="closeFriendsConversationMessagesThread">Close</button></div>
            <div id="InsidefriendsConversationMessagesThread" style="min-height:80%;max-height:80%;width:100%;overflow-x: hidden;overflow-y: auto;padding-top: 2%">


            </div>

            <textarea style="width:100%;min-height:20%;max-height: 20%;background:white!important" class="replyToMessageTextarea">


            </textarea>
        </div>

    </div>
    <div id="newsStream">

        <button id="closeNewsStream"style="position: absolute;right:0px;top:50%;padding:1%">Close</button>

    </div>
    <div id="newsStreamButton">
        <span>N</span>
        <span>e</span>
        <span>w</span>
        <span>s</span>
        <span>&nbsp;</span>
        <span>F</span>
        <span>e</span>
        <span>e</span>
        <span>d</span>

    </div>
    <div id="messageStreamButton">
        <span>M</span>
        <span>e</span>
        <span>s</span>
        <span>s</span>
        <span>a</span>
        <span style="font-size: 0.9em; position: relative;bottom: 1%">g</span>

        <span>e</span>

        <span>s</span>

    </div>
    <div id="images_div_friendsalbumImages">

        <div style="position:absolute; bottom:0px; width: 100%; text-align: center"><button class="closefriendsalbumImagesDiv">Close</button></div>

    </div>
    <div id="selectUserAlbums" style="display:none" >
        <div>Select Album :</div>
        <select style="padding:4px; font-size: 1em" id="selectUserAlbumsId">
            <c:forEach items="${requestScope.userInfo.allalbumsList}" var="albums">


                <option value="<c:out value="${albums.albumId}"></c:out>"><c:out value="${albums.albumName}"></c:out></option>


            </c:forEach>
        </select>
    </div>
    <div id="images_div">


        <div style="position:absolute; bottom:0px; width: 100%; text-align: center"><button class="closeImagesDiv">Close</button></div>
    </div>
    <div id="editProfileSlideDiv">



    </div>

    <div id="addToSlambookSlidesDiv">

    </div>

    <div id="previewRequestSlidesDiv">

    </div>

    <div id="accounts_div">

        Accounts Section

    </div>
    <div id="friends_div">
        <%! int pageNumber = 0;%>
        <% pageNumber = 7;%>
        <c:forEach items="${requestScope.userInfo.friendsList}" var="friends" varStatus="pageNumber">

            <a href="#/page/<%=pageNumber%>">
                <div class="userSingleFriendsDiv" pageNumber="<%= pageNumber%>">
                    <% pageNumber = pageNumber + 2;%>

                    <div style="width:40%; height: 100%; background-color: #CCC; display: inline; float: left">

                        <img style="width: 100%; height: 100%;" src="resources/users/<c:out value="${friends.userId}" escapeXml="true"></c:out>/profilepic/thumbs/<c:out value="${friends.profilePicId}${'.jpg'}" escapeXml="true"></c:out>"/>

                        </div>

                        <div style="width:60%; height: 100%; display: inline; float: left">

                        <c:out value="${friends.firstName}" escapeXml="true"></c:out> </br>
                        <c:out value="${friends.lastName}" escapeXml="true"></c:out>
                        </div>

                    </div>
                </a>

        </c:forEach>

        <div style="position:absolute; bottom:0px; width: 100%; text-align: center"><button style="padding:1%" class="closeFriendsDiv">Close</button></div>
    </div>

    <div id="addVideosDiv" style="display:none">

        <table class="addTable">

            <tr><td>Video Url(Youtube)</td><td><input type="text" id="videoUrl"/></td></tr>
            <tr><td>Video Description</td><td><textarea id="videoDescription"></textarea></td></tr>

        </table>


    </div>

    <div id="viewProfileSlidesDiv">


    </div>
    <div id="searchFriends">


    </div>

    <div id="sendMessageDiv" style="display:none">

        <table class="addTable" style="width:400px">

            Enter Message :
            <tr><td style="width:70%;height:100px"><textarea id="messageText"></textarea></td></tr>


        </table>


    </div>

    <div id="friendsAlbumImages">

        <div style="position:absolute; bottom:0px; width: 100%; text-align: center"><button class="closefriendsAlbumImages">Close</button></div>
    </div>

    <div id="friendsAlbums">

        <div style="position:absolute; bottom:0px; width: 100%; text-align: center"><button class="closefriendsAlbums">Close</button></div>
    </div>

    <div id="friendsVideos">


        <div style="position:absolute; bottom:0px; width: 100%; text-align: center"><button class="closefriendsVideos">Close</button></div>
    </div>

    <div id="selectSearchOption">

        <span style="float:left">Search By Email&nbsp;&nbsp;<input type="radio" value="email" name="searchOption" checked/></span>
        <span style="float:right">Search By Name&nbsp;&nbsp;<input type="radio" value="fullname" name="searchOption" /></span>

    </div>
    <div id="addAlbumsDiv" style="display:none">

        <table class="addTable">
            <sf:form modelAttribute="albums" id="addAlbumsForm">
                <tr><td>Album Name</td><td><sf:input type="text" id="albumName" path="albumName"/></td></tr>
            <tr><td>Album Description</td><td><sf:textarea id="albumSummary" path="albumSummary"></sf:textarea></td></tr>
            <tr><td>Date Taken</td><td><sf:input type="text" id="albumDate" path="albumDate" style="width:80%;margin-right: 2%;"/></td></tr>
            </sf:form>
        </table>

    </div>

    <div id="uploadImagesForm" style="display: none">

        <div style="width:300px;margin:auto;position: relative; right: 5%;">
            <sf:form modelAttribute="imageFileUpload" id="uploader" action="Images/addImage" method="post" enctype="multipart/form-data">
                <fieldset>
                    <legend>Choose some files to upload</legend>

                    <sf:input path="albumId" id="albumImagesUploadId"class="grad" type="hidden"/>

                    <p id="fileField">
                        <sf:input type="file" path="upload" id="upload[]" multiple="multiple"/>
                    </p>
                    <div id="fileListWrap"  class="grad">
                        <ol id="fileList">
                            <!--- populated by js --->
                        </ol>
                        <a id="addFiles" href="#" title="Add some files">
                            <img src="resources/images/add.png" alt="Add files" width="24" height="24" />
                        </a>
                    </div>
                    <p id="controls">
                        <input class="blueButtonLink" type="submit" name="doit" value="upload" />
                    </p>
                </fieldset>
            </sf:form>

            <div  style="clear: both"></div>
            <div id="updateArea" style="width:100%">
                <div id="progressBarOuter">
                    <div id="progressBar"></div>
                </div>
                <p id="progressMeta">
                    <span id="statusText"></span>&nbsp;
                    <span id="percentage">0</span>&#37;
                </p>
            </div>
        </div>

    </div>
    <div id="addImagesDiv" style="display:none">


        <!--            <form action="UploadImage" method="post" enctype="multipart/form-data" id="addImagesForm">
                    <tr><td style="width:70%;">Choose Files</td></tr>
                    <tr><td><input type="text" id="imagesalbumId" name="albumId" value=""/></td></tr>
                    <tr><td><input type="file" id="AddImagesFileInput" accept="image/*" name="image" multiple="multiple"/></td></tr>
        
                    <tr><td><input type="submit"/></td></tr>
                    </form>-->


    </div>

    <div id="changeProfilePicDiv" style="display: none">

        <!--            <form action="ChangeProfilePic" method="post" enctype="multipart/form-data">
                        <table>
        
                            <tr><td><input type="file" id="changeProfilePicInput" name="image"/></td></tr>
        
                            <tr><td><input type="submit"/></td></tr>
        
                        </table>
        
                    </form>-->

        <sf:form method="post" modelAttribute="profilepic" enctype="multipart/form-data"  action="ChangeProfilePic">

            <sf:input type="file" name="imagefile" id="imagefile" path="imagefile" /></

        </sf:form>
    </div>

    <!--Notification Div Begins -->

    <div id="notificationsSlidesDiv">

        <div id="notificationsAccordion">

            <h3>&nbsp;&nbsp;&nbsp;&nbsp;Notifications</h3>
            <div class="yourNotificationsDiv">

            </div>

            <h3>&nbsp;&nbsp;&nbsp;&nbsp;Friend Requests</h3>
            <div class="friendRequestNotifications">

                

            </div>


            <h3>&nbsp;&nbsp;&nbsp;&nbsp;Friends News Feed</h3>

            <div class="friendsNotificationsDiv">
                <div class="innerfriendsNotificationsDiv" style="width:100%; height: auto; overflow-x: hidden;overflow-y: auto ">
                    
                    
                </div>



                <div style="width:100%; text-align: center"><button id="loadMoreFriendsNotifications" style="text-align: center;padding:0.5%;margin-right: 30%;float:right;">Load More..</button></div>
            </div>

        </div>
        <div style="position:absolute; bottom:0px; width: 100%; text-align: center"><button style="padding:1%" class="closeNotificationsSlidesDiv">Close</button></div>

    </div>


    <!--Notification Div Ends -->

    <!--Header Navigation Begins -->
    <div id="header_nav">

        <!--Inside Header Naigation Begins -->
        <div id="inside_header_nav">

            <!--Logo Begins -->
            <div class="logo">Slambook<sub style="font-size:0.7em">(beta)</sub></div>
            <!--Logo Ends -->

            <!--Search Friend Begins -->
            <div class="search_friend">
                <input type="search" class="search"  placeholder="Search For A Friend"/>
            </div>
            <!--Search Friend Endss -->

            <!--Links List Begins -->
            <div class="links">

                <img src="resources/images/cog-icon-2-48x48.png" style="float:right;margin-left: 1%;width:inherit;height:inherit" id="userSettingsButton"/>
                <span id="account">Log Out</span>
                <span id="friends">Friends</span>
                <a href="#/page/1" style="text-decoration: none;color:white"><span><c:out value="${requestScope.userInfo.firstName}"></c:out></span></a>
                    
                <c:choose>

                    <c:when test="${profilePic == '0.jpg'}">

                        
                        <span style="border:none; height:100%;"><img src="resources/images/defaultIcon.png"/></span>
                    </c:when>
                    <c:otherwise>

                        
                        <span style="border:none; height:100%;"><img src="resources/users/<%= userId%>/profilepic/thumbs/<%= profilePic%>"/></span>
                    </c:otherwise>

                </c:choose>

                




                </div>
                <!--Links List Endss -->



                <div class="clear"></div>

            </div>
            <!--Inside Header Naigation Ends -->

        </div>

        <!--Header Naigation Ends -->



        <div id='magazine'>

            <!-- B-load Begins -->

            
            <!-- Page 1 Begins -->
            <div style="overflow:auto !important"  class="b-load" alt="Your Profile">


                <div style="overflow:auto;overflow-x: hidden" alt="Your Profile">


                    <div id="editProfileMenu">

                        <span id="editProfileButtonClick">Edit Profile</span>
                        <span id="changeProfilePicButton">Change Profile Picture</span>
                    </div>
                    <span style="font-size:1.4em;display: block;color: #888"><c:out value="${requestScope.userInfo.firstName}"></c:out>&nbsp;<c:out value="${requestScope.userInfo.lastName}"></c:out><img src="resources/images/cog-icon-2-48x48.png" id="showEditProfileMenu"style="width:42px;height: 42px;float:right;margin-top: 1%; "/></span>
                    </br>

                <c:choose>

                    <c:when test="${profilePic == '0.jpg'}">

                        <img id="profilePic" src="resources/images/defaultIcon.png" class="friend_photo tool" style="margin-top: 1%;"/>

                    </c:when>
                    <c:otherwise>

                        <img id="profilePic" src="resources/users/<%= userId%>/profilepic/thumbs/<%= profilePic%>" class="friend_photo tool" style="margin-top: 1%;"/>

                    </c:otherwise>

                </c:choose>




                </br>
                <span class="userInfoSpan"><span class="profileIntro">Tagline:</span><span class="profileIntroTagline"><c:out value="${requestScope.userInfo.tagline}"></c:out></span></span>
                    </br>
                    <span class="userInfoSpan"><span class="profileIntro">Introduction:</span><span class="profileIntroIntroduction"><c:out value="${requestScope.userInfo.introduction}"></c:out></span></span>
                    </br>
                    <span class="userInfoSpan"><span class="profileIntro">Bragging Rights:</span><span class="profileIntroBraggingRights"><c:out value="${requestScope.userInfo.braggingRights}"></c:out></span></span>
                    </br>
                    <span class="userInfoSpan"><span class="profileIntro">Places Lived:</span><span class="profileIntroPlacesLived"><c:out value="${requestScope.userInfo.placesLived}"></c:out></span></span>
                    </br>
                    <span class="userInfoSpan"><span class="profileIntro">Looking For:</span><span class="profileIntroLookingFor"><c:out value="${requestScope.userInfo.lookingFor}"></c:out></span></span>
                    </br>
                    <span class="userInfoSpan"><span class="profileIntro">Birthday:</span><span class="profileIntroBirthday"><c:out value="${requestScope.userInfo.birthday}"></c:out></span></span>
                    </br>






                </div>
                <!-- Page 1 Ends -->




                <!-- Page 2 Begins -->
                <div style="overflow:auto;overflow-x: hidden" alt="Your Profile">




                    <!--                        <div id="newInvitesDiv">
                                                Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.
                                                Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.
                                                Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.
                                                Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.
                    
                                                Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.
                                                Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.
                                                Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.
                                                Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.
                                            </div>
                    -->


                    <!--                        <div id="notificationsDiv">
                    
                    
                    
                                            </div>-->
                    <span style="display:block; clear:both;margin-top: 1%;margin-bottom: 1%">
                        <a href="#/page/3" class="myimages" style="clear:left">My Images</a>
                        <a href="#/page/3" class="myimages" >My Videos</a>

                    </span>
                    <span class="userInfoSpan"><span class="profileIntro">Email:</span><span class="profileIntroEmail"><c:out value="${requestScope.userInfo.email}"></c:out></span></span>
                    </br>

                    <span class="userInfoSpan"><span class="profileIntro">Gender:</span><span class="profileIntroGender"><c:out value="${requestScope.userInfo.gender}"></c:out></span></span>
                    </br>
                    <span class="userInfoSpan"><span class="profileIntro">Relationship Status:</span><span class="profileIntroRelationShipStatus"><c:out value="${requestScope.userInfo.relationshipStatus}"></c:out></span></span>
                    </br>
                    <span class="userInfoSpan"><span class="profileIntro">School:</span><span class="profileIntroSchool"><c:out value="${requestScope.userInfo.school}"></c:out></span></span>
                    </br>
                    <span class="userInfoSpan"><span class="profileIntro">College:</span><span class="profileIntroCollege"><c:out value="${requestScope.userInfo.college}"></c:out></span></span>
                    </br>
                    <span class="userInfoSpan"><span class="profileIntro">Employment:</span><span class="profileIntroEmployment"><c:out value="${requestScope.userInfo.occupation}"></c:out></span></span>
                    </br>
                    <span class="userInfoSpan"><span class="profileIntro">Website:</span><a href="<c:out value="${requestScope.userInfo.website}"></c:out>"><span class="profileIntroWebsite"><c:out value="${requestScope.userInfo.website}"></c:out></span></a></span>








                </div>
                <!-- Page 2 Ends -->


                <!-- Page 1 Begins -->
                <div style="overflow:auto !important; overflow-x: hidden !important; padding-bottom: 10%;min-height: 90% !important;" alt="Your Albums & Videos">

                    <!--                    <span class="page_title">Friends Are Always Treasured</span>
                                        <div><a class="fancybox" rel="group" href="images/selena.jpg"><img src="images/selena.jpg"  class="friend_photo"/></a></div>
                    
                                        <span class="questions myimages" style="visibility:hidden;">Name :</span> <span class="answers"style="visibility:hidden;">Mayank Sharma</span>
                                        <span class="questions">Loved Ones Call Me</span> <span class="answers">Mayank Sharma</span>
                                        <span class="questions">My Zodiac</span> <span class="answers">Mayank Sharma</span>
                                        <span class="questions">I Was On Cloud9 When</span> <span class="answers">Mayank Sharma</span>
                                        <span class="questions">My Secret Desire Is</span> <span class="answers">Mayank Sharma</span>
                                        <span class="questions">Person I Admire The Most</span> <span class="answers">Mayank Sharma</span>
                                        <span class="questions">My Ideal Vacation Spot</span> <span class="answers">Mayank Sharma</span>-->

                    <div id="editAlbumMenu">

                        <span id="editAlbumButtonClick">Create New Album</span>
                        <span>Edit Album</span>
                        <span id="uploadImagesToAlbumForm">Upload Images</span>
                    </div>

                    <div style="width: 100%;text-align: center">

                        <span>Your Albums <img src="resources/images/cog-icon-2-48x48.png" id="showEditAlbumMenu"style="width:42px;height: 42px;float:right;margin-top: 1%; "/></span>

                    </div>


                    <div class="clear"></div>

                    <div id="userAlbums1">
                    <%! int i = 0;%>

                    <div id="userAlbums">
                        <c:set var="albumCounter" value="0"></c:set>
                        <c:forEach items="${requestScope.userInfo.albumList}" var="albums">
                            
                        <% i++;%>
                            <c:set var="albumCounter" value="1"></c:set>

                                <div class="albumsDiv getImages" albumId="<c:out value="${albums.albumId}"></c:out>">
                                <span class="deleteUserAlbum" albumId="<c:out value="${albums.albumId}"></c:out>" style="z-index:1000000;position:absolute;right:-7%;top:-7%;display:none"><img albumId="<c:out value="${albums.albumId}"></c:out>" src="images/wrong.png" /></span>
                                    <c:set var="albumId" value="${albums.coverImageId}"/>

                                <c:choose>

                                    <c:when test="${albums.coverImageId == '0'}">

                                        <c:set var="albumId" value="0"/>
                                        <img src="resources/images/default_album_300_g4.png"  style="width:100%; height: 75%;"/>
                                        <div style="text-align: center; width: 100%">
                                            <span style="width:100%" class="currentAlbumName"><c:out value="${albums.albumName}"></c:out></span></br>
                                            <span style="width:100%"><c:out value="${albums.albumImageCount}"></c:out>&nbsp;Images</span>

                                            </div>


                                    </c:when>
                                    <c:otherwise>


                                        
                                        <img src="resources/users/<%= session.getAttribute("userId")%>/albums/<c:out value="${albums.albumId}"></c:out>/thumbs/<c:out value="${albums.coverImageId}"></c:out>.jpg"  style="width:100%; height: 75%;"/>
                                            <div style="text-align: center; width: 100%">
                                                    <span style="width:100%"><c:out value="${albums.albumName}"></c:out></span></br>
                                            <span style="width:100%"><c:out value="${albums.albumImageCount}"></c:out>&nbsp;Images</span>

                                            </div>

                                    </c:otherwise>

                                </c:choose>



                            </div>
                            <%

                                if (i % 2 == 0) {

                                    out.print("<div class='clear'></div>");
                                }

                            %>



                        </c:forEach>
                        <c:choose>

                            <c:when test="${albumCounter == '0'}">

                                <div style="overflow: hidden;width:100%; margin-left: 30%; margin-right: 30%;">No Videos (Add Some Videos)</div>

                            </c:when>


                        </c:choose>
                    </div>
                    <div style="width:inherit"><button id="loadMoreUserAlbums" style="text-align: center;margin-left: 40%; margin-right: 40%;padding:1%">Load More..</button></div>
                    <a href="#footer-navig"></a>
                </div>
                <div id="deleteAlbumsDroppable">


                </div>

            </div>
            <!-- Page 1 Ends -->



            <!-- Page 2 Begins -->
            <div style="overflow:hidden !important" alt="Your Albums & Videos">
                <!--                    <span style="display:block; clear:both">
                                        <a href="#" class="myimages images_div_button" style="clear:left">My Images</a>
                                        <a href="#" class="myimages myvideos">My Videos</a>
                                        <a href="#" class="myimages">My MP3's</a>
                                    </span>
                                    <div class="clear" style="margin-top:4%;margin-bottom:4%;"></div>
                                    <span class="questions" >I Define Love As</span><span class="answers"  style="display:inline">Mayank Sharma</span>
                                    <div class="clear" style="margin-top:8%;margin-bottom:8%;"></div>
                                    <span class="questions">I Would Like To Go On A Date With</span><span class="answers" style="display:inline">Mayank Sharma</span>
                                    <div class="clear" style="margin-top:8%;margin-bottom:8%;"></div>
                                    <span class="questions">One Thing Missing In My Life Is</span><span class="answers" style="display:inline">Mayank Sharma</span>
                                    <div class="clear" style="margin-top:8%;margin-bottom:8%;"></div>
                                    <span class="questions">Oops! I Made A Mistake When</span><span class="answers" style="display:inline">Mayank Sharma</span>
                                    <div class="clear" style="margin-top:8%;margin-bottom:8%;"></div>
                                    <span class="questions">I Am Proud Of</span><span class="answers" style="display:inline">Mayank Sharma</span>
                                    <div class="clear" style="margin-top:8%;margin-bottom:8%;"></div>
                                    <span class="questions">I Like You Because You Are</span><span class="answers" style="display:inline">Mayank Sharma</span>
                                    <div class="clear" style="margin-top:8%;margin-bottom:8%;"></div>
                                    <span class="questions">My Latest Crush</span><span class="answers" style="display:inline">Mayank Sharma</span>    -->

                <div id="editVideoMenu">

                    <span id="editVideoButtonClick">Add Video</span>
                    <span>Edit Videos</span>
                </div>

                <div style="width:100%; text-align: center"> Your Videos <img src="resources/images/cog-icon-2-48x48.png" id="showEditVideoMenu"style="width:42px;height: 42px;float:right;margin-top: 2%; "/></div>

                <div id="userVideos">
                    <c:set var="videoCount" value="0"/>
                    <c:forEach items="${requestScope.userInfo.videoList}" var="video" varStatus="0">
                        <c:set var="videoCount" value="1"/>



                        
                         
                        <div class="videosDiv" title="<c:out value="${video.videoDescription}"></c:out>">

                                <iframe title="<c:out value="${video.videoDescription}"></c:out>" class="videoPlayer" width="100%" height="240px" src="http://www.youtube.com/embed/<c:out value="${video.videoUrl}"></c:out>" frameborder="0" allowfullscreen style="margin-bottom: 0;z-index:10!important">
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
                            <span class="deleteUserVideo" videoId="<c:out value="${video.videoId}"></c:out>" style="z-index:1000000;float: left;position:relative; left:80%;bottom:100%;display:none"><img videoId="<c:out value="${video.videoId}"></c:out>" src="resources/images/wrong.png" /></span>
                            <a class="videofancybox fancybox fancybox.iframe" href="VideoComments/getVideoComments/<c:out value="${video.videoId}"></c:out>"><span style="float:right;margin-right: 4%;text-decoration: none;color:white" class="videoComments" videoId="<c:out value="${video.videoId}"></c:out>"><c:out value="${video.videoCommentsCount}"></c:out>&nbsp;Comments</span></a>
                            
                            </div>
                            
                             
                          


                    </c:forEach>
                    <c:choose>

                        <c:when test="${videoCount == '0'}">

                            <div style="overflow: hidden;width:100%; margin-left: 30%; margin-right: 30%;">No Videos (Add Some Videos)</div>

                        </c:when>


                    </c:choose>
                </div>
                <div style="width:inherit"><button id="loadMoreUserVideos" style="text-align: center;margin-left: 40%; margin-bottom: 2%; margin-right: 40%;padding:1%">Load More..</button></div>

            </div>
            <!-- Page 2 Ends -->

            <!-- Page 1 Begins -->

            <!-- Page 2 Ends -->


            <!-- Page 1 Begins -->

            <c:forEach items="${requestScope.userInfo.slambookAnswersList}" var="answers">
                <div style="overflow:auto !important" alt="<c:out value="${answers.name}"></c:out>">
                    <span style="font-size:1.4em;display: block;color: #888"><c:out value="${answers.name}"></c:out><img src="resources/images/cog-icon-2-48x48.png" id=""style="width:42px;height: 42px;float:right;margin-top: 0%; "/><img src="resources/images/email.png" class="sendEmail" receiverName ="<c:out value="${answers.ans1}"></c:out>"receiverId ="<c:out value="${answers.senderId}"></c:out>"style="width:32px;height: 32px;float:right;margin-top: 0%; margin-right: 3%; margin-top: 1%; "/></span>
                        <span class="page_title">Friends Are Always Treasured</span>
                                <div class="viewProfileLink" friendId="<c:out value="${answers.senderId}" escapeXml="true"></c:out>"><a class="fancybox" rel="group" href="resources/users/<c:out value="${answers.senderId}" escapeXml="true"></c:out>/profilepic/<c:out value="${answers.currentProfilePic}${'.jpg'}" escapeXml="true"></c:out>"><img src="resources/users/<c:out value="${answers.senderId}" escapeXml="true"></c:out>/profilepic/thumbs/<c:out value="${answers.currentProfilePic}${'.jpg'}" escapeXml="true"></c:out>"  class="friend_photo"/></a></div>


                                        <span class="questions" >Loved Ones Call Me</span><span class="answers">&nbsp; <c:out value="${answers.ans1}"></c:out></span>
                    <span class="questions">My Zodiac</span> <span class="answers">&nbsp;<c:out value="${answers.ans2}"></c:out></span>
                    <span class="questions">I Was On Cloud9 When</span> <span class="answers">&nbsp;<c:out value="${answers.ans3}"></c:out></span>
                    <span class="questions">My Secret Desire Is</span> <span class="answers">&nbsp;<c:out value="${answers.ans4}"></c:out></span>
                    <span class="questions">Person I Admire The Most</span> <span class="answers">&nbsp;<c:out value="${answers.ans5}"></c:out></span>
                    <span class="questions">My Ideal Vacation Spot</span> <span class="answers">&nbsp;<c:out value="${answers.ans6}"></c:out></span>




                    </div>
                    <!-- Page 1 Ends -->



                    <!-- Page 2 Begins -->
                    <div>
                        <span style="display:block; clear:both">
                            <a class="myimages images_div_button friendsAlbumsButton" friendId="<c:out value="${answers.senderId}"></c:out>" style="clear:left">My Images</a>
                        <a class="myimages friendsVideosButton" friendId="<c:out value="${answers.senderId}"></c:out>">My Videos</a>

                        </span>
                        <div class="clear" style="margin-top:4%;margin-bottom:4%;"></div>
                        <span class="questions" >I Define Love As</span><span class="answers"  style="display:inline">&nbsp;<c:out value="${answers.ans7}"></c:out></span>
                        <div class="clear" style="margin-top:8%;margin-bottom:8%;"></div>
                        <span class="questions">I Would Like To Go On A Date With</span><span class="answers" style="display:inline">&nbsp;<c:out value="${answers.ans8}"></c:out></span>
                        <div class="clear" style="margin-top:8%;margin-bottom:8%;"></div>
                        <span class="questions">One Thing Missing In My Life Is</span><span class="answers" style="display:inline">&nbsp;<c:out value="${answers.ans9}"></c:out></span>
                        <div class="clear" style="margin-top:8%;margin-bottom:8%;"></div>
                        <span class="questions">Oops! I Made A Mistake When</span><span class="answers" style="display:inline">&nbsp;<c:out value="${answers.ans10}"></c:out></span>
                        <div class="clear" style="margin-top:8%;margin-bottom:8%;"></div>
                        <span class="questions">I Am Proud Of</span><span class="answers" style="display:inline">&nbsp;<c:out value="${answers.ans11}"></c:out></span>
                        <div class="clear" style="margin-top:8%;margin-bottom:8%;"></div>
                        <span class="questions">I Like You Because You Are</span><span class="answers" style="display:inline">&nbsp;<c:out value="${answers.ans12}"></c:out></span>
                        <div class="clear" style="margin-top:8%;margin-bottom:8%;"></div>
                        <span class="questions">My Latest Crush</span><span class="answers" style="display:inline">&nbsp;<c:out value="${answers.ans13}"></c:out></span>


                    </div>
                    <!-- Page 2 Ends -->

            </c:forEach>

        </div>
                    

        <!-- B-load Ends -->

    </div>







    <!--Footer Begins  -->
    <div id="footer">
        <!--Footer Begins  -->
        <div id="inside_footer">
            <span class="mayank">Developed By Mayank Sharma</span>
        </div>
        <!--Footer Ends  -->
    </div>
    <!--Footer Ends  -->


    <!--Dialog Divs Begin-->

    <div id="addSchool" style="display: none">

        <table class="addTable">
            <tr><td>SchoolName:</td><td><input type="text" id="schoolName"/></td></tr>
            <tr><td>Place:</td><td><input type="text" id="place"/></td></tr>
            <tr><td>Year:</td><td><input type="text" id="yearSchoolAttended"/></td></tr>
        </table>

    </div>

    <div id="addCollege" style="width:40%; display: none" style="display: none">

        <table class="addTable">
            <tr><td>College Name:</td><td><input type="text" id="collegeName"/></td></tr>
            <tr><td>Stream:</td><td><input type="text" id="stream"/></td></tr>
            <tr><td>Year:</td><td><input type="text" id="yearCollegeAttended"/></td></tr>
        </table>

    </div>
    <input type="hidden" id="userId" value="<c:out value="${sessionScope.userId}"></c:out>"/>
    <input type="hidden" id="currentProfilePic" value="<c:out value="${requestScope.userInfo.profilePic}"></c:out>"/>
    <input type="hidden" id="currentUserName" value="<c:out value="${requestScope.userInfo.firstName}"></c:out> <c:out value="${requestScope.userInfo.lastName}"></c:out>"/>
    <!--Dialog Divs Ends-->

</body>
</html>