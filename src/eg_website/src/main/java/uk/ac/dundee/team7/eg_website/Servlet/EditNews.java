/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.team7.eg_website.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
import uk.ac.dundee.team7.eg_website.Store.NewsStore;
import uk.ac.dundee.team7.eg_website.Store.UserDetails;
import uk.ac.dundee.team7.eg_website.model.ContentModel;
import uk.ac.dundee.team7.eg_website.model.NewsModel;

/**
 *
 * @author dragomir
 */
@WebServlet(name = "EditNews", urlPatterns = {"/Admin/changeNews",
"/Admin/editNews"})
public class EditNews extends HttpServlet {

   
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
         NewsStore cs = new NewsStore();
        String tempstring = (String) request.getParameter("path");
        
       
        System.out.println(tempstring);
        NewsModel cm = new NewsModel();
        try {
            cs = cm.fetchNews(tempstring);
        } catch (SQLException ex) {
            Logger.getLogger(ManageContent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageContent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ManageContent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ManageContent.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        UserDetails ud = (UserDetails) session.getAttribute("UserDetails");
        if (ud == null || ud.getGroupID() != 3)
        {
            Message.message("You do not have access to the admin page.", request, response);
        }
        else
        {
            request.setAttribute("editContentTitle", cs.getContent().getContentTitle());
            request.setAttribute("editContentPath", cs.getContent().getContentPath());
            request.setAttribute("editContent", cs.getContent().getContent());
            request.setAttribute("editContentSummary", cs.getContent().getContentSummary());
            request.setAttribute("contentID", cs.getContent().getContentID());
            request.setAttribute("editNewsImage", cs.getNewsImage());
            request.setAttribute("editStartTime", cs.getDisplayTime());


            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/editNews.jsp");
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
        NewsModel cm = new NewsModel();
        ContentStore cs = new ContentStore();
        NewsStore ns = new NewsStore();
        String contentTitle = request.getParameter("editContentTitle");
        String contentPath = request.getParameter("editContentPath");
        contentPath = "/News/" + contentPath;
        String contentSummary = request.getParameter("editContentSummary");
        String content = request.getParameter("editContent");
        String contentID = request.getParameter("contentID");
        String imagePath = request.getParameter("editImagePath");
        String StartTime1 = request.getParameter("daterange");
        String StartTime2 = request.getParameter("timepicker");
        
        String finalStarTime = StartTime1 +" "+ StartTime2+":00";
       
        System.out.println(finalStarTime);
        DateTime date = DateTime.parse(finalStarTime, 
                  DateTimeFormat.forPattern("MM/dd/YYYY HH:mm:ss"));
        
        int tempContID = Integer.parseInt(contentID);
        
        
        contentPath = "/News/" + contentPath;
                
        cs.setContent(content);
        cs.setContentID(tempContID);
        cs.setContentPath(contentPath);
        cs.setContentSummary(contentSummary);
        cs.setContentTitle(contentTitle);
        ns.setNewsImage(imagePath);
        ns.setDisplayTime(date);
        ns.setContent(cs);
        try {
            cm.updateContent(ns);
        } catch (SQLException ex) {
            Logger.getLogger(EditContent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditNews.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(EditNews.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(EditNews.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/editNews.jsp");
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
