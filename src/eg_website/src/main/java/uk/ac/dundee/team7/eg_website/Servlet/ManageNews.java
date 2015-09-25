package uk.ac.dundee.team7.eg_website.Servlet;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.joda.time.DateTime;
import uk.ac.dundee.team7.eg_website.Store.ContentStore;
import uk.ac.dundee.team7.eg_website.Store.NewsStore;
import uk.ac.dundee.team7.eg_website.Store.UserDetails;
import uk.ac.dundee.team7.eg_website.model.NewsModel;


@WebServlet(name = "addNews", urlPatterns = {"/addNews"})

public class ManageNews extends HttpServlet {
    
    
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
                NewsModel cm = new NewsModel();
                NewsStore contentS;
                HttpSession session = request.getSession();
                UserDetails ud = (UserDetails) session.getAttribute("UserDetails");
                    
                java.sql.Date sqlStartDate = null;
		String newsTitle=request.getParameter("newsTitle");
                String newsPath=request.getParameter("newsPath");
                String newsSummary=request.getParameter("newsSummary");
                String news=request.getParameter("newsContent");
                String newsImageURL=request.getParameter("newsLink");
                //String displayDateTime=request.getParameter("newsDisplayTime");
                String realDisplayTime = request.getParameter("daterange");
                String realDisplayTime1 = request.getParameter("time");
                DateTime newsStartTime;
                
                System.out.println("date");
                System.out.println(realDisplayTime);
                System.out.println("time");
                System.out.println(realDisplayTime1);
                
               // realDisplayTime1.substring(0,realDisplayTime1.length()-2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
            try {
                System.out.println("THE TIME BRO");
                System.out.println(realDisplayTime+" "+ realDisplayTime1.substring(0,realDisplayTime1.length()-2));
                java.sql.Date date = (java.sql.Date ) simpleDateFormat.parse(realDisplayTime+" "+ realDisplayTime1.substring(0,realDisplayTime1.length()-2));
               // newsStartTime = new DateTime(date);
                 sqlStartDate = new java.sql.Date(date.getTime());
            } catch (ParseException ex) {
                Logger.getLogger(ManageNews.class.getName()).log(Level.SEVERE, null, ex);
            }
                   int userID = 3;//ud.getUserID();
                int categoryID = 1;
                
                        //java.sql.Date sqlStartDate = new java.sql.Date(newsStartTime.getMillis());

                
                
              try{
                   cm.addNews(userID, newsPath, newsTitle, news, sqlStartDate, newsImageURL, categoryID, newsSummary);
                    
                } catch (SQLException ex) {
               Logger.getLogger(ManageContent.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManageNews.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(ManageNews.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ManageNews.class.getName()).log(Level.SEVERE, null, ex);
            }
                
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
	}

}