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
import uk.ac.dundee.team7.eg_website.Store.ContentStore;
import uk.ac.dundee.team7.eg_website.model.ContentModel;


@WebServlet(name = "addContent", urlPatterns = {"/Admin/addContent"})
public class ManageContent extends HttpServlet {

        
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
            
		String contentTitle=request.getParameter("contentTitle");
                String contentPath=request.getParameter("contentPath");
                String contentSummary=request.getParameter("contentSummary");
                String content=request.getParameter("content");
                
                ContentModel cm = new ContentModel();
                ContentStore contentS;
                
                try{
                    cm.addContent(contentPath, content, contentTitle, contentSummary);
                    
                } catch (SQLException ex) {
                Logger.getLogger(ManageContent.class.getName()).log(Level.SEVERE, null, ex);
            }
                
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/addContent.jsp");
            view.include(request, response);
	}

}