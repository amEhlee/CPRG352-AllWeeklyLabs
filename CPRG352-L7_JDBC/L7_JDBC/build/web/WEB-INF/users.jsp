<%-- 
    Document   : users.jsp
    Created on : Jul 9, 2021, 9:17:53 PM
    Author     : 856885
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="./Assets/main.css" rel="stylesheet" type="text/css"/>
    
    <title>User Manager</title>
</head>
<body>
    <main>
        <addUsers>
            <h2>Add User</h2>
            <form method="post" action="addUser">
                <input type="email" name="email" id="email" placeholder="Email Address" required autofocus>
                <br>
                <input type="text" name="firstname" id="firstname" placeholder="First Name" title="Please enter a first name" required>
                <br>
                <input type="text" name="lastname" id="lastname" placeholder="Last Name" title="Please enter a last name" required>
                <br>
                <input type="password" name="password" id="password">
                <br>
    
                <button type="submit" value="Submit">Add User</button>
            </form>
        </addUsers>
        <showUsers>
            <table>
                <tr>
                    <th>Email</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Role</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <c:forEach items = "${users}" var = "user">
                    <tr>
                        <th>${user.getEmail()}</th>
                        <th>${user.getFirstName()}</th>
                        <th>${user.getLastName()}</th>
                        <th>${user.getRole()}</th>
                        <th><a href="action?edit">Edit Link</a></th>
                        <th><a href="action?delete">Delete Link</a></th>
                    </tr>
                </c:forEach>
            </table>
        </showUsers>
    </main>

</body>
</html>