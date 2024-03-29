package uk.ac.dundee.team7.eg_website.model;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
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

public class NewsModel {

    /**
     *
     * @param newsPath
     */
    public NewsStore fetchNews(String newsPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = null;

        cs = conn.prepareCall("{call getNewsOne(?)}");
        cs.setString(1, newsPath);
        cs.execute();
        ResultSet rs = cs.getResultSet();
        DateTime now = new DateTime();
        ContentStore contentstore = new ContentStore();
        rs.first();
        contentstore.setContent(rs.getString("content"));
        contentstore.setContentID(rs.getInt("contentID"));
        contentstore.setContentPath(rs.getString("contentPath"));
        contentstore.setContentTitle(rs.getString("contentTitle"));
        contentstore.setContentSummary(rs.getString("contentSummary"));

        Timestamp posted = rs.getTimestamp("posted");
        Date date = new Date(posted.getTime());
        DateTime dateNow = new DateTime(date);
        NewsStore ns = new NewsStore(rs.getInt("newsID"), dateNow, now, rs.getString("newsImage"), rs.getString("contentTitle"), contentstore);
        conn.close();
        return ns;
    }

    public ArrayList<NewsStore> fetchNews() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        //TODO fetch news need to be ordered by date
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = null;

        cs = conn.prepareCall("{call getNews()}");
        cs.execute();
        ResultSet rs = cs.getResultSet();
        //rs.first();
        ArrayList<NewsStore> newsList = new ArrayList<NewsStore>();
        while (rs.next()) {
            ContentStore contentstore = new ContentStore();
            contentstore.setContent(rs.getString("content"));
            contentstore.setContentID(rs.getInt("contentID"));
            contentstore.setContentPath(rs.getString("contentPath"));
            contentstore.setContentTitle(rs.getString("contentTitle"));
            contentstore.setContentSummary(rs.getString("contentSummary"));

            Timestamp posted = rs.getTimestamp("posted");
            Date date = new Date(posted.getTime());
            DateTime postedtime = new DateTime(date);
            DateTime displaytime = new DateTime();
            NewsStore newsToAdd = new NewsStore(rs.getInt("newsID"), postedtime, displaytime, rs.getString("newsImage"), rs.getString("categoryName"), contentstore);
            newsList.add(newsToAdd);
        }
        conn.close();
        return newsList;
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
    public Boolean addNews(int userID, String newsPath, String newsTitle, String news, java.sql.Date displayTime, String imageURL, int categoryID, String newSummary) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = null;

        java.sql.Date sqlStartDate = new java.sql.Date(displayTime.getTime());

        cs = conn.prepareCall("{call addNews(?,?,?,?,?,?,?,?)}");
        cs.setDate(1, sqlStartDate);
        cs.setString(2, imageURL);
        cs.setString(3, news);
        cs.setInt(4, categoryID);
        //TODO newsPath must be unique
        cs.setString(5, newsPath);
        cs.setInt(6, userID);
        cs.setString(7, newsTitle);
        cs.setString(8, newSummary);
        cs.execute();
        conn.close();
        return true;
    }

    /**
     *
     * @param news
     */
    public Boolean updateContent(NewsStore news) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = null;

        cs = conn.prepareCall("{call updateNews(?,?,?,?,?,?,?,?,?)}");
        
        cs.setInt(1, news.getNewsID());
        cs.setInt(2, news.getContent().getContentID());
        
        cs.setTimestamp(3, new Timestamp(news.getDisplayTime().getMillis()));
        cs.setString(4, news.getNewsImage());
        ContentStore contentstore = news.getContent();
        cs.setString(5, contentstore.getContent());
        cs.setInt(6, 1);

        cs.setString(7, contentstore.getContentPath());
        cs.setString(8, contentstore.getContentTitle());
        cs.setString(9, contentstore.getContentSummary());

        cs.execute();
        conn.close();
        return true;
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
        cs.setInt(1, newsID);
        cs.execute();
        conn.close();
        return true;
    }

}
