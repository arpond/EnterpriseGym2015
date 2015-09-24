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
import uk.ac.dundee.team7.eg_website.Store.EventStore;
import uk.ac.dundee.team7.eg_website.model.EventModel;

/**
 *
 * @author Andrew
 */
@WebServlet(name = "Index", urlPatterns = {""})
public class Index extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
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
        request.setAttribute("events", events);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
        view.include(request, response);
    
    }
    
}
