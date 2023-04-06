<%-- 
    Document   : home
    Created on : Mar 7, 2023, 4:31:33 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <style>

            .headerLeft{
                width: 50%;
                height: 300px;
                font-size: 30px;
                font-weight: 500;
                margin: 30px 0px 30px 100px;
            }

            .headerRight{
                /*display: inline-block;*/

                width: 30%;
                height: 200px;
                margin-bottom: 100px;
            }
            img{
                display: inline;
            }

            .x{
                width: 120px;
                height: 40px;
            }
            .y{
                width: 120px;
                height: 40px;
            }
/*            body{
                background-image: url("images/fpthanoi01-130.jpg");
                background-size: cover;
            }*/

        </style>

        <div  style="display: flex">
            <div class="headerLeft">
                <p>FPT University Academic Portal<p>

            </div>


            <div class="headerRight">
                <p>FAP mobile app (myFAP) is ready at</p>
                <img class="x" src='images/Apple.png'>
                <img class="y" src='images/Capture.PNG'>
                <%@include file="Login.jsp" %>

            </div>
        </div>

        
        <div>
            <p align='center'>© Powered by Ngo Van Hung</p>
        </div>
    </body>
</html>
