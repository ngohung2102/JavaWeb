<%-- 
    Document   : ListSubject
    Created on : Mar 7, 2023, 4:52:01 PM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Register Subject </title>
    </head>
    <body>
        <style>
            table{
                width: 500px;
                border: 1px solid black;
            }
            
           
        </style>
        <button><a href="Menu.jsp">QuayLai </a></button>
        <h2 style="color: red" id="demo"></h2>
        <form action="teacher" id="myForm">
            <br/>
            Search <input type="text" name="search" value="${SubjectID}"/>
            <input type="submit" name="tim" value="Tim" />
                <table rules="rows">
                    <tr>
                        <td>SubjectID</td>
                    </tr>
                    <c:forEach items="${listBS}" var="item">
                        <tr>
                            <td><input type="checkbox" name="${item.getSubjectID()}" value="${item.getSubjectID()}"> ${item.getSubjectID()}</td>
                        </tr>
                    </c:forEach>
                </table>
            
            <input type="submit" name="save" value="Save"/>
            <p style="color: red">${requestScope.err} </p>
            <p style="color: red">${requestScope.result} </p>
        </form>
        
                <script>
            // Set the date we're counting down to
//            var countDownDate = new Date().getTime() + (3 * 2 * 60 * 60 * 1000);
            var countDownDate = new Date("Mar 17, 2023 22:15:30").getTime();
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
                document.getElementById("myForm").style.display = "none";
                document.getElementById("demo").innerHTML = "Da qua thoi han dang ky mon hoc";
//                window.location.href = "ListSubject.jsp";
                
            }
        }, 1000);
        </script>
    </body>
</html>
