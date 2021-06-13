/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 856885
 */
public class arithServ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("answer", "---");
        getServletContext().getRequestDispatcher("/WEB-INF/arithCalc.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // capture params
        String firstNum = request.getParameter("first");
        String secondNum = request.getParameter("second");
        String button = request.getParameter("buttons");

        // vars for later
        double first = 0;
        double second = 0;
        double value = 0;

        // set attributes for the JSP
        request.setAttribute("first", firstNum);
        request.setAttribute("second", secondNum);
        request.setAttribute("buttonID", button);

        // Validation if parameters are not entered
        if(firstNum == null || firstNum.equals("") || secondNum == null || secondNum.equals(""))
        {
            request.setAttribute("errorMsg", "Invalid: Please Input a Number in BOTH Fields");
            getServletContext().getRequestDispatcher("/WEB-INF/arithCalc.jsp").forward(request, response);
            return;
        }
        
        // Validation to check if parameters are indeed a number
        try {
            first = Double.parseDouble(firstNum);
            second = Double.parseDouble(secondNum);
        } catch (NumberFormatException e) {
            // catches if it can't convert the number
            request.setAttribute("errorMsg", "<p>Invalid: Please Make Sure Both Inputs Are Digits and Not Their Text Equivalents <br>e.g<br>Good Inputs: 1, 5, 123<br>Bad Inputs: one, two, four etc</p>");
            getServletContext().getRequestDispatcher("/WEB-INF/arithCalc.jsp").forward(request, response);
        }

        switch (button) {
            case "add":
                value = first + second;
                break;
            case "subtract":
                value = first - second;
                break;
            case "multiply":
                value = first * second;
                break;
            case "divide":
                if(second != 0)
                    value = first / second;
                else {
                    request.setAttribute("errorMsg", "<p>Invalid: Cannot Divide By Zero</p>");
                    getServletContext().getRequestDispatcher("/WEB-INF/arithCalc.jsp").forward(request, response);
                    return;
                }
                break;
            default:
                request.setAttribute("errorMsg", "<p>Please Choose an Operator</p>");
                break;
        }

        // format response to 2 decimal places | Stack OverFlow link for logic https://stackoverflow.com/questions/11701399/round-up-to-2-decimal-places-in-java
        value = Math.round(value * 100.0) / 100.0;

        // set attributes for the JSP
        request.setAttribute("firstMsg", firstNum);
        request.setAttribute("secondMsg", secondNum);
        request.setAttribute("answer", value);

        // run it backkkkk
        getServletContext().getRequestDispatcher("/WEB-INF/arithCalc.jsp").forward(request, response);
        return;
    }

}