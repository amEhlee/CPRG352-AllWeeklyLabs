<%-- 
    Document   : arithCalc
    Created on : May 26, 2021, 12:47:01 PM
    Author     : 856885
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>

        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
        
    </head>
    <body>

        <!-- STYLING -->
        <style>
            /*I Don't know how to link css yet but I wanted to try this*/ 
            :root {
                /*Fonts*/
                --F_Main : 'Poppins', sans-serif;

                /*Colors*/
                --C_Background : #2f2f47;
                --C_Main : #FFFFFF;
                --C_Accent : #42FBF2;
                --C_HyperLink : #c3fb42;
            }
            html {
                /*Fits gradient to 100% height*/
                min-height: 100%;
                min-width: 100%;
            }

            h3 {
                margin: 0;
                margin-bottom: 4px;
            }

            form, header, footer, b {
                text-align: center;
            }

            body {
                background-repeat: no-repeat;
                background-color: var(--C_Background);
                background-size: cover;
                font-family: var(--F_Main);
                
                color: var(--C_Main);
                transition: 5s;
            }

            #wrapper {
                border: 3px solid var(--C_Main);
                border-radius: 20px;
                max-width: 600px;
                padding: 20px;

                margin: 0 auto;
                margin-top: 100px;
                transition: ease-in-out 0.2s;
            }

            #wrapper:hover {
                border: 5px solid var(--C_Accent);
            }
            

            button, input {
                transition: ease-in-out 0.3s;
                font-family: var(--F_Main);
                font-weight: bold;
                text-align: center;
                
                background: none;
                color: var(--C_Main);
                border-radius: 5px;
                border: 2px solid var(--C_Main);

                padding: 5px;
                min-width: 100px;
            }

            button:hover, input:hover {
                border: 2px solid var(--C_Accent);
                color: var(--C_Accent);
                cursor: pointer;
            }

            a {
                transition: ease-in-out 0.3s;
                color: var(--C_Accent);
                
            }
            a:hover {
                color: var(--C_HyperLink);
            }
            
        </style>

        <!-- FORM -->
        <main id = "wrapper">

            <header>
                <h1>Arithmetic Calculator</h1>
            </header>

            <form method="post">
                <h3>Enter Your Numbers Down Below</h3>
                <div>
                    <label for= "first">Enter First Number</label><br>
                    <input type="text" name = "first" id = "first">
                </div>
    
                <div>
                    <label for= "second">Enter Second Number</label><br>
                    <input type="text" name = "second" id = "second">
                </div>
                <br>

                <h3>Choose an Operator Below</h3>
                <OperatorButtons>
                    <button type = "submit" name = "buttons" id = "add" value = "add">ADD</button>
                    <button type = "submit" name = "buttons" id = "subtract" value = "subtract">SUBTRACT</button>
                    <button type = "submit" name = "buttons" id = "multiply" value = "multiply">MULTIPLY</button>
                    <button type = "submit" name = "buttons" id = "divide" value = "divide">DIVIDE</button>
                </OperatorButtons>
                <br><br>

                <p>
                    <h3>The Answer to Your Question is:</h3>
                    <h2>${answer}</h2>
                    ${errorMsg}
                </p>

            </form>

            <footer>
                <a href ="age">Link to Age Calculator</a>
            </footer>

        </main>

    </body>
</html>
