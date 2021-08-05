<%-- 
    Document   : shoplist
    Created on : Jun 25, 2021, 10:46:29 PM
    Author     : 856885
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./Assets/Styles/CSS.css" rel="stylesheet" type="text/css"/>
        <title>SHOP Page</title>
    </head>
    <body>
        <header>
            <h1>SHOPPING LIST</h1>
            <p> hello ${username}.</p>
            <a href="?action=logout">Logout</a>
        </header>

        <main>
            <form action="" method="post">
                <label for="addItem">Add Item:</label>
                <input type="text" name ="addItem" id = "addItem" required>
                <input type="submit" value="Add">
                <input type="hidden" name="action" value="add">
            </form>
    
            <!-- Conditional that hides delete and item list if items list is empty-->
            <c:if test="${items.size() > 0}">
                <form action="" method="post">
                    <h2>ITEM LIST</h2>
                    <ul>
                        <c:forEach var="i" items="${items}">
                            <li><input type="radio" name = "itemList" value ="${i}">${i}</li><br>
                        </c:forEach>
                    </ul>
        
                    <input type="submit" value="Delete"/>
                    <input type="hidden" name="action" value="delete"/>
                </form>
            </c:if>

        </main>

        <footer>
            
        </footer>

    </body>
</html>
