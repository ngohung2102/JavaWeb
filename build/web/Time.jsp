<%-- 
    Document   : Time
    Created on : Mar 13, 2023, 11:26:17 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Countdown Timer</title>
    </head>
    <body>
        <p id="demo"></p>
        <script>
            // Set the date we're counting down to
//            var countDownDate = new Date().getTime() + (3 * 2 * 60 * 60 * 1000);
            var countDownDate = new Date("Mar 16, 2023 00:00:00").getTime();
            // Update the count down every 1 second
            var x = setInterval(function() {

            // Get today's date and time
            var now = new Date().getTime();

            // Find the distance between now and the count down date
            var distance = countDownDate - now;

            // Time calculations for hours, minutes and seconds
            var days = Math.floor((distance % (1000 * 60 * 60 * 24 *24 ))/(1000 * 60 * 60 * 24));
            var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
            var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
            var seconds = Math.floor((distance % (1000 * 60)) / 1000);

            // Display the result in an element with id="demo"
            document.getElementById("demo").innerHTML = days + "d"  + hours + "h "
                + minutes + "m " + seconds + "s ";

            // If the count down is finished, write some text 
            if (distance < 0) {
                clearInterval(x);
                document.getElementById("demo").innerHTML = "Da qua thoi han dang ky mon hoc";
            }
        }, 1000);
        </script>
    </body>
</html>
