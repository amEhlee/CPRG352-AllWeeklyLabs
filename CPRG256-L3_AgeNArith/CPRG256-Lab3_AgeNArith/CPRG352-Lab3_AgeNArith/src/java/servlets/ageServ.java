
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
public class ageServ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ageCalc.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Capture Params
        String ageInput = request.getParameter("ageInput");

        // Vars for later
        int updatedAge = 0;
        
        // Set attributes for the JSP
        request.setAttribute("ageInput", ageInput);
        
        // Validation if parameters are not entered
        if(ageInput == null || ageInput.equals(""))
        {
            request.setAttribute("errorMsg", "Please Input a Age");
            getServletContext().getRequestDispatcher("/WEB-INF/ageCalc.jsp").forward(request, response);
            return;
        }
        
        // Validation to check if parameters are indeed a number
        try {
            updatedAge = Integer.parseInt(ageInput) + 1;
        } catch (NumberFormatException e) {
            // catches if it can't convert the number
            request.setAttribute("errorMsg", "<p>Please Make Sure to Enter a Digit For Your Age and Not it's Text Equivalent <br>e.g<br>Good Inputs: 1, 5, 123<br>Bad Inputs: one, two, four etc</p>");
            getServletContext().getRequestDispatcher("/WEB-INF/ageCalc.jsp").forward(request, response);
        }

        // update answer and send it throughhhh
        request.setAttribute("answer", "<h3>On Your Next Birthday You'll Be...</h3><h2>" + updatedAge + " Years Old!</h2>");
        getServletContext().getRequestDispatcher("/WEB-INF/ageCalc.jsp").forward(request, response);
        
    }

}
