/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataaccess.UserDB;
import models.User;

/**
 *
 * @author 856885
 */
public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        HttpSession session = httpRequest.getSession();
        
        
        // get email from session 
        String email = (String) session.getAttribute("email");
        
        if(email == null) {
            httpResponse.sendRedirect("login");
            return;
        } else {
                try {
                    User user = new UserDB().get(email);                    
                    if (user.getRole().getRoleId() != 1) {
                        httpResponse.sendRedirect("notes");
                        return;
                    }
                } catch(Exception e) {
                    
                }
            }
        
        chain.doFilter(request, response);
    }  
    

    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}


}
