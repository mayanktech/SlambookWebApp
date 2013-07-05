<html>

    <head>

        <title>Error Logging In</title>
        <link href="css/homepagestyle.css" type="text/css" rel="stylesheet" />
        <style>
            
            table tr td{
                
                padding:2%;
            }
            
        </style>
    </head>

    <body>

        <div id="header_nav" style="height:15%">


            <!--Logo Begins -->
            <div class="logo" title="Hii">Slambook</div>
            <!--Logo Ends -->

            <div class="login_form">

                <span style="float:right">
                    </br>

                    <form action="loginAuthentication" method="post" id="loginForm" style="visibility: hidden">

                        <input type="submit" id="loginButto"  value="Login" tabindex="3"style="float:right; padding:4px;margin-top: 5%; color: #FFF; background-color: #69A74E; font-size: 0.8em"/>
                </span>
                <span class="password">
                    Password</br>
                    <input type="password"  required size="25" style="height:1.8em" name="password"  id="pwd" tabindex="2"/></br>
                    Forgot Your Password
                </span>

                <span class="email">Email</br>
                    <input type="email" required   size="25" id="emailId" name ="email"style="height:1.8em" autofocus="autofocus" tabindex="1"></br>
                    <input type="checkbox"/>&nbsp;Keep me Logged In
                </span>
                </form>
            </div>



        </div>

        <div id="errorLoginForm">

            <div style="width:98%; background-color: #69A74E; font-size: 1.5em;text-align: center; padding:1%;color:white;border-radius: 15px">Please Try Again</div>
            <div>


                </br>

                <form action="loginAuthentication" method="post" >

                    <table style="text-align:center;width:100%;font-size:1.5em;color:#000000">

                        <tr><td>Email</td>
                            <td><input type="email" style="font-size:1em" required   size="25" id="emailId" name ="email" autofocus="autofocus" tabindex="1"></br>
                                    
                                </td></tr>

                        <tr><td>Password</td>
                            <td> <input type="password" style="font-size:1em"  required size="25" name="password"  id="pwd" tabindex="2"/></td></tr>
                        <tr><td colspan="2"><input type="submit" id="loginButto"  value="Login" tabindex="3"style="padding:4px;color: #FFF; background-color: #69A74E; font-size: 0.8em"/></td></tr>
                        <tr><td style="color: tomato" colspan="2">Oops ! Credentials You Entered Are Incorrect :(</td></tr>
                    </table>




                    


                </form>
            </div> 
        </div>

    </body>

</html>