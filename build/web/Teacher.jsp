<%-- 
    Document   : Teacher
    Created on : Mar 13, 2023, 3:50:40 PM
    Author     : Administrator
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ListTeacher</title>
    </head>
    <body>
        <form action="registed" method="post">
            <button><a href="Menu.jsp">QuayLai </a></button>
                <table rules="rows">
                    <tr>
                        <td>TeacherID</td>
                    </tr>
                    <c:forEach items="${listTeach}" var="item">
                        <tr>
                            <td> <input type="checkbox" name="${item.getTeacherID()}" value="${item.getTeacherID()}"> ${item.getTeacherID()} </td>
                        </tr>
                    </c:forEach>
                </table>
            <input type="text" name="subjectId" value="${subjectId}" readonly="">
            <input type="text" name="acc" value="${acc}" readonly="">
            <input type="submit" name="luu" value="Save"/>
            <p style="color: red">${requestScope.err} </p>
        </form>
    </body>
</html>
