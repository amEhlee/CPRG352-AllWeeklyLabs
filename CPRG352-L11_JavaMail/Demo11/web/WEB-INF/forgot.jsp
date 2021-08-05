<%-- 
    Document   : forgot
    Created on : Aug 5, 2021, 2:01:59 PM
    Author     : 856885
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password Page</title>
    </head>
    <body>
        <h1>Forgotten Password</h1>
        <form method="post" action="forgot">
            <label for="email">Email</label><br>
            <input type="text" id="email" name="email"><br>
            <button type="submit" value = "Submit">Submit</button>
        </form>
        <a href ="login">Return To Login Page</a>
        <p>${info}</p>
    </body>
</html>
