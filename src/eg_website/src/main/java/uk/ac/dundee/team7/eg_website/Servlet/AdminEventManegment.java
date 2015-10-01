/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.team7.eg_website.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uk.ac.dundee.team7.eg_website.Store.EventStore;
import uk.ac.dundee.team7.eg_website.Store.NewsStore;
import uk.ac.dundee.team7.eg_website.Store.UserDetails;
import uk.ac.dundee.team7.eg_website.model.EventModel;
import uk.ac.dundee.team7.eg_website.model.NewsModel;

/**
 *
 * @author dragomir
 */
@WebServlet(name = "AdminEventManegment", urlPatterns = {"/Admin/EventOptions"})
public class AdminEventManegment extends HttpServlet {

  

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       EventModel nm = new EventModel();
        ArrayList<EventStore> csAL = new ArrayList<EventStore>();
        try {
            csAL = nm.fetchEvents();
        } catch (Exception e) {
            Message.message("Database error. " + e.toString(), request, response);
            return;
        }
        
        HttpSession session = request.getSession();
        UserDetails ud = (UserDetails) session.getAttribute("UserDetails");
        if (ud == null || ud.getGroupID() != 3)
        {
            Message.message("You do not have access to the admin page.", request, response);
        }
        else
        {
            request.setAttribute("allEvensForEdit", csAL);
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/editAllEvents.jsp");
            view.include(request, response);
        }
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EventModel nm = new EventModel();
        ArrayList<EventStore> csAL = new ArrayList<EventStore>();
        try {
            csAL = nm.fetchEvents();
        } catch (Exception e) {
            Message.message("Database error. " + e.toString(), request, response);
            return;
        }
        
        HttpSession session = request.getSession();
        UserDetails ud = (UserDetails) session.getAttribute("UserDetails");
        if (ud == null || ud.getGroupID() != 3)
        {
            Message.message("You do not have access to the admin page.", request, response);
        }
        else
        {
            request.setAttribute("allEvensForEdit", csAL);
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/editAllEvents.jsp");
            view.include(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
