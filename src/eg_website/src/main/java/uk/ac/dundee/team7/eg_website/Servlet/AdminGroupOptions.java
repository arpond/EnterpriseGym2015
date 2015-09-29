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
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uk.ac.dundee.team7.eg_website.Store.UserStore;
import uk.ac.dundee.team7.eg_website.model.AdminModel;
import uk.ac.dundee.team7.eg_website.model.UserModel;

/**
 *
 * @author dragomir
 */
@WebServlet(name = "AdminGroupOptions", urlPatterns = {"/Admin/manageGroups"})
public class AdminGroupOptions extends HttpServlet {

    
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
        ArrayList<UserStore> usL = new ArrayList();
        HashMap gHM = new HashMap();
        AdminModel am = new AdminModel();
        UserModel um = new UserModel();
        
        try {
            usL = am.fetchUsers();
            gHM = am.fetchGroups();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminGroupOptions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AdminGroupOptions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AdminGroupOptions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminGroupOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         request.setAttribute("userList", usL);
         request.setAttribute("groupList", gHM);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/editGroups.jsp");
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
