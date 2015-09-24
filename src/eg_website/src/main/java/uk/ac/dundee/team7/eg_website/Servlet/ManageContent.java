package uk.ac.dundee.team7.eg_website.Servlet;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uk.ac.dundee.team7.eg_website.Store.ContentStore;
import uk.ac.dundee.team7.eg_website.model.ContentModel;


@WebServlet(name = "addContent", urlPatterns = {"/addContent"})
public class ManageContent extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String contentTitle=request.getParameter("contentTitle");
                String contentPath=request.getParameter("contentPath");
                String contentSummary=request.getParameter("contentSummary");
                String content=request.getParameter("content");
                
                ContentModel cm = new ContentModel();
                ContentStore contentS;
                
                try{
                    cm.addContent(contentPath, content, contentTitle);
                    
                } catch (SQLException ex) {
                Logger.getLogger(ManageContent.class.getName()).log(Level.SEVERE, null, ex);
            }
                
	}

	public void doGet() {
		// TODO - implement ManageContent.doGet
		throw new UnsupportedOperationException();
	}

}