/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// import others
import Services.AccountService;
import models.User;

/**
 *
 * @author 856885
 */
public class LoginServlet extends HttpServlet {
    private AccountService accountWorker = new AccountService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // redirect incase session already exists / user already logged in
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        if(request.getParameter("logout") == null)
        {
            if(user != null){
                // RUNNN!!!!!!! THE USER EXISTS!!!!!
                response.sendRedirect("home");
                return;
            }   
        }
        else if(request.getParameter("logout").equals("")){
            // if the user logsout invalidate their previous session
            session.invalidate();
            request.setAttribute("errMsg","You have successfully signed out");
        }

        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        
        // login using username and password 
        User user = accountWorker.login(username,password);
        
        // check if user is null or not 
        if(user == null)
        {
            // user was not able to login correctly
            request.setAttribute("errMsg", "Incorrect Cridentials for logging in");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        // if it goes past here it was a successful login, create session
        HttpSession session = request.getSession();
        
        // set a session attribute of the previously created user
        session.setAttribute("user", user);
        response.sendRedirect("home");
    }

}