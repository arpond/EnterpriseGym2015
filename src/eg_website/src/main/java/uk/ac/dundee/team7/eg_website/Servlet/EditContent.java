/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.team7.eg_website.Servlet;

import java.io.IOException;
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
import uk.ac.dundee.team7.eg_website.Store.ContentStore;
import uk.ac.dundee.team7.eg_website.Store.UserDetails;
import uk.ac.dundee.team7.eg_website.model.ContentModel;

/**
 *
 * @author Andrew
 */
@WebServlet(name = "EditContent", urlPatterns = {
    "/Admin/editContent",
    "/Admin/changeContent"
})
public class EditContent extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        ContentModel cm = new ContentModel();
        ContentStore cs = new ContentStore();
        String contentTitle = request.getParameter("editContentTitle");
        String contentPath = request.getParameter("editContentPath");
        contentPath = "/Content/" + contentPath;
        String contentSummary = request.getParameter("editContentSummary");
        String content = request.getParameter("editContent");
        String contentID = request.getParameter("contentID");
        
        contentPath = "/Content/" + contentPath;
        int tempContID = Integer.parseInt(contentID);
        cs.setContent(content);
        cs.setContentID(tempContID);
        cs.setContentPath(contentPath);
        cs.setContentSummary(contentSummary);
        cs.setContentTitle(contentTitle);

        try {
            cm.updateContent(cs);
        } catch (SQLException ex) {
            Logger.getLogger(EditContent.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/editContent.jsp");

    }

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
        ContentStore cs = new ContentStore();
        String tempstring = (String) request.getParameter("path");
        // String tempstring = subFam.getContentPath();
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
