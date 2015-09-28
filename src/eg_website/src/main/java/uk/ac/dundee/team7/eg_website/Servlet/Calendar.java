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
import uk.ac.dundee.team7.eg_website.lib.Utils;
import uk.ac.dundee.team7.eg_website.model.EventModel;

@WebServlet(urlPatterns = {
    "/Calendar"
})
public class Calendar extends HttpServlet{

    /**
     * Function that handles the get request
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
            DisplayAllEvents(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        EventModel em = new EventModel();
        int eventID;
        HttpSession session = request.getSession();
        UserDetails ud = (UserDetails) session.getAttribute("UserDetails");
        
        
        try
        {
            eventID = Integer.parseInt(request.getParameter("eventID"));
            em.signUp(ud.getUserID(), eventID);
        }
        catch (Exception e)
        {
            Message.message("Event could not be found", request, response);
            return;
        }
        Message.message("Thanks for signing up.", request, response);
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
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/calendar.jsp");
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
        HttpSession session = request.getSession();
        UserDetails ud = (UserDetails) session.getAttribute("UserDetails");
        
        StringBuilder sb = new StringBuilder();    
        for (int i = 1; i < args.length; i++)
        {
            sb.append("/"+args[i]);
        }

        String path = sb.toString();

        Boolean attending = false;
        EventModel em = new EventModel();
        EventStore es;
        try
        {
             es = em.fetchEvent(path);
             //attending = em.attending(ud.getUserID(),es.getEventID());
              System.out.println(path);
        }
        catch (Exception e)
        {
            Message.message("Database error. " + e.toString(), request, response);
            return;
        }

        request.setAttribute("attending", attending);
        request.setAttribute("event", es);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/displayEvent.jsp");
        view.include(request, response);
    }
}
