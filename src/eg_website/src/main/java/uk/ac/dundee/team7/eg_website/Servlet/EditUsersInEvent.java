/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.team7.eg_website.Servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.json.JSONObject;
import uk.ac.dundee.team7.eg_website.Store.NewsStore;
import uk.ac.dundee.team7.eg_website.Store.UserDetails;
import uk.ac.dundee.team7.eg_website.Store.UserStore;
import uk.ac.dundee.team7.eg_website.model.AdminModel;
import uk.ac.dundee.team7.eg_website.model.EventModel;
import uk.ac.dundee.team7.eg_website.model.NewsModel;

/**
 *
 * @author dragomir
 */
@WebServlet(name = "EditUsersInEvent", urlPatterns = {"/Admin/EditUsersInEvent",
"/Admin/markUsersAsAttended123"})
public class EditUsersInEvent extends HttpServlet {

   

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
         //EventModel cs = new EventStore();
         
         ArrayList<UserStore> csAL = new ArrayList<UserStore>();
        String eventID = request.getParameter("eventID");
        int tempstring = Integer.parseInt(request.getParameter("eventID"));
        
        EventModel cm = new EventModel();
        
        try {
            csAL = cm.fetchUsersForEvent(tempstring);
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
            request.setAttribute("getUsersForEvent", csAL);
            request.setAttribute("eventID", eventID);
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/editEventsUsers.jsp");
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
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String json = "";
            if(br != null)
            {
                json = br.readLine();
            }
            
            
            JSONObject jsonResult = new JSONObject(json);
            System.out.println(jsonResult.toString());
            String selected = jsonResult.getString("selected");
            List<String> userIDs = Arrays.asList(selected.split("\\s*,\\s*"));
            
            AdminModel am = new AdminModel();
           // ArrayList<String> userIDs = new ArrayList();
           // String users = request.getParameter("userID");
            String eventID = request.getParameter("eventID");
            
            
            
            
            int tempEventID = Integer.parseInt(eventID);
            try {
                am.givePointsForEvent(userIDs, tempEventID);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EditUsersInEvent.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(EditUsersInEvent.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(EditUsersInEvent.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(EditUsersInEvent.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (JSONException ex) {
            Logger.getLogger(EditUsersInEvent.class.getName()).log(Level.SEVERE, null, ex);
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
