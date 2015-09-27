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
import uk.ac.dundee.team7.eg_website.Store.ContentStore;
import uk.ac.dundee.team7.eg_website.Store.NewsStore;
import uk.ac.dundee.team7.eg_website.model.ContentModel;
import uk.ac.dundee.team7.eg_website.model.NewsModel;

/**
 *
 * @author dragomir
 */
@WebServlet(name = "AdminContentOptions", urlPatterns = {"/Admin/ContentOptions"})
public class AdminContentOptions extends HttpServlet {

   

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
        ContentModel nm = new ContentModel();
        ArrayList<ContentStore> csAL = new ArrayList<ContentStore>();
        try
        {
            csAL = nm.fetchAllContent();
        }
        catch (Exception e)
        {
            Message.message("Database error. " + e.toString(), request, response);
            return;
        }
        request.setAttribute("allContentForEdit", csAL);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/allEditableContent.jsp");
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
       HttpSession session = request.getSession();
        ContentStore cs = (ContentStore) session.getAttribute("editContent");
        
        String tempstring = cs.getContentPath();
       
        ContentModel cm = new ContentModel();
        try {
            cs = cm.fetchContent(tempstring);
        } catch (SQLException ex) {
            Logger.getLogger(ManageContent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageContent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ManageContent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ManageContent.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("editContentTitle", cs.getContentTitle());
        request.setAttribute("editContentPath", cs.getContentPath());
        request.setAttribute("editContent", cs.getContent());
        request.setAttribute("editContentSummary", cs.getContentSummary());
        request.setAttribute("contentID", cs.getContentID());

        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/editContent.jsp");
        view.include(request, response);

    }
    }

