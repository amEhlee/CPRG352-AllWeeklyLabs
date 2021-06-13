/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.Note;

/**
 *
 * @author 856885
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // create our note
        Note noteWorker = new Note();
        
        // if in the paramater it has the edit page
        if(request.getParameter("edit") == null) // VIEW PAGE
        {
            // Get the path for note.txt
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            
            // take contents of note
            String[] fillNote = noteWorker.viewNote(path);

            // Return the Webpage
            request.setAttribute("nTitle", fillNote[0]);
            request.setAttribute("nContent", fillNote[1]);
            getServletContext().getRequestDispatcher("/WEB-INF/viewNote.jsp").forward(request, response);
        }
        else if(request.getParameter("edit").equals("")) // EDIT PAGE  
        {
            getServletContext().getRequestDispatcher("/WEB-INF/editNote.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Capture Params
        String nTitle = request.getParameter("nTitle");
        String nContents = request.getParameter("nContent");

        // Get the path for target Note
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        Note noteWorker = new Note();

        // Validation if parameters are not entered
        if(nTitle == null || nTitle.equals("") || nContents == null || nContents.equals(""))
        {
            // If nothing was put in make sure its not null at least 
            nTitle = "N/A";
            nContents = "N/A";
        }

        // Apply changes to the note
        noteWorker.editNote(path, nTitle, nContents);
        
        // take contents of note
        String[] fillNote = noteWorker.viewNote(path);

        // Return the Webpage
        request.setAttribute("nTitle", fillNote[0]);
        request.setAttribute("nContent", fillNote[1]);
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewNote.jsp").forward(request, response);
       
    }
}
