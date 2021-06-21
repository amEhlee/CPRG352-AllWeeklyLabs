<%-- 
    Document   : login
    Created on : Jun 13, 2021, 4:23:09 PM
    Author     : 856885
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300&display=swap" rel="stylesheet">
        <title>Account Login</title>
    </head>
    <body>
        <style>
            html {
                /*Fits gradient to 100% height*/
                min-height: 100%;
                min-width: 100%;
            }
            
            body {
                /*Gradient Specifications*/
                background-image: linear-gradient(to bottom, rgb(185, 153, 185), rgb(181, 228, 94) );
                background-repeat: no-repeat;
                background-size: cover;
                margin: 10% 20%;
                font-family: 'Poppins', sans-serif;
                transition: 0.3s;
            }
            
            h2 {
                text-align: center;
            }
            
            #wrapper {
                font-family: 'Poppins', sans-serif;
                background-color: #FFFFFF8e;
                width: 50%;
                min-width: 400px;
                max-width: 600px;
                padding: 50px 30px;
                margin: 50px auto;    
                transition: 0.3s;
            }
            
            .login-details {
                display: flex;
                flex-direction: column;
                margin-bottom: 20px;
            }
            
            input {
                background : none;
                border: none;
                border-bottom: 1px solid black;
                font-family: 'Poppins', sans-serif;
                font-size: 1.2em;
            }
            
            button {
                font-family: 'Poppins', sans-serif;
                border: none;
                background: none;
                background-color: black;
                color: white;
                width: 100%;
                font-size: 1.5em;
                transition: 0.3s;
                
            }
            
            button:hover {
                background-color: rgb(181, 228, 94);
                color: black;
                cursor: pointer;
            }
            
            
        </style>


        <div id = "wrapper">
            <form method="POST">
                <header>
                    <h2>Account Login</h2>
                </header>
                <div class = "login-details">
                    <label for="username">Username:</label>
                    <input type="text" name ="username" id = "username">
                    <br>
                    <label for="password">Password:</label>
                    <input type="password" name ="password" id = "password">
                </div>
                <br>
                <div>
                    <button type="submit" value ="submit">LOGIN</button>
                </div>
                <p>${errMsg}</p>
            </form>
            
        </div>
    </body>
</html>
