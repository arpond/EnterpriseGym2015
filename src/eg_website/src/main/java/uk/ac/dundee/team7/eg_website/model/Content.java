package uk.ac.dundee.team7.eg_website.model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import uk.ac.dundee.team7.eg_website.Store.*;

public class Content {

	/**
	 * 
	 * @param contentPath
	 */
	public ContentStore fetchContent(String contentPath) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
	
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            DatabaseConnection dbc = new DatabaseConnection();
            java.sql.Connection conn = dbc.connectToDB();
            
            CallableStatement cs = conn.prepareCall("select * from eg_content where contentPath = ?");
            ContentStore contents = new ContentStore();
            cs.setString(1, contentPath);
            cs.execute();

            ResultSet rs = cs.getResultSet();

            if(rs != null && rs.next()){
               
                contents.setContent(rs.getString("content"));
                contents.setContentID(rs.getInt("contentID"));
                contents.setContentTitle(rs.getString("contentTitle"));
                contents.setContentPath(rs.getString("contentPath"));
            }
            conn.close();
            return contents;
	}

	/**
	 * 
	 * @param contentPath
	 * @param content
	 * @param contentTitle
	 */
	public Boolean addContent(String contentPath, String content, String contentTitle) {
            try 
            {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                DatabaseConnection dbc = new DatabaseConnection();
                java.sql.Connection conn = dbc.connectToDB();

                CallableStatement cs = conn.prepareCall("insert into eg_content (content, contentPath, contentTitle) VALUES (?,?,?) ");
                ContentStore contents = new ContentStore();
                cs.setString(1, content);
                cs.setString(2, contentPath);
                cs.setString(3, contentTitle);
                cs.execute();
            }
            catch (Exception e)
            {
                return false;
            }
            return true;
	}

	/**
	 * 
	 * @param content
	 */
	public Boolean updateContent(ContentStore content) {
		// TODO - implement Content.updateContent
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param contentID
	 */
	public Boolean deleteContent(int contentID) {
		// TODO - implement Content.deleteContent
		throw new UnsupportedOperationException();
	}

}