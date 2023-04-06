<%-- 
    Document   : ListRegisted
    Created on : Mar 7, 2023, 11:23:04 PM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ListRegisted</title>
    </head>
    <body>
        <style>
            table{
                border: 1px solid black;
            }

        </style>
        <h1>Danh sach mon hoc da dang ky</h1>
        <form action="registed">
            <button><a href="Menu.jsp">QuayLai </a></button>
            <c:if test="${requestScope.save == 1}">
                <table rules="rows">
                <tr>
                    <td>TeacherID</td>
                    <td>SubjectID</td>
                </tr>
                <c:forEach items="${listData}" var="item">
                    <tr>
                        <td>${item.getTeacherID()} </td>
                        <td>${item.getSubjectID()}</td>
                    </tr>
                </c:forEach>
            </table>
                
            </c:if>
            <p style="color: red">${requestScope.err}</p>
            
            <c:if test="${requestScope.save==0}">
                <p style="color: red">${requestScope.err}</p>
            </c:if>
            
        </form>
    </body>
</html>
