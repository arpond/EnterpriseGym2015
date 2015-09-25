package uk.ac.dundee.team7.eg_website.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uk.ac.dundee.team7.eg_website.Store.NewsStore;
import uk.ac.dundee.team7.eg_website.lib.Utils;
import uk.ac.dundee.team7.eg_website.model.NewsModel;

@WebServlet(urlPatterns = {
    "/News",
    "/News/*",
})
public class ViewNews extends HttpServlet{

    /**
     * Function to handle get requests for news
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String[] args = Utils.SplitRequestPath(request);
        // Args less than 2 means display all news
        if (args.length <= 2)
        {
            DisplayAllNews(request, response);
        }
        else
        {
            DisplayNewsItem(args, request, response);
        }
    }

    /**
     * Function to display all the news
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    private void DisplayAllNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        NewsModel nm = new NewsModel();
        ArrayList<NewsStore> news = new ArrayList<NewsStore>();
        try
        {
            news = nm.fetchNews();
        }
        catch (Exception e)
        {
            Message.message("Database error. " + e.toString(), request, response);
            return;
        }
        request.setAttribute("news", news);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/displayAllNews.jsp");
        view.include(request, response);
    }

    /**
     * Function to display a single news item
     * @param args
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    private void DisplayNewsItem(String[] args, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        StringBuilder sb = new StringBuilder();    
        for (int i = 1; i < args.length; i++)
        {
            sb.append("/" + args[i]);
        }

        String path = sb.toString();

        NewsModel nm = new NewsModel();
        NewsStore ns;
        try
        {
             ns = nm.fetchNews(path);
        }
        catch (Exception e)
        {
            Message.message("Database error. " + e.toString(), request, response);
            return;
        }
        request.setAttribute("news", ns);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/displayNews.jsp");
        view.include(request, response);
    }
}