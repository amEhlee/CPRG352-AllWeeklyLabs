/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 856885
 */
public class ShopListServlets extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if(action != null && action.equals("logout")){
            session.invalidate();
            request.setAttribute("errMsg", "You have been logged out");
        }
        else if(session.getAttribute("username") != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/shoplist.jsp").forward(request, response);
            return;
        }

        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");

        // instansiate items array list based on list stored in session
        ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
        if(items == null) {
            items = new ArrayList<String>();
        }

        // show username
        if(username != null) {
            request.setAttribute("username", username);
        }
        
        // apply individual actions
        if(request.getParameter("action").equals("register")) {
            session.setAttribute("username", username);
            request.setAttribute("username", username);
        }
        else if(request.getParameter("action").equals("add")) {
            items.add(request.getParameter("addItem"));
        }
        else if(request.getParameter("action").equals("delete")) {
            items.remove(request.getParameter("itemList"));
        }

        // save changes based on previous actions
        session.setAttribute("items", items);
        request.setAttribute("items", session.getAttribute("items"));

        // get za page
        getServletContext().getRequestDispatcher("/WEB-INF/shoplist.jsp").forward(request, response);

    }

}
