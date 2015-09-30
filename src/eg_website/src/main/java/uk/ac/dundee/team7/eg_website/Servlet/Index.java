/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.team7.eg_website.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uk.ac.dundee.team7.eg_website.Store.EventStore;
import uk.ac.dundee.team7.eg_website.Store.UserDetails;
import uk.ac.dundee.team7.eg_website.model.EventModel;

/**
 *
 * @author Andrew
 */
@WebServlet(urlPatterns = {
    "",
    "/Index"
    
})
public class Index extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDetails ud = (UserDetails) session.getAttribute("UserDetails");
        EventModel em = new EventModel();
        ArrayList<EventStore> events = new ArrayList<EventStore>();
        try
        {
            events = em.fetchEvents();
        }
        catch (Exception e)
        {
            Message.message("Database error. " + e.toString(), request, response);
            return;
        }
        session.setAttribute("UserDetails", ud);
        request.setAttribute("events", events);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
        view.include(request, response);
    
    }
    
}
