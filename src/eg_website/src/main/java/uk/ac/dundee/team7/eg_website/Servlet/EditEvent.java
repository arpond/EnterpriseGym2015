/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.team7.eg_website.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
import org.joda.time.format.DateTimeFormat;
import uk.ac.dundee.team7.eg_website.Store.ContentStore;
import uk.ac.dundee.team7.eg_website.Store.EventStore;
import uk.ac.dundee.team7.eg_website.Store.NewsStore;
import uk.ac.dundee.team7.eg_website.model.EventModel;
import uk.ac.dundee.team7.eg_website.model.NewsModel;

/**
 *
 * @author dragomir
 */
@WebServlet(name = "EditEvent", urlPatterns = {"/Admin/EditEvent",
"/Admin/changeEvent"})
public class EditEvent extends HttpServlet {

   
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
          HttpSession session = request.getSession();
       // NewsStore cs = new NewsStore();
         EventStore cs = new EventStore();
        String tempstring = (String) request.getParameter("eventPath");
        ArrayList<String> tempPointTypeArray = new ArrayList();
        
        System.out.println(tempstring);
        EventModel cm = new EventModel();
        try {
            cs = cm.fetchEvent(tempstring);
            tempPointTypeArray = cm.fetchPointTypes();
        } catch (SQLException ex) {
            Logger.getLogger(ManageContent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageContent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ManageContent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ManageContent.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("editContentTitle", cs.getContent().getContentTitle());
        request.setAttribute("editContentPath", cs.getContent().getContentPath());
        request.setAttribute("editContent", cs.getContent().getContent());
        request.setAttribute("editContentSummary", cs.getContent().getContentSummary());
        request.setAttribute("contentID", cs.getContent().getContentID());
        request.setAttribute("editEventImage", cs.getEventImage());
        request.setAttribute("editPointType", tempPointTypeArray);
        request.setAttribute("editEventID", cs.getEventID());
        request.setAttribute("editEventValue", cs.getEventValue());
        request.setAttribute("editStartTime", cs.getEventStartTime());
        
        
        
        

        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/editEvent.jsp");
        view.include(request, response);
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
        EventModel cm = new EventModel();
        ContentStore cs = new ContentStore();
        EventStore ns = new EventStore();
        
        
        String contentTitle = request.getParameter("editContentTitle");
        String contentPath = request.getParameter("editContentPath");
        String contentSummary = request.getParameter("editContentSummary");
        String content = request.getParameter("editContent");
        String contentID = request.getParameter("contentID");
        String imagePath = request.getParameter("editEventImage");
        String evenPointType = request.getParameter("editPointType");
        String eventID = request.getParameter("editEventID");
        String eventValue = request.getParameter("editEventValue");
        
        String StartTime1 = request.getParameter("daterange");
         System.out.println("JORDAAasdasdadsasdasdasdasdasdasd");
        System.out.println(StartTime1);
        String StartTime2 = request.getParameter("timepicker");
        String StartTime3 = request.getParameter("timepicker1");
         System.out.println("JORDAAasdasdadsasdasdasdasdasdasd");
        System.out.println(StartTime2);
        String finalStarTime = StartTime1 +" "+ StartTime2;
        System.out.println("JORDAAasdasdadsasdasdasdasdasdasd");
        System.out.println(finalStarTime);
        DateTime date = DateTime.parse(finalStarTime, 
                  DateTimeFormat.forPattern("MM/dd/YYYY HH:mm:ss"));
        String finalEndTime = StartTime1 + " " + StartTime3;
        DateTime date1 = DateTime.parse(finalEndTime, 
                  DateTimeFormat.forPattern("MM/dd/YYYY HH:mm:ss"));
        
        
        int tempEventID = Integer.parseInt(eventID);
        int tempEventValue = Integer.parseInt(eventValue);
        

        int tempContID = Integer.parseInt(contentID);
        
        cs.setContent(content);
        cs.setContentID(tempContID);
        cs.setContentPath(contentPath);
        cs.setContentSummary(contentSummary);
        cs.setContentTitle(contentTitle);
        ns.setEventImage(imagePath);
        ns.setEventStartTime(date);
        ns.setEventEndTime(date1);
        
        ns.setEventPointType(evenPointType);
        ns.setEventID(tempEventID);
        ns.setEventValue(tempEventValue);
        
        
        ns.setContent(cs);
        try {
            cm.updateEvent(ns);
        } catch (SQLException ex) {
            Logger.getLogger(EditContent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditNews.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(EditNews.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(EditNews.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/editAllEvents.jsp");
     
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
