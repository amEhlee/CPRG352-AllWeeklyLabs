<%-- 
    Document   : viewNote
    Created on : Jun 4, 2021, 8:21:54 PM
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
        <!-- STYLING -->
        <style>
            /*I Don't know how to link css yet but I wanted to try this*/ 
            :root {
                /*Fonts*/
                --F_Main : 'Poppins', sans-serif;
                /*Colors*/
                --C_Background : #f0f0f0;
                --C_Main : #ffffff;
                --C_TextColor: #30352e;
                --C_Accent : #9fac66;
                --C_Accent2 : #42effb;
            }

            body{
                font-family: var(--F_Main);
                color: var(--C_TextColor);
                background-color: var(--C_Background);
            }

            #wrapper{
                background-color: var(--C_Main);
                border-radius: 20px;
                text-align: center;

                max-width: 400px;
                padding: 20px;
                margin: 0 auto;
                margin-top: 100px;
                transition: ease-in-out 0.2s;
            }

            a {
                transition: ease-in-out 0.3s;
                color: var(--C_Accent)
            }
            a:hover {
                color: var(--C_Accent2);
            }
            
        </style>
        
        <main id = "wrapper">
            <header>
                <h1>Simple Note Keeper</h1>
            </header>
                <h3>View Note</h3>
                <nTitle><b>Title:</b><br> <titleFill>${nTitle}</titleFill> </nTitle><br><br>
                <nContent><b>Content:</b><br> <conFill>${nContent}</conFill> </nContent><br>
            <footer>
                <a href ="note?edit">Link to Edit Note</a>
            </footer>
        </main>

    </body>
</html>
