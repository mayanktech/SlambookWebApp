<%-- 
    Document   : index
    Created on : 13 Sep, 2012, 10:55:09 PM
    Author     : Mayank
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Jai Shree Ganesh-->
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Slambook - Home</title>
<link href="css/homepagestyle.css" type="text/css" rel="stylesheet" />

<link type="text/css" href="css/start/jquery-ui-1.8.23.custom.css" rel="stylesheet" />
        <script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.23.custom.min.js"></script>
        
<link href="css/bjqs.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/bjqs-1.3.min.js"></script>
<script src="js/jquery.touchslider.min.js"></script>


<script src="js/script.js" type="text/javascript"></script>


</head>

<body>
    
    
    
<div id="dialog"></div>
<div id="notifications">
    
    <div id="message">Hii</div>

</div>
<!--Header Naigation Begins --> 
<div id="header_nav" style="height:15%">

	
	<!--Logo Begins -->
        <div class="logo" title="Hii">Slambook</div>
    <!--Logo Ends -->
    
    <div class="login_form">
    
    <span style="float:right">
    </br>
    
    <form action="loginAuthentication" method="post" id="loginForm">
    
        <input type="submit" id="loginButto"  value="Login" tabindex="3"style="float:right; padding:4px;margin-top: 5%; color: #FFF; background-color: #69A74E; font-size: 0.8em"/>
    </span>
    <span class="password">
    Password</br>
    <input type="password"  required size="25" style="height:1.8em" name="password"  id="pwd" tabindex="2"/></br>
    Forgot Your Password
    </span>
    
    <span class="email">Email</br>
        <input type="email" required   size="25" id="emailId" name ="email"style="height:1.8em" autofocus="autofocus" tabindex="1"></br>
        <input type="checkbox" name="loggedInAllow"/>&nbsp;Keep me Logged In
    </span>
    </form>
    </div>
    
    
	
</div>

<!--Header Naigation Ends -->


<div id="infoSlider">

<div class="touchslider" style="width:inherit !important;height:inherit !important;">
    <div class="touchslider-viewport" style="width:100%;height:100%;overflow:hidden"><div>
        
        <div class="touchslider-item">
            
            
           
        
        
        </div>
        <div class="touchslider-item">
            
            
           
        
        
        </div>
       
    </div></div>

    
</div>

</div>

<div id="signup">
    <div style="background-color: #3B5998;text-align:center; color: #FFF;width: 103%;border-radius: 10px; position: relative; right: 2.3%;padding-left: 2%;padding-top: 1%;padding-bottom: 1%;">
    <span style="font-size: 1.4em">Sign Up</span></br>
    <span style="font-size: 1em">It's Awesome & Always Will Be :)</span>
    </div>
    <table>

	<tr style="width:30%"><td style="text-align:right">First Name: &nbsp;&nbsp;</td><td><input type="text" id="firstName" class="tooltipshow" title="Enter Your First Name" style="width:80%; font-size:1.2em;"/></td></tr>
	<tr><td style="text-align:right">Last Name:&nbsp;&nbsp;</td><td><input type="text" class="tooltipshow" title="Enter Your Last Name" id="lastName" style="width:80%; font-size:1.3em;"/></td></tr>
        <tr><td style="text-align:right">Your Email:&nbsp;&nbsp;</td><td><input type="email" class="tooltipshow" title="Enter Your Email" id="email"style="width:80%; font-size:1.3em;"></td><td><img id="checkEmail" src="images/282.gif"style="display:none"/></td></tr>
    <tr><td style="text-align:right">Password:&nbsp;&nbsp;</td><td><input type="password" id="password" class="tooltipshow" title="Password(More then 6 letters)" style="width:80%; font-size:1.3em;"></td></tr>
    <tr><td style="text-align:right">Confirm Password: &nbsp;</td><td><input type="password" id="repeatPassword" class="tooltipshow" title="Type Password Again" style="width:80%; font-size:1.3em;"></td><td><img id="checkPassword" src=""style="display:none"/></td></tr>
    <tr><td style="text-align:right">I am: &nbsp;&nbsp;</td><td><select id="gender" class="tooltipshow" title="Select Your Gender" style="font-size:1.3em;padding:5px;"><option>Male</option><option>Female</option></select></td></tr>
    <tr><td style="text-align:right">Birthday: &nbsp;&nbsp;</td><td><input type="text" id="birthday" class="tooltipshow" title="Enter Date Of Birth(DD-MM-YYYY)"style="width:80%;  font-size:1.3em;margin-right: 10px"/></td></tr>
    <tr><td colspan="2" style="text-align:center"><input type="submit" value="Sign up !" id="signUpButton"style="padding:5px;font-size:1.1em;background-color: #69A74E;color: #FFF"/></td></tr>

</table>

</div>
<div class="clear"></div>
<span style="float: left;font-size: 1.3em; margin-top: 2%; margin-left: 1%">Developed By Mayank Sharma</span>
<img src="images/java_logo.png" style="float: right;margin-right: 1%;margin-top: 0.2%"/><span style="float: right;font-size: 1.3em;margin-right: 1%;margin-top: 1.5%">Powered By </span>

<!--Footer Begins  -->
<div id="footer">
	<!--Footer Begins  -->
    <div id="inside_footer">
    
    </div>
	<!--Footer Ends  -->
</div>
<!--Footer Ends  -->
</body>
</html>
