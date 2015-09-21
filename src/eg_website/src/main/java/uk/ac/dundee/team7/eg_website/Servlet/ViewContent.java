package uk.ac.dundee.team7.eg_website.Servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uk.ac.dundee.team7.eg_website.Store.ContentStore;
import uk.ac.dundee.team7.eg_website.model.Content;


@WebServlet(name = "Content", urlPatterns = {"/Content"})
public class ViewContent extends HttpServlet{

	@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String path = "dsadas"; //TODO split string and get path from current path
                
                Content cm = new Content();
                ContentStore cs;
                try
                {
                     cs = cm.fetchContent(path);
                }
                catch (Exception e)
                {
                    Message.message("Database error. " + e.toString(), request, response);
                    return;
                }
                request.setAttribute("content", cs);
                RequestDispatcher view = request.getRequestDispatcher("/displayContent.jsp");
                view.include(request, response);
	}

}