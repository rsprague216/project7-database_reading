<%-- 
    Document   : bookDetails
    Created on : Apr 27, 2018, 1:29:14 AM
    Author     : Ryan Sprague
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Details</title>
    </head>
    <body>
        <h1><c:out value="${book.title}" /></h1>
        <p>
            <c:out value="by ${book.author}" /><br />
            <c:out value="${book.review}" />
        </p>
    </body>
</html>
