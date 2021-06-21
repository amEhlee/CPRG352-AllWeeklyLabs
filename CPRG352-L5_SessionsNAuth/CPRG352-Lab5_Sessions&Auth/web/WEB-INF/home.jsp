<%-- 
    Document   : home
    Created on : Jun 13, 2021, 4:22:57 PM
    Author     : 856885
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <style>
            html {
                /*Fits gradient to 100% height*/
                min-height: 100%;
                min-width: 100%;
            }
            
            main {
                margin-top: 80px;
                text-align: center;
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
            
            .button {
                display: block;
                width: 120px;
                height: 25px;
                background: black;
                padding: 10px;
                text-align: center;
                border-radius: 5px;
                color: white;
                font-weight: bold;
                font-family: 'Poppins', sans-serif;
                text-decoration: none;

                transition: 0.3s;
                margin: 0 auto;
                
            }
            
            .button:hover {
                background-color: rgb(181, 228, 94);
                color: black;
                cursor: pointer;
            }
        </style>

        <div id = "wrapper">
            <main>
                <float>
                    <h1>Hello ${user.getUsername()}.</h1>
                </float>
                <br><br><br>
                <a class="button" href="login?logout">Logout</a>
            </main>

        </div>
    </body>
</html>
