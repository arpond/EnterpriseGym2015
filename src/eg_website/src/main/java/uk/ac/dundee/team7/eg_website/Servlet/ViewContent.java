package uk.ac.dundee.team7.eg_website.Servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uk.ac.dundee.team7.eg_website.Store.ContentStore;
import uk.ac.dundee.team7.eg_website.lib.Utils;
import uk.ac.dundee.team7.eg_website.model.ContentModel;


@WebServlet(urlPatterns = {
    "/Content",
    "/Content/*"
    
})
public class ViewContent extends HttpServlet{

	@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
            
            
            String[] args = Utils.SplitRequestPath(request);
            
            
            
            StringBuilder sb = new StringBuilder();    
            for (int i = 1; i < args.length; i++)
            {
                sb.append("/" + args[i]);
            }
            
            String path = sb.toString();
            ContentModel cm = new ContentModel();
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
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/displayContent.jsp");
            view.include(request, response);
	}

}