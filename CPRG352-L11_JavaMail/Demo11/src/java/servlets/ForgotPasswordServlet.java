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

import services.AccountService;

/**
 *
 * @author 856885
 */
public class ForgotPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String path = getServletContext().getRealPath("/WEB-INF/emailtemplates/forgot.html");
        String info;

        System.out.println("zzz1");
        if(!(new AccountService().forgotPassword(email, path)))
            info = "Error: Could not Find User or Send Email!";
        else 
            info = "Password Reset Information Has been Sent to your email";
        
        System.out.println("zzz2");
        request.setAttribute("info", info);

        getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
    }
}
