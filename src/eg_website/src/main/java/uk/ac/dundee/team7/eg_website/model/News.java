package uk.ac.dundee.team7.eg_website.model;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import uk.ac.dundee.team7.eg_website.Store.*;

public class News {

	/**
	 * 
	 * @param newsPath
	 */
	public NewsStore fetchNews(String newsPath) {
		// TODO - implement News.fetchNews
		throw new UnsupportedOperationException();
	}

	public ArrayList<NewsStore> fetchNews() {
		// TODO - implement News.fetchNews
		throw new UnsupportedOperationException();
                //fetch news need to be ordered by date
	}

	/**
	 * 
	 * @param newsPath
	 * @param newsTitle
	 * @param news
	 * @param displayTime
	 * @param imageURL
	 * @param category
	 */
	public Boolean addNews(int userID, String newsPath, String newsTitle, String news, DateTime displayTime, String imageURL, int categoryID) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = null;
        
        
        cs = conn.prepareCall("{call addNews(?,?,?,?,?,?,?)}");
        cs.setTimestamp(1, new Timestamp(displayTime.getMillis()));
        cs.setString(2, imageURL);
        cs.setString(3, news);
        cs.setInt(4, categoryID);
        cs.setString(5, newsPath);        
        cs.setInt(6, userID);
        cs.setString(7, newsTitle);
        cs.execute();
        return true;
	}

	/**
	 * 
	 * @param news
	 */
	public Boolean updateContent(NewsStore news) {
		// TODO - implement News.updateContent
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param newsID
	 */
	public Boolean deleteNews(int newsID) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
	
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = null;
        
        
        cs = conn.prepareCall("Delete from eg_news where newsID=?");
        cs.setInt(1,newsID);
        cs.execute();
        return true;
	}

}