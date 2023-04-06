<%-- 
    Document   : Menu
    Created on : Mar 7, 2023, 4:49:24 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu FPT</title>
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

            .header p{
                padding: 100px;
            }
            body{
                background-image: url("images/fpthanoi01-130.jpg");
                background-size: cover;
            }
            ul{
                margin: 0 auto;
            }
            ul li{
                padding: 0.9em;
                text-decoration: none;
                list-style-type: none;

            }
            ul li:nth-child(2){
                border-right: 1px solid black;
                border-left: 1px solid black;
            }
            .dk p{
                margin-left: 10em;
            }
            ul li a {
                background-color: #5cb85c;
            }


        </style>
      
        <div style="width: 100%;display: flex">
            <div style="width: 50%"><h1 style="margin-left: 25%;margin-top: 10%">FPT University Academic Portal</h1></div>
            <div style="width: 50%;margin-left: 20%;margin-top: 2%">
                <p>FAP mobile app (myFAP) is ready at</p>
                <img class="x" src='images/Apple.png'>
                <img class="y" src='images/Capture.PNG'>
            </div> 

        </div>

        <div style="display: grid;place-items: center">
            <div style="width: 80%;height: 3em;background-color: #cccccc;border-radius: 10px">
                <ul style="display: flex;justify-content: end">
                    <li><a>Username: ${sessionScope.tk}</a></li>
                    <li><a href="logout">logout</a></li>
                    <li><a>CAMPUS: FPTU-Hòa Lạc</a></li>
                </ul>
            </div>
        </div>
        <div style="width: 100%;display: flex;justify-content: end;">
            <div style="width: 50%;" class="dk">
                <p> <a href="registed?mod=1">Dang ky mon hoc</a></p>
                <p> <a href="view">Mon hoc da dang ky</a></p>
            </div> 
        </div>
    </body>
</html>
