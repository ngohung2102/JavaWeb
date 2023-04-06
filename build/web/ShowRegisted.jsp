<%-- 
    Document   : ShowRegisted
    Created on : Mar 8, 2023, 9:38:07 PM
    Author     : Administrator
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Registed</title>
    </head>
    <body>
        <style>
            table{
                border: 1px solid black;
            }

        </style>
        <form action="view">
            <button><a href="Menu.jsp">QuayLai </a></button>
            <table rules="rows">
                <tr>
                    <td>TeacherID</td>
                    <td>SubjectID</td>
                </tr>
                <c:forEach items="${list}" var="item">
                    <tr>
                        <td>${item.getTeacherID()} </td>
                        <td>${item.getSubjectID()}</td>
                    </tr>
                </c:forEach>
            </table>
            <a href="edit">Edit</a>
            <p style="color: red">${requestScope.err}</p>
        </form>
    </body>
</html>
