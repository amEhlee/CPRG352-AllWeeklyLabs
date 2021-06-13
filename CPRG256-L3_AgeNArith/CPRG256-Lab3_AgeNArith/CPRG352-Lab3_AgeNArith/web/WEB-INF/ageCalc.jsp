<%-- 
    Document   : ageCalc
    Created on : May 26, 2021, 12:46:51 PM
    Author     : 856885
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Age Calculator</title>
    </head>
    <body>
        <!-- STYLING -->
        <style>
            /*I Don't know how to link css yet but I wanted to try this*/ 
            :root {
                /*Fonts*/
                --F_Main : 'Poppins', sans-serif;

                /*Colors*/
                --C_Background : #472f45;
                --C_Main : #FFFFFF;
                --C_Accent : #fb4279;
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
                color: var(--C_Accent)
            }
            a:hover {
                color: var(--C_HyperLink);
            }
            
        </style>

        <main id = "wrapper">
            <header>
                <h1>Age Calculator</h1>
            </header>
    
            <form method="post">
                <h3>Please Enter Your Current Age</h3>
                <div>
                    <input type="text" name = "ageInput" id = "ageInput">
                </div>
                <br><br>

                <button type="submit" id = "ageSubmit" value="ageSubmit">CALCULATE AGE</button>
                <p>
                    ${answer}
                    ${errorMsg}
                </p>

                <a href = "arith"> Link to the Arithmetic Calculator</a>
    
            </form>
        </main>

    </body>
</html>
