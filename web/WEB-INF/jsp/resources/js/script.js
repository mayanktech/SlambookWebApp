// JavaScript Document
var params = {};
var currentRealTimeSenderId;
var currentRealTimeMessageId;
var startRealTimeChat;

$(document).ready(function(e) {

    //	var inFoSliderWidth = $('#infoSlider').width();
    //        var inFoSliderHeight = $('#infoSlider').height();
    //	$('#infoSlider').bjqs({
    //            animtype      : 'slide',
    //            showcontrols : false,
    //            responsive    : true,
    //            width:inFoSliderWidth,
    //            height:inFoSliderHeight,
    //            showcontrols:true,
    //            showmarkers : false,
    //            usecaptions : false,
    //            hoverpause : true
    //          });


    //        $('.tool').tipTip({
    //
    //
    //
    //        });

    /*  Home Page Script Begins  */
    //        $(".touchslider").touchSlider({
    //
    //            autoplay:true
    //
    //        });


    /*Login Script Begins */
    var receiverId;

    var albumId;
    var friendId;
    var userAlbumId;
    var curentAlbumName;
    var friendAlbumClickTimes = 0;
    var userAlbumClickTimes = 0;
    var userVideoClickTimes = 0;
    var userFriendClickTimes = 0;
    var friendNotificationClickTimes = 0;
    var friendMessagesClickTimes = 0;
    var currentFriendMessageId;
    var currentfriendId;
    $('#pwd').keypress(function(event){

        var keycode = (event.keyCode ? event.keyCode : event.which);
        if(keycode == '13'){
            $('#loginForm').submit();
        }

    });


    /*Login Script Begins */

    /**/

    /**/
    var icons = {
            header: "ui-icon-circle-arrow-e",
            activeHeader: "ui-icon-circle-arrow-s"
        };
    $('#notificationsAccordion').accordion({

        icons:icons
    });

    /**/

    /*   Check Email Validity Script Begins */

    var status = "true";
    var checkemailajax ="false";
    $('#email').blur(function(){

        if($('#email').val().trim().length != 0){
            status = "true";
            $('#checkEmail').css("display", "inline");
            $('#checkEmail').attr("src", "resources/images/282.gif");
            var email = $('#email').val();
            if(!validateEmail(email)){
                $('#checkEmail').attr("src", "resources/images/wrong.png");
            //status ="falseemailregex";
            }
            else{
                $.ajax({

                    url:'UserInfo/checkEmail',
                    type:'post',

                    data:{
                        email:email
                    }

                }).success(function(msg){

                    
                    if (msg == false){

                        $('#checkEmail').attr("src", "resources/images/correct.gif");
                        checkemailajax ="true";
                    }
                    else{

                        $('#checkEmail').attr("src", "resources/images/wrong.png");
                        status = "falseemail";
                        checkemailajax ="true";
                    }


                });
            }
        }

    });



    /*   Check Email Validity Script Ends */

    /**/

    $('#repeatPassword').blur(function(){

        var password = $('#password').val();
        var conpassword = $('#repeatPassword').val();
        $('#checkPassword').css("display","inline");

        if(conpassword.length != 0){

            if(password == conpassword  ){

                $('#checkPassword').attr("src","images/correct.gif");

            }
            else{

                $('#checkPassword').attr("src","images/wrong.png");
            //$('#checkPassword').css("display","inline");
            }

        }
    });


    /**/

    /*Birthday DatePicker Script Begins */
    $('#birthday').datepicker({

        changeMonth: true,
        changeYear: true,
        showOn: "button",
        buttonImage: "images/calendar.gif",
        buttonImageOnly: true,
        yearRange: "1980:2012",
        showAnim: "explode",
        duration: "normal",
        dateFormat: "dd-mm-yy",

    });


    $('#birthday').focus(function(){

        $('#birthday').datepicker({

            changeMonth: true,
            changeYear: true,
            showOn: "button",
            buttonImage: "images/calendar.gif",
            buttonImageOnly: true
        });

    });
    $('#birthday').click(function(){

        $('#birthday').datepicker({

            changeMonth: true,
            changeYear: true,
            showOn: "button",
            buttonImage: "images/calendar.gif",
            buttonImageOnly: true
        });

    });

    /*Birthday DatePicker Script Ends*/
    /*  Sign Up Button Script Begins  */


    $('#signUpButton').click(function(e){
        
        e.preventDefault();
        
        var firstName;
        var lastName;
        var email;
        var password;
        var conpassword;
        var gender;
        var birthday;
        if(status != 'falseemail'){
            status = "true";
        }
        firstName = $('#firstName').val();
        lastName = $('#lastName').val();
        email = $('#email').val();
        password = $('#password').val();
        conpassword = $('#repeatPassword').val();
        gender = $('#gender').val();
        birthday = $('#birthday').val();

        /*alert(firstName+lastName+email+password+gender+birthday);*/



        $('#signup').find('input[type="text"]').each(function(){


            if($(this).val().trim() == ""){

                status = "falsem";
            //alert(status);
            }


        });

        $('#signup').find('input[type="password"]').each(function(){


            if($(this).val().trim() == ""){

                status = "falsem";
            //alert("pass");
            }


        });

        if(status != 'falsem'){

            if(password != conpassword){

                status = "falsep";


            }
        }


        if($('#email').val().trim().length != 0){
            if(!validateEmail(email)){
                $('#checkEmail').attr("src", "images/wrong.png");
                status ="falseemailregex";
            }
        }
        /*$('#signup').find('input[type="password"]').each(function(){


                 if($(this).val().trim().length < 7){

                    status = "falsel";
                    //alert("pass");
                }


                });*/





        if(status == 'true' && checkemailajax =='false'){
            var formData = $('#signUpForm').serialize();
            $('#dialog').html('Signing Up Please Wait').dialog({


                
                modal:true,

                draggable:false,
                resizable:false,
                title:"Please Wait ......",
                show: {
                    effect: "fold",
                    duration: 500
                },
                hide: {
                    effect: "fold",
                    duration: 1000
                },
                buttons:{

            }







            });

            $.ajax({


                url:'UserInfo/addUser',
                type:'post',
                data:formData

            }).success(function(msg){
                var email = $('#email').val();
                $('#signup').find('input[type="password"]').each(function(){


                    $(this).val("");


                });
                $('#signup').find('input[type="text"]').each(function(){


                    $(this).val("");


                });

                $('#signup').find('input[type="email"]').each(function(){


                    $(this).val("");


                });

                $('#checkEmail').css("display", "none");
                $('#checkPassword').css("display", "none");

                $.ajax({

                    url:'SendEmail',
                    type:'post',
                    data:{
                        recipient:email,
                        subject:'Hii',
                        messageBody:'Hii'
                    }

                });
                $('#dialog').html('Please Check Ur Email To Activate Your Account').dialog({

                    modal:true,
                    buttons: [
                    {
                        text: "Ok",
                        click: function() {
                            $(this).dialog("close");
                            $('#emailId').focus();
                            $('#emailId').css("background-color","yellow");
                        }
                    }
                    ],
                    draggable:false	,
                    resizable:false ,
                    title:"Thanx A Ton :) "	,
                    show: {
                        effect: "fold",
                        duration: 1000
                    },
                    hide: {
                        effect: "fold",
                        duration: 1000
                    }



                });






            }).error(function(){


                alert('error');

            });

        }

        else if(status == "falsem"){

            showNotification('Oops ! Some Fields Are Missing :(');

        }
        else if(status == "falseemail"){

            showNotification('That Email Has Already Been Registered :(');

        }
        else if( status == "falsep"){

            showNotification('Oops ! Password Didn\'t match :(');

        }
        else if(status == 'falsel'){

            showNotification('Password lenght must be more than 7 characters');

        }

        else if(status == "falseemailregex"){

            showNotification("Please Enter Valid Email Address");
        }





    });


    /*  Sign Up Button Script Ends  */

    /*  Home Page Script Ends  */





    /*Log Out*/



    /**/

    /* Adding School Script Begins*/

    $('#addSchoolButton').click(function(){

        $('#addSchool').dialog({

            modal:true,
            title:'Add New School',
            resizable:false,
            height:'250',
            width:'400',
            show: {
                effect: "drop",
                duration: 1000
            },
            hide: {
                effect: "drop",
                duration: 1000
            },
            draggable:false,
            buttons:[

            {

                text:'Add',
                click:function(){

                    $('#addSchool').dialog("close");
                    $('#dialog').html("Adding School Please Wait .....").dialog({

                        modal:true,
                        title:'Please Wait ...',
                        show: {
                            effect: "fade",
                            duration: 500
                        },
                        hide: {
                            effect: "fade",
                            duration: 1000
                        },
                        buttons:{

                    }


                    });
                    var userId = $('#userId').val();
                    var schoolName = $('#schoolName').val();
                    var place = $('#place').val();
                    var yearSchoolAttended = $('#yearSchoolAttended').val();
                    $.ajax({

                        url:'AddSchool',
                        type:'post',
                        data:{
                            userId:userId,
                            schoolName:schoolName,
                            place:place,
                            yearSchoolAttended:yearSchoolAttended
                        }


                    }).success(function(){

                        $('#dialog').dialog("close");

                    }).error(function(){

                        alert("error");
                    });

                },


            },{

                text:'Cancel',
                click:function(){

                    $(this).dialog("close");

                }
            }

            ]

        });

    /* Adding School Script Ends*/

    }).next().button({
        text: 'false',
        icons: {
            primary: "ui-icon-gear"
        }
    });

    /*Adding College Script Begins*/


    $('#addCollegeButton').click(function(){

        $('#addCollege').dialog({


            modal:true,
            title:'Add New College',
            height:'250',
            width:'400',
            resizable:false,
            draggable:false,
            buttons:[{

                text:'Add',
                click:function(){

                    $('#addCollege').dialog("close");
                    $('#dialog').html("Adding College Please Wait .....").dialog({

                        modal:true,
                        title:'Please Wait ...',
                        show: {
                            effect: "fade",
                            duration: 500
                        },
                        hide: {
                            effect: "fade",
                            duration: 1000
                        },
                        buttons:{

                    }


                    });
                    var userId = $('#userId').val();
                    var collegeName = $('#collegeName').val();
                    var stream = $('#stream').val();
                    var yearCollegeAttended = $('#yearCollegeAttended').val();
                    $.ajax({

                        url:'AddCollege',
                        type:'post',
                        data:{
                            userId:userId,
                            collegeName:collegeName,
                            stream:stream,
                            yearCollegeAttended:yearCollegeAttended
                        }


                    }).success(function(){

                        $('#dialog').dialog("close");
                        $('#addCollege').dialog("close");

                    }).error(function(){

                        alert("error");
                    });

                },


            },{

                text:'Cancel',
                click:function(){

                    $(this).dialog("close");

                }
            }

            ]






        });


    });



    /*Adding College Script Ends*/


    /*Accordion Script Ends*/

    $('.logo').click(function(){


        $('#dialog').html('Welcome To Slambook').dialog({

            modal:true,
            resizable:false,
            draggable:false,
            title:'Welcome !',
            show: {
                effect: "fold",
                duration: 1000
            },
            hide: {
                effect: "fold",
                duration: 1000
            },
            buttons: {
                "Close": function() {
                    $(this).dialog("close");
                }
            }
        });

    });


    if(($.browser.mozilla) || ($.browser.opera)){
        $('#magazine').booklet({


            width:'84%',
            height:'580',
            easing:'easeInCubic',

            shadows: true,
            hoverWidth: 25,
            hash: true,
            arrows:true,
            cursor: "pointer",
            pageNumbers:false,
            keyboard:true,
            start: function(event, data) {
               $('#pageFlipSound').get(0).play();
            }
        });
        $('fieldset').css('height', '200px')
    }
    else{
        var counter = 0;
        $('#magazine').booklet({


            width:'84%',
            height:'580',
            easing:'easeInCubic',

            shadows: true,
            hoverWidth:25,
            hash: true,
            arrows:true,
            cursor: "pointer",
            pageNumbers:false,
            keyboard:false,
            closed: false,
            covers:false,
            autoCenter: true,
            create: function(event, data) {

            if(data.index == 0){

                // $('#magazine').booklet("option", {arrows: false});
                 //   $('#magazine').css('left','8%');
                //  $('#magazine').booklet("option", {hoverWidth:250});
                //$('.b-next').css('display','none');
                }
                else{

                 //  $('#magazine').booklet("option", {arrows: true});
                  // $('#magazine').css('left','0%');
                   document.title = "SlamBook - "+data.pages[0].getAttribute("alt");
                  // $('#magazine').booklet("option", {hoverWidth:25});
                  //$('.b-next').css('display','inline');
                }

            },
            start: function(event, data) {
               $('#pageFlipSound').get(0).play();
               document.title = "SlamBook - "+data.pages[0].getAttribute("alt");

               if(data.index != 0){


               }
               else{

                   //$('#magazine').css('box-shadow','');

               }


            },
            change: function(event, data) {


                if(data.index == 0){

              //      $('#magazine').booklet("option", {arrows: false});
                    //$('#magazine').css('left','8%');
                    //$('.b-next').css('display','none');
                    document.title = "Slambook - Home";
                    //$('#magazine').css('box-shadow','0');
                //    $('#magazine').booklet("option", {hoverWidth:250});

                }
                else{
                     //$('.b-next').css('display','inline');
                 //  $('#magazine').booklet("option", {arrows: true});
                   //$('#magazine').css('left','0');

                   //$('#magazine').css('box-shadow','0 0 6px 6px  #FFF');
                   document.title = "SlamBook - "+data.pages[0].getAttribute("alt");
                   //$('#magazine').booklet("option", {hoverWidth:25});
                }

            }
        });


    }


    $('#uploadImagesToAlbumForm').click(function(){


        $('#editAlbumMenu').slideUp(500);
        $('#selectUserAlbums').dialog({

            width:'450',
            height:'150',
            modal:true,
            title:'Add Images To Album',
            draggable:'false',
            resizable:'false',
            show: {
                effect: "drop",
                duration: 1000
            },
            hide: {
                effect: "drop",
                duration: 1000
            }

        });

    });
    $('#loadMoreUserAlbums').live('click',function(){
        var userId = $('#userId').val();
        userAlbumClickTimes++;
        $('#loadMoreUserAlbums').text("Loading ....");
        $.ajax({

            url:'album/LoadMoreUserAlbums/'+userId+"/"+userAlbumClickTimes,
            type:'post',
            data:{
                userId:userId,
                clickTimes:userAlbumClickTimes
            }

        }).success(function(data){


            $('#userAlbums').append(data);
            $('#loadMoreUserAlbums').text("Load More...");



        });

    });
    $('#loadMoreFriendAlbums').live('click',function(){

        friendAlbumClickTimes++;
        $('#loadMoreFriendAlbums').text("Loading ....");
        $.ajax({

            url:'LoadMoreFriendsAlbums',
            type:'post',
            data:{
                userId:currentfriendId,
                clickTimes:friendAlbumClickTimes
            }

        }).success(function(data){


            $('.friendsAlbums').append(data);
            $('#loadMoreFriendAlbums').text("Load More...");

        });

    });
    $('#loadMoreFriendsNotifications').live('click',function(){

        var userId = $('#userId').val();
        friendNotificationClickTimes++;
        $('#loadMoreFriendsNotifications').text("Loading ....");
        $.ajax({

            url:'LoadMoreFriendsNewsFeed',
            type:'post',
            data:{
                userId:userId,
                clickTimes:friendNotificationClickTimes
            }

        }).success(function(data){


            $('.friendsNotifications').append(data);

            $('#loadMoreFriendsNotifications').text("Load More...");

        });

    });
    $('#loadMoreUserVideos').live('click',function(){
        var userId = $('#userId').val();
        userVideoClickTimes++;
        $('#loadMoreUserVideos').text("Loading ....");
        $.ajax({

            url:'Videos/LoadMoreUserVideos/'+userId+"/"+userVideoClickTimes,
            type:'post',
            data:{
                userId:userId,
                clickTimes:userVideoClickTimes
            }

        }).success(function(data){


            $('#userVideos').append(data);
            $('#loadMoreUserVideos').text("Load More...");

        });

    });

    $('#loadMoreFriendsVideos').live('click',function(){

        userFriendClickTimes++;



        $('#loadMoreFriendsVideos').text("Loading ....");
        $.ajax({

            url:'LoadMoreFriendsVideos',
            type:'post',
            data:{
                userId:currentfriendId,
                clickTimes:userFriendClickTimes
            }

        }).success(function(data){



            $('.friendsVideos').append(data);
            if(data != null){

                $('#loadMoreFriendsVideos').text("Load More...");
            }
            else{

                $('#loadMoreFriendsVideos').text("No More...");
            }

        });

    });
    $(".getImages").live({
        mouseenter:
           function()
           {

           $(this).find('span[class="deleteUserAlbum"]').show(500);

           },
        mouseleave:
           function()
           {

           $(this).find('span[class="deleteUserAlbum"]').hide(500);

           }
       }
    );
        $(".videosDiv").live({
        mouseenter:
           function()
           {

           $(this).find('span[class="deleteUserVideo"]').show(500);

           },
        mouseleave:
           function()
           {

           $(this).find('span[class="deleteUserVideo"]').hide(500);

           }
       }
    );
    $(".deleteUserAlbum").live({
        mouseenter:
           function()
           {

           $(this).parent().removeClass('getImages');

           },
        mouseleave:
           function()
           {

          $(this).parent().addClass('getImages');

           }
       }
    );
        $(".imagesDiv").live({
        mouseenter:
           function()
           {


           //$(this).find('span[class="deleteUserAlbumImage"]').show(100);

           },
        mouseleave:
           function()
           {

           //$(this).find('span[class="deleteUserAlbumImage"]').hide(100);

           }
       }
    );
         $('.deleteUserAlbumImage').live('click',function(){
        $(this).hide(500);
        var imageId = $(this).attr("imageId");
        var albumId = $(this).attr("albumId");

        $(this).parent().addClass('currentAlbumImageToBeDeleted');
        $('#dialog').html("Are You Sure You Want To Delete This Image ?").dialog({

            width:'auto',
            modal:true,
            title:'Confirmation ..',
            show: {
                effect: "drop",
                duration: 500
            },
            hide: {
                effect: "drop",
                duration: 500
            },
            buttons:[
            {
                text: "Yes",
                click: function() {
                    $('#dialog').dialog('close');
                    $('#dialog').html('Deleting Image Please Wait ..').dialog({

                        modal:true,
                        width:'auto',
                        title:'Please Wait',
                        draggable:false,
                        show: {
                            effect: "drop",
                            duration: 300
                        },
                        hide: {
                            effect: "drop",
                            duration: 100
                        },
                        resizable:false,
                        buttons:{}

                    });
                    $.ajax({

                        url:"DeleteUserAlbumImage",
                        type:'post',
                        data:{
                            imageId:imageId,
                            albumId:albumId
                        }

                    }).success(function(data){


                          $('#dialog').dialog('close');

                    $('#dialog').html('Image Deleted Successfully :(').dialog({

                        modal:true,
                        width:'auto',
                        title:'Success :)',
                        draggable:false,
                        show: {
                            effect: "drop",
                            duration: 300
                        },
                        hide: {
                            effect: "drop",
                            duration: 100
                        },
                        resizable:false,
                        buttons:[{

                            text:"Ok",
                            click:function(){

                               $('#dialog').dialog('close');
                               $('div.currentAlbumImageToBeDeleted').hide(1000);
                            }

                        }]

                    });
                    }).error(function(data){

                        alert("OE"+data);

                    });

                }

            },
            {

                text: "No",
                click: function() {

                    $(this).dialog('close');

                }

            }
            ]

        });



    });



    $('.deleteUserVideo').live('click',function(){
        $(this).hide(500);
        var videoId = $(this).attr("videoId");
        $(this).parent().addClass('currentVideoToBeDeleted');
        $('#dialog').html("Are You Sure You Want To Delete This Video ?").dialog({

            width:'auto',
            modal:true,
            title:'Confirmation ..',
            show: {
                effect: "drop",
                duration: 500
            },
            hide: {
                effect: "drop",
                duration: 500
            },
            buttons:[
            {
                text: "Yes",
                click: function() {
                    $('#dialog').dialog('close');
                    $('#dialog').html('Deleting Video Please Wait ..').dialog({

                        modal:true,
                        width:'auto',
                        title:'Please Wait',
                        draggable:false,
                        show: {
                            effect: "drop",
                            duration: 300
                        },
                        hide: {
                            effect: "drop",
                            duration: 100
                        },
                        resizable:false,
                        buttons:{}

                    });
                    $.ajax({

                        url:"DeleteUserVideo",
                        type:'post',
                        data:{
                            videoId:videoId
                        }

                    }).success(function(data){


                          $('#dialog').dialog('close');

                    $('#dialog').html('Video Deleted Successfully :(').dialog({

                        modal:true,
                        width:'auto',
                        title:'Success :)',
                        draggable:false,
                        show: {
                            effect: "drop",
                            duration: 300
                        },
                        hide: {
                            effect: "drop",
                            duration: 100
                        },
                        resizable:false,
                        buttons:[{

                            text:"Ok",
                            click:function(){

                               $('#dialog').dialog('close');
                               $('div.currentVideoToBeDeleted').hide(2000);
                            }

                        }]

                    });
                    }).error(function(){

                        alert("OE");

                    });

                }

            },
            {

                text: "No",
                click: function() {

                    $(this).dialog('close');

                }

            }
            ]

        });



    });




    $('.deleteUserAlbum').live('click',function(){
        $(this).hide(500);
        var albumId = $(this).attr("albumId");
        $(this).parent().addClass('currentAlbumToBeDeleted');
        $('#dialog').html("Are You Sure You Want To Delete This Album ?").dialog({

            width:'auto',
            modal:true,
            title:'Confirmation ..',
            show: {
                effect: "drop",
                duration: 500
            },
            hide: {
                effect: "drop",
                duration: 500
            },
            buttons:[
            {
                text: "Yes",
                click: function() {
                    $('#dialog').dialog('close');
                    $('#dialog').html('Deleting Album Please Wait ..').dialog({

                        modal:true,
                        width:'auto',
                        title:'Please Wait',
                        draggable:false,
                        show: {
                            effect: "drop",
                            duration: 300
                        },
                        hide: {
                            effect: "drop",
                            duration: 100
                        },
                        resizable:false,
                        buttons:{}

                    });
                    $.ajax({

                        url:"DeleteUserAlbum",
                        type:'post',
                        data:{
                            albumId:albumId
                        }

                    }).success(function(data){


                          $('#dialog').dialog('close');

                    $('#dialog').html('Album Deleted Successfully :(').dialog({

                        modal:true,
                        width:'auto',
                        title:'Success :)',
                        draggable:false,
                        show: {
                            effect: "drop",
                            duration: 300
                        },
                        hide: {
                            effect: "drop",
                            duration: 100
                        },
                        resizable:false,
                        buttons:[{

                            text:"Ok",
                            click:function(){

                               $('#dialog').dialog('close');
                               $('div.currentAlbumToBeDeleted').hide(1000);
                            }

                        }]

                    });
                    }).error(function(){

                        alert("OE");

                    });

                }

            },
            {

                text: "No",
                click: function() {

                    $(this).dialog('close');

                }

            }
            ]

        });



    });

    $('.getImages').live('click',function(e) {



        $('#dialog').html('<div><img src="resources/images/143.gif" style="margin-left: auto; margin-right: auto;text-align:center;width:100%;"/></div>Please Wait While The Images Loads').dialog({


            width:'auto',
            title:'Please Wait ....',
            show: {
                effect: "drop",
                duration: 300
            },
            hide: {
                effect: "drop",
                duration: 100
            },
            buttons:{

        }


        });
        albumId = $(this).attr("albumId");
        var userId = $("#userId").val();
        $.ajax({

            url:"Images/getImages/"+albumId+"/"+userId,
            type:'post',
            
        }).success(function(data){
            $('#dialog').dialog('close');
            $('#images_div').html('<div style="position:absolute; bottom:0px; width: 100%; text-align: center"><button style="padding:1%" class="closeImagesDiv">Close</button></div>');
            $('#images_div').prepend(data).slideDown(1000);

        });



    });

    $('.closeImagesDiv').live('click',function(){

        $('#images_div').slideUp(1000);
    });

    $('.closefriendsalbumImagesDiv').live('click',function(){

        $('#images_div_friendsalbumImages').slideUp(1000);

    })
    $('.currentViewAlbumHide').live('click',function(){

        $('#images_div').slideUp(1000,function(){

            $('#images_div').html("");

        });

    });

    $('#account').click(function(e) {

        $('#dialog').html('Are You Sure You want to Log Out !').dialog({

            modal:true,
            width:'auto',
            title:'Confirm Log Out',
            draggable:'false',
            resizable:'false',
            show: {
                effect: "fade",
                duration: 500
            },
            hide: {
                effect: "fade",
                duration: 1000
            },

            buttons: [
            {
                text: "Yes",
                click: function() {
                    $('#dialog').dialog('close');
                    $('#dialog').html('Logging Off Please Wait ..').dialog({

                        modal:true,
                        width:'auto',
                        title:'Confirm Log Out',
                        draggable:'false',
                        resizable:'false'

                    });
                    $.ajax({

                        url:'logOutUser',
                        type:'post'

                    }).success(function(){


                        location.href="http://localhost:8084/SlamBook/logOutInfo.jsp";

                    });

                }

            },
            {

                text: "Cancel",
                click: function() {

                    $(this).dialog('close');

                }

            }
            ]

        });

    });

    $('#friends').click(function(e) {
        $('#friends_div').slideDown(1000);
    });

    $('.closeFriendsDiv').click(function(){

        $('#friends_div').slideUp(1000);

    });

    var i = 0;
    $(".fancybox").fancybox({


        padding : 0,

        title:'',
        openEffect : 'elastic',
        openSpeed  : 150,

        closeEffect : 'elastic',
        closeSpeed  : 150,
        beforeLoad :function(){


           if(i == 0){
           //$('#magazine').booklet("option", {keyboard: false});
           }
           i++;

        },
        afterClose:function(){
            i = 0;
           //$('#magazine').booklet("option", {keyboard: true});

        },
        helpers : {

            thumbs : {
                width  : 75,
                height : 75
            },
            buttons	: {
                tpl: '<div id="fancybox-buttons"><ul style="width:132px"><li><a class="btnPrev" title="Previous" href="javascript:;"></a></li><li><a class="btnPlay" title="Start slideshow" href="javascript:;"></a></li><li><a class="btnNext" title="Next" href="javascript:;"></a></li><li><a class="btnClose" title="Close" href="javascript:jQuery.fancybox.close();"></a></li></ul></div>',
                type : 'inside'
            },
            overlay : {
                css : {
                    'background' : 'rgba(0,0,0,0.85)'
                }
            }

        },




        afterLoad : function() {
            this.title = 'Image ' + (this.index + 1) + ' of ' + this.group.length + (this.title ? ' - ' + this.title : '');
        }


    });

    $(".videofancybox").fancybox({
        padding : 0,

        title:'',
        openEffect : 'elastic',
        openSpeed  : 150,

        closeEffect : 'elastic',
        closeSpeed  : 150,

        helpers : {



            overlay : {
                css : {
                    'background' : 'rgba(0,0,0,0.85)'
                }
            }

        },





    });




    $(".imageCommentsfancybox").fancybox({
        padding : 0,

        title:'',
        openEffect : 'elastic',
        openSpeed  : 150,
        showNavArrows: false,
        closeEffect : 'elastic',
        closeSpeed  : 150,
        type:'iframe',
        autoSize:true,
        onComplete:function(){

            alert('H');
            $('.fancybox-nav').css('display','none!important');

        },
        helpers : {


            overlay : {
                css : {
                    'background' : 'rgba(0,0,0,0.85)'
                }
            }

        }





    });
    
    $(".imageLikesfancybox").fancybox({
        padding : 0,
        width:250,
        height:300,
        title:'',
        openEffect : 'elastic',
        openSpeed  : 150,
        showNavArrows: false,
        closeEffect : 'elastic',
        closeSpeed  : 150,
        type:'iframe',
       
        onComplete:function(){

            alert('H');
            $('.fancybox-nav').css('display','none!important');

        },
        helpers : {


            overlay : {
                css : {
                    'background' : 'rgba(0,0,0,0.85)'
                }
            }

        }





    });
    
    





//
//    $(window).resize(function(){
//
//        if(($.browser.webkit)){
//
//            alert("Hii");
//            $('#magazine').booklet({
//                width:'88%',
//                height:'100%',
//                easing:'easeInCubic',
//
//                shadows: true,
//                hoverWidth: 100,
//                hash: true,
//                cursor: "pointer",
//                pageNumbers:false,
//                arrows:true
//            });
//
//        }
//
//
//    });


//    if(($.browser.mozilla) || ($.browser.opera)){
//
//        $(window).resize(function() {
//
//
//
//            if(($.browser.opera) || ($.browser.mozilla)){
//
//                $('#magazine').booklet({
//                    width:'88%',
//                    height:'100%',
//                    easing:'easeInCubic',
//
//                    shadows: true,
//                    hoverWidth: 100,
//                    hash: true,
//                    cursor: "pointer",
//                    pageNumbers:false,
//                    arrows:true
//                });
//            /*alert('ggh');
//*/	}
//            else{
//
//                $('#magazine').booklet({
//                    width:'88%',
//                    height:'100%',
//                    easing:'easeInCubic',
//
//                    shadows: true,
//                    hoverWidth: 100,
//                    hash: true,
//                    cursor: "pointer",
//                    pageNumbers:false,
//                    arrows:true
//                });
//
//
//            }
//
//        });
//
//    }



    /*editprofile.jsp script begins*/


    $('#showEditProfileMenu').click(function(){

        
        $('#editProfileMenu').slideToggle(1000);
    });




    $('#showEditAlbumMenu').click(function(){


        $('#editAlbumMenu').slideToggle(1000);
    });

    $('#albumDate').datepicker({

        changeMonth: true,
        changeYear: true,
        showOn: "button",
        buttonImage: "/resources/images/calendar.gif",
        buttonImageOnly: true,
        yearRange: "1980:2012",
        duration: "normal",
        dateFormat: "dd-mm-yy",


    });



    /*Delete Album Script Begins*/

    $('.albumsDiv').draggable({
        revert: "invalid",
        scroll: true,
        grid: [ 100,100 ],
        scrollSensitivity: 100 ,
        scrollspeed:100
    });

    $( "#deleteAlbumsDroppable" ).droppable({
        activeClass: "ui-state-hover",
        hoverClass: "ui-state-active",
        drop: function( event, ui ) {
            alert('dropped');
        }
    });

    /**/



    $('#editAlbumButtonClick').click(function(){

        $('#editAlbumMenu').slideToggle(1000);
        $('#addAlbumsDiv').dialog({

            width:'auto',
            modal:true,
            title:'Create New Album',
            draggable:'false',
            resizable:'false',
            show: {
                effect: "drop",
                duration: 1000
            },
            hide: {
                effect: "drop",
                duration: 1000
            },
            buttons: {
                "Create Album": function() {

                    var albumName;
                    var albumSummary;
                    var albumDate;

                    albumName = $('#albumName').val();
                    albumSummary = $('#albumSummary').val();
                    albumDate = $('#albumDate').val();

                    $.ajax({

                        url:'album/addAlbum',
                        type:'post',
                        
                        data:{
                            albumName:albumName,
                            albumSummary:albumSummary,
                            albumDate:albumDate
                        }

                    }).success(function(msg){
                        userAlbumId = msg;
                        $('#albumImagesUploadId').attr('value', userAlbumId);
                        
                        
                        //$('#imagesalbumId').attr('value', msg);
                        $('#addAlbumsDiv').dialog("close");
                        $('#uploadImagesForm').dialog({
                            width:'450',
                            height:'450',
                            modal:true,
                            title:'Add Images To Album',
                            draggable:'false',
                            resizable:'false',
                            show: {
                                effect: "drop",
                                duration: 1000
                            },
                            hide: {
                                effect: "drop",
                                duration: 1000
                            },
                            buttons:{
                                "Add Images":function(){

                                    alert("Hi");

                                }
                            }


                        });




                    });



                }

            }


        });

    });

    $('#selectUserAlbumsId').change(function(){

        var albumId = $('#selectUserAlbumsId').val();
        $('#albumImagesUploadId').attr('value', albumId);
        $('#uploadImagesForm').dialog({

            width:'450',
            height:'380',
            modal:true,
            title:'Add Images To Album',
            draggable:'false',
            resizable:'false',
            show: {
                effect: "drop",
                duration: 1000
            },
            hide: {
                effect: "drop",
                duration: 1000
            }
        });
    });



    /*******************Upload Album Image Script Begins *********************/




    //        var input = document.getElementById("images"),
    //		formdata = false;
    //
    //
    //
    //	if (window.FormData) {
    //
    //	}
    //
    // 	input.addEventListener("change", function (evt) {
    //                formdata = new FormData();
    //                 $('#addImagesDiv').dialog("close");
    //                 $('#dialog').html('<img src="images/142.gif" style="margin-left: auto; margin-right: auto"/></br>Changing Profile Pic Please Wait').dialog({
    //
    //                     modal:true,
    //                    width:'auto',
    //                    title:'Please Wait'
    //
    //                 });
    // 		//document.getElementById("response").innerHTML = "Uploading . . ."
    // 		var i = 0, len = this.files.length, img, reader, file;
    //
    //		for ( ; i < len; i++ ) {
    //			file = this.files[i];
    //
    //			if (!!file.type.match(/image.*/)) {
    //				if ( window.FileReader ) {
    //					reader = new FileReader();
    //					reader.onloadend = function (e) {
    //						//showUploadedItem(e.target.result, file.fileName);
    //					};
    //					reader.readAsDataURL(file);
    //				}
    //				if (formdata) {
    //					formdata.append("images", file);
    //				}
    //			}
    //		}
    //
    //		if (formdata) {
    //			$.ajax({
    //				url: "Upload",
    //				type: "POST",
    //				data: formdata,
    //				processData: false,
    //				contentType:false,
    //				success: function (res) {
    //					//document.getElementById("response").innerHTML = res;
    //                                        //alert(res);
    ////                                        var id=$('#userId').val();
    ////                                        $.ajax({
    ////
    ////                                            url:'users/'+id+'/profilepic/'+res+'.jpg',
    ////                                            type:'post',
    ////                                            success:function(){
    ////
    ////                                                $('#profilePic').attr('src','users/'+id+'/profilepic/'+res+'.jpg');
    ////                                        $('#dialog').dialog("close");
    ////
    ////                                            }
    ////
    ////                                        });
    ////
    ////                                        $('#profilePic').attr('src','users/'+id+'/profilepic/'+res+'.jpg');
    ////                                        $('#dialog').dialog("close");
    //                                        alert("Success"+res);
    //				},
    //                                error:function(){
    //
    //                                    //document.getElementById("response").innerHTML = "Error";
    //                                }
    //			});
    //		}
    //	}, false);


    /*****************Upload Album Image Script Ends ***********************/

    /*Send Message Scrpit Begins*/

    $('#messageStreamButton').click(function(){
        $('#InsidefriendsConversationMessages').html("");
        var userId = $('#userId').val();
        $('#dialog').html("Loading Messages Plesae Wait .....").dialog({

            modal:true,
            width:'auto',
            title:'Please Wait ...',
            show: {
                effect: "fade",
                duration: 500
            },
            hide: {
                effect: "fade",
                duration: 500
            },
            buttons:{

        }

        });

       
        $.ajax({

            url:'message/getTop10Messages',
            type:'post',
            data:{userId:userId}


        }).success(function(data){
            $('#dialog').dialog("close");
            $('#InsidefriendsConversationMessages').html(data)
            $('#friendsConversationMessages').slideToggle(1000);
        });


    });
    
    $('.closeFriendsMessages').click(function(){
        
        $('#friendsConversationMessages').slideToggle(1000);
    });

    $('.viewMessageConversation').live('click',function(){
         $('#InsidefriendsConversationMessagesThread').html("");

        $('#dialog').html("Loading Messages Plesae Wait .....").dialog({

            modal:true,
            width:'auto',
            title:'Please Wait ...',
            show: {
                effect: "fade",
                duration: 500
            },
            hide: {
                effect: "fade",
                duration: 500
            },
            buttons:{

        }

        });

        receiverId = $(this).attr('senderId');
        var senderId = $(this).attr('senderId');
        
        currentFriendMessageId = $(this).attr('senderId');
        currentRealTimeSenderId = senderId;
        friendMessagesClickTimes = 0;
        $.ajax({

            url:'message/getMessages',
            type:'post',
            data:{senderId:senderId,clickTimes:0}

        }).success(function(data){

        $('#dialog').dialog('close');
       $('#InsidefriendsConversationMessagesThread').append(data);
       $('#friendsConversationMessagesThread').slideToggle(1000);
      
       
       $('#InsidefriendsConversationMessagesThread').find($('.messageBox')).each(function(){
           
           currentRealTimeMessageId = $(this).attr("messageId");
           
           
       });
        startRealTimeChat = setInterval(getRealTimeMessageId,5000,currentRealTimeSenderId,currentRealTimeMessageId);
       
        });


    });
    
    $('.closeFriendsConversationMessagesThread').click(function(){
       $('#friendsConversationMessagesThread').slideToggle(1000);
        clearInterval(startRealTimeChat);
        
    });

    $('.loadMoreFriendsMessages').live('click',function(){

        friendMessagesClickTimes++;


        $.ajax({

            url:'message/getMessages',
            type:'post',
            data:{senderId:currentFriendMessageId,clickTimes:friendMessagesClickTimes}

        }).success(function(data){


       $('#InsidefriendsConversationMessagesThread').prepend(data);


        });

    });


    $('.replyToMessageTextarea').live('keyup',function(e){

        if(e.keyCode == 13){
            $('.replyToMessageTextarea').attr('disabled','disabled');
            var senderId = $('#userId').val();

        var message = $(this).val();
                    $.ajax({

                        url:'sendMessage',
                        type:'post',
                        data:{
                            message:message,
                            senderId:senderId,
                            receiverId:receiverId
                        }

                    }).success(function(msg){
                        $('.replyToMessageTextarea').removeAttr('disabled');
                        $('.replyToMessageTextarea').val();
                        $('#InsidefriendsConversationMessagesThread').append('<div style="width:100%;display: block;float:left;margin-top: 1%; padding-bottom: 1%" ><div style="float:right;width:60px; height: 60px;margin-right: 3%;"> <img style="width:inherit;height:inherit" src="users/'+senderId+'/profilepic/thumbs/'+$('#currentProfilePic').val()+'.jpg"/> </div> <div class="bubbleright"><p style="position:relative;left:6%">'+$('#currentUserName').val()+'&nbsp;said:'+message+'</p></div></div>');

                    }).error(function(msg){

                        alert('error'+msg);
                    });




        }



    });



    $('.sendEmail').click(function(){

        var senderId = $('#userId').val();
        var receiverId = $(this).attr("receiverId");
        var receiverName = $(this).attr('receiverName');
        $('#sendMessageDiv').dialog({

            modal:true,
            title:'Send Message To '+receiverName,
            width:'auto',
            show: {
                effect: "drop",
                duration: 1000
            },
            hide: {
                effect: "drop",
                duration: 1000
            },
            buttons:{
                "Send Message":function(){

                    var message = $('#messageText').val();
                    $.ajax({

                        url:'message/addMessage',
                        type:'post',
                        data:{
                            message:message,
                            senderId:senderId,
                            userReceiverId:receiverId
                        }

                    }).success(function(msg){

                        $('#sendMessageDiv').dialog("close");
                        showHomeNotification("Message Sent Successfully Thanks !")
                        

                    }).error(function(msg){

                        alert('error'+msg);
                    });

                }
            }

        });

    });


    /*Send Message Scrpit Ends*/

    /**/

    $('.acceptRequestPreview').click(function(){

        var friendId = $(this).attr('friendId');
        var userId = $('#userId').val();

        //alert(friendId+userId);

        $.ajax({

            url:'PreviewAnswers',
            type:'post',
            data:{
                userId:userId,
                friendId:friendId
            }

        }).success(function(data){


            $('#previewRequestSlidesDiv').html(data).slideDown(1000);

        });

    });



    $('#cancelRequest').live('click',function(){

        var friendId = $(this).attr('friendId');
        var userId = $('#userId').val();

        //alert(friendId+userId);

        $.ajax({

            url:'CancelRequest',
            type:'post',
            data:{
                userId:userId,
                friendId:friendId
            }

        }).success(function(data){


            $('#previewRequestSlidesDiv').slideUp(2000);

        });

    });


    /**/
    $('#showEditVideoMenu').click(function(){


        $('#editVideoMenu').slideToggle(1000);
    });

    $('#editVideoButtonClick').click(function(){

        $('#editVideoMenu').slideToggle(1000);
        $('#addVideosDiv').dialog({

            width:'auto',
            modal:true,
            show: {
                effect: "drop",
                duration: 1000
            },
            hide: {
                effect: "drop",
                duration: 1000
            },
            title:'Add New Video',
            draggable:'false',
            resizable:'false',
            buttons:{
                "Add Video":function(){

                    var videoUrl = $('#videoUrl').val();
                    var videoDescription = $('#videoDescription').val();
                    $.ajax({

                        url:'Videos/addVideo',
                        type:'post',
                        data:{
                            videoUrl:videoUrl,
                            videoDescription:videoDescription
                        }

                    }).success(function(msg){


                        var userId = $('#userId').val();


                        $.ajax({

                            url:'Videos/LoadMoreUserVideos/'+userId+"/"+0,
                            type:'post',
                            data:{
                                userId:userId,
                                clickTimes:'0'
                            }

                        }).success(function(data){


                            $('#userVideos').html(data);


                        });



                        $('#addVideosDiv').dialog('close');
                        $('#dialog').html('Your Video has been added to the playlist Thanx :)').dialog({

                            width:'40%',
                            modal:true,
                            title:'Video Added',
                            draggable:'false',
                            resizable:'false',
                            show: {
                                effect: "fade",
                                duration: 500
                            },
                            hide: {
                                effect: "fade",
                                duration: 1000
                            },
                            buttons:{
                                "Ok":function(){

                                    $('#dialog').dialog('close');


                                }
                            }

                        });
                    });
                }
            }

        });

    });


    $('.changeVideo').live('click',function(){

        $('.videoPlayer').attr('src',$(this).attr('videoUrl'));
    });







    $('#changeProfilePicButton').click(function(){

        $('#editProfileMenu').slideUp('2000');
        $('#changeProfilePicDiv').dialog({

            modal:true,
            width:400,
            title:'Change Profile Image',
            show: {
                effect: "drop",
                duration: 1000
            },
            hide: {
                effect: "drop",
                duration: 1000
            }

        });

    });

    $('#editProfileButtonClick').click(function(){




        $('#editProfileMenu').slideUp('2000');
        $('#editProfileSlideDiv').slideDown(2000);
        $.ajax({

            url:'UserInfo/editUser',
            type:'post'
        }).success(function(data){

            $('#editProfileSlideDiv').html(data);
            $('#editbirthday').datepicker({

                changeMonth: true,
                changeYear: true,
                showOn: "button",
                buttonImage: "images/calendar.gif",
                buttonImageOnly: true,
                yearRange: "1980:2012",

                duration: "normal",
                dateFormat: "dd-mm-yy",

            });


        });

    });

    $('.viewProfileLink').click(function(){


        var friendId = $(this).attr('friendId');
        $.ajax({

            url:'ViewProfile',
            type:'post',
            data:{
                friendId:friendId
            }

        }).success(function(data){

            $('#viewProfileSlidesDiv').html(data).slideDown(2000);
        });

    });

    $('#editProfileButton').live('click',function(){


        var tagline = $('#edittagline').val();
        var introduction = $('#editintroduction').val();
        var braggingRights = $('#editbraggingRights').val();
        var placesLived = $('#editplacesLived').val();
        var lookingFor = $('#editlookingFor').val();
        var email = $('#editemail').val();

        var gender = $('#editgender').val();
        var birthday = $('#editbirthday').val();
        var school = $('#editschool').val();
        var college = $('#editcollege').val();
        var relationshipStatus = $('#editrelationshipStatus').val();
        var occupation = $('#editoccupation').val();
        var website = $('#editwebsite').val();


        $('#dialog').html("Updating Profile Please Wait .....").dialog({

            modal:true,
            title:'Please Wait ...',
            show: {
                effect: "fade",
                duration: 500
            },
            hide: {
                effect: "fade",
                duration: 1000
            },
            buttons:{

        }

        });


        $.ajax({

            url:'UserInfo/updateUser',
            type:'post',
            data:{
                tagline:tagline,
                introduction:introduction,
                braggingRights:braggingRights,
                placesLived:placesLived,
                lookingFor:lookingFor,
                email:email,
                gender:gender,
                birthday:birthday,
                school:school,
                college:college,
                relationshipStatus:relationshipStatus,
                occupation:occupation,
                website:website
            }


        }).success(function(data){

            $('.profileIntroTagline').html(tagline);
            $('.profileIntroIntroduction').html(introduction);
            $('.profileIntroBraggingRights').html(braggingRights);
            $('.profileIntroPlacesLived').html(placesLived);
            $('.profileIntroLookingFor').html(lookingFor);
            $('.profileIntroEmail').html(email);
            $('.profileIntroGender').html(gender);
            $('.profileIntroBirthday').html(birthday);
            $('.profileIntroSchool').html(school);
            $('.profileIntroCollege').html(college);
            $('.profileIntroRelationshipStatus').html(relationshipStatus);
            $('.profileIntroOccupation').html(occupation);

            $('.profileIntroWebsite').html(website);
            $('#dialog').html('Your Profile Has Updated !! ').dialog({

                modal:true,
                show: {
                    effect: "fade",
                    duration: 500
                },
                hide: {
                    effect: "fade",
                    duration: 1000
                },
                buttons: [
                {
                    text: "Ok",
                    click: function() {
                        $(this).dialog("close");
                        $('#editProfileSlideDiv').html("").slideUp(1000);


                    }
                }
                ],
                draggable:false	,
                resizable:false ,
                title:"Profile Updated"




            });


        }).error(function(){

            alert("Error");
        });






    });


    /*Search Friend Script Begins*/


    $('.search').focus(function(){

        //$('#selectSearchOption').slideDown(500);
        var friendName = $('.search').val();

        if(friendName.length > 3){

            $('#searchFriends').css('display','block');

        }

    });

    $('.search').blur(function(){

        //$('#selectSearchOption').slideUp(1000);
        //$('#searchFriends').css('display','none');
        });


    $('.search').keyup(function(){

        var friendName = $('.search').val();

        if(friendName.length > 3){


            $.ajax({

                url:'Friends/searchFriendsByName/'+friendName,
                type:'post',
                

            }).success(function(data){

                $('#searchFriends').html(data).css('display','block');

            });



        }
        else{

            $('#searchFriends').css('display','none');

        }


    });

    /*Search Friend Script Ends*/

    /*editprofile.jsp script ends*/

    /**/

    $('.addToSlambookButton').live('click',function(){

        $('#dialog').html('<div style="width:100%;text-align:center"><img src="resources/images/143.gif" style="margin-left: auto; margin-right: auto"/></div>Please Wait...').dialog({


            width:'auto',
            show: {
                effect: "fade",
                duration: 500
            },
            hide: {
                effect: "fade",
                duration: 1000
            },
            buttons:{

        }


        });
        $('#searchFriends').hide(100);
        receiverId = $(this).attr('userId');

        $.ajax({

            url:'Friends/addFriend',
            type:'get'
        }).success(function(data){

            $('#addToSlambookSlidesDiv').html(data).slideDown(2000);
            $('#dialog').dialog('close');
        });



    });


    $('#addToSlambookButtonConfirm').live('click',function(){

        $('#dialog').html('<img src="images/143.gif" style="margin-left: auto; margin-right: auto"/></br>Adding To Slambook Please Wait ..').dialog({


            modal:true,
            width:"auto",
            title:'Please Wait',
            show: {
                effect: "fade",
                duration: 500
            },
            hide: {
                effect: "fade",
                duration: 1000
            },
            buttons:{

        }



        });

        var senderId = $('#userId').val();
        var ans1 = $('#ans1').val();
        var ans2 = $('#ans2').val();
        var ans3 = $('#ans3').val();
        var ans4 = $('#ans4').val();
        var ans5 = $('#ans5').val();
        var ans6 = $('#ans6').val();
        var ans7 = $('#ans7').val();
        var ans8 = $('#ans8').val();
        var ans9 = $('#ans9').val();
        var ans10 = $('#ans10').val();
        var ans11 = $('#ans11').val();
        var ans12 = $('#ans12').val();
        var ans13 = $('#ans13').val();
        $.ajax({

            url:'SlamBookAnswers/addAnswers',
            type:'post',
            data:{
                senderId:senderId,
                receiverId:receiverId,
                ans1:ans1,
                ans2:ans2,
                ans3:ans3,
                ans4:ans4,
                ans5:ans5,
                ans6:ans6,
                ans7:ans7,
                ans8:ans8,
                ans9:ans9,
                ans10:ans10,
                ans11:ans11,
                ans12:ans12,
                ans13:ans13
            }

        }).success(function(data){


            $('#dialog').dialog('close');
            $('#dialog').html('A request has been sent to your friend for approval Thanx').dialog({

                modal:true,
                width:'400',
                title:'Thanx !!',
                show: {
                    effect: "fade",
                    duration: 500
                },
                hide: {
                    effect: "fade",
                    duration: 1000
                },
                buttons: [
                {
                    text: "Ok",
                    click: function() {
                        $('#dialog').dialog("close");
                        $('#addToSlambookSlidesDiv').html("").slideUp(1000);


                    }
                }
                ]

            });
        });

    });

    /**/

    $('.friendsAlbumsButton').click(function(){
        $('.closefriendsAlbums').hide(100);
        currentfriendId = $(this).attr("friendId");
        friendId = $(this).attr("friendId");
        var clickTimes = 1;

        $.ajax({

            url:'album/getUserFriendsAlbums/'+friendId+"/"+clickTimes,
            type:'get',
            

        }).success(function(data){

            $('#dialog').dialog('close');
            $('#images_div').html('<div style="position:absolute; bottom:0px; width: 100%; text-align: center"><button style="padding:1%" class="closeImagesDiv">Close</button></div>');
            $('#images_div').prepend(data).slideDown(1000);

        });

    });

    $('.closefriendsAlbums').live('click',function(){
        $('.closefriendsAlbums').hide(100);
        $('#friendsAlbums').slideUp(1000);

    });

    $('.getFriendsAlbum').live("click",function(){


        if($(this).attr("friendId") != null){

            friendId = $(this).attr("friendId");

        }
        var albumId = $(this).attr("albumId");
        $.ajax({

            url:"Images/getFriendsImages/"+albumId+"/"+friendId,
            type:"post",
            data:{
                
            }

        }).success(function(data){

            $('#dialog').dialog('close');
            $('#images_div_friendsalbumImages').html('<div style="position:absolute; bottom:0px; width: 100%; text-align: center"><button style="padding:1%" class="closefriendsalbumImagesDiv">Close</button></div>');
            $('#images_div_friendsalbumImages').prepend(data).slideDown(1000);

        });


    });

    $('.closefriendsAlbumsImages').live('click',function(){

        $('#friendsAlbumImages').slideUp(1000);

    });
    $('.closefriendsVideos').live('click',function(){

        $('#friendsVideos').slideUp(1000);

    });


    $('.friendsVideosButton').click(function(){

        var friendVideoId = $(this).attr('friendId');
        currentfriendId = $(this).attr('friendId');
        userFriendClickTimes = 0;

        $.ajax({

            url:"Videos/getFriendsVideos/"+friendVideoId+"/"+1,
            type:"post",
            data:{
               
            }

        }).success(function(data){

             $('#images_div').html('<div style="position:absolute; bottom:0px; width: 100%; text-align: center"><button style="padding:1%" class="closeImagesDiv">Close</button></div>');
            $('#images_div').prepend(data).slideDown(1000);

        });

    });
    $('.changeFriendVideo').live("click",function(){

        $('.friendvideoPlayer').attr('src',$(this).attr('videoUrl'));

    });


    /**/
    /*******************Upload Change PRofile Script Begins *********************/




    var input = document.getElementById("imagefile"),
    formdata = false;



    if (window.FormData) {

    }

    input.addEventListener("change", function (evt) {
        formdata = new FormData();
        $('#changeProfilePicDiv').dialog("close");
        $('#dialog').html('<img src="images/143.gif" style="margin-left: auto; margin-right: auto"/></br>Changing Profile Pic Please Wait').dialog({

            modal:true,
            width:'auto',
            title:'Please Wait',
            show: {
                effect: "fade",
                duration: 500
            },
            hide: {
                effect: "fade",
                duration: 1000
            },
            buttons:{

        }



        });
        //document.getElementById("response").innerHTML = "Uploading . . ."
        var i = 0, len = this.files.length, img, reader, file;

        for ( ; i < len; i++ ) {
            file = this.files[i];

            if (!!file.type.match(/image.*/)) {
                if ( window.FileReader ) {
                    reader = new FileReader();
                    reader.onloadend = function (e) {
                    //showUploadedItem(e.target.result, file.fileName);
                    };
                    reader.readAsDataURL(file);
                }
                if (formdata) {
                    formdata.append("imagefile", file);
                }
            }
        }

        if (formdata) {
            $.ajax({
                url: "profilepic/changeprofilepic",
                type: "POST",
                data: formdata,
                processData: false,
                contentType: false,
                success: function (res) {
                    //document.getElementById("response").innerHTML = res;
                    //alert(res);
                    var id=$('#userId').val();
                    $.ajax({

                        url:'resources/users/'+id+'/profilepic/thumbs/'+res+'.jpg',
                        type:'get',
                        success:function(){

                            $('#profilePic').attr('src','resources/users/'+id+'/profilepic/thumbs/'+res+'.jpg');
                            $('#dialog').dialog("close");

                        }

                    });
                //                                        $('#profilePic').attr('src','users/'+id+'/profilepic/'+res+'.jpg');
                //                                        $('#dialog').dialog("close");
                },
                error:function(){

                //document.getElementById("response").innerHTML = "Error";
                }
            });
        }
    }, false);


    /*****************Upload Change PRofile Script Ends ***********************/

    /**/


    /**/
    /*Video Likes*/

    $('.addVideoLikes').live('click',function(){

        var userId = $('#userId').val();
        var videoId = $(this).attr('videoId');
        $(this).next().addClass('current');
        $(this).addClass('removeVideoLikes');
        $(this).removeClass('addVideoLikes');
        $(this).html('UnLike');
        $.ajax({

            url:'VideoLikes/addVideoLike',
            type:'post',
            data:{
                videoId:videoId,
                userId:userId
            }

        }).success(function(data){

            var likeNumber = data.toString();
            $('.current').html(likeNumber+" Likes");
            $('.current').removeClass('current');
            showHomeNotification("Liked SuceesFully");

        }).error(function(data){

            alert("error"+userId+videoId);

        });

    });

    $('.removeVideoLikes').live('click',function(){

        var userId = $('#userId').val();
        var videoId = $(this).attr('videoId');
        $(this).next().addClass('current');
        $(this).removeClass('removeVideoLikes');
        $(this).addClass('addVideoLikes');
        $(this).html('Like');
        $.ajax({

            url:'VideoLikes/removeVideoLike',
            type:'post',
            data:{
                videoId:videoId,
                userId:userId
            }

        }).success(function(data){

            $('.current').html(data+" Likes");
            $('.current').removeClass('current');
            showHomeNotification("Unliked SuceesFully");

        }).error(function(data){

            alert("error"+userId+videoId);

        });


    });

    /*Video Likes*/
    /*Image Likes*/
    
    $('.addImageLikesInfo').live('click',function(){
        
        var imageId = $(this).attr("imageId");
        
        
    });

    $('.addImageLikes').live('click',function(){

        var userId = $('#userId').val();
        var imageId = $(this).attr('imageId');
        var albumId = $(this).attr('albumId');
        $(this).next().addClass('current');
        $(this).addClass('removeImageLikes');
        $(this).removeClass('addImageLikes');
        $(this).html('UnLike');
        $.ajax({

            url:'ImageLikes/addLike',
            type:'post',
            data:{
                imageId:imageId,
                albumId:albumId,
                userId:userId
            }

        }).success(function(data){

            var likeNumber = data.toString();
            $('.current').html(likeNumber+" Likes");
            $('.current').removeClass('current');
            showHomeNotification("Liked SuceesFully");

        }).error(function(data){

            alert("error"+userId+imageId);

        });

    });

    $('.removeImageLikes').live('click',function(){

        var userId = $('#userId').val();
        var imageId = $(this).attr('imageId');
        var albumId = $(this).attr('albumId');
        $(this).next().addClass('current');
        $(this).removeClass('removeImageLikes');
        $(this).addClass('addImageLikes');
        $(this).html('Like');
        $.ajax({

            url:'ImageLikes/removeLike',
            type:'post',
            data:{
                imageId:imageId,
                albumId:albumId,
                userId:userId
            }

        }).success(function(data){

            $('.current').html(data+" Likes");
            $('.current').removeClass('current');
            showHomeNotification("Unliked SuceesFully");

        }).error(function(data){

            alert("error"+userId+imageId);

        });


    });

/* Image Likes*/



/*User Design Settings*/

$('#userSettingsButton').click(function(){
    
   
    
    $('#settingsDiv').append('<div style="position:absolute; bottom:0px; width: 100%; text-align: center"><button style="padding:1%" class="closeSettingsDiv">Close</button></div>');
    $('#settingsDiv').slideDown(1000);
   
    
});

$('.closeSettingsDiv').live('click',function(){
    
    $('#settingsDiv').slideUp(1000);
    
});

 $('#userDesignAccordion').accordion();
 $('#insideUserDesignAccordion').accordion();
 
 
 /* Slambook Pages Background Texture*/
 
 $('.slambookPagesBackgroundTexture').hover(function(){
     
     var textureId = $(this).attr("textureId");
     $('div .b-wrap-right').toggleClass("slambookPagesBackgroundTexture"+textureId);
     $('div .b-wrap-left').toggleClass("slambookPagesBackgroundTexture"+textureId)
     
     
 });
 
 /* Slambook Pages Background Texture*/

 /* Slambook Background Texture*/
 
 
 $('.slambookBackgroundTexture').hover(function(){
     
     var textureId = $(this).attr("textureId");
     $('body').toggleClass('backgroundTextture'+textureId);
     
 });
 
 /* Slambook  Background Texture*/



/*User Design Settings*/


/*News Feed*/

$('#newsStreamButton').click(function(){
var userId = $('#userId').val();
$('.innerfriendsNotificationsDiv').html("");
$('.yourNotificationsDiv').html("");
$('#dialog').html("Loading Notifications Plesae Wait .....").dialog({

            modal:true,
            title:'Please Wait ...',
            show: {
                effect: "fade",
                duration: 500
            },
            hide: {
                effect: "fade",
                duration: 1000
            },
            buttons:{

        }

        });



$.ajax({

    url:'GetFriendsNotifications',
    type:'post',
    data:{userId:userId}

}).success(function(data){


    $('.innerfriendsNotificationsDiv').append(data);


});
$.ajax({

    url:'GetUserNotifications',
    type:'post',
    data:{userId:userId}

}).success(function(data){

    $('#notificationsSlidesDiv').slideDown(1000);
    $('#dialog').dialog("close");
    $('.yourNotificationsDiv').prepend(data);


});

});

$('.closeNotificationsSlidesDiv').click(function(){

    $('#notificationsSlidesDiv').slideUp(1000);

});

$('#closeNewsStream').click(function(){
 $('#newsStream').animate({

    width: "toggle"

},1000);

});

/**/
});

function showNotification(msg){

    $('#message').html(msg);
    $('#notifications').slideDown(1000).delay(3000).slideUp(1000);

}
function showHomeNotification(msg){

    $('#Homemessage').html(msg);

    $('#Homenotifications').slideDown(1000).delay(3000).slideUp(1000);

}

function validateEmail(sEmail) {

    var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;

    if (filter.test(sEmail)) {

        return true;

    }

    else {

        return false;

    }

}

function youtube_parser(url){
    var regExp = /^.*((youtu.be\/)|(v\/)|(\/u\/\w\/)|(embed\/)|(watch\?))\??v?=?([^#\&\?]*).*/;
    var match = url.match(regExp);
    if (match&&match[7].length==11){
        return match[7];
    }else{
        return"failed";
    }
}

function getEmail(){

    var prmstr = window.location.search.substr(1);
    var prmarr = prmstr.split ("&");


    for ( var i = 0; i < prmarr.length; i++) {
        var tmparr = prmarr[i].split("=");
        params[tmparr[0]] = tmparr[1];
    }
    return params.email;
}

function getRealTimeMessageId(senderId,messageId){
   

    
$.ajax({
    
     url:'message/getRealTimeMessageId',
            type:'post',
            data:{
                senderId:senderId,
                messageId:messageId
            }
    
    
}).success(function(data){
    
    console.log("current ="+currentRealTimeMessageId+" Data = "+data);
    if(data > currentRealTimeMessageId){
       
            retrieveMessage(currentRealTimeSenderId,currentRealTimeMessageId);
            currentRealTimeMessageId = data;
        
    }
    else{
        
        
        
    }
});    
    
}

function retrieveMessage(senderId,messageId){

$.ajax({

            url:'message/getRealTimeMessages',
            type:'post',
            data:{senderId:senderId,messageId:messageId}

        }).success(function(data){

       
       $('#InsidefriendsConversationMessagesThread').append(data);
       

        });




}