package uk.ac.dundee.team7.eg_website.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uk.ac.dundee.team7.eg_website.Store.EventStore;
import uk.ac.dundee.team7.eg_website.lib.Utils;
import uk.ac.dundee.team7.eg_website.model.Event;

@WebServlet(urlPatterns = {
    "/Event",
    "/Event/*",
})
public class ViewEvent {

    /**
     * Function that handles the get request
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String[] args = Utils.SplitRequestPath(request);
        // Args less than 2 means display all news
        if (args.length < 2)
        {
            DisplayAllEvents(request, response);
        }
        else
        {
            DisplayEvent(args, request, response);
        }
    }

    /**
     * Function which displays all the events
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    private void DisplayAllEvents(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        Event em = new Event();
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
        RequestDispatcher view = request.getRequestDispatcher("/displayAllEvents.jsp");
        view.include(request, response);
    }

    /**
     * Function which displays a single event
     * @param args
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    private void DisplayEvent(String[] args, HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        StringBuilder sb = new StringBuilder();    
        for (int i = 1; i < args.length; i++)
        {
            sb.append(args[i]);
        }

        String path = sb.toString();

        Event em = new Event();
        EventStore es;
        try
        {
             es = em.fetchEvent(path);
        }
        catch (Exception e)
        {
            Message.message("Database error. " + e.toString(), request, response);
            return;
        }
        request.setAttribute("event", es);
        RequestDispatcher view = request.getRequestDispatcher("/displayEvent.jsp");
        view.include(request, response);
    }
}
