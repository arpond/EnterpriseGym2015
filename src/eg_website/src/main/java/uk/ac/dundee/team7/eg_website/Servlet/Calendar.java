package uk.ac.dundee.team7.eg_website.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.joda.time.DateTime;
import uk.ac.dundee.team7.eg_website.Store.ContentStore;
import uk.ac.dundee.team7.eg_website.Store.EventStore;
import uk.ac.dundee.team7.eg_website.Store.NewsStore;
import uk.ac.dundee.team7.eg_website.Store.UserDetails;
import uk.ac.dundee.team7.eg_website.lib.Utils;
import uk.ac.dundee.team7.eg_website.model.AdminModel;
import uk.ac.dundee.team7.eg_website.model.EventModel;
import uk.ac.dundee.team7.eg_website.model.NewsModel;

@WebServlet(name = "addEvent", urlPatterns = {"/Admin/addEvent"})

public class Calendar extends HttpServlet {

    /**
     * Function that handles the get request
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        HashMap types = new HashMap();

        AdminModel am = new AdminModel();
        try {
            types = am.fetchPointTypes();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Calendar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Calendar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Calendar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Calendar.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("pointTypes", types);
        //ContentStore cs = (ContentStore) session.getAttribute("getContentToEdit");
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/addEvent.jsp");
        view.include(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EventModel em = new EventModel();
        EventStore contentS;
        HttpSession session = request.getSession();
        UserDetails ud = (UserDetails) session.getAttribute("UserDetails");

        java.sql.Date sqlStartDate = null;
        String eventTitle = request.getParameter("eventTitle");
        String eventPath = request.getParameter("eventPath");
        String eventSummary = request.getParameter("eventSummary");
        String event = request.getParameter("eventContent");
        String eventImageURL = request.getParameter("eventLink");
        //String displayDateTime=request.getParameter("newsDisplayTime");
        String realDisplayTime = request.getParameter("daterange");
        String realDisplayTime1 = request.getParameter("time");
       
        int pointTypeID = Integer.parseInt( request.getParameter("ptTypes"));
        DateTime eventStartTime;

        System.out.println("date");
        System.out.println(realDisplayTime);
        System.out.println("time");
        System.out.println(realDisplayTime1);

        // realDisplayTime1.substring(0,realDisplayTime1.length()-2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        try {
            System.out.println("THE TIME BRO");
            System.out.println(realDisplayTime + " " + realDisplayTime1.substring(0, realDisplayTime1.length() - 2));
            java.util.Date date = simpleDateFormat.parse(realDisplayTime + " " + realDisplayTime1.substring(0, realDisplayTime1.length() - 2) + ":00");
            // newsStartTime = new DateTime(date);
            sqlStartDate = new java.sql.Date(date.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(ManageNews.class.getName()).log(Level.SEVERE, null, ex);
        }
        int userID = 3;//ud.getUserID();
        int categoryID = 1;
        
        int points = 1;
        eventStartTime = new DateTime(sqlStartDate);
        DateTime eventEndTime = new DateTime(sqlStartDate);
HashMap types = new HashMap();

        AdminModel am = new AdminModel();
        //java.sql.Date sqlStartDate = new java.sql.Date(newsStartTime.getMillis());                
        try {
            types = am.fetchPointTypes();
            em.addEvent(eventPath, eventTitle, event, eventStartTime, eventEndTime, eventImageURL, pointTypeID, points, userID, categoryID, eventSummary);

        } catch (SQLException ex) {
            Logger.getLogger(ManageContent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageNews.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ManageNews.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ManageNews.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("pointTypes", types);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/addEvent.jsp");
        view.include(request, response);
    }

}
