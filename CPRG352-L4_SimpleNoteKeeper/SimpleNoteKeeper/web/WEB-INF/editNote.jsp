<%-- 
    Document   : editnote
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
                --C_TextColot: #000000;
                --C_Accent : #9fac66;
                --C_Accent2 : #42effb;
            }

            body{
                text-align : center;
                font-family: var(--F_Main);
                background-color: var(--C_Background);
            }

            #wrapper{
                background-color: var(--C_Main);
                border-radius: 20px;
                text-align: center justify;

                max-width: 400px;
                padding: 20px;
                margin: 0 auto;
                margin-top: 100px;
                transition: ease-in-out 0.2s;
            }

            button, input, textarea {
                transition: ease-in-out 0.3s;
                font-family: var(--F_Main);
                font-weight: bold;
                text-align: center;
                background: none;
                color: var(--C_TextColot);
                border-radius: 5px;
                border: 2px solid var(--C_Accent);
                padding: 5px;
                min-width: 100px;
            }

            textarea{
                transition: none;
            }

            button{
                color: var(--C_Accent)
            }

            button:hover, input:hover, textarea:hover {
                border: 2px solid var(--C_Accent2);
                color: var(--C_Accent2);
                cursor: pointer;
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

            <form method="post" action="note">
                <h3>Edit Note</h3>
                <div>
                    <label for= "nTitle">Enter Note Title:</label><br>
                    <input type="text" name = "nTitle" id = "nTitle">
                </div><br>
        
                <div>
                    <label for= "nContent">Enter Note Contents:</label><br>
                    <textarea type="text" name = "nContent" id = "nContent" rows="4" cols="50"></textarea>
                </div><br>

                <formbuttons>
                    <button type = "submit" name = "submit" id = "submit">Update Note</button>
                </formbuttons>
                <br><br>
            </form>

            <footer>
                <a href ="note">Link to View Note</a>
            </footer>
        </main>

    </body>
</html>
