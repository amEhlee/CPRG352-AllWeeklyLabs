<%-- 
    Document   : register
    Created on : Jun 25, 2021, 10:46:18 PM
    Author     : 856885
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./Assets/Styles/CSS.css" rel="stylesheet" type="text/css"/>
        <title>REGISTER Page</title>
    </head>
    <body>
        <h1>REGISTER World!</h1>
        <form action="shoplist" method="post">
            <label for="username">Username</label><br>
            <input type="text" id="username" name="username" required><br>
            <input type="submit" value="Register"><br>
            <input type="hidden" name="action" value="register"><br>

            <p>${errMsg}</p>
        </form>
    </body>
</html>
