<%-- 
    Document   : Login
    Created on : Mar 7, 2023, 3:54:52 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
       <style>
            #frm{
                width: 100%;
                height: 200px;
                border: 1px black solid;
                margin-right: 50px;
            }
            #account{
                width: 200px;
                margin-left: 20px;
                margin-top: 50px;
                
            }
            #pass{
                width: 200px;
                margin-left: 13px;
                margin-top: 10px;
            }
            #sub{
                margin-left: 200px; 
            }
            #acc{
                margin-left: 80px;
            }
            #mk{
                 margin-left: 80px;
            }
            
        </style>
        <form id="frm" action="login" method="POST">
            <span id="acc"> Account </span> <input id="account" type="text" name="account" />
            <br/><br/>
            <span id="mk">Password</span> <input id="pass" type="password" name="password" />
            <br/><br/>
            <input id="sub" type="submit" name="submit" value="LOGIN"/>
        </form>
        <p style="color: red"> ${requestScope.err}</p>
    </body>
</html>
