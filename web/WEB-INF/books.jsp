<%-- 
    Document   : books
    Created on : Apr 24, 2018, 8:53:46 PM
    Author     : Ryan Sprague
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books</title>
    </head>
    <body>
        <h1>Books</h1>
        <ul>
            <c:forEach var="book" items="${books}">
                <li>
                    <a href="/project7/books/info?id=${book.getID()}">${book.title}</a> | 
                    ${book.rating}/5
                </li>
                
            </c:forEach>
        </ul>
    </body>
</html>
